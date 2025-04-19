package com.example.telegrambotv2

import com.github.kotlintelegrambot.bot
import com.github.kotlintelegrambot.dispatch
import com.github.kotlintelegrambot.dispatcher.command
import com.github.kotlintelegrambot.dispatcher.handlers.CommandHandlerEnvironment
import com.github.kotlintelegrambot.entities.ChatId
import com.github.kotlintelegrambot.logging.LogLevel
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.coroutines.*

fun main() {
    val token = System.getenv("TELEGRAM_BOT_TOKEN") ?: "7392239915:AAG18GXQgRkqw-CH_4805ZUXSizaNwNhh2"

    val bot = bot {
        this.token = token
        this.logLevel = LogLevel.Network.Body

        dispatch {
            command("start") {
                reply("Привіт! Це бот v2.")
            }

            command("help") {
                reply("Доступні команди: /start, /help")
            }
        }
    }

    // Запускаємо бота в окремій корутині
    GlobalScope.launch {
        bot.startPolling()
    }

    // Простий HTTP сервер для Fly.io
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        routing {
            get("/") {
                call.respondText("Telegram Bot v2 is running!")
            }
        }
    }.start(wait = true)
}

private fun CommandHandlerEnvironment.reply(text: String) {
    bot.sendMessage(chatId = ChatId.fromId(message.chat.id), text = text)
}






