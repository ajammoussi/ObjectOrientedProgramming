import java.util.ArrayList;
import java.util.Scanner;

public class FreeUser implements User {
    private String Name;
    private int ID;
    private ArrayList<Playlist> playlists;
    private int numPlaylists = 0;
    private ArrayList<Album> favoriteAlbums;
    private ArrayList<Artist> favoriteArtists;
    private int skips = 6;

    public FreeUser(String name, int ID) {
        Name = name;
        this.ID = ID;
        favoriteAlbums = new ArrayList<>();
        favoriteArtists = new ArrayList<>();
        playlists = new ArrayList<>();
    }

    public String getName() {
        return Name;
    }

    public int getID() {
        return ID;
    }

    @Override
    public void listen(Song s) {
        boolean test = true;
        while (test) {
            System.out.print("Playing: ");
            s.songInformation();
            System.out.println("Do you wish to stop? (Y/N)");
            Scanner sc = new Scanner(System.in);
            String ans = sc.next();
            if (ans.toUpperCase().equals("Y")) {
                System.out.println("Song Stopped");
                test = false;
            }
        }
        System.out.println();
    }

    @Override
    public void listen(Album a) {
        boolean test = true;
        int currentIndex = 0;

        while (test) {
            if (skips == 0) {
                System.out.println("Upgrade to premium to have unlimited skips");
                break;
            } else {
                System.out.println("You have " + skips + " skips left");
            }

            Scanner sc = new Scanner(System.in);
            System.out.printf("Album: ");
            a.albumInformation();
            System.out.print("Playing: ");
            a.getSongs().get(currentIndex).songInformation();

            System.out.println("Press 1 to skip, 2 to stop");
            int k = sc.nextInt();

            if (k == 1) {
                System.out.println("Song Skipped");
                skips--;
                currentIndex = (currentIndex + 1) % a.getSongs().size();
            } else {
                System.out.println("Song Stopped");
                test = false;
            }
        }
    }

    @Override
    public void listen(Playlist p) {
        boolean test = true;
        int currentIndex = 0;

        while (test) {
            if (skips == 0) {
                System.out.println("Upgrade to premium to have unlimited skips");
                break;
            } else {
                System.out.println("You have " + skips + " skips left");
            }

            Scanner sc = new Scanner(System.in);
            System.out.printf("Playlist: ");
            p.playlistInformation();
            System.out.print("Playing: ");
            p.getSongs().get(currentIndex).songInformation();

            System.out.println("Press 1 to skip, 2 to stop: ");
            int k = sc.nextInt();

            if (k == 1) {
                System.out.println("Song Skipped");
                skips--;
                currentIndex = (currentIndex + 1) % p.getSongs().size();
            } else {
                System.out.println("Song Stopped");
                test = false;
            }
        }
    }


    @Override
    public void addPlaylist(Playlist p) {
        if (numPlaylists == 15)
            System.out.println("Upgrade to premium to add more songs");
        else {
            System.out.println("Playlist is added");
            playlists.add(p);
            numPlaylists++;
        }
        System.out.println();
    }

    @Override
    public void removePlaylist(Playlist p) {
        if (playlists.isEmpty()) {
            System.out.println("List of playlists is already empty");
            System.out.println();
            return;
        }
        if (playlists.remove(p)) {
            System.out.println("Playlist is deleted");
            numPlaylists--;
        } else {
            System.out.println("Playlist is not found");
        }
        System.out.println();
    }

    @Override
    public void addAlbum(Album a) {
        System.out.println("Album is added to user");
        favoriteAlbums.add(a);
        System.out.println();
    }

    @Override
    public void removeAlbum(Album a) {
        System.out.println("Album is removed from user");
        favoriteAlbums.remove(a);
        System.out.println();
    }

    @Override
    public void addArtist(Artist a) {
        System.out.println("Artist is added to user");
        favoriteArtists.add(a);
        System.out.println();
    }

    @Override
    public void removeArtist(Artist a) {
        System.out.println("Artist is removed from user");
        favoriteArtists.remove(a);
        System.out.println();
    }

    @Override
    public void userInformation() {
        System.out.println(Name + ' ' + ID);
        System.out.println("Playlists: ");
        for (Playlist p : playlists) {
            p.playlistInformation();
        }
        System.out.println("Favorite Albums");
        for (Album a : favoriteAlbums) {
            a.albumInformation();
        }
        System.out.println("Favorite Artists");
        for (Artist a : favoriteArtists) {
            a.artistInformation();
        }
        System.out.println();
    }
}
