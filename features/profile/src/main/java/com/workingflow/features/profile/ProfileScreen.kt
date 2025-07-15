package com.workingflow.features.profile

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProfileScreen(
    displayName: String,
    bio: String,
    onEditProfile: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Text(text = "Profile", style = MaterialTheme.typography.headlineMedium, modifier = Modifier.padding(bottom = 24.dp))
        Text(text = "Display Name:", style = MaterialTheme.typography.titleMedium)
        Text(text = displayName, style = MaterialTheme.typography.bodyLarge, modifier = Modifier.padding(bottom = 16.dp))
        Text(text = "Bio:", style = MaterialTheme.typography.titleMedium)
        Text(text = bio, style = MaterialTheme.typography.bodyLarge, modifier = Modifier.padding(bottom = 24.dp))
        Button(onClick = onEditProfile, modifier = Modifier.fillMaxWidth()) {
            Text("Edit Profile")
        }
    }
}
