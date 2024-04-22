package com.example.proiecttestare
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainInOrder
import io.kotest.matchers.shouldBe
import kotlin.random.Random

class IntegrationKotestTests : StringSpec( {
    "test calculateCube and reset functionality" {
        //testing with a valid random number
        val number = Random.nextInt(101)

        val calculator = Functionalities()
        val cube = calculator.calculateCube(number)

        cube shouldBe number*number*number

        //testing reset functionality after cube calculation
        calculator.reset()
        calculator.getResultsSorted() shouldBe emptyList()

    }

    "test calculate square and reset functionality" {
        //testing with a random nr
        val number = Random.nextInt(101)
        val calculator = Functionalities()

        //testing the square functionality
        val square = calculator.calculateSquare(number)
        square shouldBe number * number

        //testing the reset functionality
        calculator.reset()
        calculator.getResultsSorted() shouldContainInOrder emptyList()
    }

    "test calculate square and calculate cube functionality" {
        //testing with a random nr
        val number  = Random.nextInt(101)
        val calculator = Functionalities()

        //testing the square functionality
        val square = calculator.calculateSquare(number)
        square shouldBe number * number

        val cube = calculator.calculateCube(square)
        cube shouldBe square * square * square
    }

})