# Indian News DataBase (INDB)

This is a Spring based project which provides a REST API to the Hindu Archive.

# How to run the project.

  - Clone the repo in your local directory
  - Compile and run the project using maven.
  - Server will be running on [localhost:8080](localhost:8080)

# API Endpoints

[GET]  /authors<br>
Lists all the authors of the articles available in the DB.


[GET]  /searchbyauthor?author="authorname" <br>
Search for the articles of the given author

[GET]  /searchbytitledescription?title="title"&description="description"<br>
Search for the articles of the given Title and Description. 
It performs a starts with query with title and contains query for description.

[GET]  /savearticlesforgivenday?url="hinduArchiveURLForADay"<br>
Scrapes the given URL and fetches and stores all the articles for the given day.

