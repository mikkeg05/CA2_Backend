package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.DataDTO;
import dtos.JokeDTO2;
import facades.JokeFacade;
import utils.EMF_Creator;
import utils.HttpUtils;

import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

@Path("jokes")
public class JokesResource {
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();

    private static final JokeFacade FACADE =  JokeFacade.getJokeFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    @Context
    private UriInfo context;

    @Context
    SecurityContext securityContext;

    Gson gson = new Gson();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("admin")
    public String getJoke() throws IOException, ExecutionException, InterruptedException {
        String result = gson.toJson(HttpUtils.fetchJoke());
        return result;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/individual")
    public String getJoke2() throws IOException, ExecutionException, InterruptedException {
       DataDTO data = FACADE.getJoke();

        return gson.toJson(data);
    }

}
