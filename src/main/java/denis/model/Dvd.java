package denis.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "dvd")
public class Dvd {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "dvd_Name")
    private String dvdName;

    @Column(name = "given")
    private Integer given;

    @ManyToOne
    @JoinColumn(name = "dvd_owner")
    private User user1;

    @ManyToMany(mappedBy = "dvds1") //dvds1 - название поля по которому идет связка модель User private Set<Dvd> dvds1;
    private List<User> userList;

    //второй вариант связки многие ко многим
    /*@ManyToMany
    @JoinTable(name="location_disk", joinColumns = @JoinColumn(name="dvd_id"),
            inverseJoinColumns = @JoinColumn(name="user_id"))
    private Set<User> userSet;*/

    public Dvd(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDvdName() {
        return dvdName;
    }

    public void setDvdName(String dvdName) {
        this.dvdName = dvdName;
    }

    public Integer getGiven() {
        return given;
    }

    public void setGiven(Integer given) {
        this.given = given;
    }

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void getUserList(List<User> userList) {
        this.userList = userList;
    }
}
