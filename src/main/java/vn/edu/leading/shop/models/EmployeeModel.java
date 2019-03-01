package vn.edu.leading.shop.models;

import lombok.*;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

@Table(name = "shop_employees")
public class EmployeeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Column(name = "last_name",nullable = false)
    private String lastName;
    @NotEmpty
    @Column(name = "first_name",nullable = false)
    private String firstName;
    @Column(name = "birth_day",nullable = false)
    private String birthDay;
    private String notes;
    private String photo;

}
