package com.example.test_rpay_finance.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test_rpay_finance.model.Location
import com.example.test_rpay_finance.model.ToDo
import com.example.testphincon.data.remote.RetrofitInstance
import kotlinx.coroutines.launch

class LocationViewModel : ViewModel() {
    private val apiService = RetrofitInstance.api

    val todoList: MutableState<List<ToDo>> = mutableStateOf(emptyList())
    private val rawTodoList = arrayListOf<ToDo>()

    val location: MutableState<Location> = mutableStateOf(Location())

    fun getLocation() {
        viewModelScope.launch {
            try {
                val response = apiService.getLocation()
                location.value = response
            } catch (e: Exception) {
                Log.e("Retrofit error", e.message.toString())
            }
        }
    }

    fun addList(todo: ToDo) {
        rawTodoList.add(todo)
        todoList.value = rawTodoList
    }
}