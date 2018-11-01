/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectfinal;

import java.util.Scanner;

/**
 *
 * @author tappel2
 */
public class Main {

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
        System.out.println("cat: reads content of file");
        System.out.println("---------------------");
        //System.out.println("Type rmdir to delete a directory."); We need to figure out how to do this
        //Input
        String temp = scan.nextLine();
        String choice;
        String detail="";
        if (temp.contains(" ")) // if its "mkdir tacos"
        {
        choice = temp.substring(0, temp.indexOf(' ')); // mkdir taco tuesday: captures "mkdir"
        detail = temp.substring(temp.indexOf(' ') + 1);// mkdir taco tuesday: captures "taco tuesday"
        }
        else
            choice=temp; // if there isn't detail, so like "ls"
        while (true) {
            
            switch(choice)
            {
                case "ls":
                    ls(current);
                    break;
                case "pwd":
                    pwd();
                    break;
                case "cd":
                    
                    cd(current,parent, detail);
                    break;
                case "touch":
                    touch(current,detail);
                    break;
                case "mkdir":
                    mkdir(parent,detail);
                    break;
                case "rmdir":
                    
                    break;
                case "cat":
                    cat();
                    break;
                case "exit":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Command");
            }

        //Input    
        temp = scan.nextLine();
        if (temp.contains(" "))
        {
        choice = temp.substring(0, temp.indexOf(' ')); // mkdir tacos: captures "mkdir"
        detail = temp.substring(temp.indexOf(' ') + 1);// mkdir taco tuesday: captures "taco tuesday"
        }
        else
            choice=temp; // if there isn't detail, so like "ls"
        
        
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
    }
    public static void pwd() {
        System.out.println("Working Directory: " + System.getProperty("user.dir"));
    }
    public static void cd(Directory cdir, Directory parent, String detail) {
        
         Directory temp=new Directory(detail);
         parent=current;
        current=temp;
        current.setRoot(parent);
        //ls(current);
    }
    public static void touch(Directory current,String detail) {
        current.add(new File(detail+".txt"));
    }
            
    public static void mkdir(Directory dir,String detail) {
        
        //current=new Directory(detail);
        dir.add(new Directory(detail));
        // d1.add(current);
        
    }
    public static void rmdir() {
          
    }
    public static void cat() {
        
    }
}
       
