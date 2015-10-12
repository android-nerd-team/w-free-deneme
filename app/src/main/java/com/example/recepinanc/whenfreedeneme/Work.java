package com.example.recepinanc.whenfreedeneme;

import java.util.UUID;

/**
 * Created by recepinanc on 10/10/15.
 */
public class Work {

    private String mName;
    private String mDate;
    private String mTime;
    private String mCategory;

    public Work() {

    }

    public Work(String name, String category, String date, String time) {
        this.mName = name;
        this.mCategory = category;
        this.mDate = date;
        this.mTime = time;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmDate() {
        return mDate;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }

    public String getmCategory() {
        return mCategory;
    }

    public void setmCategory(String mCategory) {
        this.mCategory = mCategory;
    }

    public String getmTime() {
        return mTime;
    }

    public void setmTime(String mTime) {
        this.mTime = mTime;
    }
}
