package educa.iesam.examen.karamon.simpsons.core.cache

import android.content.Context
import android.content.SharedPreferences
import educa.iesam.examen.karamon.simpsons.R
import educa.iesam.examen.karamon.simpsons.time.AppTime

interface AppCache {
    fun actualizarHora(clave: String)
    fun caducado(clave: String, tiempoDeVidaRestante: Long): Boolean

    class AppCacheTiempoDeVidaRestante(
        private val context: Context,
        private val actualizarHora: AppTime
    ) :
        AppCache {
        val preferenciasCompartidas: SharedPreferences = context.getSharedPreferences(
            context.getString(R.string.app_cache),
            Context.MODE_PRIVATE
        )

        override fun actualizarHora(clave: String) {
            preferenciasCompartidas.edit().apply {
                putLong(clave, actualizarHora.tiempoDeVidaRestante())
                apply()
            }
        }

        override fun caducado(
            clave: String,
            tiempoDeVidaRestante: Long
        ): Boolean {

            val tiempoGuardado = preferenciasCompartidas.getLong(clave, -1)
            return (actualizarHora.tiempoDeVidaRestante() - tiempoGuardado) >= tiempoDeVidaRestante
        }

    }
}