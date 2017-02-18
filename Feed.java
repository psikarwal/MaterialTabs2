package main.traveldiaries.com.materialtabs;

/**
 * Created by Piyush on 2/17/2017.
 */
public class Feed {
    private String userName;
    private String title;
    private String artist;
    private String album;
    private int thumbnail;
    public Feed() {
    }

    public Feed(String userName, String title, String artist, String album, int thumbnail) {
        this.userName = userName;
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.thumbnail = thumbnail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String name) {
        userName = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}