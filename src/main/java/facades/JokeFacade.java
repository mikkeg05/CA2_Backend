package facades;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.DataDTO;
import dtos.JokeDTO;
import dtos.JokeDTO2;
import entities.JokeEntity;
import utils.EMF_Creator;
import utils.HttpUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.io.IOException;

public class JokeFacade{
    private static JokeFacade instance;
    private static EntityManagerFactory emf;
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private JokeFacade(){}

    public static JokeFacade getJokeFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new JokeFacade();
        }
        return instance;
    }
    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }




    public DataDTO getJoke() throws IOException {
        EntityManager em = getEntityManager();
        DataDTO d = HttpUtils.fetchJoke2();
        JokeEntity je = new JokeEntity(d.getData().getfact(), d.getData().getcat());
        try {
            em.getTransaction().begin();
            em.persist(je);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return d;
        }







}
