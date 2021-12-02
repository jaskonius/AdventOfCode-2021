class Day02 {
    private val input:List<String> = getInput("day_02")

    data class Directions(
        var depth: Int = 0,
        var forward: Int = 0
    )

    data class DirectionsAim(
        private val directions: Directions = Directions(),
        var depth: Int = directions.depth,
        var forward: Int = directions.forward,
        var aim: Int = 0
    )

    fun task01(): Int {
        val directions: Directions = Directions()

        input.forEach {
            when {
                it.contains("up") -> directions.depth -= it.split(" ")[1].toInt()
                it.contains("down") -> directions.depth += it.split(" ")[1].toInt()
                it.contains("forward") -> directions.forward += it.split(" ")[1].toInt()
            }
        }

        return directions.depth * directions.forward
    }

    fun task02(): Int {
        val directionsAim: DirectionsAim = DirectionsAim()

        input.forEach {
            val value: Int = it.split(" ")[1].toInt()
            when {
                it.contains("up") -> {
                    directionsAim.aim -= value
                }
                it.contains("down") -> {
                    directionsAim.aim += value
                }
                it.contains("forward") -> {
                    directionsAim.forward += value
                    directionsAim.depth += directionsAim.aim * value
                }
            }
        }
        return directionsAim.depth * directionsAim.forward
    }
}

fun main() {
    println(Day02().task01())
    println(Day02().task02())
}