package com.example.explorekarachi;


public class example_item
{


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private int mImageResource;
    private String description;
    private String mText1;
    private String category;
    private String location;

    public example_item(int mImageResource, String description, String mText1, String category, String location, String longitude, String latitude) {
        this.mImageResource = mImageResource;
        this.description = description;
        this.mText1 = mText1;
        this.category = category;
        this.location = location;
        this.longitude = longitude;
        this.latitude = latitude;
        expanded = false;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    private boolean expanded;

    private String longitude;
    private String latitude;
    public String getLongitude() {
        return longitude;
    }

    public String getLatitude() {
        return latitude;
    }


    public String getCategory() {
        return category;
    }

    public String getLocation() {
        return location;
    }





    public example_item(int imageResource, String text1, String text2,String text3,String text4,String text5) {
        mImageResource = imageResource;
        mText1 = text1;
        category=text2;
        location=text3;
        longitude=text4;
        latitude=text5;

    }

    public int getImageResource() {
        return mImageResource;
    }

    public String getText1() {
        return mText1;
    }



}