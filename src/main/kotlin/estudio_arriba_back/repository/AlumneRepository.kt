package estudio_arriba_back.repository

import estudio_arriba_back.model.Alumne
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface AlumneRepository: CrudRepository<Alumne, String> {

}