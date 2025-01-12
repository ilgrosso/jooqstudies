package net.tirasa.test.mavenproject1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import net.tirasa.test.mavenproject1.model.tables.Article;
import org.jooq.DSLContext;
import org.jooq.Record2;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

public class Mavenproject1 {

    public static void main(final String[] args) throws SQLException {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://172.17.0.2:5432/microtone",
                "microtone",
                "microtone")) {

            DSLContext context = DSL.using(conn, SQLDialect.POSTGRES);

//            AuthorRecord author = context.newRecord(Author.AUTHOR);
//            author.setId(1);
//            author.setFirstName("Pasqualindro");
//            author.setLastName("Jones");
//            author.store();
//            
//            ArticleRecord article = context.newRecord(Article.ARTICLE);
//            article.setId(2);
//            article.setTitle("jOOQ examples");
//            article.setDescription("A few examples of jOOQ CRUD operations");
//            article.setAuthorId(1);
//            article.store();
//
//            Result<Record> authors = context.select()
//                    .from(Author.AUTHOR)
//                    .fetch();
//            authors.forEach(author -> {
//                Integer id = author.getValue(Author.AUTHOR.ID);
//                String firstName = author.getValue(Author.AUTHOR.FIRST_NAME);
//                String lastName = author.getValue(Author.AUTHOR.LAST_NAME);
//                Integer age = author.getValue(Author.AUTHOR.AGE);
//
//                System.out.printf("Author %s %s has id: %d and age: %d\n", firstName, lastName, id, age);
//            });
            Result<Record2<Integer, String>> articles = context.select(Article.ARTICLE.ID, Article.ARTICLE.TITLE)
                    .from(Article.ARTICLE)
                    .fetch();
            System.out.println("XXXXXXXXXXX\n" + articles);
        }
    }
}
