package news.agoda.com.sample.view.feed;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.example.app_domain.model.NewsResponseDomain;

import news.agoda.com.sample.R;
import news.agoda.com.sample.util.AppUtils;
import news.agoda.com.sample.view.BundleKeys;
import news.agoda.com.sample.view.detail.NewsDetailActivity;
import news.agoda.com.sample.view.detail.fragment.NewsDetailFragment;
import news.agoda.com.sample.view.feed.fragment.NewsFeedFragment;

public class NewsFeedActivity extends FragmentActivity implements NewsFeedFragment.Callbacks {

    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_feed);
        if (findViewById(R.id.item_detail_container) != null) {
            mTwoPane = true;
        }
    }

    @Override
    public void onItemSelected(NewsResponseDomain result) {
        if (mTwoPane) {
            Bundle arguments = new Bundle();
            arguments.putString(BundleKeys.TITLE, result.getTitle());
            arguments.putString(BundleKeys.DESCRIPTION, result.getAbstract());
            arguments.putString(BundleKeys.TITLE_IMAGE_URL, AppUtils.getImageUrlFromResult(result));
            arguments.putString(BundleKeys.FULL_STORY_URL, result.getUrl());
            NewsDetailFragment fragment = new NewsDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction().replace(R.id.item_detail_container, fragment).commit();

        } else {
            if (result != null) {
                Intent detailIntent = new Intent(this, NewsDetailActivity.class);
                detailIntent.putExtra(BundleKeys.TITLE, result.getTitle());
                detailIntent.putExtra(BundleKeys.DESCRIPTION, result.getAbstract());
                detailIntent.putExtra(BundleKeys.TITLE_IMAGE_URL, AppUtils.getImageUrlFromResult(result));
                detailIntent.putExtra(BundleKeys.FULL_STORY_URL, result.getUrl());
                startActivity(detailIntent);
            }
        }

    }
}
