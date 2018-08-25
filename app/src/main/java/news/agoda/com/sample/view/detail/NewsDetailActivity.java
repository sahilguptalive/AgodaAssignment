package news.agoda.com.sample.view.detail;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import news.agoda.com.sample.R;
import news.agoda.com.sample.view.BundleKeys;
import news.agoda.com.sample.view.detail.fragment.NewsDetailFragment;

public class NewsDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        if (savedInstanceState == null) {
            Bundle arguments = new Bundle();
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                return;
            }
            String storyURL = extras.getString(BundleKeys.FULL_STORY_URL);
            String title = extras.getString(BundleKeys.TITLE);
            String summary = extras.getString(BundleKeys.DESCRIPTION);
            String imageURL = extras.getString(BundleKeys.TITLE_IMAGE_URL);
            arguments.putString(BundleKeys.FULL_STORY_URL, storyURL);
            arguments.putString(BundleKeys.TITLE, title);
            arguments.putString(BundleKeys.DESCRIPTION, summary);
            arguments.putString(BundleKeys.TITLE_IMAGE_URL, imageURL);
            NewsDetailFragment fragment = new NewsDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction().add(R.id.item_detail_container, fragment).commit();
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}