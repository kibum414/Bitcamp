package pkb.dev.api.address;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Data
@Component
public class AddressDto {

    private long addressId;
    private String name;
    private String addr;
    private Date rdate;

}
