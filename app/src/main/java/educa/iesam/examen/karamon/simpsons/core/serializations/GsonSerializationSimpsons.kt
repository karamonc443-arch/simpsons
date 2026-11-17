package educa.iesam.examen.karamon.simpsons.core.serializations

import com.google.gson.Gson
import java.lang.reflect.Type

class GsonSerializationSimpsons<T>(private val tipo: Type, private val gson: Gson = Gson()) :
    JsonSerializationSimpsons<T> {
    override fun serializar(objeto: T): String = gson.toJson(objeto, tipo)

    override fun deserializar(json: String): T = gson.fromJson<T>(json, tipo)
        ?: throw IllegalArgumentException("El fichero de JSON está vacío o está nulo")
}