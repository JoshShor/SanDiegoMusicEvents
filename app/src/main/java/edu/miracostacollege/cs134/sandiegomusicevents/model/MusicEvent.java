package edu.miracostacollege.cs134.sandiegomusicevents.model;

/**
 * The MusicEvent class is a place holder for data corresponding to music events
 * occurring within San Diego County.  Currently, two arrays contain the data: one array
 * stores the titles of each upcoming music event, while the other maintains the details
 * about the event.
 *
 * @author Alexis Miles
 * @version 2.0
 */
public class MusicEvent {

    //Every instance variable in Java class should mimic the JSON file
    private String mArtist;
    private String mDate;
    private String mDay;
    private String mTime;
    private String mVenue;
    private String mCity;
    private String mState;
    private String mImageName;

    public String getArtist() {
        return mArtist;
    }

    public String getDate() {
        return mDate;
    }

    public String getDay() {
        return mDay;
    }

    public String getTime() {
        return mTime;
    }

    public String getVenue() {
        return mVenue;
    }

    public String getCity() {
        return mCity;
    }

    public String getState() {
        return mState;
    }

    public String getImageName() {
        return mImageName;
    }

    public void setArtist(String artist) {
        mArtist = artist;
    }

    public void setDate(String date) {
        mDate = date;
    }

    public void setDay(String day) {
        mDay = day;
    }

    public void setTime(String time) {
        mTime = time;
    }

    public void setVenue(String venue) {
        mVenue = venue;
    }

    public void setCity(String city) {
        mCity = city;
    }

    public void setState(String state) {
        mState = state;
    }

    public void setImageName(String imageName) {
        mImageName = imageName;
    }
}
