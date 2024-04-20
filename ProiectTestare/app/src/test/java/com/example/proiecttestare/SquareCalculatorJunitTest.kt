package com.example.proiecttestare

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Testare unitara pe SquareCalculator - JUnit5")
class SquareCalculatorJunitTest {

    private lateinit var squareCalculator: Functionalities

    @BeforeEach
    fun setUp() {
        squareCalculator = Functionalities()
    }

    @Test
    @DisplayName("Testarea ridicarii la patrat al unui numar pozitiv - JUnit5")
    fun testCalcForPositiveNumber() {
        val result = squareCalculator.calculateSquare(5)
        assertEquals(25, result)
    }

    @Test
    fun testCalcForNegativeNumber() {
        val result = squareCalculator.calculateSquare(-3)
        assertEquals(9, result)
    }

    @Test
    fun testCalcForZero() {
        val result = squareCalculator.calculateSquare(0)
        assertEquals(0, result)
    }

    @Test
    fun testSortWithPositiveNumbers() {
        squareCalculator.calculateSquare(3)
        squareCalculator.calculateSquare(1)
        squareCalculator.calculateSquare(2)

        val sortedResults = squareCalculator.getResultsSorted()
        assertEquals(listOf(1, 4, 9), sortedResults)
    }

    @Test
    fun testSortWithNegativeNumbers() {
        squareCalculator.calculateSquare(-3)
        squareCalculator.calculateSquare(-1)
        squareCalculator.calculateSquare(-2)

        val sortedResults = squareCalculator.getResultsSorted()
        assertEquals(listOf(1, 4, 9), sortedResults)
    }

    @Test
    fun testSortWithMixedNumbers() {
        squareCalculator.calculateSquare(-3)
        squareCalculator.calculateSquare(1)
        squareCalculator.calculateSquare(2)

        val sortedResults = squareCalculator.getResultsSorted()
        assertEquals(listOf(1, 4, 9), sortedResults)
    }
}
