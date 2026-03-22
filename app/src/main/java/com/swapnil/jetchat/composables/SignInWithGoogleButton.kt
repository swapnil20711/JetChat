package com.swapnil.jetchat.composables

import android.app.Activity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.swapnil.jetchat.R

@Composable
fun SignInWithGoogleButton(
    onSuccess: (FirebaseUser) -> Unit,
    onFailure: (Exception?) -> Unit
) {
    val signInLauncher = rememberLauncherForActivityResult(
        FirebaseAuthUIActivityResultContract()
    ) { result: FirebaseAuthUIAuthenticationResult ->
        val response = result.idpResponse
        if (result.resultCode == Activity.RESULT_OK) {
            val user = FirebaseAuth.getInstance().currentUser
            user?.let {
                onSuccess(it)
            } ?: onFailure(Exception("Unable to get the user!"))
        } else {
            if (response != null) {
                onFailure(response.error)
            }
        }
    }

    ElevatedButton(onClick = {
        // Move Firebase UI initialization inside onClick to avoid crashes during Composable Preview
        // where FirebaseApp might not be initialized and Context might be null.
        val providers = arrayListOf(
            AuthUI.IdpConfig.GoogleBuilder().build()
        )

        val signInIntent = AuthUI.getInstance()
            .createSignInIntentBuilder()
            .setAvailableProviders(providers)
            .build()
        
        signInLauncher.launch(signInIntent)
    }) {
        Image(
            modifier = Modifier
                .size(32.dp)
                .padding(end = 12.dp),
            painter = painterResource(id = R.drawable.google),
            contentDescription = "Google icon"
        )
        Text("Sign In with Google", fontWeight = FontWeight.Bold)
    }
}

@Composable
@Preview
fun SignInButtonPreview() {
    SignInWithGoogleButton(onSuccess = {

    }, onFailure = {

    })
}
