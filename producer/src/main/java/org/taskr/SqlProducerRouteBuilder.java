package org.taskr;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class SqlProducerRouteBuilder extends RouteBuilder {

	public void configure() {
		//from("{{sql.source}}").to("{{activemq.target}}").end();
		from("{{sql.source}}").to("log:test").end();
	}
}