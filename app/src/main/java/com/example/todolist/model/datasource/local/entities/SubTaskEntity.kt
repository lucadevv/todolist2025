package com.example.todolist.model.datasource.local.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(
    tableName = "subtask_table",
    foreignKeys = [
        ForeignKey(
            TaskEntity::class,
            parentColumns = ["idTask"],
            childColumns = ["idTask"],
        )
    ]
)
data class SubTaskEntity(
    @PrimaryKey(autoGenerate = true)
    val idSubTask:Int = 0,
    val nameSubTask: String,
    val state:Boolean = false,
    val idTask:Int

)
