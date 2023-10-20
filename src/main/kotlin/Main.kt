fun <T: Comparable<T>> increasingSubsequences(seq: Sequence<T>): Sequence<List<T>> {
    fun helper(current: List<T>, rest: Sequence<T>): Sequence<List<T>> = sequence {
        val first = rest.firstOrNull()
        //Проверка на пустоту внутри~
        if (first == null) {
            if (current.isNotEmpty()) yield(current)
        } else {
            //Ищем возврастающие подпоследовательности
            if (current.isEmpty() || first > current.last()) {
                // Добавляем текущий элемент к подпоследовательности и продолжаем рекурсивно
                yieldAll(helper(current + first, rest.drop(1)))
            }
            // Пропускаем текущий элемент и продолжаем рекурсивно
            yieldAll(helper(current, rest.drop(1)))
        }
    }
    return helper(emptyList(), seq)
}

fun main() {
    val seq = sequenceOf(1, 2, 3) //условно бесконечная последовательность
    increasingSubsequences(seq).forEach { println(it) }
}