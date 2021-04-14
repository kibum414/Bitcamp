package pkb.dev.api.address;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue
    @Column(name = "seq")
    private long seq;

    @Column(name = "name")
    private String name;

    @Column(name = "addr")
    private String addr;

    @Column(name = "rdate")
    private Date rdate;

}
