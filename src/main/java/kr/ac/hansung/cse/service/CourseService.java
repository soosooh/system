package kr.ac.hansung.cse.service;

import kr.ac.hansung.cse.dao.CourseDao;
import kr.ac.hansung.cse.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Service
public class CourseService {

    private CourseDao courseDao;

    @Autowired
    public CourseService(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    public List<Course> getAllCourses() {
        return courseDao.getAllCourses();
    }

    public List<Course> getCoursesByGroup(int year, int semester) {
        return courseDao.getCoursesByGroup(year, semester);
    }

    public int getTotalCredits() {
        return courseDao.getTotalCredits();
    }

    public Map<String, Object> getGroupedCourses() {
        List<Course> allCourses = getAllCourses();
        Map<String, List<Course>> groupedCourses = allCourses.stream()
                .collect(Collectors.groupingBy(
                        course -> course.getYear() + "-" + course.getSemester(),
                        TreeMap::new,
                        Collectors.toList()
                ));

        Map<String, Object> coursesInfo = new TreeMap<>(); // Maintain order
        groupedCourses.forEach((key, value) -> {
            int totalCredits = value.stream().mapToInt(Course::getCredit).sum();
            Map<String, Object> details = new HashMap<>();
            details.put("courses", value);
            details.put("totalCredits", totalCredits);
            coursesInfo.put(key, details);
        });

        return coursesInfo;
    }

}
