package com.example.dorm_management.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "role", schema = "dorm")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class RoleEntity {
    private Integer id;
    private Integer actionId;
    private Integer groupId;
    private Integer roleId;
    private ActionEntity actionByActionId;
    private GroupsEntity groupsByGroupId;
    private UserEntity userByRoleId;
    private Collection<RoleUserEntity> roleUsersById;
    private Collection<UserEntity> usersById;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    @Basic
//    @Column(name = "action_id")
//    public Integer getActionId() {
//        return actionId;
//    }
//
//    public void setActionId(Integer actionId) {
//        this.actionId = actionId;
//    }
//
//    @Basic
//    @Column(name = "group_id")
//    public Integer getGroupId() {
//        return groupId;
//    }
//
//    public void setGroupId(Integer groupId) {
//        this.groupId = groupId;
//    }
//
//    @Basic
//    @Column(name = "role_id")
//    public Integer getRoleId() {
//        return roleId;
//    }
//
//    public void setRoleId(Integer roleId) {
//        this.roleId = roleId;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleEntity that = (RoleEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(actionId, that.actionId) &&
                Objects.equals(groupId, that.groupId) &&
                Objects.equals(roleId, that.roleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, actionId, groupId, roleId);
    }

    @ManyToOne
    @JoinColumn(name = "action_id", referencedColumnName = "id", nullable = false)
    public ActionEntity getActionByActionId() {
        return actionByActionId;
    }

    public void setActionByActionId(ActionEntity actionByActionId) {
        this.actionByActionId = actionByActionId;
    }

    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id", nullable = false)
    public GroupsEntity getGroupsByGroupId() {
        return groupsByGroupId;
    }

    public void setGroupsByGroupId(GroupsEntity groupsByGroupId) {
        this.groupsByGroupId = groupsByGroupId;
    }

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    public UserEntity getUserByRoleId() {
        return userByRoleId;
    }

    public void setUserByRoleId(UserEntity userByRoleId) {
        this.userByRoleId = userByRoleId;
    }

    @OneToMany(mappedBy = "roleByRoleId")
    public Collection<RoleUserEntity> getRoleUsersById() {
        return roleUsersById;
    }

    public void setRoleUsersById(Collection<RoleUserEntity> roleUsersById) {
        this.roleUsersById = roleUsersById;
    }

    @OneToMany(mappedBy = "roleByRoleId")
    @JsonIgnore
    public Collection<UserEntity> getUsersById() {
        return usersById;
    }

    public void setUsersById(Collection<UserEntity> usersById) {
        this.usersById = usersById;
    }
}
