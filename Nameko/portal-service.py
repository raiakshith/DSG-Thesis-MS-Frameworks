from nameko.rpc import rpc, RpcProxy
from nameko.web.handlers import http
from nameko_prometheus import PrometheusMetrics
from prometheus_client import Counter
from nameko_zipkin import Zipkin

work_units = Counter(
    "my_service_work_units_total", "Total number of work units", ["work_type"]
)

class PortalService:
   metrics = PrometheusMetrics()
   name = 'PortalService'
   zipkin = Zipkin()
   customerService = RpcProxy("CustomerService")
   addrressService = RpcProxy("AddressService")
   @rpc
   def say_hello(self):
    assert self.zipkin.service_name == PortalService.name
    assert self.zipkin.span_name == PortalService.method.__name__
    work_units.labels(work_type="hard").inc()
    address = self.addrressService.GetAddress()
    details = self.customerService.GetCustomerDetails()
    return address + details

   @http("GET", "/metrics")
   def serve_metrics(self, request):
    return self.metrics.expose_metrics(request)