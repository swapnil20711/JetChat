package com.swapnil.jetchat.feature.editProfile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.swapnil.jetchat.composables.ChatAppBar
import kotlinx.coroutines.launch


@Preview
@Composable
fun EditProfileScreen(modifier: Modifier = Modifier) {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    Scaffold(snackbarHost = { SnackbarHost(hostState =snackbarHostState,modifier= Modifier.imePadding()) },topBar = { ChatAppBar("Edit Profile") }) { paddingValues ->
        var name by remember { mutableStateOf("") }
        Column(
            modifier = modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = name, onValueChange = {
                    name = it
                },
                label = { Text("Name") })

            // "     " ->!Empty,blank
            //Empty -> len = 0
            //Blank -> len=0 || only space
            Button(modifier= Modifier.padding(24.dp).align(Alignment.CenterHorizontally),onClick = {
                if(name.isNotBlank()){
                    scope.launch {
                        snackbarHostState.showSnackbar("Name is $name")
                    }
                }else{
                    scope.launch {
                        snackbarHostState.showSnackbar("Please input your name")
                    }
                }
            }) {
                Text("Save")
            }

        }
    }

}