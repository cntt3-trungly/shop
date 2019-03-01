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
@Table(name ="shop_customers")

public class CustomerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Column(name = "customer_name",nullable = false)
    private String customerName;

    @NotEmpty
    @Column(name = "contact_name",nullable = false)
    private String contactName;

    private String address;

    private String city;

    @Column(name ="postal_code" )
    private String postalCode;

    private String country;

}
