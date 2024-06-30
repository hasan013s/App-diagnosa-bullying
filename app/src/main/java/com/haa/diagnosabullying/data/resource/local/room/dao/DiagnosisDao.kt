package com.haa.diagnosabullying.data.resource.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.haa.diagnosabullying.data.resource.local.room.entity.DiagnosisEntity

@Dao
interface DiagnosisDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(diagnosisEntity: DiagnosisEntity): Long

    @Query("SELECT * FROM stress_level_entity WHERE id = :id")
    suspend fun getById(id: Int): DiagnosisEntity?

    @Query("SELECT * FROM stress_level_entity")
    suspend fun getAll(): List<DiagnosisEntity>

    @Query("DELETE FROM stress_level_entity WHERE id = :id")
    suspend fun deleteById(id: String)
}