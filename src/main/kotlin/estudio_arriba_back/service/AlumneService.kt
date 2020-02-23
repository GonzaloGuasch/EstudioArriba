package estudio_arriba_back.service


import estudio_arriba_back.model.Alumne
import estudio_arriba_back.model.ComentarioAlumne
import estudio_arriba_back.repository.AlumneRepository
import org.springframework.stereotype.Service

@Service
class AlumneService(private var alumneRepository: AlumneRepository) {


    fun registrarAlumne(nueveAlumne: Alumne): Alumne {
        this.alumneRepository.save(nueveAlumne)
        return nueveAlumne
    }

    fun registrarComentario(nombreAlumne: String, comentario: ComentarioAlumne): Alumne {
        val alumne = this.alumneRepository.findById(nombreAlumne).get()
        alumne.recibirComentario(comentario)
        this.alumneRepository.save(alumne)

        return alumne
    }

    fun buscarALumnePorNombre(nombreAlumne: String): Alumne {
        return this.alumneRepository.findById(nombreAlumne).get()
    }

    fun getAllAlumnes(): MutableList<Alumne> {
        return this.alumneRepository.findAll().toMutableList()
    }
}