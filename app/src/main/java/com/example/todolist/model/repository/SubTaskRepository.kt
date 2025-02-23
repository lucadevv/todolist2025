package com.example.todolist.model.repository

import com.example.todolist.model.datasource.local.dao.SubTaskDao
import com.example.todolist.model.datasource.local.entities.SubTaskEntity
import kotlinx.coroutines.flow.Flow

class SubTaskRepository(private val subTaskDao: SubTaskDao) {
    fun getAllSubTask():Flow<List<SubTaskEntity>> = subTaskDao.getAllSubTask()
}