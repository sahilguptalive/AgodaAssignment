package com.example.app_domain.usecase;

import io.reactivex.Observable;
import okhttp3.ResponseBody;

public abstract class AbstractInteractor implements Interactor {

    private volatile boolean mIsRunning;

    AbstractInteractor() {
    }

    public abstract Observable<ResponseBody> run();

    public void cancel() {
        mIsRunning = false;
    }

    public boolean isRunning() {
        return mIsRunning;
    }

    private void onFinished() {
        mIsRunning = false;
    }

    public Observable<ResponseBody> execute() {

        // mark this interactor as running
        this.mIsRunning = true;

        // start running this interactor in a background thread
        // run the main logic
        Observable<ResponseBody> result = run();
        // mark it as finished
        onFinished();
        return result;
    }

}
