package com.example.dorm_management.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by vuong on 12/5/2018.
 */
@Data
@Entity
@Table(name = "semester")
public class Semester {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "month")
    private Integer month;

    @Column(name = "month_begin")
    private Integer monthBegin;

    @Column(name = "month_end")
    private Integer monthEnd;
/*

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "semester")
    private List<TimeRegister> timeRegisters;


    public List<TimeRegister> getTimeRegisters() {
        return timeRegisters;
    }

    public void setTimeRegisters(List<TimeRegister> timeRegisters) {
        this.timeRegisters = timeRegisters;
    }
*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getMonthBegin() {
        return monthBegin;
    }

    public void setMonthBegin(Integer monthBegin) {
        this.monthBegin = monthBegin;
    }

    public Integer getMonthEnd() {
        return monthEnd;
    }

    public void setMonthEnd(Integer monthEnd) {
        this.monthEnd = monthEnd;
    }

    public Semester() {

    }

    public Semester(String name, Integer month, Integer monthBegin, Integer monthEnd) {

        this.name = name;
        this.month = month;
        this.monthBegin = monthBegin;
        this.monthEnd = monthEnd;
    }

}
