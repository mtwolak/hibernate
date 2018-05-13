package collections.set.jointable;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CAR_LIST2")
public class Car2 {
    @Id
    @Column(name = "CAR_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String color;

    public Car2() {
    }

    public Car2(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car2 car2 = (Car2) o;
        return id == car2.id &&
                Objects.equals(name, car2.name) &&
                Objects.equals(color, car2.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, color);
    }
}
