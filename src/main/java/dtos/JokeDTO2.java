package dtos;

import entities.JokeEntity;

public class JokeDTO2 {
    private String fact;
    private String cat;


    public JokeDTO2(String fact, String cat) {
        this.fact = fact;
        this.cat = cat;
    }
    /*public JokeDTO2(JokeEntity je){
        this.fact = je.getfact();
        this.cat = je.getcat();
    }

     */



    public String getfact() {
        return fact;
    }

    public void setfact(String fact) {
        this.fact = fact;
    }

    public String getcat() {
        return cat;
    }

    public void setcat(String cat) {
        this.cat = cat;
    }
}
