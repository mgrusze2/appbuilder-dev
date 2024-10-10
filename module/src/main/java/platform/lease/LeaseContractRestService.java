package platform.lease;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.planonsoftware.jaxrs.api.v9.context.IJaxRsResourceContext;

import platform.lease.jaxrs.dto.BuildingSuiteDTO;
import platform.lease.jaxrs.dto.LeaseContractDTO;
import platform.lease.jaxrs.dto.LeaseContractLineDTO;
import platform.lease.jaxrs.dto.PropertyDTO;
import platform.lease.jaxrs.service.BuildingSuiteService;
import platform.lease.jaxrs.service.LeaseContractLineService;
import platform.lease.jaxrs.service.LeaseContractService;
import platform.lease.jaxrs.service.PropertyService;

@Path("/lease")
public class LeaseContractRestService {
    @Context
    IJaxRsResourceContext jaxrsContext;

    @GET
    @Path("/contractlines")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getContractLineDetails() {
        jaxrsContext.getLogService().debug("Planon getContractLineDetails method execution started");
        LeaseContractLineService service = new LeaseContractLineService();
        List<LeaseContractLineDTO> line = null;
        Response response = null;
        try {

            line = service.getAllLeaseLineContract(jaxrsContext);

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (line == null) {
            response = Response.status(Response.Status.NOT_FOUND).build();
        } else {
            response = Response.ok().entity(line).build();
        }
        jaxrsContext.getLogService().debug("Planon getContractLineDetails method execution ended.......");
        return response;
    }

    @GET
    @Path("/contractline/{leaseContractRef}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getContractLineDetailsByContractRef(@PathParam("leaseContractRef") int contractRef) {
        jaxrsContext.getLogService()
                .debug("Planon getContractLineDetailsByContractRef method execution started" + contractRef);
        LeaseContractLineService service = new LeaseContractLineService();
        List<LeaseContractLineDTO> line = null;
        Response response = null;
        try {

            line = service.getAllLeaseLineContractByContractRef(jaxrsContext, contractRef);

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (line == null) {
            response = Response.status(Response.Status.NOT_FOUND).build();
        } else {
            response = Response.ok().entity(line).build();
        }
        jaxrsContext.getLogService().debug("Planon getAllLeaseLineContractByContractRef method execution ended.......");
        return response;
    }

    @GET
    @Path("/contractline/property/{propertyRef}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllLeaseLineContractByPropertyRef(@PathParam("propertyRef") int propertyRef) {
        jaxrsContext.getLogService()
                .debug("Planon getAllLeaseLineContractByPropertyRef method execution started" + propertyRef);
        LeaseContractLineService service = new LeaseContractLineService();
        List<LeaseContractLineDTO> line = null;
        Response response = null;
        try {

            line = service.getAllLeaseLineContractByPropertyRef(jaxrsContext, propertyRef);

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (line == null) {
            response = Response.status(Response.Status.NOT_FOUND).build();
        } else {
            response = Response.ok().entity(line).build();
        }
        jaxrsContext.getLogService().debug("Planon getAllLeaseLineContractByPropertyRef method execution ended.......");
        return response;
    }

    @GET
    @Path("/leasecontracts")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLeaseContractDetails() {
        jaxrsContext.getLogService().debug("Planon getContractDetails method execution started");
        LeaseContractService service = new LeaseContractService();
        List<LeaseContractDTO> line = null;
        Response response = null;
        try {

            line = service.getAllLeaseContract(jaxrsContext);

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (line == null) {
            response = Response.status(Response.Status.NOT_FOUND).build();
        } else {
            response = Response.ok().entity(line).build();
        }
        jaxrsContext.getLogService().debug("Planon getContractLineDetails method execution ended.......");
        return response;
    }

    @GET
    @Path("/leasecontract/{syscode}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLeaseContractDetailsBySyscode(@PathParam("syscode") int sysCode) {
        jaxrsContext.getLogService()
                .debug("Planon getLeaseContractDetailsBySyscode method execution started " + sysCode);
        LeaseContractService service = new LeaseContractService();
        List<LeaseContractDTO> line = null;
        Response response = null;
        try {

            line = service.getLeaseContractDetailsBySyscode(jaxrsContext, sysCode);

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (line == null) {
            response = Response.status(Response.Status.NOT_FOUND).build();
        } else {
            response = Response.ok().entity(line).build();
        }
        jaxrsContext.getLogService().debug("Planon getContractLineDetails method execution ended.......");
        return response;
    }

    @GET
    @Path("/leasecontract/suite/{suite}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLeaseContractDetailsBySuite(@PathParam("suite") String suite) {
        jaxrsContext.getLogService()
                .debug("Planon getLeaseContractDetailsBySuite method execution started " + suite);
        LeaseContractService service = new LeaseContractService();
        List<LeaseContractDTO> line = null;
        Response response = null;
        try {

            line = service.getLeaseContractDetailsBySuite(jaxrsContext, suite);

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (line == null) {
            response = Response.status(Response.Status.NOT_FOUND).build();
        } else {
            response = Response.ok().entity(line).build();
        }
        jaxrsContext.getLogService().debug("Planon getLeaseContractDetailsBySuite method execution ended.......");
        return response;
    }

    @GET
    @Path("/properties")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPropertyDetails() {
        jaxrsContext.getLogService().debug("Planon getPropertyDetails method execution started");
        PropertyService service = new PropertyService();
        List<PropertyDTO> property = null;
        Response response = null;
        try {

            property = service.getAllProperty(jaxrsContext);

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (property == null) {
            response = Response.status(Response.Status.NOT_FOUND).build();
        } else {
            response = Response.ok().entity(property).build();
        }
        jaxrsContext.getLogService().debug("Planon getPropertyDetails method execution ended.......");
        return response;
    }

    @GET
    @Path("/property/syscode/{syscode}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPropertyBySysCode(@PathParam("syscode") int syscode) {
        jaxrsContext.getLogService().debug("Planon getPropertyBySysCode method execution started");
        PropertyService service = new PropertyService();
        List<PropertyDTO> property = null;
        Response response = null;
        try {

            property = service.getPropertyBySysCode(jaxrsContext, syscode);

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (property == null) {
            response = Response.status(Response.Status.NOT_FOUND).build();
        } else {
            response = Response.ok().entity(property).build();
        }
        jaxrsContext.getLogService().debug("Planon getPropertyBySysCode method execution ended.......");
        return response;
    }
    @GET
    @Path("/property/building/{buildingcode}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPropertyByBuildingCode(@PathParam("buildingcode") String buildingCode) {
        jaxrsContext.getLogService().debug("Planon getPropertyByBuildingCode method execution started");
        PropertyService service = new PropertyService();
        List<PropertyDTO> property = null;
        Response response = null;
        try {

            property = service.getPropertyByBuildingCode(jaxrsContext, buildingCode);

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (property == null) {
            response = Response.status(Response.Status.NOT_FOUND).build();
        } else {
            response = Response.ok().entity(property).build();
        }
        jaxrsContext.getLogService().debug("Planon getPropertyBySysCode method execution ended.......");
        return response;
    }

    @GET
    @Path("/buildingsuites")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBuildingSuites() {
        jaxrsContext.getLogService().debug("Planon getBuildingSuites method execution started");
        BuildingSuiteService service = new BuildingSuiteService();

        List<BuildingSuiteDTO> buildingSuite = null;
        Response response = null;
        try {

            buildingSuite = service.getAllBuildingSuites(jaxrsContext);

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (buildingSuite == null) {
            response = Response.status(Response.Status.NOT_FOUND).build();
        } else {
            response = Response.ok().entity(buildingSuite).build();
        }
        jaxrsContext.getLogService().debug("Planon getBuildingSuites method execution ended.......");
        return response;
    }

}