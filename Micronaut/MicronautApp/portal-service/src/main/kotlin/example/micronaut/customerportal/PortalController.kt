package example.micronaut

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import reactor.core.publisher.Flux
import org.reactivestreams.Publisher
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Produces

@Controller("/portal")
class PortalController(private val customerServiceOperations: CustomerServiceOperations,
                       private val addressServieOperations: AddressServiceOperations) {

    @Produces(MediaType.TEXT_PLAIN)
    @Get("/{customerId}")
    open fun index(customerId: Int): String {
        val customerData = customerServiceOperations.customer(customerId).toString()
        val addressData = addressServieOperations.address(customerId).toString()
        return customerData + addressData
    }
}
