package cz.osu.student.r19229.rest.repositories;

import cz.osu.student.r19229.rest.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {

}
