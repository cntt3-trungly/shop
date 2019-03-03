package vn.edu.leading.shop.repositories;

import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import vn.edu.leading.shop.models.OrderModel;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

public interface OrderDetailRepository extends JpaAttributeConverter<OrderModel,Long> {
}


