package effective.item22

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.ObjectMapper


class Document(var id: String? = null,
    var title: String? = null,
    var subtitle: String? = null,
    var description: String? = null,
    var source: String? = null,
    var createdAt: String? = null,
    var author: String? = null,
    var link: Link? = null,
    var groupName: String? = null,
    var _score: Double? = null
) {

    override fun toString(): String {
        return """
            title: $title
            subtitle: $subtitle
            description: $description
            source: $source
            createdAt: $createdAt
            author: $author
            link: $link
            groupNmae: $groupName
            _score: $_score
        """.trimIndent()
    }
}
class Link(var title: String? = null,
    var url: String? = null,
    var target: String? = null
)

fun main() {
    val objectMapper =  ObjectMapper()


    val linkedHashMap = LinkedHashMap<String, String>()
    linkedHashMap.put("title", "이곳에")
    linkedHashMap.put("description", "클릭 후")
    // linkedHashMap.put("link.url", "https://kakaoenterprise.agit.in/g/300038267/wall")
    linkedHashMap.put("id", "1")
    linkedHashMap.put("my_subtitle", "전사 공지")
    linkedHashMap.put("No", "0")
    linkedHashMap.put("title_number", "이곳에")
    linkedHashMap.put("my_title", "이곳에")
    linkedHashMap.put("my_description", "zmfflrgn")
    val document: Document = objectMapper.convertValue(linkedHashMap, Document::class.java)
    println(document)
}