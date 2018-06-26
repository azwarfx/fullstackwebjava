package repo;

import entity.CalonJamaah;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public abstract interface CalonJamaahRepository extends CrudRepository<CalonJamaah, Long>
{
  public abstract CalonJamaah findById(Long paramLong);

  public abstract List<CalonJamaah> findAll();
}
