package kr.ac.hansung.cse.service;

import kr.ac.hansung.cse.dao.RegisterDao;
import kr.ac.hansung.cse.model.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterService {
    @Autowired
    private RegisterDao registerDao;

    public void insert(Registration registration){
        registerDao.insert(registration);
    }

    public List<Registration> getCoursesByGroup(int year, int semester) {
        return registerDao.getCoursesByGroup(year, semester);
    }

}
