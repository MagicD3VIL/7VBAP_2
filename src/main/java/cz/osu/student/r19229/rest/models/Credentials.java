package cz.osu.student.r19229.rest.models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Credentials {
    private Long userUuid;
    private String password;

    @Id
    @Column(name = "user_uuid", nullable = false)
    public Long getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(Long userUuid) {
        this.userUuid = userUuid;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 60)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Credentials that = (Credentials) o;

        if (userUuid != null ? !userUuid.equals(that.userUuid) : that.userUuid != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userUuid != null ? userUuid.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
