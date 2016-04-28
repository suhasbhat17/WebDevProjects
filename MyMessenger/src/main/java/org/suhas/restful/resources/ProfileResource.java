package org.suhas.restful.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.suhas.restful.model.Profile;
import org.suhas.restful.service.ProfileService;

@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {
	
	private ProfileService proServ = new ProfileService();
	
	@GET
	public List<Profile> getAllProfiles(){
		
		return proServ.getAllProfiles();
	}
	
	@GET
	@Path("/{profileName}")
	public Profile getProfileByName(@PathParam("profileName") String name){
		return proServ.getProfileByname(name);
	}
	
	@POST
	public Profile addProfile(Profile pro){
		return proServ.addProfile(pro);
	}
	
	@PUT
	@Path("/{profileName}")
	public Profile updateProfile(@PathParam("profileName") String name, Profile pro){
		pro.setProfile(name);
		return proServ.updateProfile(pro);
		
	}
	
	@DELETE
	@Path("/{profileName}")
	public void removeProfile(@PathParam("profileName") String name){
		
		proServ.removeProfile(name);
	}
	

	
}
