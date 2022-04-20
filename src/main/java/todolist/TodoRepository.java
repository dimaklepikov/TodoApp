package todolist;

import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todos, Integer> {
}
