import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {

        Album album1 = new Album("Ciribilibela","Bijelo Dugme");

        album1.addSong("Napile se ulice",4.5);
        album1.addSong("Lijepa nasa",3.6);
        album1.addSong("Ako ima Boga",4.9);
        album1.addSong("Sta ima novo",5.7);
        albums.add(album1);
        album1 = new Album("Vrijeme je na nasoj strani","Parni Valjak");
        album1.addSong("Veceras trebam drustvo",4.5);
        album1.addSong("Moje dnevne paranoje",3.9);
        album1.addSong("Noc nema svijedoka",5.5);
        albums.add(album1);

        LinkedList<Songs> playlist_1 = new LinkedList<>();
        albums.get(0).addToPlaylist("Ako ima Boga", playlist_1);
        albums.get(0).addToPlaylist("Sta ima novo", playlist_1);
        albums.get(1).addToPlaylist("Moje dnevne paranoje", playlist_1);
        albums.get(1).addToPlaylist("Noc nema svijedoka", playlist_1);

        play(playlist_1);
    }

    private static void play(LinkedList<Songs> playlist) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Songs> listIterator = playlist.listIterator();

        if(playlist.size() == 0) {
            System.out.println("This playlist has no songs");
        }else{
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }
        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    System.out.println("Playlist complete");
                    quit = true;
                    break;
                case 1:
                    if (!forward) {
                        if(listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().toString());
                    }else{
                        System.out.println("No more songs");
                        forward = false;
                    }
                    break;
                case 2:
                    if(forward){
                        if(listIterator.hasNext()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous().toString());
                    }else{
                        System.out.println("We are at the first song");
                        forward = false;
                    }
                    break;
                case 3:
                    if (forward) {
                        if(listIterator.hasPrevious()) {
                            System.out.println("Now playing " + listIterator.previous().toString());
                            forward = false;
                        }else{
                            System.out.println("We are at the start of the list");
                        }
                    }else {
                        if(listIterator.hasNext()) {
                            System.out.println("Now playing " + listIterator.next().toString());
                            forward = true;
                        }else{
                            System.out.println("We are at the end of the list");
                        }
                    }
                    break;
                case 4:
                    printList(playlist);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if (playlist.size() > 0) {
                        listIterator.remove();
                        if(listIterator.hasNext()) {
                            System.out.println("Now playing " + listIterator.next().toString());
                        }
                    }else{
                        if(listIterator.hasPrevious()) {
                            System.out.println("Now playing " + listIterator.previous().toString());
                        }

                    }
            }
        }
    }
    private static void printMenu(){
        System.out.println("Available options: \n press");
        System.out.println("Press 0 to quit\n" +
                "press 1 to play next song\n" +
                "press 2 to for play previous song\n" +
                "press 3 to replay the current song\n" +
                "press 4 to list all songs in album\n" +
                "press 5 to print all available options\n" +
                "press 6 to delete current song");
    }
    private static void printList(LinkedList<Songs> playlist) {
        Iterator<Songs> iterator = playlist.iterator();
        System.out.println("--------------------------------------------");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            System.out.println("--------------------------------------------");
        }
    }
}
