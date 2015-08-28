package com.ca.field.restevent;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.nimsoft.nimbus.NimException;

/**
 * Root resource (exposed at "rest" path)
 */
@Path("UIM")
public class UIMRescource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
//    @Path("/{param}")
//    public String getIt(@PathParam("param") String msg) {
    public String getIt() {
  //  	String output = "REST says : " + msg;

        return "REST put method only lives here";
    }
    
    @PUT
//    @Path("/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public String putIt(@QueryParam("severity") int iSeverity, 
    		@QueryParam("message") String sMessage, 
    		@QueryParam("subsystem") String sSubsystem, 
    		@QueryParam("suppressionid") String sSuppressionid, 
    		@QueryParam("source") String sSource ) throws NimException // ?severity=5&message=test boodschap&subsystem=1.2.3&suppressionid=suppression&source=vanmij
    {
    	// String output = "REST says : " + Id + " " + " " + inDate ;
    	
    	// int iSeverity, String sMessage, String sSubsystem, String sSuppressionid, String sSource
    	String id= Wto.event(iSeverity,sMessage,sSubsystem,sSuppressionid,sSource);
//    	Wto.event(3, "test boodschap", "1.1.19", "supp", "van mij");
        
    	return "{ \" received \": { \"subkey\" : \""+id+"\" }}";
   
    }
}
