package denis.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Transient
    private String confirmPassword;

    @OneToMany(mappedBy = "user1") //mapped - поле по которому связь идет user1
    private List<Dvd> dvds;

    @ManyToMany
    @JoinTable(name="location_disk", joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="dvd_id"))
    private Set<Dvd> dvds1;

    @ManyToMany
    @JoinTable(name="user_roles", joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="role_id"))
    private Set<Role> roles;


    public User(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public List<Dvd> getDvds() {
        return dvds;
    }

    public void setDvds(List<Dvd> dvds) {
        this.dvds = dvds;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Dvd> getDvds1() {
        return dvds1;
    }

    public void setDvds1(Set<Dvd> dvds1) {
        this.dvds1 = dvds1;
    }
}

