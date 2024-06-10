package com.example.diplomaprojectclientapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.diplomaprojectclientapp.data.repository.Request
import com.example.diplomaprojectclientapp.viewmodel.HomeViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen() {
    val viewModel: HomeViewModel = koinViewModel()
    val requests by viewModel.requests.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(requests) { request ->
            RequestCard(request)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun RequestCard(request: Request) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
//        elevation = 4.dp
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Request ID: ${request.id}")
            Text(text = "Request Title: ${request.title}")
            Text(text = "Request Description: ${request.description}")
        }
    }
}