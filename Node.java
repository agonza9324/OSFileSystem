package projectfinal;

public abstract class Node implements Comparable<Node> {

    private Directory root;
    private String name;

    public Node(String name) {
        this.name = name;



import projectfinal.Directory;
import java.time.LocalDateTime;

/**
 * @author Bazlur Rahman Rokon
 * @since 3/31/17.
 */
public abstract class Node implements Comparable<Node> {
    private Directory root;
    private String name;
    private LocalDateTime created;
    private LocalDateTime lastUpdated;
    private LocalDateTime lastAccessed;

    public Node(String name) {
        this.name = name;
        this.created = LocalDateTime.now();
        this.lastUpdated = LocalDateTime.now();
        this.lastAccessed = LocalDateTime.now();

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

    //public Node getParent() {
    //    return root;
    //}

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

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public LocalDateTime getLastAccessed() {
        return lastAccessed;
    }

    @Override
    public String toString() {
        return "root=" + root +
                ", \nname='" + name;/* + '\'' +
                ", \ncreated=" + created +
                ", \nlastUpdated=" + lastUpdated +
                ", \nlastAccessed=" + lastAccessed;*/

    }
}

