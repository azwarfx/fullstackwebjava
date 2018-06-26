package repo;

import entity.Dokumen;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public abstract interface DokumenRepository extends CrudRepository<Dokumen, Long> {
	public abstract Dokumen findById(Long paramLong);
	public abstract List<Dokumen> findAll();
}