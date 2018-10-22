package com.example.dorm_management.services;

import com.example.dorm_management.entities.StudentCode;
import com.example.dorm_management.respositories.StudentCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by vuong on 10/22/2018.
 */
@Service
public class CodeStudentServiceImpl implements CodeStudentService {
    @Autowired
    private StudentCodeRepository studentCodeRepository;
    @Override
    public boolean addStudentCode(StudentCode studentCode) {
        try{
            if(studentCode == null) return false;
            studentCodeRepository.save(studentCode);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean deleteStudentCode(Integer id) {
        try{
            studentCodeRepository.delete(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean updateStudentCode(Integer id, StudentCode _studentCode) {
        try{
            StudentCode studentCode = studentCodeRepository.findOne(id);
            if(studentCode == null) return false;
            studentCode.setName(_studentCode.getName());
            studentCode.setGrade(_studentCode.getGrade());
            studentCode.setUser(_studentCode.getUser());
            studentCode.setValue(_studentCode.getValue());
            studentCodeRepository.save(studentCode);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
