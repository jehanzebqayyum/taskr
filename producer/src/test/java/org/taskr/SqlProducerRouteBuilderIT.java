package org.taskr;

import java.util.concurrent.TimeUnit;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.activemq.junit.EmbeddedActiveMQBroker;
import org.apache.camel.CamelContext;
import org.apache.camel.Consume;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.NotifyBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.spring.CamelSpringBootRunner;
import org.apache.camel.test.spring.CamelTestContextBootstrapper;
import org.apache.camel.test.spring.DisableJmx;
import org.apache.camel.test.spring.MockEndpoints;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.BootstrapWith;
import org.springframework.test.context.ContextConfiguration;
import static org.junit.Assert.assertTrue;
import static org.apache.activemq.camel.component.ActiveMQComponent.activeMQComponent;

@Ignore
@RunWith(CamelSpringBootRunner.class)
@SpringBootTest(classes = ProducerApplication.class)
public class SqlProducerRouteBuilderIT {
	@Rule
	public EmbeddedActiveMQBroker broker = new EmbeddedActiveMQBroker();

	@Autowired
	protected CamelContext camelContext;

	@Test
	public void testPositive() throws Exception {
		((ActiveMQComponent)camelContext.getComponent("activemq")).setBrokerURL("vm://embedded-broker");
		NotifyBuilder notify = new NotifyBuilder(camelContext).whenDone(1).create();

		boolean done = notify.matches(10, TimeUnit.SECONDS);
		assertTrue("Should be done", done);
	}
}
