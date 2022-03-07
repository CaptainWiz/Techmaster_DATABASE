import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Post_Add{
    private int id;
    private String title;
    private String content;
    private String description;
    private String thumbnail;
    private LocalDate create_at;
    private Status status;
    private int id_category;
    private int id_author;

    public Post_Add(String title, String content, String description, String thumbnail, int id_category, int id_author, LocalDate create_at, Status status) {
        this.title = title;
        this.content = content;
        this.description = description;
        this.thumbnail = thumbnail;

        this.id_category = id_category;
        this.id_author = id_author;
        this.create_at = create_at;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Post_Add{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", description='" + description + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", create_at=" + create_at +
                ", status='" + status + '\'' +
                ", id_category=" + id_category +
                ", id_author=" + id_author +
                '}';
    }
}
