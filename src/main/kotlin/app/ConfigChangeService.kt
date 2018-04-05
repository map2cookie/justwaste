package app

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import javax.transaction.Transactional

@Service
@Transactional
class ConfigChangeService(val changeRepository: ConfigChangeRepository) {
    @Autowired
    lateinit var  myself:ConfigChangeService

    fun getAll(since: LocalDateTime?): List<ConfigChangeEO> {
        if (since == null) {
            return changeRepository.findAll().asSequence().toList()
        } else {
            return changeRepository.findBycreateTsGreaterThan(since.atZone(ZoneId.systemDefault()).toInstant())
        }
    }

    fun <A> process(description: String, f: () -> A) : A {
        val id = myself.start(description)
        var ex: Exception? = null
        try {
            return f()
        } catch (e: Exception) {
            ex = e
            throw e
        } finally {
            if (ex == null)
                myself.end(id)
            else
                myself.problem(id, ex)
        }
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    fun start(description: String): Long {
        val eo = changeRepository.save(ConfigChangeEO(id = null, configaction = description, createTs = Instant.now(), doneTs = null, failed = false, outcome = null))
        return eo.id!!
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    fun end(id: Long) {
        val eo = changeRepository.findById(id).get()
        changeRepository.save(eo.copy(doneTs = Instant.now(), outcome = "OK"))
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    fun problem(id: Long, ex: Exception) {
        val eo = changeRepository.findById(id).get()
        val msg = ex.toString()
        changeRepository.save(eo.copy(doneTs = Instant.now(), failed = true,
                outcome = if (msg.length > 255) msg.substring(0, 255) else msg))
    }
}
