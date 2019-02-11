package my.examples.blog.repository;

import my.examples.blog.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostRepository extends JpaRepository<Post, Long> {
    @Query(value = "SELECT p FROM Post p INNER JOIN FETCH p.category ORDER BY p.id DESC",
           countQuery = "SELECT count(p) FROM Post p")
    public Page<Post> getPosts(Pageable pageable);
}
