package com.swapnil.jetchat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.swapnil.jetchat.ui.JetChatNavHost
import com.swapnil.jetchat.ui.theme.JetChatTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetChatTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    JetChatNavHost(innerPadding)
                }
            }
        }
    }
}
