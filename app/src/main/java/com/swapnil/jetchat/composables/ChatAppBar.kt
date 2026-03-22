package com.swapnil.jetchat.composables

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatAppBar(title: String) {
    TopAppBar(
        title = { Text(title) }, colors = TopAppBarDefaults.topAppBarColors(
            MaterialTheme.colorScheme.primary,
            titleContentColor = Color.White
        )
    )
}