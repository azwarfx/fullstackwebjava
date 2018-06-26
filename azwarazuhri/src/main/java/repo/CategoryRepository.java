package repo;

import entity.Category;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public abstract interface CategoryRepository extends CrudRepository<Category, Long>
{
  public abstract Category findById(Long paramLong);

  public abstract List<Category> findAll();
}
