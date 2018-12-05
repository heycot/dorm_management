package com.example.dorm_management.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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

//    @NotNull
//    @Column(name = "semester_id")
//    private Integer semesterId;

    @Column(name = "status")
    private Integer status;

    @Column(name = "date_begin")
    private String dateBegin;

    @Column(name = "date_end")
    private String dateEnd;

    @ManyToOne()
    @JoinColumn(name = "semester_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Semester semester;

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
//
//    public Integer getSemesterId() {
//        return semesterId;
//    }
//
//    public void setSemesterId(Integer semesterId) {
//        this.semesterId = semesterId;
//    }

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

        this.semester = new Semester();
        this.semester.setId(semesterId);
        this.status = status;
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
    }

    public boolean onTime(String time){
        return Long.parseLong(time) >= Long.parseLong(dateBegin) && Long.parseLong(time) <= Long.parseLong(dateEnd);
    }

/*    @Override
    public String toString() {
        return "{ " +
                "\"id\" : " + this.id +
                "\"status\" : " + this.status +
                "\"dateBegin\" : " + this.dateBegin +
                "\"dateEnd\" : " + this.dateEnd +
                "\"semester\" : " + this.semester +
                "}";
    }*/
}
