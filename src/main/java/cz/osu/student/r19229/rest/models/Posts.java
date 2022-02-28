package cz.osu.student.r19229.rest.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@IdClass(PostsPK.class)
public class Posts {
    /* Poznámka:
    Chtěl jsem mít, že každý thread má sérii postů, kde se inkrementují IDs postů pro každý thread zvlášť.

    Tzn., že před vložením by se udělal SELECT:
    SELECT COALESCE(MAX(id), 0) AS max from `posts` where thread = '1'
    A nastavilo by se ID vkládaného postu na value výsledku selectu + 1.

    V původním REST API v Lapisu jsem to tak měl, nezjistil jsem ovšem, jak to udělat v JPA, takže tady je pouze klasický auto-increment.
    */

    private Long thread;
    private Long id;
    private Long postedBy;
    private String content;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    @Id
    @Column(name = "thread", nullable = false)
    public Long getThread() {
        return thread;
    }

    public void setThread(Long thread) {
        this.thread = thread;
    }

    @Id
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "posted_by", nullable = false)
    public Long getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(Long postedBy) {
        this.postedBy = postedBy;
    }

    @Basic
    @Column(name = "content", nullable = false, columnDefinition = "text")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "created_at", nullable = false)
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Basic
    @Column(name = "updated_at", nullable = true)
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Posts posts = (Posts) o;

        if (thread != null ? !thread.equals(posts.thread) : posts.thread != null) return false;
        if (id != null ? !id.equals(posts.id) : posts.id != null) return false;
        if (postedBy != null ? !postedBy.equals(posts.postedBy) : posts.postedBy != null) return false;
        if (content != null ? !content.equals(posts.content) : posts.content != null) return false;
        if (createdAt != null ? !createdAt.equals(posts.createdAt) : posts.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(posts.updatedAt) : posts.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = thread != null ? thread.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (postedBy != null ? postedBy.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }
}
