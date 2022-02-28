package cz.osu.student.r19229.rest.repositories;

import cz.osu.student.r19229.rest.models.Credentials;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CredentialsRepository extends JpaRepository<Credentials, Long> {

}