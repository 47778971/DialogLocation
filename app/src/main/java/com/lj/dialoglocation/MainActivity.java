package com.lj.dialoglocation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.image);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDialog dialog = new MyDialog(MainActivity.this);
                int[] locs = new int[2];
                imageView.getLocationOnScreen(locs);
                int imageHeight = imageView.getHeight();
                int anchorHeight = locs[1];
                int screenHeight = UIUtil.getScreenRealHeight(MainActivity.this);
                int dialogHeight = dialog.getHeight();
                int bottomHeight = UIUtil.getBottomBarHeight();
                int statusHeight = UIUtil.getStatusHeight(MainActivity.this);
                if (screenHeight - anchorHeight - imageHeight - bottomHeight >= dialogHeight) {
                    dialog.showAtLocation(anchorHeight + imageHeight - (screenHeight - dialogHeight + statusHeight) / 2);
                } else {
                    dialog.showAtLocation(anchorHeight - dialogHeight - (screenHeight - dialogHeight + statusHeight) / 2);
                }
            }
        });
    }
}