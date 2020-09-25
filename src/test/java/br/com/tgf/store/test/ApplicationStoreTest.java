package br.com.tgf.store.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.tgf.store.util.Util;

class ApplicationStoreControllerTest {

	HttpServer server;
	Client cliente;
	WebTarget target;
	
	@BeforeEach
	void setUp() throws IOException {
		ResourceConfig config = new ResourceConfig().packages("br.com.tgf.store.controller");
		String url = Util.getProperty("server.properties", "server.url");
		String port = Util.getProperty("server.properties", "server.port");
		URI uri = URI.create(url + ":" + port + "/store/rest");
		server = GrizzlyHttpServerFactory.createHttpServer(uri, config);
		server.start();
		
		cliente = ClientBuilder.newClient();
        target = cliente.target(url + ":" + port + "/store");
	}

	@AfterEach
	void tearDown() {
		server.shutdown();
	}

	@Test
	void versionShouldMatch() {
        String conteudo = target.path("/rest/version").request().get(String.class);
        assertEquals("0.0.1-SNAPSHOT", conteudo);
	}

}
