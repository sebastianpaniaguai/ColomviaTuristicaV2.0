package com.example.sebas.colombiaturistica;

/**
 * Created by sebas on 10/23/2015.
 */
public class GridEntries {
    private int imageId;
    private String title;
    public GridEntries(int imageId, String title){
        this.imageId=imageId;
        this.title=title;
    }

    public int getImageId() {
        return imageId;
    }

    public String getTitle() {
        return title;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
