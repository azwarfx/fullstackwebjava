package repo;

import entity.Paket;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public abstract interface PaketRepository extends CrudRepository<Paket, Long>
{
  public abstract Paket findById(Long paramLong);

  public abstract List<Paket> findAll();
}
