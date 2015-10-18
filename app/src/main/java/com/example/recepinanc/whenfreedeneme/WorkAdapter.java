package com.example.recepinanc.whenfreedeneme;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by recepinanc on 11/10/15.
 */
public class WorkAdapter extends BaseAdapter {

    private Context mContext;
    ArrayList<Work> works;

    public WorkAdapter(Context applicationContext, ArrayList<Work> works) {
    }

    @Override
    public int getCount() {
        return works.size();
    }

    @Override
    public Object getItem(int position) {
        return works.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {

            LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.work_item_layout,parent,false);

            TextView title = (TextView) convertView.findViewById(R.id.title_textView);
            TextView category = (TextView) convertView.findViewById(R.id.category_textView);
            TextView date = (TextView) convertView.findViewById(R.id.date_textView);
            TextView time = (TextView) convertView.findViewById(R.id.time_textView);

            Work work = works.get(position);

            title.setText(work.getmTitle());
            category.setText(work.getmCategory());

            return convertView;
        } else {
        }
        return null;
    }

    public static class ViewHolder {
        TextView mTitle;
        TextView mDate;
        CheckBox mIsDone;
        int background;
    }
}
