package denis.dao;

import denis.model.Dvd;
import denis.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface DvdDao extends CrudRepository<Dvd, Long> {
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "UPDATE Dvd d SET d.given = :given  WHERE d.id = :dvdId")
    void updateDvd(@Param("dvdId") Long dvdId, @Param("given") int given);
    List<Dvd> findBygiven(Integer giv);
    //в запросе необходимо писать имя извлекания поля как у модели!!!!
    @Modifying(clearAutomatically = true)
    @Transactional
    //@Query(value = "FROM Dvd d, UserTakeDvd u, User us where d.user1 = :dvdOwner AND d.given = :given AND u.dvdId = d.id AND us.id = u.userId")

    @Query(value = "FROM Dvd d where d.user1 = :dvdOwner AND d.given = :given ")
    List<Dvd> findByuser1(@Param("dvdOwner") User user, @Param("given") int given);
}
