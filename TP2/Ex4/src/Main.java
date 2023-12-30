public class Main {
    public static void main(String[] args) {
        Song song1 = new Song("Bad Romance", "Lady Gaga", 255);
        Song song2 = new Song("Poker Face", "Lady Gaga", 200);
        Song song3 = new Song("Sicko Mode", "Travis Scott", 312);
        Song song4 = new Song("Stargazing", "Travis Scott", 278);
        Song song5 = new Song("Watermelon Sugar", "Harry Styles", 174);
        Song song6 = new Song("Adore You", "Harry Styles", 207);
        Song song7 = new Song("Despacito", "Luis Fonsi ft. Daddy Yankee", 228);
        Song song8 = new Song("Échame la Culpa", "Luis Fonsi ft. Demi Lovato", 202);
        Song song9 = new Song("Whole Lotta Love", "Led Zeppelin", 333);
        Song song10 = new Song("Stairway to Heaven", "Led Zeppelin", 482);


        Album album1 = new Album("The Fame", "Lady Gaga", "Pop");
        Album album2 = new Album("Astroworld", "Travis Scott", "Hip Hop");
        Album album3 = new Album("Fine Line", "Harry Styles", "Pop");
        Album album4 = new Album("Love + Dance", "Luis Fonsi", "Latin Pop");
        Album album5 = new Album("Led Zeppelin IV", "Led Zeppelin", "Rock");

        album1.addSong(song1);
        album1.addSong(song2);
        album2.addSong(song3);
        album2.addSong(song4);
        album3.addSong(song5);
        album3.addSong(song6);
        album4.addSong(song7);
        album4.addSong(song8);
        album5.addSong(song9);
        album5.addSong(song10);


        Artist artist1 = new Artist("Lady Gaga", "United States", 2);
        Artist artist2 = new Artist("Travis Scott", "United States", 2);
        Artist artist3 = new Artist("Harry Styles", "United Kingdom", 2);
        Artist artist4 = new Artist("Luis Fonsi", "Puerto Rico", 2);
        Artist artist5 = new Artist("Led Zeppelin", "United Kingdom", 2);


        artist1.addAlbum(album1);
        artist2.addAlbum(album2);
        artist3.addAlbum(album3);
        artist4.addAlbum(album4);
        artist5.addAlbum(album5);

        System.out.println("\nArtist Information:");
        artist1.artistInformation();
        artist2.artistInformation();
        artist3.artistInformation();
        artist4.artistInformation();
        artist5.artistInformation();


        Song nonExistingSong = new Song("Non-Existing Song", "Unknown Artist", 180);
        album1.removeSong(nonExistingSong);

        Album nonExistingAlbum = new Album("Non-Existing Album", "Unknown Artist", "Unknown Genre");
        artist1.removeAlbum(nonExistingAlbum);

        album1.removeSong(song1);
        System.out.println("modified album1");
        album1.albumInformation();

        artist2.removeAlbum(album2);
        System.out.println("modified artist2");
        artist2.artistInformation();

        FreeUser fu1 = new FreeUser("Ahmed", 1234);
        fu1.addAlbum(album1);
        fu1.addAlbum(album2);
        fu1.addAlbum(album4);

        fu1.addArtist(artist1);
        fu1.addArtist(artist4);
        fu1.addArtist(artist5);

        Playlist p1 = new Playlist("mysongs", fu1);
        p1.addSong(song1);
        p1.addSong(song2);
        p1.addSong(song3);
        p1.playlistInformation();
        p1.removeSong(song2);
        p1.playlistInformation();

        fu1.userInformation();
        fu1.removeAlbum(album2);
        fu1.removeArtist(artist4);
        fu1.userInformation();

        fu1.listen(song1);
        fu1.listen(album2);
        fu1.listen(p1);

        PremiumUser fu2 = new PremiumUser("Mahdi", 4321);
        fu2.addAlbum(album1);
        fu2.addAlbum(album2);
        fu2.addAlbum(album4);

        fu2.addArtist(artist1);
        fu2.addArtist(artist4);
        fu2.addArtist(artist5);

        Playlist p2 = new Playlist("mysongs2", fu2);
        p2.addSong(song1);
        p2.addSong(song2);
        p2.addSong(song3);
        p2.playlistInformation();
        p2.removeSong(song2);
        p2.playlistInformation();

        fu2.userInformation();
        fu2.removeAlbum(album2);
        fu2.removeArtist(artist4);
        fu2.userInformation();

        fu2.listen(song1);
        fu2.listen(album2);
        fu2.listen(p1);


    }
}