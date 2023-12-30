import java.util.Objects;

public class Song {
    private String songName;
    private String artist;
    private int length;

    public Song(String songName, String artist, int length) {
        this.songName = songName;
        this.artist = artist;
        this.length = length;
    }

    public String getSongName() {
        return songName;
    }

    public int getLength() {
        return length;
    }

    public String getArtist() {
        return artist;
    }

    public void playSong() {
        System.out.println(songName + " is playing~~ ");
    }

    public void pauseSong() {
        System.out.println(songName + " is paused- ");
    }

    public void songInformation() {
        System.out.println(songName + "|" + artist + "|" + length);
    }

    public boolean compareSong(Song s) {
        return (songName.equals(s.getSongName()) && artist.equals(s.getArtist()) && length == s.getLength());
    }
}
