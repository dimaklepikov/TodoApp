package todolist;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TodoService {

    private List <Todos> todos = new ArrayList<>(Arrays.asList(
            new Todos(0, "Feed a Car", "Twice"),
            new Todos(1, "Feed a Dog", "Twice")
    ));

    public List <Todos> getTodos() {
        return todos;
    }
    public Todos getTodo(Integer id) {
        return todos.get(id);
    }

    public void addTodo(Todos todo) {
        todos.add(todo);
    }

    public void updateTodo(Integer id, Todos todo) {
        for (int i=0; i < todos.size(); i++) {
            Todos t = todos.get(i);
            if (t.getId().equals(id))
                todos.set(i, todo);
        }
    }

    public void deleteTodo(Integer id) {
        todos.removeIf(t -> t.getId().equals(id));
    }
}
