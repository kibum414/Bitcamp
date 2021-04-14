package pkb.dev.api.address;

import lombok.Data;

import java.sql.Date;

@Data
public class AddressDto {

    private long addressId;
    private String name;
    private String addr;
    private Date rdate;

}
