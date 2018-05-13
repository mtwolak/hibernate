package identifiers.composite.embedded.one;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="COURSE_ANNOTATION")
public class Course implements Serializable {
    @Id
    private CoursePK id;

    private int totalStudents = 0;

    public CoursePK getId() {
        return id;
    }

    public void setId(CoursePK id) {
        this.id = id;
    }

    public int getTotalStudents() {
        return totalStudents;
    }

    public void setTotalStudents(int totalStudents) {
        this.totalStudents = totalStudents;
    }
}
