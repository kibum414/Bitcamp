package pkb.dev.api.files;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class FileDto {

    private long fileId;
    private String saveFname;
    private String originalFname;
    private long fsize;

}
