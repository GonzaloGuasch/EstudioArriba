package estudio_arriba_back

import estudio_arriba_back.model.Asistencia
import estudio_arriba_back.model.ClasesEstudio
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.Month

class AsistenciaTest {

    @Test
    fun unaAsistenciaTieneUnMesUnAñoYUnaClase(){
        val asistenciaEnero = Asistencia(Month.JANUARY, 2020, ClasesEstudio.TEATROADULTOSPRIMERO)

        assertEquals(asistenciaEnero.claseAsistio(), ClasesEstudio.TEATROADULTOSPRIMERO)
        assertEquals(asistenciaEnero.mesDeAsistencia(), Month.JANUARY)
        assertEquals(asistenciaEnero.añoDeAsistencia(), 2020)
        assertFalse(asistenciaEnero.asistio(4))
    }

    @Test
    fun seCambiaElEstadoDeLaAsistencia(){
        val asistenciaEnero = Asistencia(Month.JANUARY, 2020, ClasesEstudio.TEATROADULTOSPRIMERO)

        asistenciaEnero.asistir(5)

        assertTrue(asistenciaEnero.asistio(5))
    }

}