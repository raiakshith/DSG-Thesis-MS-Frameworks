package example.micronaut

import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces

@Controller("/customer") // <1>
open class CustomerController {

    @Produces(MediaType.TEXT_PLAIN)
    @Get("/{customerId}")
    open fun index(customerId: Int): HttpResponse<String>  {
        return when (customerId) {
            1 -> {
                HttpResponse.ok("Customer details of customer Id=$customerId")
            }
            2 -> {
                HttpResponse.ok("Customer details of customer Id=$customerId")
            }
            else -> {
                HttpResponse.notFound()
            }
        }
    }
}
