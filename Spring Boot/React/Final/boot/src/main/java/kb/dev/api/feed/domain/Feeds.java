package kb.dev.api.feed.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "feeds")
public class Feeds {

    @Id
    @GeneratedValue
    @Column(name = "feed_no")
    private long feedNo;

    @Column(name = "title")
    private String title;

    @Column(name = "writer")
    private String writer;

    @Column(name = "content")
    private String content;

    @Column(name = "add_location")
    private String addLocation;

    @Column(name = "hash_tag")
    private String hashTag;

    @Column(name = "reg_date")
    private String regDate;

}
