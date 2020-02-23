package estudio_arriba_back

import estudio_arriba_back.model.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.Month

class AlumneTest {

    private val clase_teatro = Clase(ClasesEstudio.TEATROADULTOSPRIMERO, mutableSetOf(DayOfWeek.MONDAY), 1000)
    private val alumne = Alumne("Gonzalo Guasch", LocalDate.of(2020, 2, 20), 41471781, "Calle falsa 123", 42247439, 0, "bokeCampeon@gmaiil", "@Alfredo_gaymeir", true, DatoEmergencia("Padre", 0,1))

    @Test
    fun unAlumneTieneBandaDeDatos(){
        assertEquals(alumne.nombreApellido(), "Gonzalo Guasch")
        assertEquals(alumne.fechaNacimiento().dayOfMonth, 20)
        assertEquals(alumne.dni(), 41471781)
        assertEquals(alumne.domicilio(), "Calle falsa 123")
        assertEquals(alumne.telFijo(), 42247439)
        assertEquals(alumne.telCelular(), 0)
        assertEquals(alumne.email(), "bokeCampeon@gmaiil")
        assertEquals(alumne.redSocial(), "@Alfredo_gaymeir")
        assertTrue(alumne.sufrioAccidente())
        assertEquals(alumne.datoEmergenciaUno()!!.parentesco(), "Padre")

    }
    @Test
    fun siUnAlumneNoSeAnotoALaClaseNo1tieneAssitencias(){
        assertEquals(alumne.cantidadDeAsistenciasParaClase(clase_teatro.nombreClase(), 2020), 0)
    }
    @Test
    fun cuandoUnAlumneSeAnotaAUnaClaseEsteTieneUnaListaDeAsistenciaParaEseAño(){
        clase_teatro.anotarAlumne(alumne, 2020)

        assertEquals(alumne.cantidadDeAsistenciasParaClase(clase_teatro.nombreClase(), 2020), 12)
    }
    @Test
    fun seRegistraUnaAsistenciaALaClase(){
        clase_teatro.anotarAlumne(alumne, 2020)
        clase_teatro.registrarAsistencia(LocalDate.of(2020, 10, 2), alumne.nombreApellido())

        assertTrue(clase_teatro.alumneAsistio(LocalDate.of(2020, 10, 2), alumne.nombreApellido()))
    }
    @Test
    fun alAnotarseAUnaMateriaSeGeneranLosPagosDelAño(){
        clase_teatro.anotarAlumne(alumne, 2020)

        assertEquals(alumne.recibosDePagoParaClase(clase_teatro.nombreClase(), 2020).size, 12)
    }

    @Test
    fun unAlumnePuedePagarUnMontoParaUnaClaseYMesEspecifico(){
        clase_teatro.anotarAlumne(alumne, 2020)
        alumne.pagarMesDeClase(2020, Month.MAY, clase_teatro.nombreClase(), 1000)

        assertEquals(alumne.verReciboDeMes(2020, Month.MAY, clase_teatro.nombreClase()).montoPagado(), 1000)
    }

    @Test
    fun unAlumneTieneUnaListaDeComentarios(){

        assertEquals(alumne.comentariosAlAlumne().size, 0)
    }

    @Test
    fun seLePuedenHacerComentariosAUnalumne(){
        val comentario = ComentarioAlumne("Italiano puto", "Anonimo")
        alumne.recibirComentario(comentario)

        assertEquals(alumne.comentariosAlAlumne().size, 1)
    }
}