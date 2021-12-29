import (
    "net/http"
    "github.com/micro/go-plugins/wrapper/monitoring/prometheus/v2"
    "github.com/prometheus/client_golang/prometheus/promhttp"
)

func ExposePrometheusmetrics() {
    http.Handle("/metrics", promhttp.Handler())
    go func() {
        err := http.ListenAndServe("localhost:8085", nil)
        if err != nil {
            log.Fatal("Error occured at metrics ", err)
        }
    }() 
}

func main() {
    // New Service
    service := micro.NewService(
        micro.Name("portal-service"),
        micro.Version("latest"),
        micro.WrapHandler(prometheus.NewHandlerWrapper()),
    )

    service.Init(
    )
    go ExposePrometheusmetrics()
    
	if err := service.Run(); err != nil {
        log.Fatal(err)
    }
}

