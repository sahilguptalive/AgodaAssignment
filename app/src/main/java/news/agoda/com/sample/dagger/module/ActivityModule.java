package news.agoda.com.sample.dagger.module;

import android.app.Activity;
import android.content.Context;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import news.agoda.com.sample.dagger.scope.MainActivityScope;

@Module
public class ActivityModule {
    Context context;

    public ActivityModule(Activity context) {
        this.context = context;
    }

    @Named("activity_context")
    @MainActivityScope
    @Provides
    public Context context() {
        return this.context;
    }
}
