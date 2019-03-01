package vn.edu.leading.shop.services;

import vn.edu.leading.shop.models.CategoryModel;
import vn.edu.leading.shop.models.CustomerModel;

import java.util.List;

public interface CategoryService {
    List<CategoryModel> fineAll();
    List<CategoryModel> search(String term);
    CategoryModel findById(Long id);
    boolean update(CategoryModel category);
    void save(CategoryModel category);
    boolean delete(Long id);
}
