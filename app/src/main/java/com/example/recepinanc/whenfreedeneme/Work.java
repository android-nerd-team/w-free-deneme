package com.example.recepinanc.whenfreedeneme;

/**
 * Created by recepinanc on 10/10/15.
 */
public class Work {

    private String mTitle;
    private String mYear;
    private String mMonth;
    private String mDay;
    private String mHour;
    private String mMinute;
    private String mCategory;

    public Work() {

    }

    public Work(String name, String category, String year, String month, String day, String hour, String minute) {
        this.mTitle = name;
        this.mCategory = category;
        this.mYear = year;
        this.mMonth = month;
        this.mDay = day;
        this.mHour = hour;
        this.mMinute = minute;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmCategory() {
        return mCategory;
    }

    public void setmCategory(String mCategory) {
        this.mCategory = mCategory;
    }


    public String getmYear() {
        return mYear;
    }

    public void setmYear(String mYear) {
        this.mYear = mYear;
    }

    public String getmMonth() {
        return mMonth;
    }

    public void setmMonth(String mMonth) {
        this.mMonth = mMonth;
    }

    public String getmDay() {
        return mDay;
    }

    public void setmDay(String mDay) {
        this.mDay = mDay;
    }

    public String getmHour() {
        return mHour;
    }

    public void setmHour(String mHour) {
        this.mHour = mHour;
    }

    public String getmMinute() {
        return mMinute;
    }

    public void setmMinute(String mMinute) {
        this.mMinute = mMinute;
    }

}