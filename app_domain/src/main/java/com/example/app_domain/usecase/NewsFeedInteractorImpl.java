package com.example.app_domain.usecase;

import io.reactivex.Observable;
import okhttp3.ResponseBody;

public class NewsFeedInteractorImpl extends AbstractInteractor {
    private FeedRepository mFeedRepository;

    public NewsFeedInteractorImpl(FeedRepository feedRepository) {
        super();
        mFeedRepository = feedRepository;
    }

    @Override
    public Observable<ResponseBody> run() {
        Observable<ResponseBody> obj = mFeedRepository.getNewsFeed();
        return obj;
    }
}
