package com.dwist.mvp.screen.detail;

import com.dwist.mvp.core.base.ui.BasePresenter;
import com.dwist.mvp.core.data.remote.home.Item;
import com.dwist.mvp.core.network.NetworkCallback;

public class DetailPresenter extends BasePresenter<DetailView> {

    DetailPresenter(DetailView view) {
        super.attachView(view);
    }

    void loadData(String id) {
        view.showLoading();
        addSubscribe(apiStores.getDetailBook(id), new NetworkCallback<Item>() {
            @Override
            public void onSuccess(Item model) {
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

}