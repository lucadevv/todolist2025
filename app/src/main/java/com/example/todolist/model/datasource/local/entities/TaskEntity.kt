package com.example.todolist.model.datasource.local.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(
    tableName = "task_table",
    foreignKeys = [
        ForeignKey(
            CategoryEntity::class,
            parentColumns = ["idCategory"],
            childColumns = ["idCategory"]
        )
    ]
)
data class TaskEntity(
    @PrimaryKey(autoGenerate = true)
    val idTask: Int = 0,
    val name: String,
    val state: Boolean = false,
    val idCategory:Int,
)
