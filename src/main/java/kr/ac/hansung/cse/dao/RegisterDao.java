package kr.ac.hansung.cse.dao;

import kr.ac.hansung.cse.model.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class RegisterDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public RegisterDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

      public boolean insert(Registration registration) {
        //egeg
        Integer year = registration.getYear();
        Integer semester= registration.getSemester();
        String courseCode= registration.getCourseCode();
        String courseName= registration.getCourseName();
        String courseType= registration.getCourseType();
        String professor= registration.getProfessor();
        Integer credit= registration.getCredit();


        String sqlStatement= "insert into courses (year,semester ,course_code, course_name, course_type, professor, credit) values (?,?,?,?,?,?,?)";


        return (jdbcTemplate.update(sqlStatement, new Object[] {year,semester,courseCode, courseName, courseType,professor, credit}) == 1);
    }
    public List<Registration> getCoursesByGroup(int year, int semester) {
        //geg
        String sqlStatement = "SELECT * FROM courses WHERE year = ? AND semester = ?";
        return jdbcTemplate.query(sqlStatement, new Object[] {year, semester}, new RowMapper<Registration>() {
            @Override
            public Registration mapRow(ResultSet rs, int rowNum) throws SQLException {
                Registration registration = new Registration();
                registration.setYear(rs.getInt("year"));
                registration.setSemester(rs.getInt("semester"));
                registration.setCourseCode(rs.getString("course_code"));
                registration.setCourseName(rs.getString("course_name"));
                registration.setCourseType(rs.getString("course_type"));
                registration.setProfessor(rs.getString("professor"));
                registration.setCredit(rs.getInt("credit"));
                return registration;
            }
        });
    }
}
