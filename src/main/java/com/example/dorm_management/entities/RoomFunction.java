package com.example.dorm_management.entities;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.beans.ConstructorProperties;

@Getter
@Setter
@Builder
@Data
@Entity
@Table(name = "room_function")
public class RoomFunction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Integer status;

    public static RoomFunction.RoomFunctionBuilder builder() {
        return new RoomFunction.RoomFunctionBuilder();
    }

    @ConstructorProperties({"name", "status"})
    RoomFunction(String name, Integer status) {
        this.name = name;
        this.status = status;
    }

    public RoomFunction() {
    }

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    //==================================================================================================================

    public static class RoomFunctionBuilder {

        private String name;
        private Integer status;

        RoomFunctionBuilder() {
        }

        public RoomFunction.RoomFunctionBuilder name(String name) {
            this.name = name;
            return this;
        }

        public RoomFunction.RoomFunctionBuilder status(Integer status) {
            this.status = status;
            return this;
        }

        public RoomFunction build(){
            return new RoomFunction(this.name, this.status);
        }
    }
}
