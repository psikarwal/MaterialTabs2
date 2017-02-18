package main.traveldiaries.com.materialtabs;

/**
 * Created by Piyush on 2/17/2017.
 */
public class Rcdn {
    private String nameThird;
    private String titleThird;
    private String albumThird;
    private String artistThird;
    private int thumbnailThird;
    public Rcdn() {
    }

    public Rcdn(String nameThird, String titleThird, String artistThird, String albumThird, int thumbnailThird) {
        this.nameThird = nameThird;
        this.titleThird = titleThird;
        this.artistThird = artistThird;
        this.albumThird = albumThird;
        this.thumbnailThird = thumbnailThird;
    }

    public String getName() {
        return nameThird;
    }

    public void setName(String name) {
        nameThird = name;
    }

    public String getTitle() {
        return titleThird;
    }

    public void setTitle(String titleThird) {
        this.titleThird = titleThird;
    }

    public String getArtist() {
        return artistThird;
    }

    public void setArtist(String artistThird) {
        this.artistThird = artistThird;
    }

    public String getAlbum() {
        return albumThird;
    }

    public void setAlbum(String albumThird) {
        this.albumThird = albumThird;
    }

    public int getThumbnail() {
        return thumbnailThird;
    }

    public void setThumbnail(int thumbnailThird) {
        this.thumbnailThird = thumbnailThird;
    }
}