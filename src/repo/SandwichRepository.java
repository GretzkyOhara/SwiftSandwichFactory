package repo;

import model.Course;
import model.Sandwich;

import java.util.List;

public interface SandwichRepository {

    List<Sandwich> findAllSandwiches();

}
