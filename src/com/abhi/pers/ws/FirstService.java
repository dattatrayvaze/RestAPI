package com.abhi.pers.ws;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.abhi.pers.model.Human;

@Path("human")
public class FirstService {
	@GET
	@Path("test")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getHuman() {
		/*List<String> list = new ArrayList<String>();
		list.add("Abhishek");
		list.add("Kalpesh");
		list.add("Siddhesh");*/
		return Response.status(200).entity("hello world").build();
	}
	
	@GET
	@Path("list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getHumanList() {
		Map<String,String> map = new HashMap<String,String>();
		map.put("1","Abhishek");
		map.put("2","Kalpesh");
		map.put("3","Siddhesh");
		//new JSONObject
		return Response.status(200).entity(new JSONObject(map)).build();
	}
	@GET
	@Path("object")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getHumanObj() throws JsonGenerationException, JsonMappingException, IOException, JSONException {
		Human human = new Human("1","Abhishek","28");
		//new JSONObject
		ObjectMapper mapper = new ObjectMapper();
		

		//Object to JSON in file
		mapper.writeValue(new File("c:\\file.json"), human);

		//Object to JSON in String
		String jsonInString = mapper.writeValueAsString(human);
		Response response = Response.status(200).header("Access-Control-Allow-Origin", "*").entity(new JSONObject(jsonInString)).build();
		return response;
	}

}
