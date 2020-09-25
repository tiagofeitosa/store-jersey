package br.com.tgf.store.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
public class ApplicationStoreController {

	@GET
	@Path("version")
	public String appVersion() {
		return "0.0.1-SNAPSHOT";
	}

}
