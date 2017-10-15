package app

import java.time.Instant
import javax.persistence.*

@Entity
@Table(name="topic")
data class TopicEO(
        @Id @GeneratedValue val id: Long?,
        val name: String,
        val done: Boolean,
        val deleted: Boolean,
        val createTs: Instant,
        val doneTs: Instant?,
        val deleteTs: Instant?,
        @OneToMany(fetch=FetchType.LAZY)
        @JoinColumn(name = "topic_id")
        val workItems: List<WorkEO>)