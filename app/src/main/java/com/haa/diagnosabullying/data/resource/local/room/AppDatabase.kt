package com.haa.diagnosabullying.data.resource.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.google.gson.Gson
import com.haa.diagnosabullying.R
import com.haa.diagnosabullying.data.resource.local.room.dao.QuestionDao
import com.haa.diagnosabullying.data.resource.local.room.entity.QuestionEntity
import com.haa.diagnosabullying.helper.readJsonFromRaw
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [QuestionEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun questionDao(): QuestionDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).addCallback(object : Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        INSTANCE?.let { database ->
                            val json: String? = readJsonFromRaw(context, R.raw.question)
                            if (json != null) {
                                val questionList: List<QuestionEntity> =
                                    Gson().fromJson(json, Array<QuestionEntity>::class.java)
                                        .toList()
                                CoroutineScope(Dispatchers.Default).launch {
                                    database.questionDao().insertAll(questionList)
                                }
                            }
                        }
                    }
                }).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
