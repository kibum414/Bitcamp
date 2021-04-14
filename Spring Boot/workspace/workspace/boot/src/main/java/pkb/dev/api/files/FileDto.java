package pkb.dev.api.files;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
public class FileDto {

    private long fileId;
    private String saveFname;
    private String originalFname;
    private long fsize;

}
