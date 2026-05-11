package com.example.pomodoro.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sesiones")
data class Sesion (

    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(name = "focusTime") val focusTime: Int?,//lo guardamos en minutos enteros
    @ColumnInfo(name = "blocks") val blocks: Int?,
    @ColumnInfo (name= "date")val date : Long
)