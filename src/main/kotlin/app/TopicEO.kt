package app

import java.time.Instant
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="topic")
data class TopicEO(
        @Id @GeneratedValue val id: Long?,
        val name: String,
        val done: Boolean,
        val deleted: Boolean,
        val createTs: Instant,
        val doneTs: Instant?,
        val deleteTs: Instant?)