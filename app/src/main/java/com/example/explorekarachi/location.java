package com.example.explorekarachi;

public class location {




    private String place;
    private  String description;
    private String time;
    private boolean expanded;

    public location(String location, String description, String time) {

        this.description =description;
        this.place = location;
        this.time = time;
        this.expanded = false;


    }


    public String getPlace() {
        return place;
    }


    public String getDescription() {
        return description;
    }

    public String getTime() {
        return time;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

}

