class Day_01 {
    private val input:List<String> = getInput("day_01")
    private val numbers: List<Int> = input.map { it.toInt() }

    fun task01(): Int {
        var counter: Int = 0
        val pairs: List<List<Int>> = numbers.windowed(size = 2, step = 1)
        pairs.forEach {
            counter += (it.first() < it.last()).toInt()
        }

        return counter
    }

    fun task02(): Int {
        var counter: Int = 0
        val sums: MutableList<Int> = mutableListOf()
        val windows: List<List<Int>> = numbers.windowed(size = 3, step = 1)
        windows.forEach {
            sums.add(it.sum())
        }

        val pairs: List<List<Int>> = sums.windowed(size = 2, step = 1)
        pairs.forEach {
            counter += (it.first() < it.last()).toInt()
        }

        return counter
    }

    fun Boolean.toInt(): Int = if (this) 1 else 0

}

fun main() {
    println(Day_01().task01())
    println(Day_01().task02())
}