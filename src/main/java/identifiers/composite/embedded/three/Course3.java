package identifiers.composite.embedded.three;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@IdClass(value = CoursePK3.class)
@Entity
@Table(name = "COURSE_ANNOTATION_V3")
public class Course3 {

    @Id
    private String tutor;
    @Id
    private String title;

    private int totalStudents;

    public Course3() {
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTotalStudents() {
        return totalStudents;
    }

    public void setTotalStudents(int totalStudents) {
        this.totalStudents = totalStudents;
    }
}
