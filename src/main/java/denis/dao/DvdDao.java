package denis.dao;

import denis.model.Dvd;
import denis.model.User;
import org.hibernate.annotations.NamedNativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface DvdDao extends CrudRepository<Dvd, Long> {
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "UPDATE Dvd d SET d.given = 1 WHERE d.id = :dvdId")
    void updateDvd(@Param("dvdId") Long dvdId);
    List<Dvd> findBygiven(Integer giv);
    List<Dvd> findByuser1(User user);
    //в запросе необходимо писать имя извлекания поля как у модели!!!!
   /* @Query(value = "SELECT d.dvdName FROM Dvd d ")
    List<String> findBydvdName();*/
}
