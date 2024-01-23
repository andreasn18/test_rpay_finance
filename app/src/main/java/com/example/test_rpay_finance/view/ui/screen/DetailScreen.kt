package com.example.test_rpay_finance.view.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.test_rpay_finance.viewmodel.LocationViewModel

@Composable
fun DetailScreen(navController: NavHostController, viewModel: LocationViewModel) {
    val location by viewModel.location
    val todoList by viewModel.todoList

    Column(Modifier.padding(16.dp)) {
        Row {
            Text(text = "ID: ${location.country_code}")
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = "Country: ${location.country}")
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = "Region: ${location.region}")
            Spacer(modifier = Modifier.width(4.dp))
        }
        Spacer(modifier = Modifier.height(8.dp))
        LazyColumn() {
            items(todoList) {
                Text(text = it.title, fontWeight = FontWeight.Bold)
                Text(text = it.desc)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }

    DisposableEffect(key1 = Unit) {
        viewModel.getLocation()
        onDispose { }
    }
}