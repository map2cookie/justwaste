package app

import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
class TopicService (val topicRepository: TopicRepository) {

    fun topics(): List<Topic> =
            topicRepository.findAll().map {
                Topic(
                        name = it.name,
                        content = it.content
                )
            }

    fun add(t: Topic) {
        topicRepository.save(TopicEO(name = t.name, content = t.content))
    }
}
