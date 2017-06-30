package com.example.ajay.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * Created by ajay on 6/8/15.
 */
public class ImageAdapter extends BaseAdapter{
    private Context mContext;
    int[] mImages = { R.drawable.backup_android,R.drawable.under_the_hood,R.drawable.portal_2 };

    public ImageAdapter(Context C){
        mContext = C;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(R.layout.gridview_items,parent,false);
            holder = new ViewHolder(convertView);
//            holder.imageView = new ImageView(mContext);
//            holder.imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//            holder.imageView.setPadding(8,8,8,8);
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.imageView.setImageResource(mImages[position]);
        return convertView;
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


    private static class ViewHolder{
        ImageView imageView;

        ViewHolder(View view){
            imageView = (ImageView) view.findViewById(R.id.iv);
        }
    }
}
