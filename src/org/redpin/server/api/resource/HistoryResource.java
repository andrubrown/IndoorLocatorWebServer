package org.redpin.server.api.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.redpin.server.standalone.core.History;
import org.redpin.server.standalone.core.User;
import org.redpin.server.standalone.db.HomeFactory;
import org.redpin.server.standalone.json.GsonFactory;

@Path("/history")
public class HistoryResource {

	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<History> getAll() {
		return HomeFactory.getHistoryHome().getAll();
    }
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User postUser(String jsonRequest) {
		
		User user = GsonFactory.getGsonInstance().fromJson(jsonRequest, User.class);
		user = HomeFactory.getUserHome().add(user);
		
		return user;
	}
	
}