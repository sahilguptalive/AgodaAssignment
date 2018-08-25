package com.example.app_domain.usecase;

import io.reactivex.Observable;
import okhttp3.ResponseBody;

public interface Interactor {
    Observable<ResponseBody> execute();
}
