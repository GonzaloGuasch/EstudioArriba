package estudio_arriba_back.repository

import estudio_arriba_back.model.Usuarie
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UsuarieRepository: CrudRepository<Usuarie, String> {

}
