package example.micronaut

import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces

@Controller("/address")
open class AddressController {

    @Produces(MediaType.TEXT_PLAIN)
    @Get("/customer/{customerId}")
    open fun address(customerId: Int): HttpResponse<String> {
        return when (customerId) {
            1 -> {
                HttpResponse.ok("Address of customer Id=$customerId")
            }
            2 -> {
                HttpResponse.ok("Address of customer Id=$customerId")
            }
            else -> {
                HttpResponse.notFound()
            }
        }
    }
}
