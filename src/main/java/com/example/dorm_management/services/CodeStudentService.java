package com.example.dorm_management.services;

import com.example.dorm_management.entities.StudentCode;

/**
 * Created by vuong on 10/22/2018.
 */
public interface CodeStudentService {
    public boolean addStudentCode(StudentCode studentCode);
    public boolean deleteStudentCode(Integer id);
    public boolean updateStudentCode(Integer id, StudentCode studentCode);
}
