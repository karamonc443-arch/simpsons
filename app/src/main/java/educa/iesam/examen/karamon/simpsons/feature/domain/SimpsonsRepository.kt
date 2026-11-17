package educa.iesam.examen.karamon.simpsons.feature.domain

interface SimpsonsRepository {
    fun obtenerTodo(): List<Simpsons>
}