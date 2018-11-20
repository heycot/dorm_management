package com.example.dorm_management.entities;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.beans.ConstructorProperties;
import java.sql.Timestamp;

@Getter
@Setter
@Builder
@Entity
@Data
@Table(name = "time_register")
public class TimeRegister {

    public final static int TIME_REGISTER_ENABLE  = 1;
    public final static int TIME_REGISTER_DISABLE = 0;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date_begin")
    private Timestamp dateBegin;

    @Column(name = "date_end")
    private Timestamp dateEnd;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(Timestamp dateBegin) {
        this.dateBegin = dateBegin;
    }

    public Timestamp getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Timestamp dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public TimeRegister() {
    }

    public static TimeRegister.TimeRegisterBuilder builder(){
        return new TimeRegister.TimeRegisterBuilder();
    }

    @ConstructorProperties({"name", "numberFloor", "status"})
    TimeRegister(Timestamp dateBegin, Timestamp dateEnd, Integer status) {
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
        this.status = status;
    }


    ///===========================================
    public static class TimeRegisterBuilder {
        private Timestamp dateBegin;
        private Timestamp dateEnd;
        private Integer status;

        TimeRegisterBuilder() {
        }

        public TimeRegister.TimeRegisterBuilder dateBegin(Timestamp dateBegin) {
            this.dateBegin = dateBegin;
            return this;
        }

        public TimeRegister.TimeRegisterBuilder dateEnd(Timestamp dateEnd) {
            this.dateEnd = dateEnd;
            return this;
        }

        public TimeRegister.TimeRegisterBuilder status(Integer status) {
            this.status = status;
            return this;
        }

        public TimeRegister build(){
            return new TimeRegister(this.dateBegin, this.dateEnd, this.status);
        }
    }
}
