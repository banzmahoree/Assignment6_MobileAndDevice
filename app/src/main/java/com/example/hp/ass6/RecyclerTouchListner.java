package com.example.hp.ass6;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;


public class RecyclerTouchListner implements RecyclerView.OnItemTouchListener {
    private ClickListener clicklistener;
    private GestureDetector gestureDetector;

    @Override
    public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
        View child = recyclerView.findChildViewUnder(motionEvent.getX(),motionEvent.getY());
        if(child != null && clicklistener != null && gestureDetector.onTouchEvent(motionEvent)){
            clicklistener.onClick(child,recyclerView.getChildAdapterPosition(child));
        }
        return false;
    }

    @Override
    public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean b) {

    }

    public interface ClickListener{
        void onClick(View view,int position);
        void onLongClick(View view,int position);
    }
    public RecyclerTouchListner(Context context,
                                final RecyclerView recycleView,
                                final ClickListener clicklistener)
    {
        this.clicklistener = clicklistener;
        gestureDetector = new GestureDetector(context,
                new GestureDetector.SimpleOnGestureListener(){
                    @Override
                    public boolean onSingleTapUp(MotionEvent e) {
                        return true;
                    }

                    @Override
                    public void onLongPress(MotionEvent e) {
                        View child = recycleView.findChildViewUnder(e.getX(),e.getY());
                        if(child != null && clicklistener != null){
                            clicklistener.onLongClick(child,
                                    recycleView.getChildAdapterPosition(child));
                        }
                    }
                });
    }
}
