package denis.dao;

import denis.model.Dvd;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DvdDao extends JpaRepository<Dvd, Long> {
}
