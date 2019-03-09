package vn.edu.leading.shop.services;

import org.springframework.stereotype.Service;
import vn.edu.leading.shop.models.CategoryModel;
import vn.edu.leading.shop.models.CustomerModel;
import vn.edu.leading.shop.repositories.CategoryRepository;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryModel> findAll() {
        return categoryRepository.findAll(); // select * from shop_customers
    }

    @Override
    public List<CategoryModel> search(String term) {
        return categoryRepository.findByCategoryNameContaining(term);
        // select * from shop_customers where shop_customers.customer_name like %term%
    }

    @Override
    public CategoryModel findById(Long id) {
        return categoryRepository.findById(id).get();
        // select * from shop_customers where shop_customers.id = id
    }

    @Override
    public boolean update(CategoryModel category) {
        CategoryModel categoryModel = categoryRepository.findById(category.getId()).orElse(null);
        if (categoryModel == null) {
            return false;
        }
        categoryRepository.save(categoryModel);
        return true;
    }

    @Override
    public void save(CategoryModel category) {
        categoryRepository.save(category);
    }

    @Override
    public boolean delete(Long id) {
        CategoryModel categoryModel = categoryRepository.findById(id).orElse(null);
        if (categoryModel == null) {
            return false;
        }
        categoryRepository.delete(categoryModel);
        return true;
    }
}