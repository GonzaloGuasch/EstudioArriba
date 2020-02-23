package estudio_arriba_back

import estudio_arriba_back.model.DatoEmergencia
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DatosEmergenciaTest {

    @Test
    fun unDatoDeEmergenciaTieneUnFijoParentestoYDni(){
        val dato_emergencia = DatoEmergencia("Padre", 45, 1111111)

        assertEquals(dato_emergencia.dni(), 1111111)
        assertEquals(dato_emergencia.fijo(), 45)
        assertEquals(dato_emergencia.parentesco(), "Padre")
    }
}