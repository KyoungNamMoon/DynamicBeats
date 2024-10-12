package testClass.dynamic_beat_1;

public class Track {

    private String startImage; //작은 배경
    private String gameImage; //큰 배경
    private String gameMusic;

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

    public void setGameImage(String gameImage) {
        this.gameImage = gameImage;
    }

    public Track(String startImage, String gameImage, String gameMusic) {
        this.startImage = startImage;
        this.gameImage = gameImage;
        this.gameMusic = gameMusic;
    }
}
