package pkb.dev.api.address;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.sql.Date;

@Component
@Data
public class AddressDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private long seq;
    private String name;
    private String addr;
    private Date rdate;

}
