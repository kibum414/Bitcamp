package kb.dev.api.item.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Table(name = "sale_items")
@NoArgsConstructor
public class SaleItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_no")
    private long itemNo;

    @Column(name = "hash_tag")
    private String hashTag;

    @Column(name = "item_picture")
    private String itemPicture;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "reg_date")
    private Date regDate;

    @Column(name = "price")
    private String price;

    @Column(name = "writer")
    private String writer;

    @Column(name = "sold_out")
    private Boolean soldOut;

}
