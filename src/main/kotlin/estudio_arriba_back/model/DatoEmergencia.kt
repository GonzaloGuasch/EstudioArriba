package estudio_arriba_back.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class DatoEmergencia( val parentesco: String,
                      val fijo: Int,
                      val dni: Int,
                     @Id
                     @GeneratedValue
                      val id: Long = 0) {

    fun parentesco(): String{
        return this.parentesco
    }

    fun fijo(): Int{
        return this.fijo
    }

    fun dni(): Int{
        return this.dni
    }

}
