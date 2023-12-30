public interface User {
    void listen(Song s);
    void listen(Album a);
    void listen(Playlist p);
    void addPlaylist(Playlist p);
    void removePlaylist(Playlist p);
    void addAlbum(Album a);
    void removeAlbum(Album a);
    void addArtist(Artist a);
    void removeArtist(Artist a);
    void userInformation();

}
