package projectfinal;

public abstract class Node implements Comparable<Node> {

    private Directory root;
    private String name;

    public Node(String name) {
        this.name = name;
    }

    public boolean isDirectory() {

        return this instanceof Directory;
    }

    public boolean isFile() {

        return this instanceof File;
    }

    public String getPath() {

        return root != null ? root.getPath() + "/" + name : name;
    }

    public Directory getParent() {
        return root;
    }

    public abstract long getLength();

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Node o) {

        return this.getName().compareTo(o.getName());
    }

    public void setRoot(Directory root) {
        this.root = root;
    }

    @Override
    public String toString() {
        return "root=" + root
                + ", \nname='" + name;

    }
}
