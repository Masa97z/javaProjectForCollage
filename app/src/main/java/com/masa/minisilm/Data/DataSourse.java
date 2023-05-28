package com.masa.minisilm.Data;


public class DataSourse {
    private int id;
    private String title;
    private String description;
    private Long date;
    public DataSourse(
            int id,
            String title,
            String description,
            Long date)
    {
        this.id = id;
        this.title = title;
        this.description = description;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Long getDate() {
        return date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(Long date) {
        this.date = date;
    }
}
