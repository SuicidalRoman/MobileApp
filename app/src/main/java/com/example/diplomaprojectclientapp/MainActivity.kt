package com.example.diplomaprojectclientapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.diplomaprojectclientapp.di.appModule
import com.example.diplomaprojectclientapp.ui.screens.HomeScreen
import com.example.diplomaprojectclientapp.ui.screens.LoginScreen
import com.example.diplomaprojectclientapp.ui.screens.MainScreen
import com.example.diplomaprojectclientapp.ui.screens.RegisterScreen
import com.example.diplomaprojectclientapp.ui.theme.DiplomaProjectClientAppTheme

import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startKoin {
            androidContext(this@MainActivity)
            modules(appModule)
        }
        setContent {
            DiplomaProjectClientAppTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    Navigation()
                }
            }
        }
    }
}

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginScreen(navController) }
        composable("home") { HomeScreen()  }
        composable("register") { RegisterScreen(navController) }
        composable("main") { MainScreen()}
    }
}
