package domain.news.agoda.com.network;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;

public interface APIInterface {
    @GET("nl6jh")
    Observable<ResponseBody> getNewsFeed();
}
