package org.exoplatform.market.rest;

import java.util.List;

import io.swagger.annotations.*;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.exoplatform.market.service.ProductService;
import org.exoplatform.market.dto.Product;
import org.exoplatform.market.util.Utils;

import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.rest.resource.ResourceContainer;
import org.exoplatform.common.http.HTTPStatus;
import org.exoplatform.services.log.Log;


@Path("/market/api")
@Api(value =  "/v1/market/product", description = "Manage Product associate to users")
@RolesAllowed("users")
public class ProductRest implements ResourceContainer{

  private static final Log LOG = ExoLogger.getLogger(ProductRest.class);
  private ProductService productService;

  public ProductRest(ProductService productService) {
    this.productService = productService;
  }

  @GET 
  @RolesAllowed("users")
  @Produces(MediaType.APPLICATION_JSON)
  @Path("allProduct")
  @ApiOperation(
    value = "Retrieves the list of products available for an owner of type user or space, identitifed by its identity technical identifier.",
    httpMethod = "GET",
    response = Response.class,
    produces = "application/json"
  )
  @ApiResponses(
    value = { @ApiResponse(code = HTTPStatus.OK, message = "Request fulfilled"),
        @ApiResponse(code = HTTPStatus.UNAUTHORIZED, message = "Unauthorized operation"),
        @ApiResponse(code = HTTPStatus.INTERNAL_ERROR, message = "Internal server error"), }
  )
  public Response getAllProduct() {
    String currentUser = Utils.getCurrentUser();
    if (StringUtils.isBlank(currentUser)) {
      LOG.warn("current User is null");
      return Response.status(Response.Status.UNAUTHORIZED).build();
    }
    try {
      List<Product> productsList = productService.getAllProducts();
      return Response.ok(productsList).build();
    } catch (IllegalAccessException e) {
      LOG.warn("User '{}' attempts to access to product list with owner Ids", currentUser, e);
      return Response.status(Response.Status.UNAUTHORIZED).entity(e.getMessage()).build();
    } catch (Exception e) {
      LOG.warn("Error retrieving list of products", e);
      return Response.serverError().entity(e.getMessage()).build();
    }
  }
  
}
