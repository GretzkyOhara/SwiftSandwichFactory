package repo;

import model.Course;

import java.util.ArrayList;
import java.util.List;

public class FileCourseRepository implements CourseRepository {

    private List<Course> courses = new ArrayList<>();
    private String fileLocation = "C:\\Users\\Duser\\IdeaProjects\\SwiftSandwichFactory\\src\\repo\\courses.csv";


}
