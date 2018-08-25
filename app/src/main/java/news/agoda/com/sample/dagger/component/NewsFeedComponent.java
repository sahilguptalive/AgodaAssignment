package news.agoda.com.sample.dagger.component;

import com.example.app_domain.network.APIInterface;

import dagger.Component;
import news.agoda.com.sample.dagger.module.ContextModule;
import news.agoda.com.sample.dagger.module.NewsFeedModule;
import news.agoda.com.sample.dagger.scope.NewsFeedApplicationScope;

@NewsFeedApplicationScope
@Component(modules = {NewsFeedModule.class, ContextModule.class})
public interface NewsFeedComponent {
    APIInterface getApiClient();
}
