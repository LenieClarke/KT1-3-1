fun main() {
    println("был(а) в сети ${agoToText(seconds = 130)}")
//    println("был(а) в сети ${agoToText(seconds = 50_000)}")
//    println("был(а) в сети ${agoToText(seconds = 175_000)}")
}

fun agoToText(seconds: Int): String = when (seconds) {
    in 0..60 -> "только что"
    in 61..60 * 60 -> {val minutesAgo = seconds / 60; "$minutesAgo ${wordMinute(minutesAgo)} назад"}
    in 60 * 60 + 1..24 * 60 * 60 -> {val hoursAgo = seconds / 3_600; "$hoursAgo ${wordHour(hoursAgo)} назад"}
    in 24 * 60 * 60 + 1..24 * 60 * 60 * 2 -> "сегодня"
    in 24 * 60 * 60 * 2 + 1..24 * 60 * 60 * 3 -> "вчера"
    else -> "давно"
}

fun wordMinute(minutes: Int): String = when (minutes) {
    1, 21, 31, 41, 51 -> "минуту"
    in 2..4, in 22..24, in 32..34, in 42..44, in 52..54 -> "минуты"
    else -> "минут"
}

fun wordHour(hours: Int): String = when (hours) {
    1, 21 -> "час"
    in 2..4, in 22..24 -> "часа"
    else -> "часов"
}