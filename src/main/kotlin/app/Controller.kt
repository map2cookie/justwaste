package app

import org.springframework.web.bind.annotation.*

@RestController
class Controller(val service: TopicService) {

    @RequestMapping("/")
    fun index() = """The 'topic' site.
Use '/send' to post a topic.
Use '/search' to search for topics"""

    @RequestMapping(value = ["/send"], method = arrayOf(RequestMethod.POST))
    fun createComment(@RequestBody t: Topic) {
        service.add(t)
    }

    @RequestMapping("/search")
    fun search(@RequestParam(name = "name") value: String?) = service.topics()
}