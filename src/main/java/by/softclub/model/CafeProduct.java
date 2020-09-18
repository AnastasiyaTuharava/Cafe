package by.softclub.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cafe_products")
public class CafeProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "title")
    private String title;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "price", referencedColumnName = "id")
    private Price price;
    @Column(name = "description")
    private String description;
}
