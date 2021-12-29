/*
package example.micronaut

import io.micronaut.runtime.Micronaut.*
fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("example.micronaut")
		.start()
}

*/
package example.micronaut

import io.micronaut.context.env.Environment
import io.micronaut.runtime.Micronaut

class ApplicationKt {
	companion object {
		@JvmStatic
		fun main(args: Array<String>) {
			Micronaut.build(*args)
					.mainClass(ApplicationKt::class.java)
					.defaultEnvironments(Environment.DEVELOPMENT)
					.start()
		}
	}
}