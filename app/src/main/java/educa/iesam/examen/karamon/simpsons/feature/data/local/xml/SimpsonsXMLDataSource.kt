package educa.iesam.examen.karamon.simpsons.feature.data.local.xml

import android.content.Context
import android.content.SharedPreferences
import educa.iesam.examen.karamon.simpsons.R
import educa.iesam.examen.karamon.simpsons.core.cache.AppCache
import educa.iesam.examen.karamon.simpsons.core.serializations.JsonSerializationSimpsons
import educa.iesam.examen.karamon.simpsons.feature.domain.Simpsons

class SimpsonsXMLDataSource(
    private val contexto: Context,
    private val serialization: JsonSerializationSimpsons<List<Simpsons>>,
    private val appCache: AppCache
) {
    private val claveSimpson: String = "simpson"
    private val tiempoDeVidaRestante: Long = 5 * 60 * 100
    val preferenciasCompartidas: SharedPreferences = contexto.getSharedPreferences(
        contexto.getString(R.string.simpsons_local_xml), Context.MODE_PRIVATE
    )

    fun guardar(simpsons: List<Simpsons>) {
        preferenciasCompartidas.edit().apply {
            putString(claveSimpson, serialization.serializar(simpsons))
            apply()
        }
    }

    fun buscarTodo(): List<Simpsons> {
        if (!appCache.caducado(claveSimpson, tiempoDeVidaRestante)) {
            val listaSimpsons: String? = preferenciasCompartidas.getString(claveSimpson, null)
            listaSimpsons?.let {
                return serialization.deserializar(it)
            }
        }
        return emptyList()
    }

    fun buscarPorId(id: String): Simpsons? {
        return buscarTodo().find { it.id == id }
    }

    fun eliminarPorId(id: String) {
        guardar(buscarTodo().filter { it.id != id })
    }

    fun eliminarTodo() {
        preferenciasCompartidas.edit().apply {
            remove(claveSimpson)
            apply()
        }
    }

    fun actualizar(simpson: Simpsons) {
        val simpsons = buscarTodo().filterNot { it.id == simpson.id }.toMutableList()
        simpsons.add(simpson)
        guardar(simpsons)
    }

}