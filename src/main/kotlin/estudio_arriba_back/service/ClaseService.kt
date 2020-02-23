package estudio_arriba_back.service

import estudio_arriba_back.model.AnotarAlumneWrapper
import estudio_arriba_back.model.AsistenciaWrapper
import estudio_arriba_back.model.Clase
import estudio_arriba_back.model.ClasesEstudio
import estudio_arriba_back.repository.AlumneRepository
import estudio_arriba_back.repository.ClaseRepository
import org.springframework.stereotype.Service
import java.time.Month

@Service
class ClaseService(private var claseRepository: ClaseRepository, private var alumneRepository: AlumneRepository) {


    fun registrarNuevaClase(claseARegistrar: Clase): Clase {
        this.claseRepository.save(claseARegistrar)
        return claseARegistrar
    }

    fun buscarClasePorNombre(nombreClase: ClasesEstudio): Clase? {
        return this.claseRepository.findById(nombreClase).get()
    }

    fun getAllClases(): MutableIterable<Clase> {
        return this.claseRepository.findAll()
    }

    fun anotarAlumneAClase(anotarWrapper: AnotarAlumneWrapper): Clase {
        val alumne = this.alumneRepository.findById(anotarWrapper.nombreAlumne!!).get()
        val clase = this.buscarClasePorNombre(anotarWrapper.nombreClase!!)!!

        clase.anotarAlumne(alumne, 2020)
        this.claseRepository.save(clase)

        return clase
    }

    fun registrarPago(asistenciaWrapper: AsistenciaWrapper): Boolean {
        val clase = this.buscarClasePorNombre(asistenciaWrapper.nombreClase!!)!!

        clase.registrarAsistencia(asistenciaWrapper.asistencia!!, asistenciaWrapper.nombreAlumne!!)
        this.claseRepository.save(clase)

        return clase.alumneAsistio(asistenciaWrapper.asistencia!!, asistenciaWrapper.nombreAlumne!!)
    }

    fun claseAlumne(nombreAlumne: String): List<Clase> {
        val alumne = this.alumneRepository.findById(nombreAlumne).get()
        val clases = this.claseRepository.findAll().toMutableList()

        return clases.filter{ unaClase -> unaClase.tieneAlumneAnotade(alumne) }
    }

    fun buscarAsistencia(nombreAlumne: String, nombreClase: ClasesEstudio, mesAsistencia: Month, añoAsistencia: Int): Any {
        val clase = this.buscarClasePorNombre(nombreClase)!!
        val alumne = this.alumneRepository.findById(nombreAlumne).get()

        return clase.asistenciasDeMes(alumne, mesAsistencia, añoAsistencia)
    }

}
