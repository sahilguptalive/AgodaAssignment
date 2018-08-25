package news.agoda.com.sample.dagger.module;

import com.example.app_domain.network.APIInterface;

import dagger.Module;
import dagger.Provides;
import news.agoda.com.sample.dagger.scope.NewsFeedApplicationScope;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Module
public class NewsFeedModule {
    public static final String BASE_URL = "https://api.myjson.com/bins/";

    @Provides
    public APIInterface apiClient(Retrofit retrofit) {
        return retrofit.create(APIInterface.class);
    }

    @NewsFeedApplicationScope
    @Provides
    public Retrofit retrofit(JacksonConverterFactory jacksonConverterFactory, RxJava2CallAdapterFactory rxJava2CallAdapterFactory) {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(rxJava2CallAdapterFactory)
                .addConverterFactory(jacksonConverterFactory)
                .build();
    }

    @NewsFeedApplicationScope
    @Provides
    public RxJava2CallAdapterFactory rxJava2CallAdapterFactory() {
        return RxJava2CallAdapterFactory.create();
    }

    @NewsFeedApplicationScope
    @Provides
    public JacksonConverterFactory jacksonConverterFactory() {
        return JacksonConverterFactory.create();
    }

}
