package respositories;

import entities.State;
import entities.Task;
import org.hibernate.query.sqm.mutation.internal.TableKeyExpressionCollector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.function.LongFunction;
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

   default List<Task> findByState(State state){
        return this.findByState(state);
    }
}
