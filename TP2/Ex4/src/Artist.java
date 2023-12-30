import java.util.ArrayList;

public class Artist {
    private String name;
    private String countryOfOrigin;
    private ArrayList<Album> albums;
    private int numberOfAlbums = 0;

    public Artist(String name, String countryOfOrigin, int capacity) {
        this.name = name;
        this.countryOfOrigin = countryOfOrigin;
        this.albums = new ArrayList<>(capacity);
    }

    public String getName() {
        return name;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public ArrayList<Album> getAlbums() {
        return albums;
    }

    public void addAlbum(Album a) {
        for (int i = 0; i < numberOfAlbums; i++) {
            if (albums.get(i).compareAlbum(a)) {
                System.out.println("Album already exists in discography");
                System.out.println();
                return;
            }
        }
        System.out.println("Album added to discography");
        albums.add(a);
        numberOfAlbums++;
        System.out.println();
    }

    public void removeAlbum(Album a) {
        if (numberOfAlbums == 0) {
            System.out.println("Discography is already empty");
            System.out.println();
            return;
        }

        if (albums.remove(a)) {
            System.out.println("Album is deleted from artist");
            numberOfAlbums--;
        } else {
            System.out.println("Album is not found in discography");
        }
        System.out.println();
    }

    public void artistInformation() {
        System.out.println(name + "|" + countryOfOrigin);
        for (Album album : albums) {
            album.albumInformation();
        }
        System.out.println();
    }
}
