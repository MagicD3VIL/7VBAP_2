package cz.osu.student.r19229.rest.models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Users {
    private Long uuid;
    private String username;
    private String email;
    private String nickname;

    @Id
    @Column(name = "uuid", nullable = false)
    public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 32)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 60)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "nickname", nullable = false, length = 32)
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (uuid != null ? !uuid.equals(users.uuid) : users.uuid != null) return false;
        if (username != null ? !username.equals(users.username) : users.username != null) return false;
        if (email != null ? !email.equals(users.email) : users.email != null) return false;
        if (nickname != null ? !nickname.equals(users.nickname) : users.nickname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = uuid != null ? uuid.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        return result;
    }
}
