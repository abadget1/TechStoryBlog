package TechStory.Blog.repositories;

import TechStory.Blog.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.relational.core.mapping.Table;

@Table
public interface ArticleRepository extends JpaRepository<Article, Integer> {
}
