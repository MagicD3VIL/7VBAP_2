package cz.osu.student.r19229.rest.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Tags implements Serializable {
    private Long id;
    private String name;
    @JsonIgnore
    private Set<Threads> threads;

    @Id
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "tags", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    public Set<Threads> getThreads() {
        return threads;
    }
    public void setThreads(Set<Threads> threads) {
        this.threads = threads;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tags tags = (Tags) o;

        if (id != null ? !id.equals(tags.id) : tags.id != null) return false;
        if (name != null ? !name.equals(tags.name) : tags.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
