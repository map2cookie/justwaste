package app

import java.time.Instant
import javax.persistence.*

@Entity
@Table(name="work")
data class WorkEO(
        @Id @GeneratedValue val id: Long?,
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "topic_id")
        val topic: TopicEO,
        val startTs: Instant,
        val endTs: Instant)