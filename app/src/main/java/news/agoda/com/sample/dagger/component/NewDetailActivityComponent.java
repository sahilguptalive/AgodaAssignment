package news.agoda.com.sample.dagger.component;

import dagger.Component;
import news.agoda.com.sample.dagger.module.NewsDetailFragmentModule;
import news.agoda.com.sample.dagger.scope.MainActivityScope;
import news.agoda.com.sample.view.detail.fragment.NewsDetailFragment;

@Component(modules = {NewsDetailFragmentModule.class}, dependencies = NewsFeedComponent.class)
@MainActivityScope
public interface NewDetailActivityComponent {

    void injectNewsDetailFragment(NewsDetailFragment newsDetailFragment);
}
