package com.lj.dialoglocation;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Window;
import android.view.WindowManager;

public class MyDialog extends Dialog {

    private Context context;

    public MyDialog(Context context) {
        super(context, R.style.MyDialog);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    public void init() {
        setContentView(LayoutInflater.from(context).inflate(R.layout.dialog_layout, null));
    }

    public void showAtLocation(int y) {
        show();
        Window window = getWindow();
        WindowManager.LayoutParams p = window.getAttributes();
        p.width = (int) (UIUtil.getScreenSize(context)[0] * 0.9);
        p.height = 500;
        p.y = y;
        window.setAttributes(p);
    }

    public int getHeight() {
        return 500;
    }
}