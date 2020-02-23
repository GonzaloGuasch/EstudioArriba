package estudio_arriba_back.model


import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class ComentarioAlumne(private val mensaje: String,
                       private val autore: String,
                       @Id
                       @GeneratedValue
                       private var id: Long = 0) {

    fun mensaje(): String{
        return this.mensaje
    }

    fun autore(): String{
        return this.autore
    }
}
