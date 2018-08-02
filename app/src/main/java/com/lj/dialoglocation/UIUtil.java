package com.lj.dialoglocation;

import android.content.Context;
import android.view.WindowManager;

public class UIUtil {

    public static int[] getScreenSize(Context context) {
        int[] size = new int[2];
        final WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        size[0] = wm.getDefaultDisplay().getWidth();
        size[1] = wm.getDefaultDisplay().getHeight();
        return size;
    }

    public static int getStatusHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    public static int getBottomBarHeight() {
        return 150;
    }
}
