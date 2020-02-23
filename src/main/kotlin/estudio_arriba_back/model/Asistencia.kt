package estudio_arriba_back.model

import java.time.Month
import javax.persistence.ElementCollection
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Asistencia( val mesDeAsistencia: Month,
                  val añoDeAsistencia: Int,
                  var claseAsistencia: ClasesEstudio? = null,
                 @ElementCollection
                  var asistenciasDeMes: MutableSet<Int> = mutableSetOf(),
                 @Id
                 @GeneratedValue
                  var id: Long = 0) {


    fun mesDeAsistencia(): Month{
        return this.mesDeAsistencia
    }

    fun claseAsistio(): ClasesEstudio{
        return this.claseAsistencia!!
    }

    fun añoDeAsistencia(): Int {
        return this.añoDeAsistencia
    }
    fun id(): Long{
        return this.id
    }

    fun asistio(diaDeAsistencia: Int): Boolean{
        return this.asistenciasDeMes.contains(diaDeAsistencia)
    }

    fun asistir(diaDeAsistencia: Int) {
        this.asistenciasDeMes.add(diaDeAsistencia)
    }
}
