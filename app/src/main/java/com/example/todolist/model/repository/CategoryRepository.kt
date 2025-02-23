package com.example.todolist.model.repository

import com.example.todolist.model.datasource.local.dao.CategoryDao
import com.example.todolist.model.datasource.local.entities.CategoryEntity
import kotlinx.coroutines.flow.Flow


class CategoryRepository(private val categoryDao: CategoryDao){
     fun getAllCategories(): Flow<List<CategoryEntity>> {
        return categoryDao.getAllCategories();
    }
}