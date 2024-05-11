package com.example.proiecttestare

import junit.framework.TestCase.assertTrue
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class PerformanceJUnitTests {
    private lateinit var calculator: Functionalities
    @BeforeEach
    fun setUp() {
        calculator = Functionalities()
    }

    @Test
    fun calculateCubePerformanceTest() {
        val warmupIterations = 1000
        val testIterations = 100000

        //warmup
        repeat(warmupIterations) {
            val number = (0..100).random()
            calculator.calculateCube(number)
        }

        //test
        val startTime = System.currentTimeMillis()

        repeat(testIterations) {
            val number = (0..100).random()
            calculator.calculateCube(number)
        }

        val endTime = System.currentTimeMillis()
        val totalTime = endTime - startTime

        println("Total time for $testIterations iterations: $totalTime ms")
        Assertions.assertTrue(totalTime < 5000)
    }

    @Test
    fun squareAndSortingPerformance() {
        val warmupIterations = 1000
        val testIterations = 10000

        //warmup
        repeat(warmupIterations) {
            val number = (0..100).random()
            calculator.calculateSquare(number)
        }


        //test
        //test caculateSquare functionality first
        val startSquareTime = System.currentTimeMillis()

        repeat(testIterations) {
            val number = (0..100).random()
            calculator.calculateSquare(number)
        }

        val endSquareTime = System.currentTimeMillis()
        val totalSquareTime = endSquareTime - startSquareTime

        Assertions.assertTrue(totalSquareTime < 5000)


        //test sorting functionality
        val startSortingTime = System.currentTimeMillis()

        calculator.getResultsSorted()

        val endSortingTime = System.currentTimeMillis()
        val totalSortingTime = endSortingTime - startSortingTime

        Assertions.assertTrue(totalSortingTime < 7000)
    }

}