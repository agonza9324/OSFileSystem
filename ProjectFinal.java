
package projectfinal;

import java.util.*;

public class Projectfinal {

    static Directory root = new Directory("H:/");
    static Directory current = root;
    static Directory parent = root;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Directory root = new Directory("H:/");

        help(); // prints help menu

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
                case "cat":
                    cat(detail);
                    break;
                case "nano":
                    nano(detail);
                    break;
                case "help":
                    help();
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

    }

    public static void ls(Directory dir) {
        dir.printTree();
        //dir.getNodes();
    }

    public static void pwd() {
        System.out.println("Working Directory: " + current.getPath());
    }

    public static void cd(String detail) {

        Set<Node> nodes;
        nodes = current.getNodes();

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

        if (detail.equals("..") & current.getName().equals("H:/")) {

            System.out.println("\033[31;1m Error: You're currently at the root!\033[30;2m");

        } else if (detail.equals("..")) {

            //System.out.println(parent.getName());
            current = parent;
            parent = parent.getParent();
            current.setRoot(parent);

        }

        if (flag) { //if the directory was found earlier
            parent = current;
            current = (Directory) temp;
            current.setRoot(parent);
        }

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
        if (true == flag) {
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
        if (true == flag) {
            current.remove(new File(detail));
        }
    }

    public static void cat(String detail) {
        Set<Node> nodes;
        nodes = current.getNodes();
        Iterator<Node> iterator = nodes.iterator();
        boolean flagfile = false; //holds boolean if the directory is there to be changed to, and if its a directory
        Node tempf = new File(detail); //arbitrary intializing temp
        while (iterator.hasNext()) { //iterates through nodes, so it doesn't hit null
            tempf = iterator.next(); //sets Node temp = to the next node

            if (detail.equals(tempf.getName()) && tempf.isFile()) { //cd "name" if name has been added and actually is a directory
                flagfile = true; //flag variable if condition above is true
                break; // breaks so it holds the correct directory in temp

            }
        }
        if (flagfile == true) {
            File temp = (File) tempf;
            System.out.println(temp.getContent());
        }
    }

    public static void nano(String detail) {

        Scanner scan = new Scanner(System.in);
        Set<Node> nodes;
        nodes = current.getNodes();
        Iterator<Node> iterator = nodes.iterator();
        boolean flagfile = false; //holds boolean if the directory is there to be changed to, and if its a directory
        Node tempf = new File(detail); //arbitrary intializing temp
        while (iterator.hasNext()) { //iterates through nodes, so it doesn't hit null
            tempf = iterator.next(); //sets Node temp = to the next node

            if (detail.equals(tempf.getName()) && tempf.isFile()) { //cd "name" if name has been added and actually is a directory
                flagfile = true; //flag variable if condition above is true
                break; // breaks so it holds the correct directory in temp

            }
        }
        if (flagfile == true) {
            System.out.println("Enter the text you want to add");
            String txt = scan.nextLine();
            File temp = (File) tempf;
            temp.setContent(txt);
        }

    }

    public static void help() {
        System.out.println("Possible Commands");
        System.out.println("---------------------");
        System.out.println("ls: List directories");
        System.out.println("pwd: print working directory");
        System.out.println("cd: Change directory");
        System.out.println("touch: create file");
        System.out.println("mkdir: create directory");
        System.out.println("rmdir: remove directory");
        System.out.println("rmfil: remove file");
        System.out.println("nano: write to a text file");
        System.out.println("cat: reads from a file");
        System.out.println("help: help menu");
        System.out.println("exit: terminates program");
        System.out.println("---------------------");
    }
}
