package educa.iesam.examen.karamon.simpsons.core.serializations

import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json


class KotlinSerializationSimpsons<T>(
    private val serialization: KSerializer<T>,
    private val json: Json = Json { ignoreUnknownKeys = true }
) : JsonSerializationSimpsons<T> {
    override fun serializar(objeto: T): String = json.encodeToString(serialization, objeto)

    override fun deserializar(json: String): T = this.json.decodeFromString(serialization, json)

}