package cz.osu.student.r19229.rest.repositories;

import cz.osu.student.r19229.rest.models.Posts;
import cz.osu.student.r19229.rest.models.PostsPK;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface PostsRepository extends JpaRepository<Posts, PostsPK> {
    Optional<Posts> findByThreadAndId(long thread, long id);
    List<Posts> findAllByThread(long thread);
    void deleteByThreadAndId(long thread, long id);
}
