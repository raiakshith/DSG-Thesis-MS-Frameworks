from nameko.rpc import rpc
from nameko.web.handlers import http
from nameko_prometheus import PrometheusMetrics
from prometheus_client import Counter
from nameko_zipkin import Zipkin

work_units = Counter(
    "my_service_work_units_total", "Total number of work units", ["work_type"]
)

class CustomerService:
   metrics = PrometheusMetrics()
   name = 'CustomerService'
   zipkin = Zipkin()

   @rpc
   def GetCustomerDetails(self):
    assert self.zipkin.service_name == "CustomerService.name"
    #assert self.zipkin.span_name == "CustomerService.method.__name__"
    work_units.labels(work_type="hard").inc()
    return "Customer details!"

   @http("GET", "/metrics")
   def serve_metrics(self, request):
    return self.metrics.expose_metrics(request)