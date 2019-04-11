package com.tbitsglobal.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/message")
public class RestService
{
	@GET
	public String getMsg()
	{
		return "Hello World !! - Jersey 2";
	}

	//    @POST
	//    @Consumes(MediaType.APPLICATION_JSON)
	//	@Produces(MediaType.APPLICATION_JSON)
	//    public Response postRequest(List<ServiceClass> serviceclass)
	//    {    	
	//    	TestExample test=new TestExample();
	//    	test.testCompiler(serviceclass);
	//        return Response.status(Response.Status.OK).entity(serviceclass).build();
	//    }

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response postRequest(RequestClass r)
	{   
		TestExample test=new TestExample();
		Result res=test.testCompiler(r);
		return Response.status(Response.Status.OK).entity(res).build();
	}
}
