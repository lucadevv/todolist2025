package com.example.todolist.model.datasource.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(
    tableName = "category_table"
)
data class CategoryEntity(
    @PrimaryKey(autoGenerate = true)
    val idCategory: Int = 0,
    val nameCategory: String,
)
