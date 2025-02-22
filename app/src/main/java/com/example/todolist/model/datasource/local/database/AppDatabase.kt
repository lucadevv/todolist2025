package com.example.todolist.model.datasource.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.todolist.model.datasource.local.dao.CategoryDao
import com.example.todolist.model.datasource.local.dao.SubTaskDao
import com.example.todolist.model.datasource.local.dao.TaskDao

import com.example.todolist.model.datasource.local.entities.CategoryEntity
import com.example.todolist.model.datasource.local.entities.SubTaskEntity
import com.example.todolist.model.datasource.local.entities.TaskEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


@Database(
    entities =
    [
    CategoryEntity::class,
    TaskEntity::class,
    SubTaskEntity::class,
    ],
    version = 1,
    exportSchema = false,
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun categoryDao(): CategoryDao
    abstract fun taskDao():TaskDao
    abstract fun subTaskDao():SubTaskDao

    companion object{
        @Volatile
        private var Instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return Instance ?: synchronized(this){
                Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "app_database",
                ).addCallback(object :RoomDatabase.Callback(){
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)

                        val scope = CoroutineScope(Dispatchers.IO)

                        scope.launch {
                            val categoryDao = getDatabase(context).categoryDao()
                            val listCategories = listOf(
                                CategoryEntity(nameCategory = "Personal"),
                                CategoryEntity(nameCategory = "Trabajo"),
                                CategoryEntity(nameCategory = "Urgente"),
                                CategoryEntity(nameCategory = "Otros")
                            )

                            categoryDao.insertAllCategories(listCategories)
                        }
                    }
                })
                    .build()
                    .also { Instance = it  }
            }
        }
    }
}