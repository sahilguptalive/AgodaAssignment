package news.agoda.com.sample.view.feed.fragment;

import com.example.app_domain.model.NewsResponseDomain;

import java.util.List;

import news.agoda.com.sample.view.BaseView;

public interface NewsFeedFragView extends BaseView {
    void newsFeedResponse(List<NewsResponseDomain> results);
}
