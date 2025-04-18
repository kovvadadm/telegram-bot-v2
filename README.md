# Telegram Kotlin Bot v2

Цей бот написаний на Kotlin з використанням бібліотеки `kotlin-telegram-bot`. Працює як консольний застосунок і підтримує розгортання через Docker.

## Запуск локально

```
./gradlew run
```

## Запуск через Docker

```
docker build -t telegram-v2 .
docker run -e TELEGRAM_BOT_TOKEN=your_token telegram-v2
```