package com.example.telegrambotv2

import com.github.kotlintelegrambot.bot
import com.github.kotlintelegrambot.dispatch
import com.github.kotlintelegrambot.dispatcher.command
import com.github.kotlintelegrambot.dispatcher.handlers.CommandHandlerEnvironment
import com.github.kotlintelegrambot.entities.ChatId
import com.github.kotlintelegrambot.logging.LogLevel

fun main() {
    val token = System.getenv("TELEGRAM_BOT_TOKEN") ?: "7392239915:AAG18GXQgRkqw-CH_4805ZUXSizaNwNhh2"

    val bot = bot {
        this.token = token
        this.logLevel =  LogLevel.Network.Body

        dispatch {
            command("start") {
                reply("Привіт! Це бот v2.")
            }

            command("help") {
                reply("Доступні команди: /start, /help")
            }
        }
    }

    bot.startPolling()
}

private fun CommandHandlerEnvironment.reply(text: String) {
    bot.sendMessage(chatId = ChatId.fromId(message.chat.id), text = text)
}






