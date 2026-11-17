package educa.iesam.examen.karamon.simpsons.feature.data.local

import educa.iesam.examen.karamon.simpsons.feature.data.local.xml.SimpsonsXMLDataSource
import educa.iesam.examen.karamon.simpsons.feature.domain.Simpsons
import educa.iesam.examen.karamon.simpsons.feature.domain.SimpsonsRepository

class SimpsonsLocalDataSource(private val xmlDataSource: SimpsonsXMLDataSource) :
    SimpsonsRepository {
    override fun obtenerTodo(): List<Simpsons> {
        return xmlDataSource.buscarTodo()
    }
}