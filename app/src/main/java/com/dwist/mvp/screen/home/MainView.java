package com.dwist.mvp.screen.home;

import android.content.Intent;

import com.dwist.mvp.core.data.remote.home.Books;

interface MainView {
    void showLoading();

    void hideLoading();

    void getDataSuccess(Books model);

    void getDataFail(String message);

    void moveToDetail(Intent intent);

}
