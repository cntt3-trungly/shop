package vn.edu.leading.shop.models;

import lombok.*;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BaseModel<T extends BaseModel<T>> implements Persistable, Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    @Getter
    protected Long id;

    @Override
    @Transient
    public boolean isNew() {
        return null == this.getId();
    }
}
