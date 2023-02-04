package TechStory.Blog.controllers;

import TechStory.Blog.models.Article;
import TechStory.Blog.repositories.ArticleRepository;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/")
    public ResponseEntity<List<Article>> getArticles() {
        return new ResponseEntity<>(articleRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Article> addArticle(@RequestBody Article article) {
        return new ResponseEntity<>(articleRepository.save(article), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Article> getArticle(@PathVariable int id) {
        return new ResponseEntity<>( articleRepository.findById(id).orElse(null), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable int id, @RequestBody Article article) {
        Article articleToUpdate = articleRepository.findById(id).orElse(null);
        if(articleToUpdate == null) { throw new EntityNotFoundException("Article not found"); }
        //update the fields that needs to be updated
        articleToUpdate.setTitle(article.getTitle());
        articleToUpdate.setAuthorId(article.getAuthorId());
        articleToUpdate.setContent(article.getContent());
        articleToUpdate.setLikes(article.getLikes());
        return new ResponseEntity<>(articleRepository.save(articleToUpdate), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteArticle(@PathVariable int id) {
        articleRepository.deleteById(id);
    }

}

