package com.example.dorm_management.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

/**
 * Created by vuong on 12/4/2018.
 */
@Data
@Entity
@Table(name = "time_register")
public class TimeRegister {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @Column(name = "semester_id")
    private Integer semesterId;

    @Column(name = "status")
    private Integer status;

    @Column(name = "date_begin")
    private String dateBegin;

    @Column(name = "date_end")
    private String dateEnd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(Integer semesterId) {
        this.semesterId = semesterId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(String dateBegin) {
        this.dateBegin = dateBegin;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public TimeRegister() {

    }

    public TimeRegister(Integer semesterId, Integer status, String dateBegin, String dateEnd) {

        this.semesterId = semesterId;
        this.status = status;
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
    }
}
