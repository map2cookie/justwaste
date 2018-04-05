package app

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "SERVICECONFIG")
data class ServiceEO(
        @Id @GeneratedValue val id: Long?,
        val host: String,
        val port: Int,
        val url: String)
