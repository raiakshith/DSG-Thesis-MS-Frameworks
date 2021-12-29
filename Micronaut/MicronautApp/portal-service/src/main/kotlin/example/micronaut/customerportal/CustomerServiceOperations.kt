package example.micronaut

import org.reactivestreams.Publisher
import javax.validation.constraints.NotBlank
import reactor.core.publisher.Mono

interface CustomerServiceOperations {
    fun customer(@NotBlank customerId: Int): String
}
