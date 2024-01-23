package com.example.test_rpay_finance.view.ui.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.test_rpay_finance.model.ToDo
import com.example.test_rpay_finance.viewmodel.LocationViewModel

@Composable
fun MainScreen(navController: NavHostController, viewModel: LocationViewModel) {
    var title by remember { mutableStateOf("") }
    var desc by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column(Modifier.padding(16.dp)) {
        Text(text = "Title", fontWeight = FontWeight.Bold)
        TextField(value = title, onValueChange = { title = it })
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Description", fontWeight = FontWeight.Bold)
        TextField(value = desc, onValueChange = { desc = it })
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            viewModel.addList(ToDo(title, desc))
            Toast.makeText(context, "Berhasil", Toast.LENGTH_SHORT).show()
        }) {
            Text(text = "Add")
        }
        Button(onClick = {
            navController.navigate("detail")
        }) {
            Text(text = "To-Do List Page")
        }
    }
}