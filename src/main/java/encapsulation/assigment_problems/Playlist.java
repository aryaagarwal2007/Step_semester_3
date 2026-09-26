package encapsulation.assigment_problems;

import java.util.Arrays;

/**
 * Problem 2: The Playlist
 *
 * songs is a private array. getSongs() hands back a freshly built copy
 * (via Arrays.copyOf), so mutating the returned array never touches the
 * playlist's real internal state.
 */
public class Playlist {
    private final String[] songs;
    private int songCount;

    public Playlist(int maxSize) {
        this.songs = new String[maxSize];
        this.songCount = 0;
    }

    public void addSong(String title) {
        if (songCount >= songs.length) {
            System.out.println("Playlist full: cannot add " + title);
            return;
        }
        songs[songCount] = title;
        songCount++;
    }

    public String[] getSongs() {
        return Arrays.copyOf(songs, songCount);
    }

    public int getSongCount() {
        return songCount;
    }

    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        System.out.println("Songs: " + Arrays.toString(copy));

        copy[0] = "Hacked";
        System.out.println("After tampering with the copy, real songs[0]: " + p.getSongs()[0]);
        System.out.println("Song count: " + p.getSongCount());
    }
}
