package com.example.proiecttestare

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe

class SquareCalculatorKotestTest : StringSpec({

    "test calc for positive number" {
        val squareCalculator = SquareCalculator()
        val result = squareCalculator.calculateSquare(5)
        result shouldBe 25
    }

    "test calc for negative number" {
        val squareCalculator = SquareCalculator()
        val result = squareCalculator.calculateSquare(-3)
        result shouldBe 9
    }

    "test calc for zero" {
        val squareCalculator = SquareCalculator()
        val result = squareCalculator.calculateSquare(0)
        result shouldBe 0
    }

    "test sort with positive numbers" {
        val squareCalculator = SquareCalculator()
        squareCalculator.calculateSquare(3)
        squareCalculator.calculateSquare(1)
        squareCalculator.calculateSquare(2)

        val sortedResults = squareCalculator.getResultsSorted()
        sortedResults shouldContainExactly listOf(1, 4, 9)
    }

    "test sort with negative numbers" {
        val squareCalculator = SquareCalculator()
        squareCalculator.calculateSquare(-3)
        squareCalculator.calculateSquare(-1)
        squareCalculator.calculateSquare(-2)

        val sortedResults = squareCalculator.getResultsSorted()
        sortedResults shouldContainExactly listOf(1, 4, 9)
    }

    "test sort with mixed numbers" {
        val squareCalculator = SquareCalculator()
        squareCalculator.calculateSquare(-3)
        squareCalculator.calculateSquare(1)
        squareCalculator.calculateSquare(2)

        val sortedResults = squareCalculator.getResultsSorted()
        sortedResults shouldContainExactly listOf(1, 4, 9)
    }
})
