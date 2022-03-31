const val MINUTE = 60
const val HOUR = 60 * 60
const val DAY = 24 * 60 * 60
const val TWO_DAY = 24 * 2 * 60 * 60
const val THREE_DAY = 24 * 2 * 60 * 60

fun main() {
    val time = 9874
    print(agoToText(time))

}

fun selectWordEnding(time: Int): String {
    val timeMinute = time / MINUTE
    val timeHour = time / HOUR
    return when {
        time >= MINUTE + 1 && time <= HOUR -> {
            if (timeMinute % 10 == 1 && timeMinute != 11) {
                ("Был(а) $timeMinute минуту назад")
            } else if (timeMinute % 10 == 2 && timeMinute % 10 == 3 && timeMinute % 10 == 4 && timeMinute != 12 && timeMinute != 13 && timeMinute != 14) {
                ("Был(а) $timeMinute минуты назад")
            } else ("Был(а) $timeMinute минут назад")
        }
        time >= HOUR + 1 && time <= DAY -> {
            if (timeHour % 10 == 1 && timeHour != 11) {
                ("Был(а) $timeHour час назад")
            } else if (timeHour % 10 == 2 && timeHour % 10 == 3 && timeHour % 10 == 4 && timeHour != 12 && timeHour != 13 && timeHour != 14) {
                ("Был(а) $timeHour часа назад")
            } else ("Был(а) $timeHour часов назад")
        }
        else -> error("Что-то пошло не так")
    }
}

fun agoToText(time: Int): String {
    return when {
        time <= MINUTE -> "Был(а) только что"
        time >= DAY && time <= TWO_DAY -> "Был(а) сегодня"
        time >= TWO_DAY && time <= THREE_DAY -> "Был(а) вчера"
        time > THREE_DAY -> "Был(а) давно"
        else -> selectWordEnding(time)
    }
}