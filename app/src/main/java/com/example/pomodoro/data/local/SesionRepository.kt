package com.example.pomodoro.data.local

import com.example.pomodoro.data.model.Sesion
import com.example.pomodoro.data.model.SesionDao

class SesionRepository(private val sesionDao: SesionDao){
    suspend fun getSesionesEstaSemana(semana: Long): List<Sesion> {
        return sesionDao.getSesionesEstaSemana(semana)
    }
    suspend fun getSesionesHoy(hoy: Long): List<Sesion> {
        return sesionDao.getSesionesHoy(hoy)
    }
    suspend fun getRacha(): List<Sesion> {
        return sesionDao.getRacha()
    }
    suspend fun insertSesion(vararg sesiones: Sesion) {
        sesionDao.insertSesion(*sesiones)
    }
    suspend	fun updateSesion (vararg sesiones: Sesion) {
        sesionDao.updateSesion(*sesiones)
    }
}
