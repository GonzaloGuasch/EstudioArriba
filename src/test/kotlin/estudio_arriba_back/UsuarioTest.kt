package estudio_arriba_back

import estudio_arriba_back.model.Usuarie
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class UsuarioTest {

    @Test
    fun unUsuarioTieneUnNombreYContraseña(){
        val usuario = Usuarie("Gonzalo Guasch", "123")

        assertEquals(usuario.contraseña(), "123")
        assertEquals(usuario.nombreUsuarie(), "Gonzalo Guasch")
    }
}