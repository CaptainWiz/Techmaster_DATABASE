import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Post_Author {
    private int id;
    private String title;
    private String content;
    private String author_name;
    private String tag;
    private LocalDate create_at;

    @Override
    public String toString() {
        return  id + " - " + title + " - " + content + " - " + author_name+ " - " + tag + " - " + create_at;
    }
}
