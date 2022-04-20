package todolist;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Todos {
    @Id
    private Integer id;
    private String name;
    private String description;

    public Todos() {

    }

    public Todos(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }
    public Integer setId(Integer id) {
        this.id = id;
        return id;
    }
    public String getName() {
        return  name;
    }
    public String getDescription() {
        return description;
    }
    public String setDescription(String description) {
        this.description = description;
        return description;
    }
}
