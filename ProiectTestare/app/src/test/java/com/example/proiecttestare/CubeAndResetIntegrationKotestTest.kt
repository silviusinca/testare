package com.example.proiecttestare
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.collections.shouldContainExactly
import kotlin.random.Random

class CubeAndResetIntegrationKotestTest : StringSpec( {
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

})