package app

import java.time.Instant
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "CONFIGCHANGE")
data class ConfigChangeEO(
        @Id @GeneratedValue val id: Long?,
        val configaction: String,
        val createTs: Instant,
        val done_Ts: Instant?,
        val failed: Boolean,
        val outcome: String?)
