package com.example.test_rpay_finance

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.test_rpay_finance.view.ui.screen.DetailScreen
import com.example.test_rpay_finance.view.ui.screen.MainScreen
import com.example.test_rpay_finance.view.ui.theme.Test_rpay_financeTheme
import com.example.test_rpay_finance.viewmodel.LocationViewModel

class MainActivity : ComponentActivity() {
    private val locationVM: LocationViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test_rpay_financeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navigation()
                }
            }
        }
    }

    @Composable
    fun Navigation() {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "main") {
            composable("main") {
                MainScreen(navController, locationVM)
            }
            composable("detail") {
                DetailScreen(navController, locationVM)
            }
        }
    }
}