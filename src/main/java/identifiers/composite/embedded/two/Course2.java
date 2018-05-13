package identifiers.composite.embedded.two;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "COURSE_ANNOTATION_V2")
public class Course2 {

    @EmbeddedId
    private CoursePK2 id;
    private int totalStudents;

    public Course2() {
    }

    public Course2(String title, String tutor) {
        id = new CoursePK2();
        id.setTitle(title);
        id.setTutor(tutor);
    }

    public CoursePK2 getId() {
        return id;
    }

    public void setId(CoursePK2 id) {
        this.id = id;
    }

    public int getTotalStudents() {
        return totalStudents;
    }

    public void setTotalStudents(int totalStudents) {
        this.totalStudents = totalStudents;
    }
}
