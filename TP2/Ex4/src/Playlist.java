import java.util.ArrayList;

public class Playlist {
    private String name;
    private ArrayList<Song> songs;
    private User user;

    public Playlist(String name, User user) {
        this.user = user;
        this.name = name;
        songs = new ArrayList<>();
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public String getName() {
        return name;
    }

    public User getUser() {
        return user;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void playlistInformation() {
        System.out.println(name);
        for (Song s : songs)
            s.songInformation();
        System.out.println();
    }

    public void addSong(Song s) {
        if (songs == null) {
            System.out.println("Song added to playlist");
            songs.add(s);
        }
        else {
            if (songs.contains(s)) {
                System.out.println("Song is already in this playlist");
                return;
            }
            System.out.println("Song added to playlist");
            songs.add(s);
        }
        System.out.println();
    }

    public void removeSong(Song s) {
        if (songs.isEmpty()) {
            System.out.println("Playlist is empty");
            System.out.println();
            return;
        }
        if (songs.remove(s)) {
            System.out.println("Song removed from playlist");
        } else {
            System.out.println("Song is not f1ound in playlist");
        }
        System.out.println();
    }

}
