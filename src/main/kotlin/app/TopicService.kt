package app

import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
class TopicService(val topicRepository: TopicRepository) {

    fun topics() = topicRepository.findAll()

    fun add(t: Topic) {
        topicRepository.save(TopicEO(name = t.name, content = t.content))
    }
}
