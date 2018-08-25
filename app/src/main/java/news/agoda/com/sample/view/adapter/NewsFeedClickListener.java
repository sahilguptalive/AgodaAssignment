package news.agoda.com.sample.view.adapter;

import com.example.app_domain.model.NewsResponseDomain;

public interface NewsFeedClickListener {
    void listItemClicked(NewsResponseDomain result);
}
