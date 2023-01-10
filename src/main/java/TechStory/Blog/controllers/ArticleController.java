package TechStory.Blog.controllers;

import TechStory.Blog.models.Article;
import TechStory.Blog.repositories.ArticleRepository;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;


@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/")
    public List<Article> getArticles() {
        return articleRepository.findAll();
    }

    @PostMapping("/")
    public Article addArticle(@RequestBody Article article) {
        System.out.print("this is" + article.toString());
        return articleRepository.save(article);
    }

    @GetMapping("/{id}")
    public Article getArticle(@PathVariable int id) {
        return articleRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Article updateArticle(@PathVariable int id, @RequestBody Article article) {
        Article articleToUpdate = articleRepository.findById(id).orElse(null);
        if(articleToUpdate == null) {
            throw new EntityNotFoundException("Article not found");
        }

        //update the fields that needs to be updated
        articleToUpdate.setTitle(article.getTitle());
        articleToUpdate.setAuthorId(article.getAuthorId());
        articleToUpdate.setContent(article.getContent());
        articleToUpdate.setLikes(article.getLikes());
        return articleRepository.save(articleToUpdate);
    }

    @DeleteMapping("/{id}")
    public void deleteArticle(@PathVariable int id) {
        articleRepository.deleteById(id);
    }

}

