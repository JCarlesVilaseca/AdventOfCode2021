package Input

import java.io.File

private const val day = "02"

private const val expectTest1 = 150
private const val expectTest2 = 900

private fun part1(input: Iterable<String>) =
    input.fold(object { var x = 0; var depth = 0 }) { position, command ->
        val action = command.split(' ')
        val value = action[1].toInt()
        when(action[0]) {
            "forward" -> position.x += value
            "down" -> position.depth += value
            "up" -> position.depth -= value
        }
        position
     }.let {
         it.x * it.depth
    }

private fun part2(input: Iterable<String>) =
    input.fold(object { var x = 0; var depth = 0; var aim = 0}) { position, command ->
        val action = command.split(' ')
        val value = action[1].toInt()
        when(action[0]) {
            "forward" -> {
                position.x += value
                position.depth += position.aim * value
            }
            "down" -> position.aim += value
            "up" -> position.aim -= value
        }
        position
    }.let {
        it.x * it.depth
    }

fun main() {
    val testInput = listOf(
        "forward 5",
        "down 5",
        "forward 8",
        "up 3",
        "down 8",
        "forward 2"
    )

    check(part1(testInput) == expectTest1)

    val input = File("src/Input/Day$day.txt").readLines()
    println("Day $day Part 1: ${part1(input)}")

    check(part2(testInput) == expectTest2)

    println("Day $day Part 2: ${part2(input)}")
}