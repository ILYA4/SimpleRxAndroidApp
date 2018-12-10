package com.example.ilya4.simplerxandroidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


public class MainActivity extends AppCompatActivity {

    private TextView tvReact;
    private Observable<String> observable;
    private Observer<String> observer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvReact = findViewById(R.id.tv_react);
        observable = Observable.just("Hello. It's text from RxAndroid");
        observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {
                tvReact.setText(s);
                observable = Observable.just("desara loh e");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                }
            };
        }

    public void onSubcribeNow (View view){
        observable.subscribe(observer);
    }

}
