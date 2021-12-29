package example.micronaut

import org.reactivestreams.Publisher
import javax.validation.constraints.NotBlank
import reactor.core.publisher.Mono

interface AddressServiceOperations {
    fun address(@NotBlank customerId: Int): String
}
