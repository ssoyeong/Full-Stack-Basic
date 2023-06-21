package src.main.java.dto;

public class Todo {

    private Long id;
    private String name;
    private String regDate;
    private int sequence;
    private String title;
    private String type;

    public Todo(Long id, String type) {
        this.id = id;
        this.type = type;
    }

    public Todo(String name, String title, int sequence) {
        this.name = name;
        this.title = title;
        this.sequence = sequence;
    }


    public Todo(Long id, String name, String regDate, int sequence, String title, String type) {
        this.id = id;
        this.name = name;
        this.regDate = regDate;
        this.sequence = sequence;
        this.title = title;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRegDate() {
        return regDate;
    }

    public int getSequence() {
        return sequence;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", regDate='" + regDate + '\'' +
                ", sequence=" + sequence +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}