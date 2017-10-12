package app

import org.springframework.stereotype.Service
import java.time.Instant
import javax.transaction.Transactional

@Service
@Transactional
class TopicService(val topicRepository: TopicRepository) {

    fun topics() = topicRepository.findAll()

    fun add(t: Topic) {
        val doneTs = if (t.done) Instant.now() else null
        topicRepository.save(TopicEO(id = null, name = t.name, done = t.done, doneTs = doneTs,
                deleted = false, createTs = Instant.now(), deleteTs = null))
    }
}
