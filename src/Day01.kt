package Input

import java.io.File

private const val day = "01"

private const val expectTest1 = 7
private const val expectTest2 = 5

private fun part1(input: Iterable<Int>) =
    input
        .zip(input.drop(1))
        .count { it.second > it.first }

private fun part2(input: Iterable<Int>) =
    part1(input
        .zip(input
            .drop(1))
        .zip(input
            .drop(2))
        .map { it.first.first + it.first.second + it.second })

fun main() {
    val testInput = listOf(199, 200, 208, 210, 200, 207, 240, 269, 260, 263)

    check(part1(testInput) == expectTest1)

    val input = File("src/Input/Day$day.txt").readLines().map { it.toInt() }
    println("Day $day Part 1: ${part1(input)}")

    check(part2(testInput) == expectTest2)

    println("Day $day Part 2: ${part2(input)}")
}