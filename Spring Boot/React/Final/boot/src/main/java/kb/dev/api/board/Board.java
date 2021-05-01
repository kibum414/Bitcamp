package kb.dev.api.board;

import kb.dev.api.file.FileVo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "boards")
public class Board {

    @Id
    @Column(name = "board_id")
    private long boardId;

    @Column(name = "title")
    private String title;

    @Column(name = "writer")
    private String writer;

    @Column(name = "content")
    private String content;

//    @OneToMany(mappedBy = "board")
//    List<FileVo> files = new ArrayList<>();
}
