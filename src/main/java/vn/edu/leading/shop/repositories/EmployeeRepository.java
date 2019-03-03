package vn.edu.leading.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.leading.shop.models.CustomerModel;
import vn.edu.leading.shop.models.EmployeeModel;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<CustomerModel, Long> {
    List<EmployeeModel> findByEmployeeName(String term);
}