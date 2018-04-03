package app

import org.springframework.data.repository.CrudRepository
import java.time.Instant

interface ConfigChangeRepository : CrudRepository<ConfigChangeEO, Long> {
    fun findBycreateTsGreaterThan(ts: Instant): List<ConfigChangeEO>
}