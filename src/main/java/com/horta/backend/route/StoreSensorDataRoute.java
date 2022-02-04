package com.horta.backend.route;

import com.horta.backend.model.Sensor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.ListJacksonDataFormat;
import org.springframework.stereotype.Component;

@Component
public class StoreSensorDataRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:storeSensorData")
                .routeId("direct-storeSensorData")
                .log(">${body}")
                .unmarshal(new ListJacksonDataFormat(Sensor.class))
                .log(">>>>>>${body}")
                .to("jpa:com.horta.backend.model.Sensor?entityType=java.util.ArrayList")
                .end();
    }
}
