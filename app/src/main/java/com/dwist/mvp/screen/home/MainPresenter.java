package com.dwist.mvp.screen.home;

import android.app.Activity;
import android.content.Intent;

import com.dwist.mvp.core.base.ui.BasePresenter;
import com.dwist.mvp.screen.detail.DetailActivity;
import com.dwist.mvp.core.data.remote.home.Books;
import com.dwist.mvp.core.data.remote.home.Item;
import com.dwist.mvp.core.network.NetworkCallback;

class MainPresenter extends BasePresenter<MainView> {

    MainPresenter(MainView view) {
        super.attachView(view);
    }

    void loadData(String key) {
        view.showLoading();
        addSubscribe(apiStores.getTopBooks(key), new NetworkCallback<Books>() {
            @Override
            public void onSuccess(Books model) {
                view.getDataSuccess(model);
            }

            @Override
            public void onFailure(String message) {
                view.getDataFail(message);
            }

            @Override
            public void onFinish() {
                view.hideLoading();
            }
        });
    }

    void getItem(Item item, Activity activity) {
        Intent intent = new Intent(activity, DetailActivity.class);
        intent.putExtra("id", item.getId());
        view.moveToDetail(intent);
    }
}