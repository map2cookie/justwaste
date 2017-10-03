package app

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="topic")
data class TopicEO(
        @Id @GeneratedValue val id: Long? = null,
        val name: String,
        val content: String) {

    @Suppress("unused")
    private constructor() : this(name = "", content = "")
}