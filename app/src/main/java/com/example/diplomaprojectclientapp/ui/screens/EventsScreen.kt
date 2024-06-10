package com.example.diplomaprojectclientapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.diplomaprojectclientapp.viewmodel.Event
import com.example.diplomaprojectclientapp.viewmodel.EventsViewModel
import org.koin.androidx.compose.koinViewModel
import androidx.navigation.NavHostController


@Composable
fun EventsScreen(navController: NavHostController) {
    val viewModel: EventsViewModel = koinViewModel()
    val events = viewModel.events.value

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(events.size) { index ->
            val event = events[index]
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = event.title, style = MaterialTheme.typography.headlineSmall)
                    Text(text = event.description, style = MaterialTheme.typography.labelMedium)
                }
            }
        }
    }
}