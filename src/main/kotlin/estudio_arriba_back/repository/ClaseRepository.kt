package estudio_arriba_back.repository

import estudio_arriba_back.model.Clase
import estudio_arriba_back.model.ClasesEstudio
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface ClaseRepository: CrudRepository<Clase, ClasesEstudio> {

}
