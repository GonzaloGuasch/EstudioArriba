package estudio_arriba_back

import estudio_arriba_back.model.ClasesEstudio
import estudio_arriba_back.model.PagoClase
import estudio_arriba_back.model.ReciboDePago
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.Month

class RecibosPagoTest {

    val reciboDePago2020 = ReciboDePago(ClasesEstudio.TEATROADULTOSPRIMERO, 2020)
    val pagoJulio = PagoClase(Month.JULY, 0)

    @Test
    fun unPAgoTieneUnMesYUnMonto(){

        assertEquals(pagoJulio.mesDePago(), Month.JULY)
        assertEquals(pagoJulio.montoDePago(), 0)
    }

    @Test
    fun unReciboDePagoTieneUnAñoDePagoUnNombreDeClaseYUnaListaDe12PagosDeClase(){

        assertEquals(reciboDePago2020.nombreClase(), ClasesEstudio.TEATROADULTOSPRIMERO)
        assertEquals(reciboDePago2020.añoDeRecibo(), 2020)
        assertEquals(reciboDePago2020.pagosDelAño().size, 12)
    }

    @Test
    fun sePuedePreguntarPorUnPagoDeUnEspecifico(){

        assertEquals(reciboDePago2020.pagoDelMes(Month.JULY).montoPagado(), 0)
    }

    @Test
    fun sePuedePagarUnMonto(){
        reciboDePago2020.pagarMes(Month.DECEMBER, 100)

        assertEquals(reciboDePago2020.pagoDelMes(Month.DECEMBER).montoPagado(), 100)
    }
}