package com.dwist.mvp.screen.detail;

import com.dwist.mvp.core.data.remote.home.Item;

interface DetailView {

    void showLoading();

    void hideLoading();

    void getDataSuccess(Item item);

    void getDataFail(String message);

    void refreshData();
}
