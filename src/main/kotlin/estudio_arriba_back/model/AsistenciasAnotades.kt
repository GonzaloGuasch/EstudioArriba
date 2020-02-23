package estudio_arriba_back.model

import java.time.Month
import javax.persistence.*

@Entity
class AsistenciasAnotades( val nombreClase: ClasesEstudio,
                           val añoQueSeAnota: Int,
                          @OneToMany(cascade=[CascadeType.ALL])
                           val asistencias: MutableSet<Asistencia> = mutableSetOf(),
                          @Id
                          @GeneratedValue
                           val id: Long = 0){

    init {
        val asistenciaEnero = Asistencia(Month.JANUARY, añoQueSeAnota, nombreClase)
        val asistenciaFebrero = Asistencia(Month.FEBRUARY, añoQueSeAnota, nombreClase)
        val asistenciaMarzo = Asistencia(Month.MARCH, añoQueSeAnota, nombreClase)
        val asistenciaAbril = Asistencia(Month.APRIL, añoQueSeAnota, nombreClase)
        val asistenciaMayo = Asistencia(Month.MAY, añoQueSeAnota, nombreClase)
        val asistenciaJunio = Asistencia(Month.JUNE, añoQueSeAnota, nombreClase)
        val asistenciaJulio = Asistencia(Month.JULY, añoQueSeAnota, nombreClase)
        val asistenciaAgosto = Asistencia(Month.AUGUST, añoQueSeAnota, nombreClase)
        val asistenciaSeptiembre = Asistencia(Month.SEPTEMBER, añoQueSeAnota, nombreClase)
        val asistenciaOctubre = Asistencia(Month.OCTOBER, añoQueSeAnota, nombreClase)
        val asistenciaNoviembre = Asistencia(Month.NOVEMBER, añoQueSeAnota, nombreClase)
        val asistenciaDiciembre = Asistencia(Month.DECEMBER, añoQueSeAnota, nombreClase)

        this.asistencias().add(asistenciaEnero)
        this.asistencias().add(asistenciaFebrero)
        this.asistencias().add(asistenciaMarzo)
        this.asistencias().add(asistenciaAbril)
        this.asistencias().add(asistenciaMayo)
        this.asistencias().add(asistenciaJunio)
        this.asistencias().add(asistenciaJulio)
        this.asistencias().add(asistenciaAgosto)
        this.asistencias().add(asistenciaSeptiembre)
        this.asistencias().add(asistenciaOctubre)
        this.asistencias().add(asistenciaNoviembre)
        this.asistencias().add(asistenciaDiciembre)
    }

    fun asistencias(): MutableSet<Asistencia>{
        return this.asistencias
    }

    fun nombreClase(): ClasesEstudio{
        return this.nombreClase
    }
    fun año(): Int{
        return this.añoQueSeAnota
    }
    fun id(): Long{
        return this.id
    }

    fun registrarAsistenciaDeMes(mesAsistencia: Month, diaDeAsistencia: Int) {
        buscarAsistenciaDeMes(mesAsistencia)!!.asistir(diaDeAsistencia)
    }

    fun asistioElDiaDelMes(mesDeAsistencia: Month, dayOfMonth: Int): Boolean {
        return  buscarAsistenciaDeMes(mesDeAsistencia)!!.asistio(dayOfMonth)
    }

    private fun buscarAsistenciaDeMes(mesDeAsistencia: Month) =
            this.asistencias.find { asistencia -> asistencia.mesDeAsistencia() == mesDeAsistencia }

    fun getAsistenciasDeMes(mesAsistencia: Month): Any {
        return this.buscarAsistenciaDeMes(mesAsistencia)!!.asistenciasDeMes
    }
}
