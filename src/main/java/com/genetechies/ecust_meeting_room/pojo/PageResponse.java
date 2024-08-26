package com.genetechies.ecust_meeting_room.pojo;

import java.util.List;

public class PageResponse <T>{

    private Long total;

    private Long pages;

    private Long size;

    private Long current;
    private List<T> list;


    public PageResponse(Long total, Long pages, Long size, Long current, List<T> list) {
        this.total = total;
        this.pages = pages;
        this.size = size;
        this.current = current;
        this.list = list;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getPages() {
        return pages;
    }

    public void setPages(Long pages) {
        this.pages = pages;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Long getCurrent() {
        return current;
    }

    public void setCurrent(Long current) {
        this.current = current;
    }
}
