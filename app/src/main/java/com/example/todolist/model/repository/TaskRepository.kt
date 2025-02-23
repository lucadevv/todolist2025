package com.example.todolist.model.repository

import com.example.todolist.model.datasource.local.dao.TaskDao
import com.example.todolist.model.datasource.local.entities.TaskEntity
import kotlinx.coroutines.flow.Flow

class TaskRepository(private val taskDao: TaskDao) {
    fun getAllTask():Flow<List<TaskEntity>> = taskDao.getAllTask();
}