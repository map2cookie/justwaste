package app

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class Topic @JsonCreator constructor(
        @JsonProperty("name") val name: String,
        @JsonProperty("done") val done: Boolean
)