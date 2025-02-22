package com.example.todolist.model.datasource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.todolist.model.datasource.local.entities.CategoryEntity
import kotlinx.coroutines.flow.Flow


@Dao()
interface CategoryDao {
    @Insert
    suspend fun insertCategory(category: CategoryEntity )

    @Insert
    suspend fun insertAllCategories(listCategoryEntity: List<CategoryEntity>)

    @Query("SELECT * FROM category_table")
    fun getAllCategories():Flow<List<CategoryEntity>>
}