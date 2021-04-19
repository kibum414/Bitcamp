package pkb.dev.api.article;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Data
@Component
public class ArticleDto {

    private long articleId;
    private String writer;
    private String email;
    private String subject;
    private String content;
    private Date rdate;

    public void setArticleId(long articleId) {
        this.articleId = articleId;
    }

    public long getArticleId() {
        return this.articleId;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getWriter() {
        return this.writer;
    }
}
