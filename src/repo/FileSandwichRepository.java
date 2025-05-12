package repo;

import model.Course;
import model.Sandwich;

import java.util.ArrayList;
import java.util.List;

public class FileSandwichRepository implements SandwichRepository{
    private List<Sandwich> sandwiches = new ArrayList<>();
    private String fileLocation = "/temp/javacourses/courses.csv";

    public void addSandwich(Sandwich s) {
        sandwiches.add(s);
    }

    @Override
    public List<Sandwich> findAllSandwiches() {
        return List.of();
    }
}
