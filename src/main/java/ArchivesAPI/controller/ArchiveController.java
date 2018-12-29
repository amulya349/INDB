package ArchivesAPI.controller;

import ArchivesAPI.model.Article;
import ArchivesAPI.repository.ArticleRepository;
import ArchivesAPI.util.Scrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ArchiveController {

    @Autowired
    ArticleRepository repository;

    @RequestMapping("/authors")
    public List<String> getAuthors() {
//        This function will return all the available authors in the db.
        return repository.findDistinctAuthors();
    }

    @RequestMapping("/searchbyauthor")
    public List<Article> searchArticlesByAuthor(@RequestParam(value = "author", defaultValue = "") String author) {
        return repository.findByAuthor(author);
    }

    @RequestMapping("/searchbytitledescription")
    public List<Article> searchArticlesByAuthor(@RequestParam(value = "title", defaultValue = "") String title, @RequestParam(value = "description", defaultValue = "") String description) {
        return repository.findByTitleStartingWithAndDescriptionContaining(title, description);
    }

    @RequestMapping("/savearticlesforgivenday")
    public String saveArticles(@RequestParam(value = "url", defaultValue = "") String url) throws IOException {
//        This function should be an async one because, it will take a lot of time to run and HTTP will timeout the req after sometime.
//        This method takes URL of the Hindu archive for a day and stores all the articles data in the DB.
        Scrapper scrapper = new Scrapper();
        List<String> articleUrls = scrapper.getArticlesForTheDay(url);
        for (String articleUrl : articleUrls) {
            try {
//                save each of the parsed article in the DB
                repository.save(scrapper.parseArticlePage(articleUrl));
            } catch (Exception e) {
//                It will be automatically continue
            }
        }
//        Here, instead of saving one by one, we can store the articles in a list and save all of them once using
//        repository.saveAll() method but it's not good in this case because, if we do batch save, if one of the article parsing fails,
//            all the other unsaved articles will be lost.
        return "Done";
    }
}
