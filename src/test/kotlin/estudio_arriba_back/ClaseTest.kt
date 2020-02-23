package estudio_arriba_back

import estudio_arriba_back.model.Alumne
import estudio_arriba_back.model.Clase
import estudio_arriba_back.model.ClasesEstudio
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.DayOfWeek
import java.time.LocalDate

class ClaseTest {

    private val clase_teatro = Clase(ClasesEstudio.TEATROADULTOSPRIMERO, mutableSetOf(DayOfWeek.MONDAY), 1000)

    @Test
    fun unaClaseTieneUnProfesorLosDiasDeLaSemanaQueSeDictaUnPrecioYunaListaDeAlumnxsAnotadxs(){
        assertEquals(clase_teatro.diasQueSeDicta(), mutableSetOf(DayOfWeek.MONDAY))
        assertEquals(clase_teatro.nombreClase(), ClasesEstudio.TEATROADULTOSPRIMERO)
        assertEquals(clase_teatro.precio(), 1000)
        assertEquals(clase_teatro.cantidadAlumensAnotades().size, 0)
    }

    @Test
    fun enUnaClaseSePuedenAnotarAlumnes(){
        val mock_alumne = Alumne("Mock", LocalDate.of(2020, 2, 12))

        clase_teatro.anotarAlumne(mock_alumne, 2020)

        assertEquals(clase_teatro.cantidadAlumensAnotades().size, 1)
    }
}