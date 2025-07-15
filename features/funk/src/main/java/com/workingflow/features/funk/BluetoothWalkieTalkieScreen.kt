package com.workingflow.features.funk

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BluetoothWalkieTalkieScreen(
    isTalking: Boolean,
    onPushToTalk: (Boolean) -> Unit,
    nearbyDevices: List<String>
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Bluetooth Walkie-Talkie", style = MaterialTheme.typography.headlineMedium, modifier = Modifier.padding(bottom = 24.dp))
        Button(
            onClick = { onPushToTalk(!isTalking) },
            modifier = Modifier.size(150.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (isTalking) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary
            )
        ) {
            Text(text = if (isTalking) "Release to Talk" else "Push to Talk", style = MaterialTheme.typography.headlineSmall)
        }
        Spacer(modifier = Modifier.height(24.dp))
        Text(text = "Nearby Devices:", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(8.dp))
        nearbyDevices.forEach { device ->
            Text(text = device, style = MaterialTheme.typography.bodyMedium, modifier = Modifier.padding(vertical = 4.dp))
        }
    }
}
