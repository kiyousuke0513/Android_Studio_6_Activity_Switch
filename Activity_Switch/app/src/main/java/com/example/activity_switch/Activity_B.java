package com.example.activity_switch;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_B extends AppCompatActivity {

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        //檢查Intent是否有Extra，以判別是否是由Main_Activity跳轉過來
        if(this.getIntent().hasExtra("BK_Color")) {
            Bundle bundle = this.getIntent().getExtras();
            //接收自Main_Activity名為BK_Color的資料
            String BK_Color = bundle.getString("BK_Color");
            //利用BK_Color的資料去抓取相應的Resources
            String resName = "bkcolor_" + BK_Color;
            int resId = getApplicationContext().getResources()
                    .getIdentifier(resName
                            , "drawable"
                            , getPackageName());
            //設定背景顏色為Bundle送來的顏色
            this.getWindow().setBackgroundDrawableResource(resId);
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    public void BTN_TRIG(View view) {
        Intent intent = new Intent();
        intent.setClass(Activity_B.this, MainActivity.class);

        Bundle bundle = new Bundle();//建立Bundle以傳送資料
        String BK_Color = "YL";//傳送給Main_Activity的字串設為Yellow
        bundle.putString("BK_Color", BK_Color);//將顏色資訊put進Bundle
        intent.putExtras(bundle);//將Bundle物件put給intent

        startActivity(intent);

        Activity_B.this.finish();//結束目前 Activity
    }
}

