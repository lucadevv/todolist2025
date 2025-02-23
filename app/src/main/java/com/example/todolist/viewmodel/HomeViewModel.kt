package com.example.todolist.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todolist.model.datasource.local.entities.CategoryEntity
import com.example.todolist.model.repository.CategoryRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class HomeViewModel(
    private val categoryRepository: CategoryRepository,
):ViewModel(){

    private val _listCategories = MutableStateFlow<List<CategoryEntity>>(emptyList())
    val listCategories: StateFlow<List<CategoryEntity>> = _listCategories

    init {
        getAllCategories()
    }
    private fun getAllCategories(){
        viewModelScope.launch {
         categoryRepository.getAllCategories().collect{categories->
             _listCategories.value = categories
         }

        }
    }

}