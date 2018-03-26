package com.itgowo.itgowotool;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.ViewTarget;
import com.bumptech.glide.request.transition.Transition;
import com.itgowo.intelligenttool.IT;

public class MainActivity extends AppCompatActivity {

    private final String jsonstr = "{\"name\":\"张三\",\"age\":33}";
    private ImageView mImageView;
    private LinearLayout mLinearLayout;
    private Fragment mFragment;
    private ImageView mImageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLinearLayout = findViewById(R.id.ll);
        mImageView = findViewById(R.id.img);
        mImageView2 = findViewById(R.id.image2);
        mFragment = getSupportFragmentManager().findFragmentById(R.id.fragment);

        testJson();
        testImage();
    }

    public void testImage() {
        String url1 = "http://h.hiphotos.baidu.com/image/pic/item/622762d0f703918f57e12600583d269758eec4cc.jpg";
        String url2 = "http://a.hiphotos.baidu.com/image/pic/item/a9d3fd1f4134970a889bd63c9fcad1c8a7865d3d.jpg";
        String url3 = "http://f.hiphotos.baidu.com/image/pic/item/c2cec3fdfc03924503023a1c8d94a4c27d1e256a.jpg";

        IT.bindView(mImageView.getContext(), url1, mImageView);
        IT.bindView(mFragment, url2, mImageView2);

        Glide.with(this).load(url3).into(new ViewTarget<View, Drawable>(mLinearLayout) {

            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                mLinearLayout.setBackgroundDrawable(resource);
            }
        });
    }

    public void testJson() {
        Entity mEntity = IT.JsonToObject(jsonstr, Entity.class);
        String mS = IT.ObjectToJson(mEntity);
        System.out.println("mS = " + mS);
    }
}
