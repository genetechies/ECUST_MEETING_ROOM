package com.genetechies.ecust_meeting_room.pojo;

public class UserQueryVo extends PageQuery{
    private String role;

    private String name;


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
