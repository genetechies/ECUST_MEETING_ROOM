package com.genetechies.ecust_meeting_room.pojo;

public class ReservationAdminIdVo extends PageQuery{

    private Integer adminId;

    private String status;

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
