package com.temp.demoapp;

import android.app.Activity;
import android.location.Criteria;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Notification;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.operators.observable.ObservableFromCallable;
import io.reactivex.schedulers.Schedulers;

public class LoginActivity extends Activity {

    private String USERNAME = "gokul1";
    private String PASSWORD = "server1234";
    private TextView username;
    private TextView password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        Button b = findViewById(R.id.btn_login);
        username = (TextView) findViewById(R.id.username);
        password = (TextView) findViewById(R.id.password);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (true || validate()) {
//                    Intent intent = new Intent(LoginActivity.this, WorkOrderListActivity.class);
//                    startActivity(intent);
//                    finish();
//                }
                initDemo();
            }
        });
    }

    private void initDemo() {
//        CompositeDisposable compositeDisposable = new CompositeDisposable();
//       performaer(5).subscribe(new Consumer<String>() {
//            @Override
//            public void accept(String aBoolean) throws Exception {
//                Log.w("sadasdas", "from accept");
//            }
//        });

        ObservableFromCallable.timer(5, TimeUnit.SECONDS).doOnEach(new Consumer<Notification<Long>>() {
            @Override
            public void accept(Notification<Long> longNotification) throws Exception {
                Log.w("sadasdas", "on each " + longNotification.getValue());
            }
        }).doOnNext(new Consumer<Long>() {
            @Override
            public void accept(Long aLong) throws Exception {
                Log.w("sadasdas", "on next " + aLong);
            }
        }).
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();

//        SingleFromCallable.timer(5, TimeUnit.SECONDS).doOnSuccess(new Consumer<Long>() {
//            @Override
//            public void accept(Long aLong) throws Exception {
//                Log.w("sadasdas", "from accept");
//            }
//        }).subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe();

    }

    private Observable<String> performaer(int millis) {
        String[] items = {"one", "two", "three", "four", "five", "six"};
        return Observable.fromArray(items)
                .debounce(30, TimeUnit.SECONDS)
                .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread());

    }

    private Boolean getSomeValue() {
        return true;
    }

    private void initLocation() {
        final LocationManager manager = (LocationManager) getSystemService(LOCATION_SERVICE);
        List<String> providerList = manager.getAllProviders();
        Criteria criteria = new Criteria();
        criteria.setAltitudeRequired(true);
        criteria.setAccuracy(Criteria.ACCURACY_FINE);
        manager.getBestProvider(criteria, true);
    }


    private boolean validate() {

        if (!username.getText().toString().equalsIgnoreCase(USERNAME)) {
            Toast.makeText(this, "User not found.", Toast.LENGTH_LONG).show();
            return false;
        }
        if (!password.getText().toString().equalsIgnoreCase(PASSWORD)) {
            Toast.makeText(this, "Password do not match", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }
}
