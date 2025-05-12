package repo;

import model.Course;

import java.util.List;

public interface CourseRepository {
    List<Course> findAllCourses();
    void addCourse(Course c);
    Course parseCourse(String s);
    }
