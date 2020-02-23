package estudio_arriba_back.model

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDate

class AsistenciaWrapper(val nombreClase: ClasesEstudio?,
                        @JsonFormat(pattern = "dd/MM/yyyy")
                        val asistencia: LocalDate?,
                        val nombreAlumne: String? ) {

}
