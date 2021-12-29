from nameko.rpc import rpc
from nameko.web.handlers import http
from nameko_prometheus import PrometheusMetrics
from prometheus_client import Counter
from nameko_zipkin import Zipkin

work_units = Counter(
    "my_service_work_units_total", "Total number of work units", ["work_type"]
)


class AddressService:
   metrics = PrometheusMetrics()
   name = 'AddressService'
   zipkin = Zipkin()

   @rpc
   def GetAddress(self):
    # assert self.zipkin.service_name == AddressService.name
    # assert self.zipkin.span_name == AddressService.method.__name__
    work_units.labels(work_type="hard").inc()
    return "Address of Customer is Bamberg"

   @http("GET", "/metrics")
   def serve_metrics(self, request):
    return self.metrics.expose_metrics(request)