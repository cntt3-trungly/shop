package vn.edu.leading.shop.services;

import org.springframework.stereotype.Service;
import vn.edu.leading.shop.models.CategoryModel;
import vn.edu.leading.shop.models.SupplierModel;
import vn.edu.leading.shop.repositories.CategoryRepository;
import vn.edu.leading.shop.repositories.SupplierRepository;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;

    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public List<SupplierModel> findAll() {
        return supplierRepository.findAll(); // select * from shop_customers
    }

    @Override
    public List<SupplierModel> search(String term) {
        return supplierRepository.findBySupplierNameContaining(term);
        // select * from shop_customers where shop_customers.customer_name like %term%
    }

    @Override
    public SupplierModel findById(Long id) {
        return supplierRepository.findById(id).get();
        // select * from shop_customers where shop_customers.id = id
    }

    @Override
    public boolean update(SupplierModel supplier) {
        SupplierModel supplierModel = supplierRepository.findById(supplier.getId()).orElse(null);
        if (supplierModel == null) {
            return false;
        }
        supplierRepository.save(supplierModel);
        return true;
    }

    @Override
    public void save(SupplierModel supplier) {
        supplierRepository.save(supplier);
    }

    @Override
    public boolean delete(Long id) {
        SupplierModel supplierModel = supplierRepository.findById(id).orElse(null);
        if (supplierModel == null) {
            return false;
        }
        supplierRepository.delete(supplierModel);
        return true;
    }
}