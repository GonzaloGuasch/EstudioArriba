package estudio_arriba_back.model

import java.time.Month
import javax.persistence.*

@Entity
class ReciboDePago( var nombreClase: ClasesEstudio,
                    var añoDeRecibo: Int,
                   @OneToMany(cascade=[CascadeType.ALL])
                    var pagoDelAño: MutableSet<Pago> = mutableSetOf(),
                   @Id
                   @GeneratedValue
                    var id: Long = 0) {

    init {
        this.pagoDelAño.add(Pago(Month.JANUARY, 0, this.nombreClase))
        this.pagoDelAño.add(Pago(Month.FEBRUARY, 0, this.nombreClase))
        this.pagoDelAño.add(Pago(Month.MARCH, 0, this.nombreClase))
        this.pagoDelAño.add(Pago(Month.APRIL, 0, this.nombreClase))
        this.pagoDelAño.add(Pago(Month.MAY, 0, this.nombreClase))
        this.pagoDelAño.add(Pago(Month.JUNE, 0, this.nombreClase))
        this.pagoDelAño.add(Pago(Month.JULY, 0, this.nombreClase))
        this.pagoDelAño.add(Pago(Month.AUGUST, 0, this.nombreClase))
        this.pagoDelAño.add(Pago(Month.SEPTEMBER, 0, this.nombreClase))
        this.pagoDelAño.add(Pago(Month.OCTOBER, 0, this.nombreClase))
        this.pagoDelAño.add(Pago(Month.NOVEMBER, 0, this.nombreClase))
        this.pagoDelAño.add(Pago(Month.DECEMBER, 0, this.nombreClase))
    }

    fun nombreClase(): ClasesEstudio{
        return this.nombreClase
    }

    fun añoDeRecibo(): Int{
        return this.añoDeRecibo
    }

    fun pagosDelAño(): MutableSet<Pago>{
        return this.pagoDelAño
    }

    fun pagoDelMes(mesDePago: Month): Pago {
        return buscarPago(mesDePago)
    }
    fun id(): Long {
        return this.id
    }
    private fun buscarPago(mesDePago: Month) = this.pagoDelAño.find { unPago -> unPago.mesDePago() == mesDePago }!!

    fun pagarMes(mesParaPagar: Month, montoParaPagar: Int) {
        this.buscarPago(mesParaPagar).pagar(montoParaPagar)
    }
}
