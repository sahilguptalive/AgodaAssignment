package news.agoda.com.sample.dagger.component;

import dagger.Component;
import news.agoda.com.sample.dagger.module.ActivityModule;
import news.agoda.com.sample.dagger.module.NewsFeedFragmentModule;
import news.agoda.com.sample.dagger.scope.MainActivityScope;
import news.agoda.com.sample.view.feed.fragment.NewsFeedFragment;

@Component(modules = {NewsFeedFragmentModule.class, ActivityModule.class}, dependencies = NewsFeedComponent.class)
@MainActivityScope
public interface NewFeedActivityComponent {

    void injectNewsFeedFragment(NewsFeedFragment newsFeedFragment);
}
