import java.util.ArrayList;

public class Album {
    private String name;
    private ArrayList<Song> songs;
    private String artist;
    private String genre;
    private int totalLength = 0;

    public Album(String name, String artist, String genre) {
        this.name = name;
        this.artist = artist;
        this.genre = genre;
        this.songs = new ArrayList<Song>();
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public String getGenre() {
        return genre;
    }

    public int getTotalLength() {
        return totalLength;
    }

    public void addSong(Song s) {
        if (songs == null) {
            System.out.println("Song added to album");
            songs.add(s);
            totalLength += s.getLength();
        }
        else {
            if (songs.contains(s)) {
                System.out.println("Song already exists in album");
                System.out.println();
                return;
            }
            System.out.println("Song added to album");
            songs.add(s);
            totalLength += s.getLength();
        }
        System.out.println();
    }

    public int getNumberOfSongs() {
        return songs.size();
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void removeSong(Song s) {
        if (songs.isEmpty()) {
            System.out.println("Album is already empty");
            System.out.println();
            return;
        }

        if (songs.remove(s)) {
            System.out.println("Song is deleted from album");
            totalLength -= s.getLength();
        } else {
            System.out.println("Song is not found in album");
        }
        System.out.println();
    }

    public void albumInformation() {
        System.out.println(name + "|" + artist + "|" + genre + "|" + totalLength);
        for (Song song : songs) {
            song.songInformation();
        }
        System.out.println();
    }

    public boolean compareAlbum(Album a) {
        return name.equals(a.getName()) && artist.equals(a.getArtist()) &&
                genre.equals(a.getGenre()) && totalLength == a.getTotalLength() &&
                songs.size() == a.getNumberOfSongs() && songs.containsAll(a.getSongs());
    }
}
