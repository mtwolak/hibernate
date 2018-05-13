package identifiers.composite.embedded.three;

import java.io.Serializable;

public class CoursePK3 implements Serializable {
    private String tutor;
    private String title;

    public CoursePK3() {
    }

    public CoursePK3(String tutor, String title) {
        this.tutor = tutor;
        this.title = title;
    }
}
