package collections.list.foreignkey;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "SHOWROOM_LIST")
public class Showroom {

    @Id
    @Column(name = "SHOWROOM_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String manager;

    @OneToMany
    @JoinColumn(name = "SHOWROOM_ID")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Car> cars;

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

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
