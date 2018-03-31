package pl.portfolio.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

import pl.portfolio.entities.Book;
import pl.portfolio.entities.Course;
import pl.portfolio.entities.Link;
import pl.portfolio.entities.Project;
import pl.portfolio.entities.SiteContent;
import pl.portfolio.entities.Tag;

@Configuration
public class RepositoryConfig extends RepositoryRestConfigurerAdapter {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Link.class);
        config.exposeIdsFor(Project.class);
        config.exposeIdsFor(Course.class);
        config.exposeIdsFor(Book.class);
        config.exposeIdsFor(Tag.class);
        config.exposeIdsFor(SiteContent.class);
    }

}
