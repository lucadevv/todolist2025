package com.example.todolist.model.datasource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.todolist.model.datasource.local.entities.SubTaskEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface SubTaskDao {
    @Insert
    suspend fun insertSubTask(subTaskEntity: SubTaskEntity)
    @Query("SELECT * FROM subtask_table")
    fun getAllSubTask(): Flow<List<SubTaskEntity>>
}