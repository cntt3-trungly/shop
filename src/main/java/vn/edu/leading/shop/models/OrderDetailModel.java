package vn.edu.leading.shop.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

@Table(name = "shop_order_detail")
public class OrderDetailModel  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Column(name = "order_id",nullable = false)
    private Long orderId;
    @NotEmpty
    @Column(name="product_id",nullable = false)
    private Long productId;
    private Long quantity;


}
