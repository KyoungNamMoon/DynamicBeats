package dynamic_beat_1;

public class Track {

    private String startImage; //작은 배경
    private String gameImage; //큰 배경
    private String gameMusic;
    private String titleName;//title of the song
    public String getGameMusic() {
        return gameMusic;
    }

    public void setGameMusic(String gameMusic) {
        this.gameMusic = gameMusic;
    }


    public String getStartImage() {
        return startImage;
    }

    public void setStartImage(String startImage) {
        this.startImage = startImage;
    }


    public String getGameImage() {
        return gameImage;
    }

    public void setGameImage(String title) {
        this.gameImage = gameImage;
    }
    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public Track(String startImage, String gameImage, String gameMusic, String titleName) {
        this.startImage = startImage;
        this.gameImage = gameImage;
        this.gameMusic = gameMusic;
        this.titleName = titleName;
    }
}
