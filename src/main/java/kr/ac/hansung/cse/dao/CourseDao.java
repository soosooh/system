package kr.ac.hansung.cse.dao;

import kr.ac.hansung.cse.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
public class CourseDao {

    private JdbcTemplate jdbcTemplate;
    private static final Logger logger = LoggerFactory.getLogger(CourseDao.class);

    @Autowired
    public CourseDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Course> getAllCourses() {
        //
        String sql = "SELECT * FROM courses";
        return jdbcTemplate.query(sql, new RowMapper<Course>() {
            @Override
            public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
                Course course = new Course();
                course.setYear(rs.getInt("year"));
                course.setSemester(rs.getInt("semester"));
                course.setCourseCode(rs.getString("course_code"));
                course.setCourseName(rs.getString("course_name"));
                course.setCourseType(rs.getString("course_type"));
                course.setProfessor(rs.getString("professor"));
                course.setCredit(rs.getInt("credit"));
                return course;
            }
        });
    }


    public List<Course> getCoursesByGroup(int year, int semester) {
        //
        String sql = "SELECT * FROM courses WHERE year = ? AND semester = ?";
        List<Course> courses = jdbcTemplate.query(sql, new Object[]{year, semester}, new RowMapper<Course>() {
            @Override
            public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
                Course course = new Course();
                course.setYear(rs.getInt("year"));
                course.setSemester(rs.getInt("semester"));
                course.setCourseCode(rs.getString("course_code"));
                course.setCourseName(rs.getString("course_name"));
                course.setCourseType(rs.getString("course_type"));
                course.setProfessor(rs.getString("professor"));
                course.setCredit(rs.getInt("credit"));
                return course;
            }
        });
        return courses;
    }
    public int getTotalCredits() {
        //
        String sql = "SELECT SUM(credit) FROM courses";
        Integer totalCredits = jdbcTemplate.queryForObject(sql, Integer.class);
        return totalCredits != null ? totalCredits : 0;
    }
}