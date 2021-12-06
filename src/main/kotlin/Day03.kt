class Day03 {
    private val input:List<String> = getInput("day_03")

    private inline fun <reified T> transpose(list: List<List<T>>): List<List<T>> {
        val cols = list[0].size
        val rows = list.size
        return List(cols) { j ->
            List(rows) { i ->
                list[i][j]
            }
        }
    }

    fun task01(): Int {
        var gammaBits = ""
        var epsilonBits = ""

        val inputLists = input.toMutableList().map {
                row -> row.toCharArray().map {
                    it.code  - '0'.code // shitty solution to convert char sequence to int sequence
                }
        }

        val transposedInputList = transpose(inputLists)

        val bitSum = transposedInputList.map { it.sum() }

        bitSum.forEach {
            gammaBits += if (it > inputLists.size / 2 ) "1" else "0"
            epsilonBits += if (it < inputLists.size / 2 ) "1" else "0"
        }

        println(inputLists)
        println(bitSum)
        println(gammaBits)
        println(epsilonBits)
        val gamma = Integer.parseInt(gammaBits, 2)
        val epsilon = Integer.parseInt(epsilonBits, 2)

        return gamma * epsilon
    }


    fun task02() {

    }
}

fun main() {
    println(Day03().task01())
}