package pkb.dev.api.address;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @Column(name = "address_id")
    private long addressId;

    @Column(name = "name")
    private String name;

    @Column(name = "addr")
    private String addr;

    @Column(name = "rdate")
    private Date rdate;
}
