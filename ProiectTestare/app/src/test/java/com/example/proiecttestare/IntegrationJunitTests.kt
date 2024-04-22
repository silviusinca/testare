package com.example.proiecttestare

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.runner.RunWith
import kotlin.random.Random

@RunWith(AndroidJUnit4::class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class IntegrationJunitTests {

    private lateinit var calculator: Functionalities
    @BeforeEach
    fun setUp() {
        calculator = Functionalities()
    }

    @Test
    fun testCalculateCubeAndResetFunctionality() {
        //testing with a random number
        val number = Random.nextInt(101)


        //testing the cube functionality
        val cube = calculator.calculateCube(number)
        assertEquals(number*number*number, cube)


        //testing reset functionality after cube calculation
        calculator.reset()
        val result = calculator.getResultsSorted()
        assertEquals(emptyList<Int>(), result)
    }

    @Test
    fun testCalculateSquareAndResetFunctionality() {
        //testing with a random nr
        val number = Random.nextInt(101)

        //testing the square functionality
        val square = calculator.calculateSquare(number);
        assertEquals(number * number, square);

        //testing the reset functionality
        calculator.reset();
        val result = calculator.getResultsSorted();
        assertEquals(emptyList<Int>(), result)

    }

    @Test
    fun testCalculateCubeAndSquareFunctionality() {
        //testing with a random nr
        val number =  Random.nextInt(101);

        //testing the square functionality
        val square = calculator.calculateSquare(number);
        assertEquals(number * number, square);

        //testing the cube functionality
        val cube = calculator.calculateCube(square);
        assertEquals(square * square * square, cube);
    }

}