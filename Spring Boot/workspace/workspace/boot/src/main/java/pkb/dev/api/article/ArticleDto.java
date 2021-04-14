package pkb.dev.api.article;

import lombok.Data;

import java.sql.Date;

@Data
public class ArticleDto {

    private long articleId;
    private String writer;
    private String email;
    private String subject;
    private String content;
    private Date rdate;
}
