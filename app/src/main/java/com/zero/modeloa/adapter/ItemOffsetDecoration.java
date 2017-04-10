package com.zero.modeloa.adapter;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.IntegerRes;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;

/**
 * Created by ROBIN on 10/04/2017.
 */

public class ItemOffsetDecoration extends RecyclerView.ItemDecoration {
    private int mItemOffset;//La medida en pixeles del espaciado

    public ItemOffsetDecoration(Context context, @IntegerRes int integerResId){
        int itemOffSetDp = context.getResources().getInteger(integerResId);
        mItemOffset = convertToPixel(itemOffSetDp,context.getResources().getDisplayMetrics());
    }

    public int convertToPixel(int dp, DisplayMetrics displayMetrics){
        //Se obtiene la densidad en dp
        return dp * (displayMetrics.densityDpi/160);//Formula para convertir dp en pixels
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.set(mItemOffset, mItemOffset, mItemOffset, mItemOffset);
    }
}
