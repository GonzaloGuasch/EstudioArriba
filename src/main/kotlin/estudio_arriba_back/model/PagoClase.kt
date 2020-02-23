package estudio_arriba_back.model

import java.time.Month
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class PagoClase( var mesDePago: Month,
                 val montoDePago: Int,
                @Id
                @GeneratedValue
                 var id: Long = 0) {

    fun mesDePago(): Month{
        return this.mesDePago
    }

    fun montoDePago(): Int{
        return this.montoDePago
    }
    fun id(): Long{
        return this.id
    }
}
