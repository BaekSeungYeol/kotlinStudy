package everything.util

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.http.HttpStatus
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

internal class UtilsTest {


    @Test
    fun `test1`() {

        val s1 = Mono.just("hi")
        val s2 = Mono.just("hi2")

        val flatMapMany: Flux<Char> = s1
            .filter { it.contains("h") }
            .switchIfEmpty(s2)
            .flatMapMany {
                Flux.fromIterable(it.toCharArray().toMutableList())
            }

    }
}