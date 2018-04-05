package app

import org.springframework.stereotype.Service
import java.time.Instant
import java.util.*
import javax.transaction.Transactional

@Service
@Transactional
class ServiceService(val serviceRepository: ServiceRepository) {
    fun add(t: app.Service): ServiceEO {
        return serviceRepository.save(ServiceEO(id = null, host=t.host, port=t.port, url=t.url))
    }

    fun update(t: ServiceEO) {
        if (t.id == null) throw RuntimeException("Service must have nonnull id")
        // check existence
        serviceRepository.findById(t.id).get()
        serviceRepository.save(t)
    }

    fun get(id: Long): ServiceEO {
        val s: Optional<ServiceEO> = serviceRepository.findById(id)
        return if (s.isPresent) s.get() else throw RuntimeException("No Service with id=$id")
    }
    fun del(id: Long) {
        serviceRepository.deleteById(id)
    }

    fun getAll(): List<ServiceEO> {
        return serviceRepository.findAll().asSequence().toList()
    }
}
