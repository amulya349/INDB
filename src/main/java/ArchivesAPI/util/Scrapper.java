package ArchivesAPI.util;

import ArchivesAPI.model.Article;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Scrapper {
    public Article parseArticlePage(String url) throws ParseException, IOException {
//        This method takes URL of an article page and gives back article objects after parsing
        Document doc = Jsoup.connect(url).get();
        String author = doc.selectFirst("a.auth-nm").text();
        String title = doc.selectFirst("h1.title").text();
//        Lets fetch the description now
        Elements e = doc.select("p");
        StringBuilder descBuffer = new StringBuilder();
        for (Element x : e) {
            descBuffer.append(x.text() + '\n');
        }
        String descripton = descBuffer.toString();
        Element y = doc.selectFirst("div.teaser-text span");
        Date published_date = new SimpleDateFormat("MMM dd, yyyy HH:mm z").parse(y.text());
        return new Article(author, title, descripton, published_date);
    }

    public List<String> getURLsForDaysOfMonth(String monthUrl) throws IOException {
//        This method take URL of a month of Hindu archive and gives back the URLs of each days
        Document doc = Jsoup.connect(monthUrl).get();

        Elements e = doc.select("td a");
        List<String> urlsForDays = new ArrayList<String>();
        for (Element x : e) {
            urlsForDays.add(x.attr("href"));
        }
        return urlsForDays;
    }

    public List<String> getArticlesForTheDay(String url) throws IOException {
//        This method takes URL of a day and gives back URLs of all the articles of the given day.
        Document doc = Jsoup.connect(url).get();

        Elements e = doc.select("ul.archive-list li a");
        List<String> urls = new ArrayList<String>();
        for (Element x : e) {
            urls.add(x.attr("href"));
        }
        return urls;
    }

}
