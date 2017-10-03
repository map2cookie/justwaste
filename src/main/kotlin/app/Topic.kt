package app

import com.fasterxml.jackson.annotation.JsonCreator

data class Topic @JsonCreator constructor(
        val name: String,
        val content: String
)