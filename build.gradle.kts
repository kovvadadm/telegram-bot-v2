plugins {
    kotlin("jvm") version "1.9.22"
    application


}

repositories {
    mavenCentral()
    maven("https://jitpack.io")

}

dependencies {

    implementation("io.github.kotlin-telegram-bot.kotlin-telegram-bot:telegram:6.3.0")
}

application {
    mainClass.set("BotV2Kt")

    mainClass.set("com.example.telegrambotv2.BotV2Kt")






}
