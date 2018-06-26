package repo;

import entity.PembayaranKedua;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public abstract interface PembayaranKeduaRepository extends CrudRepository<PembayaranKedua, Long>
{
  public abstract PembayaranKedua findById(Long paramLong);

  public abstract List<PembayaranKedua> findAll();
}
