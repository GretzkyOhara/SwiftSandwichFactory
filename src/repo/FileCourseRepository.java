package repo;

import model.Course;
import model.Person;
import model.Sandwich;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class FileCourseRepository implements CourseRepository {

    private List<Course> courses = new ArrayList<>();
    private String fileLocation = "/temp/javacourses/courses.csv";

    public void addCourse(Course c) {
        courses.add(c);
    }

    public List<Course> findAllCourses() {
        return courses;
    }

    public FileCourseRepository() throws IOException {
        courses = Files.lines(Paths.get(fileLocation))
                .map(line->this.parseCourse(line))
                .collect(Collectors.toList());
    }

    public Course parseCourse(String s){
        String[] vals = s.split(";");
        String title = vals[0];
        int days = Integer.parseInt(vals[1]);
        double price = Double.parseDouble(vals[2]);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d/M/yyyy");
        LocalDate released = LocalDate.parse(vals[3],dtf);
        //System.out.println(title);
        Course c = new Course(title);
        return c;

    }


}
