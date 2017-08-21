package entity;

import org.robin.jdbc.sql.DBTable;

/**
 * Created by robin on 2017/8/18.
 */
@DBTable("post")
public class Post {
    private int id;
    private String name;
    private String keyword;
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Post(int id, String name, String keyword, String content) {
        this.id = id;
        this.name = name;
        this.keyword = keyword;
        this.content = content;
    }
    public Post(){}

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", keyword='" + keyword + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
