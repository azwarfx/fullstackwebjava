package repo;

import entity.JadwalKeberangkatan;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public abstract interface JadwalKeberangkatanRepository extends CrudRepository<JadwalKeberangkatan, Long>
{
  public abstract JadwalKeberangkatan findById(Long paramLong);

  public abstract List<JadwalKeberangkatan> findAll();
}
