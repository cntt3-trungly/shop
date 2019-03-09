package vn.edu.leading.shop.services;

import org.springframework.stereotype.Service;
import vn.edu.leading.shop.models.CustomerModel;
import vn.edu.leading.shop.models.EmployeeModel;
import vn.edu.leading.shop.repositories.CustomerRepository;
import vn.edu.leading.shop.repositories.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<EmployeeModel> findAll() {
        return employeeRepository.findAll(); // select * from shop_customers
    }

    @Override
    public List<EmployeeModel> search(String term) {
        return employeeRepository.findByFirstNameContaining(term);
        // select * from shop_customers where shop_customers.customer_name like %term%
    }

    @Override
    public EmployeeModel findById(Long id) {
        return employeeRepository.findById(id).get();
        // select * from shop_customers where shop_customers.id = id
    }

    @Override
    public boolean update(EmployeeModel employee) {
        EmployeeModel employeeModel = employeeRepository.findById(employee.getId()).orElse(null);
        if (employeeModel == null) {
            return false;
        }
        employeeRepository.save(employee);
        return true;
    }

    @Override
    public void save(EmployeeModel employee) {
        employeeRepository.save(employee);
    }

    @Override
    public boolean delete(Long id) {
        EmployeeModel employeeModel = employeeRepository.findById(id).orElse(null);
        if (employeeModel == null) {
            return false;
        }
        employeeRepository.delete(employeeModel);
        return true;
    }
}