
package example.micronaut

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Consumes
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client
import io.micronaut.retry.annotation.Recoverable
import org.reactivestreams.Publisher
import javax.validation.constraints.NotBlank
import reactor.core.publisher.Mono

@Client("http://localhost:8081")
@Recoverable(api = CustomerServiceOperations::class)
interface CustomerServiceClient : CustomerServiceOperations {

    @Consumes(MediaType.TEXT_PLAIN)
    @Get("/customer/{customerId}")
    override fun customer(@NotBlank customerId: Int): String
}
