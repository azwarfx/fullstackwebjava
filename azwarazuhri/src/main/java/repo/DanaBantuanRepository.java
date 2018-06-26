package repo;

import entity.DanaBantuan;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public abstract interface DanaBantuanRepository extends CrudRepository<DanaBantuan, Long>
{
  public abstract DanaBantuan findById(Long paramLong);

  public abstract List<DanaBantuan> findAll();
}
