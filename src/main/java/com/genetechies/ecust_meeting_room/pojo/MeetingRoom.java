package com.genetechies.ecust_meeting_room.pojo;


import javax.xml.crypto.Data;
import java.util.Date;

public class MeetingRoom {
    public Integer roomId;

    public String name;

    public Integer capacity;

    public String equipment;

    public String address;

    public String status;

    public Date createdAt;

    public Integer getRoomId() {
        return roomId;
    }

    public String getName() {
        return name;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public String getEquipment() {
        return equipment;
    }

    public String getAddress() {
        return address;
    }

    public String getStatus() {
        return status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
