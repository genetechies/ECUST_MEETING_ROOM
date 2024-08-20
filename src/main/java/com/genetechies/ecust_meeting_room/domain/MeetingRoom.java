package com.genetechies.ecust_meeting_room.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName meeting_room
 */
@TableName(value ="meeting_room")
public class MeetingRoom implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer roomId;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private Integer capacity;

    /**
     * 
     */
    private String equipment;

    /**
     * 
     */
    private String address;

    /**
     * 
     */
    private Object status;

    /**
     * 
     */
    private Date createdAt;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Integer getRoomId() {
        return roomId;
    }

    /**
     * 
     */
    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    /**
     * 
     */
    public String getName() {
        return name;
    }

    /**
     * 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     */
    public Integer getCapacity() {
        return capacity;
    }

    /**
     * 
     */
    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    /**
     * 
     */
    public String getEquipment() {
        return equipment;
    }

    /**
     * 
     */
    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    /**
     * 
     */
    public String getAddress() {
        return address;
    }

    /**
     * 
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 
     */
    public Object getStatus() {
        return status;
    }

    /**
     * 
     */
    public void setStatus(Object status) {
        this.status = status;
    }

    /**
     * 
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * 
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        MeetingRoom other = (MeetingRoom) that;
        return (this.getRoomId() == null ? other.getRoomId() == null : this.getRoomId().equals(other.getRoomId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getCapacity() == null ? other.getCapacity() == null : this.getCapacity().equals(other.getCapacity()))
            && (this.getEquipment() == null ? other.getEquipment() == null : this.getEquipment().equals(other.getEquipment()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreatedAt() == null ? other.getCreatedAt() == null : this.getCreatedAt().equals(other.getCreatedAt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRoomId() == null) ? 0 : getRoomId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getCapacity() == null) ? 0 : getCapacity().hashCode());
        result = prime * result + ((getEquipment() == null) ? 0 : getEquipment().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreatedAt() == null) ? 0 : getCreatedAt().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", roomId=").append(roomId);
        sb.append(", name=").append(name);
        sb.append(", capacity=").append(capacity);
        sb.append(", equipment=").append(equipment);
        sb.append(", address=").append(address);
        sb.append(", status=").append(status);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}