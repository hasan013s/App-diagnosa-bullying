package com.haa.diagnosabullying.data.resource.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.haa.diagnosabullying.data.resource.local.room.entity.QuestionEntity

@Dao
interface QuestionDao {
    @Query("SELECT * FROM question_entity")
    suspend fun getAllQuestion(): List<QuestionEntity>

    @Insert
    suspend fun insertAll(users: List<QuestionEntity>)
}
