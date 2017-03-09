package com.rizkimufrizal.belajar.retrofit.grid;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 09 March 2017
 * @Time 2:46 PM
 * @Project Belajar-Retrofit
 * @Package com.rizkimufrizal.belajar.retrofit.grid
 * @File GridMarginDecorationRowItem
 */
public class GridMarginDecorationRowItem extends RecyclerView.ItemDecoration {

    private int left;
    private int right;
    private int top;
    private int bottom;

    public GridMarginDecorationRowItem(int left, int right, int top, int bottom) {
        this.left = left;
        this.right = right;
        this.top = top;
        this.bottom = bottom;
    }

    @Override
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        rect.set(left, top, right, bottom);
    }

}
