package com.example.pomodoro.data.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface SesionDao {
    @Query("SELECT * FROM sesiones WHERE date >= :semana")
    suspend fun getSesionesEstaSemana(semana: Long): List<Sesion>
    @Query("SELECT * FROM sesiones WHERE date >= :hoy")
    suspend fun getSesionesHoy(hoy: Long): List<Sesion>
    @Query("SELECT * FROM sesiones ORDER BY date ASC")
    suspend fun getRacha(): List<Sesion>

    @Insert
    suspend fun insertSesion(vararg sesiones: Sesion)

    @Update
    suspend	fun updateSesion (vararg sesiones: Sesion)
}