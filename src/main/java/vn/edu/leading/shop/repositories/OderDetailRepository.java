package vn.edu.leading.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.leading.shop.models.CategoryModel;
import vn.edu.leading.shop.models.OrderDetailModel;

import java.util.List;

public interface OderDetailRepository extends JpaRepository<OrderDetailModel,Long> {
    List<CategoryModel> findByCategoryNameContaining(String term);
}
