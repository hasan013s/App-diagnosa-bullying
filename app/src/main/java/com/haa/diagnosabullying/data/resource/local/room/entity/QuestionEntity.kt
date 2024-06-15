package com.haa.diagnosabullying.data.resource.local.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "question_entity")
data class QuestionEntity(
    @PrimaryKey
    @SerializedName("id")
    @ColumnInfo(name = "id")
    val id: String,

    @ColumnInfo(name = "question")
    @SerializedName("question")
    val question: String
)
