package denis.model;

import javax.persistence.*;

/**
 * Created by Денис on 06.04.2017.
 */
@Entity
@Table(name = "location_disk")
public class UserTakeDvd {

    /*@Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;*/

    @Id
    @Column(name = "dvd_id")
    private Long dvdId;

    @Column(name = "user_id")
    private Long userId;



    public UserTakeDvd(){}

    public Long getDvdId() {
        return dvdId;
    }

    public void setDvdId(Long dvdId) {
        this.dvdId = dvdId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
