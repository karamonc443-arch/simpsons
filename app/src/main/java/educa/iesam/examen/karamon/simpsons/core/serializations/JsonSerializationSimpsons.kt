package educa.iesam.examen.karamon.simpsons.core.serializations

interface JsonSerializationSimpsons<T> {
    fun serializar(objeto: T): String
    fun deserializar(json: String): T
}