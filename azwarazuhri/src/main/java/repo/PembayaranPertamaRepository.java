package repo;

import entity.PembayaranPertama;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public abstract interface PembayaranPertamaRepository extends CrudRepository<PembayaranPertama, Long>
{
  public abstract PembayaranPertama findById(Long paramLong);

  public abstract List<PembayaranPertama> findAll();
}