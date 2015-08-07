package com.example.ajay.myapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by ajay on 6/8/15.
 */
public class ImageAdapter extends BaseAdapter{
    private Context mContext;

    public ImageAdapter(Context C){
        mContext = C;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        if(convertView == null){
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(300,300));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8,8,8,8);
        }
        else{
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mImages[position]);
        return imageView;
    }

    public int getCount(){
         return mImages.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public int[] mImages = {
            R.drawable.backup_android,R.drawable.portal_2,
            R.drawable.under_the_hood
    };
}
