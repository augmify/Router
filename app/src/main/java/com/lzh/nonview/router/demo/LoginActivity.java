package com.lzh.nonview.router.demo;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;

import com.lzh.nonview.router.Router;
import com.lzh.nonview.router.route.ActivityRouteBundleExtras;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends Activity {
    private Uri uri;
    private ActivityRouteBundleExtras extras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        uri = getIntent().getParcelableExtra("uri");
        extras = getIntent().getParcelableExtra("extra");
    }

    @OnClick(R.id.login)
    void onLoginClick () {
        DataManager.INSTANCE.setLogin(true);
        Router.create(uri).getActivityRoute().replaceBundleExtras(extras).open(this);
        finish();
    }
}
