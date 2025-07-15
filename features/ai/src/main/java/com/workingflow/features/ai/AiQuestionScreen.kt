package com.workingflow.features.ai

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AiQuestionScreen(
    apiKey: String,
    onApiKeyChange: (String) -> Unit,
    question: String,
    onQuestionChange: (String) -> Unit,
    answer: String?,
    onSendQuestion: () -> Unit,
    isLoading: Boolean
) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        OutlinedTextField(
            value = apiKey,
            onValueChange = onApiKeyChange,
            label = { Text("API Key") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = question,
            onValueChange = onQuestionChange,
            label = { Text("Ask AI") },
            modifier = Modifier.fillMaxWidth().height(150.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = onSendQuestion,
            enabled = !isLoading && apiKey.isNotBlank() && question.isNotBlank(),
            modifier = Modifier.fillMaxWidth()
        ) {
            if (isLoading) {
                CircularProgressIndicator(
                    color = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.size(24.dp)
                )
            } else {
                Text("Send")
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        answer?.let {
            Text(text = it, style = MaterialTheme.typography.bodyLarge)
        }
    }
}
