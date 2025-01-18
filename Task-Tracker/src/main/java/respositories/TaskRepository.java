package respositories;

import entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.function.LongFunction;
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
