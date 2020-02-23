package estudio_arriba_back.model

import java.time.Month
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Pago( val mesDePago: Month,
            var montoPagado: Int,
            val nombreClase: ClasesEstudio,
           @Id
           @GeneratedValue
            val id: Long = 0) {

    fun mesDePago(): Month{
        return this.mesDePago
    }

    fun montoPagado(): Int{
        return this.montoPagado
    }

    fun nombreClase(): ClasesEstudio{
        return this.nombreClase
    }
    fun id(): Long{
        return this.id
    }

    fun pagar(montoParaPagar: Int) {
        this.montoPagado += montoParaPagar
    }

}
