/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import Models.Product;
import Services.ProductService;
import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author John Wick Recargado
 */
@Path("product")
public class ProductResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ProductResource
     */
    public ProductResource() {
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("add")
    public Response create(Product p){
        try {
            ProductService pservice = new ProductService();
            pservice.create(p);
            return Response.ok(new Gson().toJson(p), MediaType.APPLICATION_JSON).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.SEE_OTHER).entity(e.toString()).build();
        }
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("addgroup")
    public Response create(Product[] p){
        try {
            ProductService pservice = new ProductService();
            pservice.create(p);
            return Response.ok(new Gson().toJson(p), MediaType.APPLICATION_JSON).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.SEE_OTHER).entity(e.toString()).build();
        }
    }
    
    private final ExecutorService executorService = java.util.concurrent.Executors.newCachedThreadPool();
    @GET
    @Path("products")
    @Produces(MediaType.APPLICATION_JSON)
    public void read(@Suspended
    final AsyncResponse asyncResponse) {
        executorService.submit(() -> {
            asyncResponse.resume(doRead());
        });
    }

    private Response doRead() {
        try {
            List<Product> lop = new ProductService().read();
            String JSON = new Gson().toJson(lop);
            return Response.ok(JSON, MediaType.APPLICATION_JSON).build();
        } catch(SQLException e) {
            return Response.status(Response.Status.SEE_OTHER).entity(e.toString()).build();
        }
    }
}
