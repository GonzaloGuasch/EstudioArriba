package estudio_arriba_back

import estudio_arriba_back.model.ComentarioAlumne
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ComentariosAlumneTest {

    @Test
    fun unComentarioTieneUnMensajeYUnAutore(){
        val comentario = ComentarioAlumne("Esta re loco amigo", "Alfredo casero")

        assertEquals(comentario.mensaje(), "Esta re loco amigo")
        assertEquals(comentario.autore(), "Alfredo casero")
    }
}