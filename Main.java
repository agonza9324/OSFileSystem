public class Main {
    public static void main(String[] args) {

        Directory root = new Directory("root");
        File file = new File("profile.jpg");
        root.add(file);

        Directory movie = new Directory("movie");
        root.add(movie);

        Directory englishMovie = new Directory("english");

        englishMovie.add(new File("IronFist.mp4"));
        englishMovie.add(new File("The Shawshank Redemption.mp4"));
        englishMovie.add(new File("ZotaPia.mp4"));
        File despicableMe = new File("DespicableMe.mp4");
        englishMovie.add(despicableMe);
        movie.add(englishMovie);

        Directory banglaMovie = new Directory("Bangla");
        banglaMovie.add(new File("The Clay Bird.mp4"));
        banglaMovie.add(new File("Jibon Thekey Neya.mp4"));

        movie.add(banglaMovie);

        root.printTree();

        System.out.println("name: " + movie.getName());
        System.out.println("Created: " + movie.getCreated());
    }
}