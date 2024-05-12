package com.example.proiecttestare

import android.os.Bundle
import android.view.Menu
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.proiecttestare.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var appBarConfiguration: AppBarConfiguration
    lateinit var binding: ActivityMainBinding
    lateinit var editTextNumber: EditText
    lateinit var textViewResult: TextView
    val results = mutableListOf<Int>()
    var functionality = Functionalities()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)


        editTextNumber = findViewById(R.id.editTextNumber)
        textViewResult = findViewById(R.id.textViewResult)


        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    fun calculateSquare(view: android.view.View) {
        val inputText = editTextNumber.text.toString().trim()
        if (inputText.isEmpty()) {
            textViewResult.text = "Please enter a number"
            return
        }

        val number = inputText.toIntOrNull()

        if (number == null || number !in -100000..100000) {
            textViewResult.text = "Invalid number. Please enter a number between -100000 and 100000"
            return
        }

        val square = functionality.calculateSquare(number)
        displayResults()
    }

    fun calculateCube(view: android.view.View) {
        val inputText = editTextNumber.text.toString().trim()
        if (inputText.isEmpty()) {
            textViewResult.text = "Please enter a number"
            return
        }

        val number = inputText.toIntOrNull()

        if (number == null || number !in -100000..100000) {
            textViewResult.text = "Invalid number. Please enter a number between -100000 and 100000"
            return
        }

        val cube = functionality.calculateCube(number)
        displayResults()
    }

    fun reset(view: android.view.View) {
        functionality.reset()
        textViewResult.text = ""
        displayResults()
    }


    fun displayResults() {
        results.sort()
        val resultText = functionality.getResultsSorted().joinToString(", ") { it.toString() }
        textViewResult.text = resultText
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}

class Functionalities {
    private val results = mutableListOf<Int>()

    fun calculateSquare(number: Int): Int {
       val square = number * number
       results.add(square)
       return square
    }

    fun calculateCube(number: Int): Int {
        val cube = number * number * number
        results.add(cube)
        return cube
    }
    
    fun reset() {
        results.clear()
    }

    fun getResultsSorted(): List<Int> {
        results.sort()
        return results.toList()
    }
}