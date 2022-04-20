package todolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {
        @Autowired
        private TodoService todoService;

        @RequestMapping("/todos")
        public List <Todos> getTodos() {
            return todoService.getTodos();
        }

        @RequestMapping("/todos/{id}")
        public Todos getTodo(@PathVariable Integer id) {
                return todoService.getTodo(id);
        }

        @RequestMapping(method= RequestMethod.POST, value="/todos")
        public void addTodo(@RequestBody Todos todo) {
                todoService.addTodo(todo);

        }

        @RequestMapping(method=RequestMethod.PUT, value="/todos/{id}")
        public void updateTodo(@RequestBody Todos todo, @PathVariable Integer id) {
                todoService.updateTodo(id, todo);

        }
        @RequestMapping(method=RequestMethod.DELETE,  value="/todos/{id}")
        public void deleteTodo(@PathVariable Integer id) {
                 todoService.deleteTodo(id);
        }

}
