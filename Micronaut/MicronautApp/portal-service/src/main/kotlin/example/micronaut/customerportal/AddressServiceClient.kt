
package example.micronaut

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Consumes
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client
import io.micronaut.retry.annotation.Recoverable
import org.reactivestreams.Publisher
import javax.validation.constraints.NotBlank
import reactor.core.publisher.Mono

@Client("http://localhost:8082")
@Recoverable(api = AddressServiceOperations::class)

interface AddressServiceClient : AddressServiceOperations {

    @Consumes(MediaType.TEXT_PLAIN)
    @Get("/address/customer/{customerId}")
    override fun address(@NotBlank customerId: Int): String
}
