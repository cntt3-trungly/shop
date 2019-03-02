package vn.edu.leading.shop.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Table (name = "shop_orders")
public class OrderModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Column(name = "customer_id",nullable = false)
    private Long customerId;
    @NotEmpty
    @Column(name="employee_id",nullable = false)
    private Long employeeId;
    @NotEmpty
    @Column(name = "shipper_id",nullable = false)
    private Long shipperId;

    private String orderDate;

}
