package news.agoda.com.sample.dagger.module;

import android.content.Context;

import com.example.app_domain.NewsFeedEntityDomainMapper;
import com.example.app_domain.network.APIInterface;
import com.example.app_domain.usecase.NewsFeedInteractorImpl;
import com.example.app_domain.usecase.NewsFeedRepository;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import news.agoda.com.sample.dagger.scope.MainActivityScope;
import news.agoda.com.sample.view.adapter.NewsListAdapter;
import news.agoda.com.sample.view.feed.fragment.NewsFeedFragment;
import news.agoda.com.sample.view.feed.fragment.NewsFeedFragmentPresenter;

@Module(includes = ActivityModule.class)
public class NewsFeedFragmentModule {
    private final NewsFeedFragment newsFeedFragment;

    public NewsFeedFragmentModule(NewsFeedFragment newsFeedActivity) {
        this.newsFeedFragment = newsFeedActivity;
    }

    @Provides
    @MainActivityScope
    public NewsListAdapter newsFeedAdapter(@Named("activity_context") Context context) {
        return new NewsListAdapter(context);
    }

    @Provides
    @MainActivityScope
    public NewsFeedFragmentPresenter newsFeedPresenter(NewsFeedInteractorImpl newsFeedInteractor, NewsFeedEntityDomainMapper newsFeedEntityDomainMapper) {
        return new NewsFeedFragmentPresenter(newsFeedFragment, newsFeedInteractor, newsFeedEntityDomainMapper);
    }

    @Provides
    @MainActivityScope
    public NewsFeedInteractorImpl newsFeedInteractor(NewsFeedRepository newsFeedRepository) {
        return new NewsFeedInteractorImpl(newsFeedRepository);
    }

    @Provides
    @MainActivityScope
    public NewsFeedRepository newFeedRepository(APIInterface apiInterface) {
        return new NewsFeedRepository(apiInterface);
    }

    @Provides
    @MainActivityScope
    public NewsFeedEntityDomainMapper newsFeedEntityDomaninMapper() {
        return new NewsFeedEntityDomainMapper();
    }
}
