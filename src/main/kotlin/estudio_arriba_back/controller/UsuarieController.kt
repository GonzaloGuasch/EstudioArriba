package estudio_arriba_back.controller

import estudio_arriba_back.model.LoginWrapper
import estudio_arriba_back.service.UsuarieService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/usuarie")
@CrossOrigin(origins = ["http://localhost:3000"])
class UsuarieController(private var usuarieService: UsuarieService) {

    @GetMapping("/")
    fun index() = "Hola"

    @PostMapping("/checkLogin")
    fun checkLogin(@RequestBody loginWrapper: LoginWrapper) = this.usuarieService.checkLogin(loginWrapper)
}