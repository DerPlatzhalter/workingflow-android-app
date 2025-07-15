package com.workingflow.features.friend

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class Friend(
    val id: String,
    val name: String,
    val online: Boolean
)

@Composable
fun FriendListScreen(
    friends: List<Friend>,
    onFriendClick: (Friend) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(friends) { friend ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .clickable { onFriendClick(friend) }
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = friend.name, style = MaterialTheme.typography.titleMedium)
                    Text(
                        text = if (friend.online) "Online" else "Offline",
                        style = MaterialTheme.typography.bodySmall,
                        color = if (friend.online) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}
