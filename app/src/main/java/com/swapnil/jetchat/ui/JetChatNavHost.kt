package com.swapnil.jetchat.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.swapnil.jetchat.feature.editProfile.EditProfileScreen
import com.swapnil.jetchat.feature.login.LoginScreen
import com.swapnil.jetchat.feature.splash.SplashScreen

@Composable
fun JetChatNavHost(innerPadding: PaddingValues) {
    val navController = rememberNavController()
    NavHost(
        modifier = Modifier.padding(innerPadding),
        navController = navController,
        startDestination = Screen.Login.name
    ) {
        composable(Screen.Splash.name) {
            SplashScreen()
        }
        composable(Screen.Login.name) {
            LoginScreen(navController)
        }
        composable(
            route = Screen.EditProfile.name + "?email={email}",
            arguments = listOf(navArgument("email") {
                type = NavType.StringType
                nullable = true
                defaultValue = null
            })
        ) {
            val email = it.arguments?.getString("email")?:error("Email not passed")
            EditProfileScreen(email)
        }
    }
}