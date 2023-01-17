package TechStory.Blog.repositories;

import TechStory.Blog.models.Author;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


@Table
public interface AuthorRepository extends JpaRepository<Author, Integer> { }

