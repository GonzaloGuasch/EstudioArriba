package estudio_arriba_back.controller

import estudio_arriba_back.model.AnotarAlumneWrapper
import estudio_arriba_back.model.AsistenciaWrapper
import estudio_arriba_back.model.Clase
import estudio_arriba_back.model.ClasesEstudio
import estudio_arriba_back.service.ClaseService
import org.springframework.web.bind.annotation.*
import java.time.Month

@RestController
@CrossOrigin(origins = arrayOf("http://localhost:3000"))
@RequestMapping("/clase")
class ClaseController(private val claseService: ClaseService) {

    @GetMapping("/")
    fun testing() = "uno dos tres probando"

    @GetMapping("/getClase/{nombre_clase}")
    fun getClaseByName(@PathVariable nombre_clase: ClasesEstudio) = this.claseService.buscarClasePorNombre(nombre_clase)

    @GetMapping("/allClases")
    fun allClases() = this.claseService.getAllClases()

    @GetMapping("/claseDeAlumne/{nombre_alumne}")
    fun claseDeAlumne(@PathVariable nombre_alumne: String) = this.claseService.claseAlumne(nombre_alumne)

    @GetMapping("/fechaAsistencia/{nombre_alumne}/{nombre_clase}/{mes_asistencia}/{año_asistencia}")
    fun asistenciaDeMes(@PathVariable nombre_alumne: String,
                        @PathVariable nombre_clase: ClasesEstudio,
                        @PathVariable mes_asistencia: Month,
                        @PathVariable año_asistencia: Int) = this.claseService.buscarAsistencia(nombre_alumne, nombre_clase, mes_asistencia, año_asistencia)

    @PostMapping("/registrarClase")
    fun registrarClase(@RequestBody claseARegistrar: Clase) = this.claseService.registrarNuevaClase(claseARegistrar)

    @PostMapping("/anotarAlumne")
    fun anotarAlumneAClase(@RequestBody anotarAlumneWrapper: AnotarAlumneWrapper) = this.claseService.anotarAlumneAClase(anotarAlumneWrapper)

    @PostMapping("/registrarPagoDeAlumne")
    fun registrarPago(@RequestBody pagoWrapper: AsistenciaWrapper) = this.claseService.registrarPago(pagoWrapper)
}