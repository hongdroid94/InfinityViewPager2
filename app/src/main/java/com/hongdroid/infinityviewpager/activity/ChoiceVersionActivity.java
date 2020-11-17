package com.hongdroid.infinityviewpager.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hongdroid.infinityviewpager.R;

/**
 * 리사이클러 or 프래그먼트 버전을 고르는 액티비티
 * 원하시는 어댑터 버전 형태로 소스 활용하세요
 */
public class ChoiceVersionActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_version);

        setInit();
    }

    private void setInit() {
        Button btn_recycler = findViewById(R.id.btn_recycler);
        Button btn_fragment = findViewById(R.id.btn_fragment);
        btn_recycler.setOnClickListener(this);
        btn_fragment.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btn_recycler:
                startActivity(new Intent(ChoiceVersionActivity.this, RecyclerVersionActivity.class));
                break;

            case R.id.btn_fragment:
                startActivity(new Intent(ChoiceVersionActivity.this, FragVersionActivity.class));
                break;
        }
    }
}