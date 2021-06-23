package model;

import javax.persistence.*;

@Entity
@Table()
public class Blog {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String content;

    public Category getCategory() {
        return category;
    }

    public Blog(long id, String name, String content, Category category) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.category = category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @ManyToOne
//    @JoinColumn(name = "category_id")
    private Category category;

    public Blog() {
    }

    public Blog(Long id, String name, String content) {
        this.id = id;
        this.name = name;
        this.content = content;
    }

    @Override
    public String toString() {
        return String.format("Blog[id=%d, name='%s', content='%s', category='%s']", id, name, content, category);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
