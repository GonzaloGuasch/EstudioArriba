package estudio_arriba_back.model

import javax.persistence.Entity
import javax.persistence.Id


@Entity
class Usuarie(@Id
              val nombreUsuarie: String,
              val contraseña: String) {

    fun nombreUsuarie(): String{
        return nombreUsuarie
    }

    fun contraseña(): String{
        return contraseña
    }

}
