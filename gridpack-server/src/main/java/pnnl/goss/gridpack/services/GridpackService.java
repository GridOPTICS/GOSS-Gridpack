package pnnl.goss.gridpack.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pnnl.goss.gridpack.common.datamodel.GridpackPowergrid;

@Path("/")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public interface GridpackService {

    @GET
    @Path("/{powergridName}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public GridpackPowergrid getGridpackGrid(
            @PathParam(value = "powergridName") String powergridName);

    @GET
    @Path("/{powergridName}/full")
    @Produces({MediaType.TEXT_PLAIN})
    public String getGridpackGridWithWadl(
            @PathParam(value = "powergridName") String powergridName,
            @PathParam(value="plain") String asPlain);


}
