package com.pranave.maintenance_app;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
@Path("owner_info")
public class test_resource {
	DbFunctions d = new DbFunctions();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<owner_info> get_values()
	{
		System.out.println("called values");
		return d.getValues_ownersinfo();
	}
	@GET
	@Path("ownerflats")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Owner_flatinfo> get_ofvalues()
	{
		System.out.println("called values");
		return d.getValues_ownersflatinfo();
	}
	@GET
	@Path("ownerflats/maintenance/{val}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Owner_flatinfo> get_ofvaluesmtnc(@PathParam("val") String val)
	{
		System.out.println("called values");
		return d.getValues_ownersflatinfo_mtnc(val);
	}
	@GET
	@Path("ownerflats/vacent")
	@Produces(MediaType.APPLICATION_JSON)
	public List<flat_info> get_flats()
	{
		System.out.println("called values");
		return d.getValues_flats();
	}
	@GET
	@Path("map")
	@Produces(MediaType.APPLICATION_JSON)
	public List<test> getmap()
	{
		System.out.println("called values");
		return d.getValues_map();
	}
	@GET
	@Path("owner/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public owner_info get_valuesTests(@PathParam("id") int id)
	{
		System.out.println("called values");
		return d.getValues_ownerinfo(id);
	}
	@POST
	@Path("owner")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public owner_info createowner(owner_info a)
	{
		System.out.println(a);
		d.create_owner(a);
		return a;
	}
	@DELETE
	@Path("owner/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public owner_info delete_owner(@PathParam("id") int id)
	{
		owner_info a = d.getValues_ownerinfo(id);
		if(a.getId()!=0)
			d.delete_owner(id);
		return a;
	}
	@PUT
	@Path("map")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public test update_flat(test a)
	{
		System.out.println(a);
		d.update_flat(a);
		return a;
	}
}
