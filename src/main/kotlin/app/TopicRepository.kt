package app

import org.springframework.data.repository.CrudRepository

interface TopicRepository : CrudRepository<TopicEO, Long>