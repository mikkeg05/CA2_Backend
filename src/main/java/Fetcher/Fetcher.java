package Fetcher;
import com.google.gson.Gson;
import java.io.IOException;

import com.google.gson.GsonBuilder;
import com.nimbusds.jose.shaded.json.JSONObject;
import dtos.DataDTO;
import facades.JokeFacade;
import utils.EMF_Creator;
import utils.HttpUtils;

import javax.persistence.EntityManagerFactory;


public class Fetcher {
    public static void main(String[] args) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();


    }
}
