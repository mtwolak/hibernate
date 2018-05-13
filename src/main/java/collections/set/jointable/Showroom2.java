package collections.set.jointable;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "SHOWROOM_LIST2")
public class Showroom2 {

    @Id
    @Column(name = "SHOWROOM_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String manager;

    @OneToMany
    @JoinTable(name = "SHOWROOM_SET_JOINTABLE",
            joinColumns = @JoinColumn(name = "SHOWROOM_ID"),
            inverseJoinColumns = @JoinColumn(name = "CAR_ID"))
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<Car2> car2s;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public Set<Car2> getCar2s() {
        return car2s;
    }

    public void setCar2s(Set<Car2> car2s) {
        this.car2s = car2s;
    }
}
