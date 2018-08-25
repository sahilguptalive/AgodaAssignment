package news.agoda.com.sample.dagger.module;


import android.content.Context;

import dagger.Module;
import dagger.Provides;
import news.agoda.com.sample.dagger.scope.ApplicationContext;
import news.agoda.com.sample.dagger.scope.NewsFeedApplicationScope;

@Module
public class ContextModule {

    Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @ApplicationContext
    @NewsFeedApplicationScope
    @Provides
    public Context context() {
        return context.getApplicationContext();
    }
}
