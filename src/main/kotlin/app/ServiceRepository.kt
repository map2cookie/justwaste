package app

import org.springframework.data.repository.CrudRepository

interface ServiceRepository : CrudRepository<ServiceEO, Long>