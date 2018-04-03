package app

import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*
import javax.transaction.Transactional

@Service
@Transactional
class ConfigChangeService(val changeRepository: ConfigChangeRepository) {

    fun getAll(since: LocalDateTime?): List<ConfigChangeEO> {
        if (since == null) {
            return changeRepository.findAll().asSequence().toList()
        } else {
            return changeRepository.findBycreateTsGreaterThan(since.atZone(ZoneId.systemDefault()).toInstant())
        }
    }
}
