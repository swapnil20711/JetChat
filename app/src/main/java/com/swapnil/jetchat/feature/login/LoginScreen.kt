package com.swapnil.jetchat.feature.login



import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.swapnil.jetchat.composables.ChatAppBar
import com.swapnil.jetchat.composables.SignInWithGoogleButton
import com.swapnil.jetchat.ui.Screen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavHostController) {
    val context = LocalContext.current
    Scaffold(topBar = {
        ChatAppBar("Welcome to Chat App")
    }) { paddingValues ->
        Box(
            Modifier
                .fillMaxSize()
                .padding(paddingValues), contentAlignment = Alignment.Center
        ) {
            SignInWithGoogleButton(onSuccess = { user ->
                Toast.makeText(context, "Signed in as ${user.email}", Toast.LENGTH_SHORT).show()
                navController.navigate("EditProfile?email=${user.email}")
            }, onFailure = { error ->
                Toast.makeText(context, "Error ${error?.message}", Toast.LENGTH_SHORT).show()
            })
        }
    }
}