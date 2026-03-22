package com.swapnil.jetchat.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.swapnil.jetchat.feature.editProfile.EditProfileScreen
import com.swapnil.jetchat.feature.login.LoginScreen
import com.swapnil.jetchat.feature.splash.SplashScreen

@Composable
fun JetChatNavHost(innerPadding: PaddingValues) {
        val navController = rememberNavController()
        NavHost(modifier = Modifier.padding(innerPadding),navController = navController, startDestination = Screen.Splash.name){
            composable(Screen.Splash.name){
                SplashScreen()
            }
            composable(Screen.Login.name){
                LoginScreen()
            }
            composable(Screen.EditProfile.name) {
                EditProfileScreen()
            }
        }
    }