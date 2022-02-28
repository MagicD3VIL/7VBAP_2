package cz.osu.student.r19229.rest.repositories;

import cz.osu.student.r19229.rest.models.Tags;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagsRepository extends JpaRepository<Tags, Long> {

}