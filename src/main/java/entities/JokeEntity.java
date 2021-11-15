package entities;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "joke_entity")
@Entity
public class JokeEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String fact;
    private String cat;

    public JokeEntity(String fact, String cat) {
        this.fact = fact;
        this.cat = cat;
    }

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

    public JokeEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}