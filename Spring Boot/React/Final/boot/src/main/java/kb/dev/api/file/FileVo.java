package kb.dev.api.file;
import kb.dev.api.board.Board;

import javax.persistence.*;

@Entity
@Table(name = "files")
public class FileVo {

    @Id
    @Column(name = "file_id")
    private long fileId;

    @Column(name = "save_fname")
    private String saveFname;

    @Column(name = "original_fname")
    private String originalFname;

    @Column(name = "fsize")
    private long fsize;

//    @ManyToOne
//    @JoinColumn(name = "board_id")
//    Board board;
}
