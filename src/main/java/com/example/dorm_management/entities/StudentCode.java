package com.example.dorm_management.entities;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by vuong on 10/21/2018.
 */
@Data
@Entity
@Table(name = "student_code")
public class StudentCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private  String value;

    private String grade;

    @OneToOne
    @JoinColumn(name = "userId")
    private User user;

    public StudentCode() {
    }

    public StudentCode(String name, String value, String grade) {

        this.name = name;
        this.value = value;
        this.grade = grade;
    }
}
