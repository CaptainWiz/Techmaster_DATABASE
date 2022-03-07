import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Post {
    private int id;
    private String title;
    private String description;
    private String thumbnail;
    private LocalDate create_at;

    @Override
    public String toString() {
        return id + " - " + title + " - " + description + " - " + thumbnail + " - " + create_at ;
    }
}


