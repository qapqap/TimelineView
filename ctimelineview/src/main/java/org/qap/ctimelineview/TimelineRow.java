package org.qap.ctimelineview;


import android.graphics.Bitmap;

import java.util.Date;



public class TimelineRow {

    private int id;
    private Date date;
    private String title;
    private String description;
    private Bitmap image;
    private int bellowLineColor;
    private int bellowLineSize;
    private int imageSize;
    private int backgroundColor;
    private int backgroundSize;

    public TimelineRow(int id, Date date, String title, String  description, Bitmap image, int bellowLineColor, int bellowLineSize, int imageSize, int backgroundColor, int backgroundSize) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.description = description;
        this.image = image;
        this.bellowLineColor = bellowLineColor;
        this.bellowLineSize = bellowLineSize;
        this.imageSize = imageSize;
        this.backgroundColor = backgroundColor;
        this.backgroundSize = backgroundSize;
    }

    public TimelineRow(int id, Date date, String title, String  description, Bitmap image, int bellowLineColor, int bellowLineSize, int imageSize) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.description = description;
        this.image = image;
        this.bellowLineColor = bellowLineColor;
        this.bellowLineSize = bellowLineSize;
        this.imageSize = imageSize;
        this.backgroundColor = -1;
        this.backgroundSize = -1;
    }

    public int getBackgroundSize() {
        return backgroundSize;
    }

    public void setBackgroundSize(int backgroundSize) {
        this.backgroundSize = backgroundSize;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImageSize() {
        return imageSize;
    }

    public void setImageSize(int imageSize) {
        this.imageSize = imageSize;
    }

    public int getBellowLineSize() {
        return bellowLineSize;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBellowLineSize(int bellowLineSize) {
        this.bellowLineSize = bellowLineSize;
    }

    public int getBellowLineColor() {
        return bellowLineColor;
    }

    public void setBellowLineColor(int bellowLineColor) {
        this.bellowLineColor = bellowLineColor;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public Date getDate() {
        return date;

    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
