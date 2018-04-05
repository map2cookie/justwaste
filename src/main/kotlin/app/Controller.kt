package app

import org.springframework.format.annotation.DateTimeFormat
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@RestController
class Controller(val serviceService: ServiceService, val configService: ConfigChangeService) {

    @RequestMapping("/")
    fun index() = """The 'config' site.
Use '/service' with post to store a new service and return that service.
Use '/service/{id}' with get to get a service by id.
Use '/service/{id}' with delete to remove a service.
Use '/service' with put to update a service (idempotent).
Use '/services' with get to get all services.
Use '/configchanges' with get to get all configuration changes
Use '/configchanges' with get and parameter 'since' with timestamp to get all configuration changes since that time
"""

    @RequestMapping("/service", method = arrayOf(RequestMethod.POST))
    fun createService(@RequestBody s: Service): ServiceEO {
        return configService.process("createService $s", {
            serviceService.add(s)
        })
    }

    @RequestMapping("/service/{id}", method = arrayOf(RequestMethod.GET))
    fun getService(@PathVariable("id") id: Long): ServiceEO {
        return serviceService.get(id)
    }

    @RequestMapping("/service/{id}", method = arrayOf(RequestMethod.DELETE))
    fun delService(@PathVariable("id") id: Long) {
        configService.process("delService $id", {
            serviceService.del(id)
        })
    }

    @RequestMapping("/service", method = arrayOf(RequestMethod.PUT))
    fun updateService(@RequestBody s: ServiceEO) {
        return configService.process("updateService $s", {
            serviceService.update(s)
        })
    }

    @RequestMapping("/services", method = arrayOf(RequestMethod.GET))
    fun getServices(): List<ServiceEO> {
        return serviceService.getAll()
    }

    @RequestMapping("/configchanges", method = arrayOf(RequestMethod.GET))
    fun getConfigChanges(
            @RequestParam(name = "since")
            @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") since: LocalDateTime?): List<ConfigChangeEO> {
        return configService.getAll(since)
    }
}