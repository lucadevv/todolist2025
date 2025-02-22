package com.example.todolist.model.datasource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.todolist.model.datasource.local.entities.TaskEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface TaskDao {
    @Insert
    suspend fun insertTask(taskEntity: TaskEntity)
    @Query("SELECT * FROM task_table")
    fun getAllTask():Flow<List<TaskEntity>>
}