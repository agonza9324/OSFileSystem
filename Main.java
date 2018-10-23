
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Type \"mkdir\" to create a new directory.");
        //System.out.println("Type rmdir to delete a directory."); We need to figure out how to do this

        String choice = scan.nextLine();

        //If they type mkdir it creates a directory and asks for directory name
        while (choice.equals("mkdir")) {

            System.out.println("Please enter directory name or \"done\" if you want to stop making directories: ");
            //String exitChoice = scan.nextLine();
            String dirName = scan.nextLine();
            if (dirName.equals("done")) {
                break;
            } else {
                /*
                    Right now this makes one directory object. We need to 
                    figure out how to automate making more directory objects 
                    (i.e. not overwriting the same one for each new directory)
                */
                Directory directory = new Directory(dirName); 

                System.out.println("type \"touch\" to add file.");
                String makeFile = scan.nextLine();
                do {
                    //System.out.println("Add File? (Y/N)");
                    System.out.println("File Name: ");
                    String fileName = scan.nextLine();
                    
                    File file = new File(fileName);
                    directory.add(file);
                    System.out.println("Type \"exit\" to stop or \"touch\" to continue");
                    makeFile = scan.nextLine();

                } while (makeFile.equals("touch"));
                directory.printTree(); //this can be an ls command option
            }
        }
        
    /* this is old code that came with the project
        Directory root = new Directory("root");
        
        File file = new File("profile.jpg");
        // root.add(file);

        Directory movie = new Directory("movie");
        //root.add(movie);

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

        //root.printTree();
        //System.out.println("name: " + movie.getName());
        //System.out.println("Created: " + movie.getCreated());
    */
    }
}
