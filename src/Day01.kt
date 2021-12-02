import java.io.File

fun part1(input: List<Int>): Int {
    return input.zip(input.drop(1)).count { it.second > it.first }
}

fun part2(input: List<Int>): Int {
    return part1(input.zip(input.drop(1)).zip(input.drop(2)).map { it.first.first + it.first.second + it.second })
}

fun main() {
    val testInput = listOf(199, 200, 208, 210, 200, 207, 240, 269, 260, 263)

    check(part1(testInput) == 7)

    val input = File("src/Input/Day01.txt").readLines().map { it.toInt() }
    println("Day 01 Part 1: ${part1(input)}")

    check(part2(testInput) == 5)

    println("Day 01 Part 2: ${part2(input)}")
}