package educa.iesam.examen.karamon.simpsons.time

interface AppTime {
    fun tiempoDeVidaRestante(): Long


    class AppLocalTime : AppTime {
        override fun tiempoDeVidaRestante(): Long {
            return System.currentTimeMillis()
        }
    }

}