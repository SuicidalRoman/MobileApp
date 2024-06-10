package com.example.diplomaprojectclientapp.ui.screens

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.diplomaprojectclientapp.data.model.Profile
import com.example.diplomaprojectclientapp.viewmodel.ProfileViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun ProfileScreen(navController: NavHostController = rememberNavController()) {
    val viewModel: ProfileViewModel = koinViewModel()
    val profile by viewModel.profile.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadProfile()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.TopEnd) {
            IconButton(onClick = { navController.navigate("settings") }) {
                Icon(Icons.Default.Settings, contentDescription = "Settings")
            }
        }

//        profile?.let {
//            ProfilePhoto(photoUrl = it.photoUrl) { newPhotoPath ->
//                viewModel.updateProfilePhoto(newPhotoPath)
//            }
//            Spacer(modifier = Modifier.height(16.dp))
//            ProfileInfo(profile = it)
//        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = { /* Log out logic */ }) {
            Text("Выйти")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = { /* Delete data logic */ }) {
            Text("Удалить данные")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = { navController.navigate("about") }) {
            Text("О приложении")
        }
    }
}

@Composable
fun ProfilePhoto(photoUrl: String?, onPhotoChange: (String) -> Unit) {
    val context = LocalContext.current
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri ->
            uri?.let {
                onPhotoChange(it.toString())
            }
        }
    )

    Box(
        modifier = Modifier
            .size(128.dp)
            .clip(CircleShape)
            .background(Color.Gray)
            .clickable { launcher.launch("image/*") },
        contentAlignment = Alignment.Center
    ) {
        if (photoUrl.isNullOrEmpty()) {
            Icon(Icons.Default.Person, contentDescription = "Profile Photo", modifier = Modifier.size(64.dp))
        } else {
//            Image(
//                painter = rememberImagePainter(photoUrl),
//                contentDescription = "Profile Photo",
//                modifier = Modifier.fillMaxSize(),
//                contentScale = ContentScale.Crop
//            )
        }
    }
}

@Composable
fun ProfileInfo(profile: Profile) {
    Column(horizontalAlignment = Alignment.Start) {
        Text("ФИО: ${profile.firstname} ${profile.surname} ${profile.patronymic ?: ""}")
        Text("Дата рождения: ${profile.birthdate}")
        Text("Дата регистрации: ${profile.phone}")
        Text("Телефон: ${profile.phone}")
    }
}
