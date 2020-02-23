package estudio_arriba_back.controller

import estudio_arriba_back.model.Alumne
import estudio_arriba_back.model.ComentarioAlumne
import estudio_arriba_back.service.AlumneService
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins = arrayOf("http://localhost:3000"))
@RequestMapping("/alumne")
class AlumneController(private var alumneService: AlumneService) {

    @GetMapping("/")
    fun testing() = "Uno dos tres probando"

    @GetMapping("/buscarAlumnePorNombre/{nombre_alumne}")
    fun buscarAlumnePorNombre(@PathVariable nombre_alumne: String) = this.alumneService.buscarALumnePorNombre(nombre_alumne)

    @GetMapping("/allAlumnes")
    fun getAllAlumnes() = this.alumneService.getAllAlumnes()

    @PostMapping("/registrarAlumne")
    fun registrar(@RequestBody nueveAlumne: Alumne) = this.alumneService.registrarAlumne(nueveAlumne)

    @PostMapping("/registrarComentario/{nombre_alumne}")
    fun registrarComentario(@PathVariable nombre_alumne: String, @RequestBody comentario: ComentarioAlumne) = this.alumneService.registrarComentario(nombre_alumne, comentario)
}