package identifiers.composite.embedded.one;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CoursePK implements Serializable {
    private String tutor;
    private String title;

    public CoursePK() {
    }

    public CoursePK(String tutor, String title) {
        this.tutor = tutor;
        this.title = title;
    }

    public String getTutor() {
        return tutor;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoursePK coursePK = (CoursePK) o;
        return Objects.equals(tutor, coursePK.tutor) &&
                Objects.equals(title, coursePK.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tutor, title);
    }
}
