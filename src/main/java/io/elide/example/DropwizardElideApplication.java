package io.elide.example;

import com.yahoo.elide.contrib.dropwizard.elide.ElideBundle;
import com.yahoo.elide.resources.JsonApiEndpoint;
import io.dropwizard.Application;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.elide.example.model.Post;
import io.elide.example.model.User;

/**
 * @author thuynh
 */
public class DropwizardElideApplication extends Application<DropwizardElideConfiguration> {
    private final ElideBundle<DropwizardElideConfiguration> elideBundle;

    public DropwizardElideApplication() {
        this.elideBundle = new ElideBundle<DropwizardElideConfiguration>(
                User.class,
                Post.class
        ) {
            @Override
            public PooledDataSourceFactory getDataSourceFactory(DropwizardElideConfiguration configuration) {
                return configuration.getDatabase();
            }
        };
    }

    @Override
    public void initialize(Bootstrap<DropwizardElideConfiguration> bootstrap) {
        bootstrap.addBundle(elideBundle);
    }

    @Override
    public void run(DropwizardElideConfiguration dropwizardElideConfiguration, Environment environment) throws Exception {
        environment.jersey().register(JsonApiEndpoint.class);
    }

    public static void main(String[] args) throws Exception {
        new DropwizardElideApplication().run(args);
    }
}
