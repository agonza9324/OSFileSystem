package projectfinal;

import java.util.*;

/**
 *
 * @author tappel2
 */
public class ProjectFinal {

    /**
     * @param args the command line arguments
     */
    static Directory root = new Directory("H:/");
    static Directory current = root;
    static Directory parent = root;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Directory root = new Directory("H:/");

        /*ArrayList<Directory> d1 = new ArrayList<Directory>(); this is to keep a list of arrays so commands like rmdir, mdkir, and cd can be coded easier */
        System.out.println("Possible Commands");
        System.out.println("---------------------");
        System.out.println("ls: List directories");
        System.out.println("pwd: print working directory");
        System.out.println("cd: Change directory");
        System.out.println("touch: create file");
        System.out.println("mkdir: create directory");
        System.out.println("rmdir: remove directory");
        System.out.println("rmfil: remove file");
        System.out.println("---------------------");
        System.out.println("\033[31;1mDo not make further cd\033[30;2m!");
        //System.out.println("Type rmdir to delete a directory."); We need to figure out how to do this
        //Input
        String temp = scan.nextLine();
        String choice;
        String detail = "";

        if (temp.contains(" ")) // if its "mkdir tacos"
        {
            choice = temp.substring(0, temp.indexOf(' ')); // mkdir taco tuesday: captures "mkdir"
            detail = temp.substring(temp.indexOf(' ') + 1);// mkdir taco tuesday: captures "taco tuesday"

        } else {
            choice = temp; // if there isn't detail, so like "ls"
        }
        while (true) {

            switch (choice) {
                case "ls":
                    ls(current);
                    break;
                case "pwd":
                    pwd();
                    break;
                case "cd":

                    cd(detail);
                    break;
                case "touch":
                    touch(detail);
                    break;
                case "mkdir":
                    mkdir(detail);
                    break;
                case "rmdir":
                    rmdir(detail);
                    break;
                case "rmfil":
                    rmfil(detail);
                    break;
                
                case "exit":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Command");
            }

            //Input    
            temp = scan.nextLine();
            if (temp.contains(" ")) {
                choice = temp.substring(0, temp.indexOf(' ')); // mkdir tacos: captures "mkdir"
                detail = temp.substring(temp.indexOf(' ') + 1);// mkdir taco tuesday: captures "taco tuesday"

            } else {
                choice = temp; // if there isn't detail, so like "ls"
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

    public static void ls(Directory dir) {
        dir.printTree();
        //dir.getNodes();
    }

    public static void pwd() {
        System.out.println("Working Directory: " + current.getPath());
        //System.out.println("Working Directory: " + System.getProperty("user.dir"));
    }

    public static void cd(String detail) {

        Set<Node> nodes;
        nodes = current.getNodes();
        //System.out.println("Is nodes empty?"+ nodes.isEmpty());

        Iterator<Node> iterator = nodes.iterator();
        boolean flag = false; //holds boolean if the directory is there to be changed to, and if its a directory
        Node temp = new Directory(detail); //arbitrary intializing temp
        while (iterator.hasNext()) { //iterates through nodes, so it doesn't hit null

            temp = iterator.next(); //sets Node temp = to the next node

            if (detail.equals(temp.getName()) && temp.isDirectory()) { //cd "name" if name has been added and actually is a directory
                flag = true; //flag variable if condition above is true
                break; // breaks so it holds the correct directory in temp

            }
        }

        if (detail.equals("..") & parent.getName() == "H:/") {
           
            
            System.out.println("\033[31;1mDo not make further cd\033[30;2m!");
            current = parent;
            parent = parent.getParent();
            current.setRoot(parent);
        }
            
        else if (detail.equals("..")) {
            
            System.out.println(parent.getName());
            current = parent;
            parent = parent.getParent();
            current.setRoot(parent);
            
        }

        if (flag) { //if the directory was found earlier
            parent = current;
            current = (Directory) temp;
            current.setRoot(parent);
        }

        //ls(current);*/
    }

    public static void touch(String detail) {
        if (detail.equals("..") || detail.equals("") || detail.equals(" ")) //not allowed to name a file".." or not name it at all
        {
            System.out.println("Invalid File Name");
        } else {
            current.add(new File(detail + ".txt"));
        }

    }

    public static void mkdir(String detail) {

        //current=new Directory(detail);
        if (detail.equals("..") || detail.equals("") || detail.equals(" ")) //not allowed to name a directory ".." or not name it at all
        {
            System.out.println("Invalid Directory Name");
        } else {
            current.add(new Directory(detail));

        }
        // d1.add(current);

    }

    public static void rmdir(String detail) {
      
        Set<Node> nodes;
        nodes = current.getNodes();
        //System.out.println("Is nodes empty?"+ nodes.isEmpty());

        Iterator<Node> iterator = nodes.iterator();
        boolean flag = false; //holds boolean if the directory is there to be changed to, and if its a directory
        Node temp = new Directory(detail); //arbitrary intializing temp
        while (iterator.hasNext()) { //iterates through nodes, so it doesn't hit null
            temp = iterator.next(); //sets Node temp = to the next node

            if (detail.equals(temp.getName()) && temp.isDirectory()) { //cd "name" if name has been added and actually is a directory
                flag = true; //flag variable if condition above is true
                break; // breaks so it holds the correct directory in temp

            }
        }
        if(true == flag) {
            current.remove(new Directory(detail));
        } 
    }
    
    public static void rmfil(String detail) {
        
        Set<Node> nodes;
        nodes = current.getNodes();
        //System.out.println("Is nodes empty?"+ nodes.isEmpty());

        Iterator<Node> iterator = nodes.iterator();
        boolean flag = false; //holds boolean if the directory is there to be changed to, and if its a directory
        Node temp = new File(detail); //arbitrary intializing temp
        while (iterator.hasNext()) { //iterates through nodes, so it doesn't hit null
            temp = iterator.next(); //sets Node temp = to the next node

            if (detail.equals(temp.getName()) && temp.isFile()) { //cd "name" if name has been added and actually is a directory
                flag = true; //flag variable if condition above is true
                break; // breaks so it holds the correct directory in temp

            }
        }
        if (true == flag)
        current.remove(new File(detail));
    }
    }

    

