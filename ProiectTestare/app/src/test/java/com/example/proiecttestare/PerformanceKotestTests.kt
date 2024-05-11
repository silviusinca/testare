package com.example.proiecttestare

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.ints.beGreaterThan
import io.kotest.matchers.longs.shouldNotBeGreaterThan
import io.kotest.matchers.shouldNotBe
import kotlin.random.Random

class PerformanceKotestTests : StringSpec ({

    "test performance of calculateCube functionality" {
        val calculator = Functionalities()

        val warmupIterations = 1000
        val testIterations = 100000

        //warmup
        repeat(warmupIterations) {
            val number = Random.nextInt(101)
            calculator.calculateCube(number)
        }

        calculator.reset()

        //test
        val startTime = System.currentTimeMillis()

        repeat(testIterations) {
            val number = Random.nextInt(101)
            calculator.calculateCube(number)
        }

        val endTime = System.currentTimeMillis()
        val totalTime = endTime - startTime

        println("Total time for $testIterations iterations: $totalTime ms")
        totalTime shouldNotBeGreaterThan 5000

    }

    //!!valorile se pot schimba
    "test performance of sorting and square functionality" {
        val calculator = Functionalities()

        val warmupIterations = 1000
        val testIterations = 100000

        //warmup
        repeat(warmupIterations) {
            val number = Random.nextInt(101)
            calculator.calculateSquare(number)
        }

        calculator.reset()


        //test
        //testing square functionality first
        val startCalculateSquareTime = System.currentTimeMillis()

        repeat(testIterations) {
            val number = Random.nextInt(101)
            calculator.calculateSquare(number)
        }

        val endCalculateSquareTime = System.currentTimeMillis()
        val totalCalculateSquareTime = endCalculateSquareTime - startCalculateSquareTime

        totalCalculateSquareTime shouldNotBeGreaterThan 5000


        //testing the sorting functionality
        val startSortingTime = System.currentTimeMillis()

        calculator.getResultsSorted()

        val endSortingTime = System.currentTimeMillis()
        val totalSortingTime = endSortingTime - startSortingTime

        totalCalculateSquareTime shouldNotBeGreaterThan 7000
    }
})