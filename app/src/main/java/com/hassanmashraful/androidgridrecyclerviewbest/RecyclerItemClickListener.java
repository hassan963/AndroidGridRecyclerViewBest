package com.hassanmashraful.androidgridrecyclerviewbest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Hassan M.Ashraful on 11/25/2016.
 */

public class RecyclerItemClickListener implements RecyclerView.OnItemTouchListener {

    private OnItemClickListener mListener;

    GestureDetector mGestureDetector;

    public interface OnItemClickListener {
        public void onItemClick(View view, int i);
    }

    public RecyclerItemClickListener(Context c, OnItemClickListener onItemClickListener) {
        mListener = onItemClickListener;
        mGestureDetector = new GestureDetector(c, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        View mChildView = rv.findChildViewUnder(e.getX(), e.getY());
        if ((mChildView != null && mListener != null && mGestureDetector.onTouchEvent(e))) {
            mListener.onItemClick(mChildView, rv.getChildPosition(mChildView));
            return true;
        }
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}
