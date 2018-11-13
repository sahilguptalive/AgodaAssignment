package domain.news.agoda.com;

import domain.news.agoda.com.network.APIInterface;

import io.reactivex.Observable;
import okhttp3.ResponseBody;

public class NewsFeedRepository implements FeedRepository {

    APIInterface apiInterface;

    public NewsFeedRepository(APIInterface apiInterface) {
        this.apiInterface = apiInterface;
    }

    @Override
    public Observable<ResponseBody> getNewsFeed() {
        return apiInterface.getNewsFeed();
    }

}
