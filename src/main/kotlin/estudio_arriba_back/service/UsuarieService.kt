package estudio_arriba_back.service

import estudio_arriba_back.model.LoginWrapper
import estudio_arriba_back.model.Usuarie
import estudio_arriba_back.repository.UsuarieRepository
import org.springframework.stereotype.Service

@Service
class UsuarieService(private var usuarieController: UsuarieRepository) {

    fun checkLogin(loginWrapper: LoginWrapper): Boolean {
        val posible_user: Usuarie = usuarieController.findById(loginWrapper.usuarie!!).get()

        return if (posible_user != null) {
            posible_user.contraseña == loginWrapper.password
        } else {
            false
        }
    }

}
