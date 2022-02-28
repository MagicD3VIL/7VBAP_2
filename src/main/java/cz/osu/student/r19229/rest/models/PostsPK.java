package cz.osu.student.r19229.rest.models;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class PostsPK implements Serializable {
    private Long thread;
    private Long id;

    @Column(name = "thread", nullable = false)
    @Id
    public Long getThread() {
        return thread;
    }

    public void setThread(Long thread) {
        this.thread = thread;
    }

    @Column(name = "id", nullable = false)
    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostsPK postsPK = (PostsPK) o;

        if (thread != null ? !thread.equals(postsPK.thread) : postsPK.thread != null) return false;
        if (id != null ? !id.equals(postsPK.id) : postsPK.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = thread != null ? thread.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }
}
