package com.spring10.springbootlearn.a1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {

    @RequestMapping("/courses")
    public List<Course> retrieveAllCourses()
    {
        return Arrays.asList(
                new Course(1, "JavaScript", "in3Days"),
                new Course(2, "HTML and CSS", "in2Days"),
                new Course(3, "Spring", "in3Days"),
                new Course(4, "React", "in4Days"),
                new Course(5, "nodeJS", "in4Days"),
                new Course(6, "nodeJS", "in4Days")
        );
    }
}
