import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Songs> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Songs>();
    }

    public Songs findSong(String title) {
        for(Songs checkedSongs : songs) {
            if(checkedSongs.getTitle().equals(title)) {
                return checkedSongs;
            }

        }
        return null;
    }

    public boolean addSong(String title,double duration) {
        if(findSong(title)==null){
            songs.add(new Songs(duration,title));
            //System.out.println(title + " has been added to the list");
            return true;
        }else {
            //System.out.println(title + " has already been added to the list");
            return false;
        }
    }

    public boolean addToPlaylist(int trackNumber, LinkedList<Songs> PlayList) {
        int index = trackNumber - 1;
        if(index > 0 && index <= this.songs.size()) {
            PlayList.add(this.songs.get(index));
            return true;
        }
        //System.out.println("This album does not have a song with track number " + trackNumber);
        return false;
    }

    public boolean addToPlaylist(String title, LinkedList<Songs> PlayList) {
        for(Songs checkedSongs : this.songs) {
            if(checkedSongs.getTitle().equals(title)) {
                PlayList.add(checkedSongs);
                return true;
            }
        }
        //System.out.println("This album does not have a song with title " + title);
        return false;
    }

}

