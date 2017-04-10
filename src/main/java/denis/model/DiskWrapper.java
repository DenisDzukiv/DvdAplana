package denis.model;

/**
 * Created by Денис on 09.04.2017.
 */
public class DiskWrapper {

    private User user;

    private Dvd dvd;

    public DiskWrapper(){}

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Dvd getDvd() {
        return dvd;
    }

    public void setDvd(Dvd dvd) {
        this.dvd = dvd;
    }
}
