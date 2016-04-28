package org.suhas.restful.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.suhas.restful.database.Database;
import org.suhas.restful.model.Profile;

public class ProfileService {
	
	private Map<String, Profile> profiles = Database.getProfile();
	
	public ProfileService(){
		profiles.put("sosChumz", new Profile(1L,"sosChumz","sos","chumz"));
		profiles.put("chumzSos", new Profile(1L,"chumzSos","mari","chumz"));
	}
	
	public List<Profile> getAllProfiles(){
		return new ArrayList<>(profiles.values());
	}
	
	public Profile getProfileByname(String name){
		return profiles.get(name);
	}
	
	public Profile addProfile(Profile pro){
		pro.setId(profiles.size()+1);
		profiles.put(pro.getProfile(), pro);
		return pro;
	}
	
	public Profile updateProfile(Profile pro){
		if(pro.getProfile().isEmpty()){
			return null;
			
		}else{
			profiles.put(pro.getProfile(),pro);
			return pro;
		}
	}
	
	public Profile removeProfile(String name){
		return profiles.remove(name);
	}
	

}
