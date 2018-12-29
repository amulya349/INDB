package ArchivesAPI.repository;

import ArchivesAPI.model.Article;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArticleRepository extends CrudRepository<Article, Long> {

    @Query("select distinct author from Article")
    List<String> findDistinctAuthors();

    List<Article> findByAuthor(String author);

    List<Article> findByTitleStartingWithAndDescriptionContaining(String title, String description);

}