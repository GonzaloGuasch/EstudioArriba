package estudio_arriba_back.model

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDate
import java.time.Month
import javax.persistence.*

@Entity
class Alumne( @Id
              val nyap: String,
              @JsonFormat(pattern="dd-MM-yyyy")
              val fechaNacimiento: LocalDate,
              val dni: Int? = null,
              val domicilio: String? = null,
              val telFijo: Int? = null,
              val telCelular: Int? = null,
              val email: String? = null,
              val redSocial: String? = null,
              val sufrioAccidente: Boolean = false,
             @OneToOne(cascade = [CascadeType.ALL])
              val datoEmergenciaUno: DatoEmergencia? = null,
             @OneToOne(cascade = [CascadeType.ALL])
              val datoEmergenciaDos: DatoEmergencia? = null,
              val comoNosConociste: String? = null,
              val comentarios: String? = null,

             @ManyToMany(cascade=[CascadeType.ALL], fetch = FetchType.LAZY)
              val asistenciasDeClases: MutableSet<AsistenciasAnotades> = mutableSetOf(),
             @ManyToMany(cascade=[CascadeType.ALL], fetch = FetchType.LAZY)
              val pagosDeClases: MutableSet<ReciboDePago> = mutableSetOf(),
             @ManyToMany(cascade = [CascadeType.ALL])
              val comentariosAlALumne: MutableSet<ComentarioAlumne> = mutableSetOf()){


    fun nombreApellido(): String {
        return this.nyap
    }

    fun fechaNacimiento(): LocalDate{
        return this.fechaNacimiento
    }

    fun dni(): Int?{
        return this.dni
    }

    fun domicilio(): String?{
        return this.domicilio
    }

    fun telFijo(): Int?{
        return this.telFijo
    }

    fun telCelular(): Int?{
        return this.telCelular
    }

    fun email(): String?{
        return this.email
    }

    fun redSocial(): String?{
        return this.redSocial
    }

    fun sufrioAccidente(): Boolean{
        return this.sufrioAccidente
    }

    fun datoEmergenciaUno(): DatoEmergencia?{
        return this.datoEmergenciaUno
    }

    fun datoEmergenciaDos(): DatoEmergencia?{
        return this.datoEmergenciaDos
    }

    fun comoNosConociste(): String?{
        return this.comoNosConociste
    }

    fun comentarios(): String?{
        return this.comentarios
    }

    fun agregarAsistenciasPara(nombreClase: ClasesEstudio, añoQueSeAnota: Int) {
        this.asistenciasDeClases.add(AsistenciasAnotades(nombreClase, añoQueSeAnota))
    }

    fun agregarPagosPara(nombreClase: ClasesEstudio, añoQueSeAnota: Int) {
        this.pagosDeClases.add(ReciboDePago(nombreClase, añoQueSeAnota))
    }

    fun cantidadDeAsistenciasParaClase(nombreClase: ClasesEstudio, añoDeAsistencia: Int): Int {
        val asistenciaDeMes: AsistenciasAnotades? =  this.asistenciasDeClases.find{ asistencia -> asistencia.nombreClase() == nombreClase && asistencia.año() == añoDeAsistencia }
        if (asistenciaDeMes != null){
            return asistenciaDeMes!!.asistencias().size
        }else{
            return 0
        }
    }

    fun recibosDePagoParaClase(nombreClase: ClasesEstudio, añoQueSeAnoto: Int): MutableSet<Pago> {
        return recibosDePago(añoQueSeAnoto, nombreClase).pagosDelAño()
    }

    private fun recibosDePago(añoQueSeAnoto: Int, nombreClase: ClasesEstudio) =
            this.pagosDeClases.find { unRecibo -> unRecibo.añoDeRecibo() == añoQueSeAnoto
                                               && unRecibo.nombreClase() == nombreClase }!!

    fun pagarMesDeClase(año: Int, mesDePago: Month, nombreClase: ClasesEstudio, montoParaPagar: Int) {
        this.recibosDePago(año, nombreClase).pagarMes(mesDePago, montoParaPagar)
    }

    fun verReciboDeMes(año: Int, mesDePago: Month, nombreClase: ClasesEstudio): Pago {
        return this.recibosDePago(año, nombreClase).pagoDelMes(mesDePago)
    }

    fun registrarAsistenciaDeClase(fechaAsistencia: LocalDate, nombreClase: ClasesEstudio) {
        buscarAsistenciaDeClase(nombreClase, fechaAsistencia.year)!!.registrarAsistenciaDeMes(fechaAsistencia.month, fechaAsistencia.dayOfMonth)
    }

    private fun buscarAsistenciaDeClase(nombreClase: ClasesEstudio, añoAsistencia: Int): AsistenciasAnotades? {
        return this.asistenciasDeClases.find { asistencia ->
            asistencia.nombreClase() == nombreClase &&
                    asistencia.año() == añoAsistencia
        }
    }

    fun asistioEnFecha(fechaPosibleDeAsistencia: LocalDate, nombreClase: ClasesEstudio): Boolean {
        return this.buscarAsistenciaDeClase(nombreClase, fechaPosibleDeAsistencia.year)!!.asistioElDiaDelMes(fechaPosibleDeAsistencia.month, fechaPosibleDeAsistencia.dayOfMonth)
    }

    fun comentariosAlAlumne(): MutableSet<ComentarioAlumne> {
        return this.comentariosAlALumne
    }

    fun recibirComentario(comentario: ComentarioAlumne) {
        this.comentariosAlAlumne().add(comentario)
    }

    fun asistenciasDeMes(mesAsistencia: Month, añoAsistencia: Int, nombreClase: ClasesEstudio): Any {
        val asistenciaDeAÑo: AsistenciasAnotades? =  this.asistenciasDeClases.find{ asistencia -> asistencia.nombreClase() == nombreClase && asistencia.año() == añoAsistencia }

        return asistenciaDeAÑo!!.getAsistenciasDeMes(mesAsistencia)
    }


}
