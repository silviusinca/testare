package com.example.proiecttestare
import android.view.Menu
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock

@RunWith(AndroidJUnit4::class)
class CoverageTest {

    @Test
    fun testOptionsMenuInflated() {
        val scenario = ActivityScenario.launch(MainActivity::class.java)

        val menu = mock(Menu::class.java)
        val result = MainActivity().onCreateOptionsMenu(menu)
        assert(result)
        scenario.close()
    }

    @Test
    fun testOnSupportNavigateUp() {
        val scenario = ActivityScenario.launch(MainActivity::class.java)
        val navController = mock(NavController::class.java)
        val mainActivity = MainActivity()
        mainActivity.appBarConfiguration = AppBarConfiguration(setOf(), mock(DrawerLayout::class.java))

        assert(mainActivity.onSupportNavigateUp() == Navigation.findNavController(mainActivity, R.id.nav_host_fragment_content_main).navigateUp())
        scenario.close()
    }
}
