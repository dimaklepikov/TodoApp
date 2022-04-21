package todolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    private List <Todos> todos = new ArrayList<>(Arrays.asList(
            new Todos(0, "Feed a Car", "Twice"),
            new Todos(1, "Feed a Dog", "Twice")
    ));

    public List <Todos> getTodos() {
        List<Todos> todos = new ArrayList<>();
        todoRepository.findAll()
                .forEach(todos::add);
        return todos;
    }
    public Optional<Todos> getTodo(Integer id) {
//        return todos.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return todoRepository.findById(id);
    }

    public void addTodo(Todos todo) {
        todoRepository.save(todo);
    }

    public void updateTodo(Integer id, Todos todo) {
        todoRepository.save(todo);
    }

    public void deleteTodo(Integer id) {
        todoRepository.deleteById(id);

    }
}
