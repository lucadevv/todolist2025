package com.example.todolist

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.todolist.model.datasource.local.database.AppDatabase
import com.example.todolist.model.repository.CategoryRepository
import com.example.todolist.ui.theme.TodolistTheme
import com.example.todolist.viewmodel.HomeViewModel

class MainActivity : ComponentActivity() {
    private lateinit var appDatabase: AppDatabase
    private lateinit var categoryRepository: CategoryRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appDatabase = AppDatabase.getDatabase(applicationContext)
        val categoryDao = appDatabase.categoryDao()
        categoryRepository = CategoryRepository(categoryDao)
        val homeViewModel = HomeViewModel(categoryRepository)
        enableEdgeToEdge()
        setContent {
            App()
        }
    }
}
