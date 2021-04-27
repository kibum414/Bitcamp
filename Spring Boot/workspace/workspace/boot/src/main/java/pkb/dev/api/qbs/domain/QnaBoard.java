package pkb.dev.api.qbs.domain;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@Entity
@Getter
@Table(name = "qnas")
public class QnaBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "board_no")
    private long boardNo;

    @NotNull
    @Column(name = "title")
    private String title;

    @NotNull
    @Column(name = "content")
    private String content;

    @NotNull
    @Column(name = "writer")
    private String writer;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @Column(name = "reg_date")
    private Date regDate = new Date();

}
