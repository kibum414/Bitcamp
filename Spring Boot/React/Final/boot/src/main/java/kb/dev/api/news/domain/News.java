package kb.dev.api.news.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long newsId;

    @Column(length = 20)
    private String category;

    @Column(length = 512)
    private String title;

    @Column(length = 1024)
    private String address;

    @Builder
    public News(String category,
                String title, String address) {
        this.category = category;
        this.title = title;
        this.address = address;
    }
}
