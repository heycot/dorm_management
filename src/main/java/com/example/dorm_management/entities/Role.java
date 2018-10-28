package com.example.dorm_management.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by vuong on 10/12/2018.
 */
@Data
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Integer getActionId() {
        return actionId;
    }

    public void setActionId(Integer actionId) {
        this.actionId = actionId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Role(Integer actionId, Integer groupId) {

        this.actionId = actionId;
        this.groupId = groupId;
    }

    @Column(name = "action_id")
    private Integer actionId;

    @Column(name = "group_id")
    private Integer groupId;

    /*@OneToMany
    @JoinColumn(name = "action_id")
    private Set<Action> actions;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;*/

    public Role() {
    }

   /* public Role(Set<Action> actions, Group group) {
        this.actions = actions;
        this.group = group;
    }*/

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /*public Set<Action> getActions() {
        return actions;
    }

    public void setActions(Set<Action> actions) {
        this.actions = actions;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }*/
}
