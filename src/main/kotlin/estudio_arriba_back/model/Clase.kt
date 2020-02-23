package estudio_arriba_back.model

import java.time.DayOfWeek
import java.time.LocalDate
import java.time.Month
import javax.persistence.*

@Entity
class Clase(@Id
            val nombreClase: ClasesEstudio,
            @ElementCollection
            val diasQueSeDicta: MutableSet<DayOfWeek>,
            val precioDeLaClase: Int,
            @ManyToMany(cascade=[CascadeType.ALL], fetch = FetchType.LAZY)
            val alumnesAnotades: MutableSet<Alumne> = mutableSetOf()) {

    fun nombreClase(): ClasesEstudio{
        return this.nombreClase
    }

    fun diasQueSeDicta(): MutableSet<DayOfWeek>{
        return this.diasQueSeDicta
    }

    fun precio(): Int{
        return this.precioDeLaClase
    }

    fun cantidadAlumensAnotades(): MutableSet<Alumne> {
        return this.alumnesAnotades
    }

    fun anotarAlumne(alumneParaAnotarse: Alumne, añoQueSeAnota: Int) {
        this.alumnesAnotades.add(alumneParaAnotarse)
        alumneParaAnotarse.agregarAsistenciasPara(this.nombreClase(), añoQueSeAnota)
        alumneParaAnotarse.agregarPagosPara(this.nombreClase(), añoQueSeAnota)
    }

    fun registrarAsistencia(fechaDeAsistencia: LocalDate, nombreAlumne: String) {
        buscarAlumne(nombreAlumne)!!.registrarAsistenciaDeClase(fechaDeAsistencia, this.nombreClase())
    }

    private fun buscarAlumne(nombreAlumne: String): Alumne? {
        return this.alumnesAnotades.find { unAlumne -> unAlumne.nombreApellido() == nombreAlumne }
    }

    fun alumneAsistio(fechaPosibleDeAsistencia: LocalDate, nombreAlumne: String): Boolean {
        return this.buscarAlumne(nombreAlumne)!!.asistioEnFecha(fechaPosibleDeAsistencia, this.nombreClase())
    }

    fun tieneAlumneAnotade(alumne: Alumne): Boolean {
        return this.alumnesAnotades.contains(alumne)
    }

    fun asistenciasDeMes(alumne: Alumne, mesAsistencia: Month, añoAsistencia: Int): Any {
       return  alumne.asistenciasDeMes(mesAsistencia, añoAsistencia, this.nombreClase())
    }

}
