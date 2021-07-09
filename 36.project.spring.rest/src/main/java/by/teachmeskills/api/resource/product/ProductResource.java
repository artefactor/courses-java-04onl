package by.teachmeskills.api.resource.product;

import by.teachmeskills.api.service.product.IProductService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
//@Path("/products")
//@Consumes(MediaType.APPLICATION_JSON)
//@Produces(MediaType.APPLICATION_JSON)
public class ProductResource {

    private IProductService productService;

//    @GET
    public Response getAll() {
        return Response.ok(productService.getAllProducts()).build();
    }

//    @GET
//    @Path("/{id}")
    public Response getProduct(@PathParam("id") Long id) {
        return Response.ok(productService.getProductById(id)).build();
    }

//    @Autowired
    public void setProductService(IProductService productService) {
        this.productService = productService;
    }
}
