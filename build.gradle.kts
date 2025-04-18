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
    mainClass.set("com.example.telegrambotv2.BotV2Kt")

    tasks.withType<Jar> {
        manifest {
            attributes["Main-Class"] = "com.example.telegrambotv2.BotV2Kt"
        }

        // Для створення fat jar
        from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    }

    tasks.jar {
        manifest {
            attributes["Main-Class"] = "com.example.telegrambotv2.BotV2Kt"
        }

        // Якщо потрібен "fat jar", щоб усі залежності були всередині
        from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
    }
}


