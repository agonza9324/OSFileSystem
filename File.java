package projectfinal;



public class File extends Node {
    private String content; 

/**
 * @author Bazlur Rahman Rokon
 * @since 3/31/17.
 */
public class File extends Node {
    private String content; /// for simplicity


    public File(String name, String content) {
        super(name);
        this.content = content;
    }

    public File(String name) {
        super(name);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public long getLength() {
        if (content != null) {
            return content.getBytes().length;
        }

        return 0;
    }
}