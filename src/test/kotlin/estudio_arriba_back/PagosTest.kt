package estudio_arriba_back

import estudio_arriba_back.model.ClasesEstudio
import estudio_arriba_back.model.Pago
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.Month

class PagosTest {

	val pagoEnero = Pago(Month.JANUARY, 1200, ClasesEstudio.TEATROADULTOSPRIMERO)

	@Test
	fun unPagoTieneUnMesUnMontoYElNombreDeLaClase() {


		assertEquals(pagoEnero.mesDePago(), Month.JANUARY)
		assertEquals(pagoEnero.montoPagado(), 1200)
		assertEquals(pagoEnero.nombreClase(), ClasesEstudio.TEATROADULTOSPRIMERO)
	}

	@Test
	fun unPagoPuedeCambiarSuMontoPagado() {
		pagoEnero.pagar(90)
		pagoEnero.pagar(10)

		assertEquals(pagoEnero.montoPagado(), 1300)
	}

}
