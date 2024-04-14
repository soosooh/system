package kr.ac.hansung.cse.controller;

import kr.ac.hansung.cse.model.Course;
import kr.ac.hansung.cse.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class CourseController {

    @Autowired
    private  CourseService courseService;

    @GetMapping("/coursecheck")
    public String showCourses(Model model) {
        Map<String, Object> groupedCoursesInfo = courseService.getGroupedCourses();
        int totalCredits = courseService.getTotalCredits();
        model.addAttribute("groupedCoursesInfo", groupedCoursesInfo);
        model.addAttribute("totalCredits", totalCredits);

        return "coursecheck";
    }

    @GetMapping("/coursedetails")
    public String showCourseDetails(Model model,
                                    @RequestParam("year") int year,
                                    @RequestParam("semester") int semester) {
        List<Course> courses = courseService.getCoursesByGroup(year, semester);
        if (courses.isEmpty()) {
            model.addAttribute("message", "그 년도와 학기는 존재하지 않습니다");
        } else {
            model.addAttribute("courses", courses);
        }
        return "coursedetails";
    }
}
