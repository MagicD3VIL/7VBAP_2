package cz.osu.student.r19229.rest.repositories;

import cz.osu.student.r19229.rest.models.Threads;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThreadsRepository extends JpaRepository<Threads, Long> {

}