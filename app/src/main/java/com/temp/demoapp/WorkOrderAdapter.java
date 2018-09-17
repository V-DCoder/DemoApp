package com.temp.demoapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class WorkOrderAdapter extends BaseAdapter {
    private List<WorkOrder> mList;

    @Override
    public int getCount() {
        return mList == null ? 0 : mList.size();
    }

    @Override
    public WorkOrder getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TextView title;
        TextView priority;
        TextView date;
        TextView type;
        TextView number;

        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.work_order_list_item, null);
        }
        title = (TextView) convertView.findViewById(R.id.title);
        priority = (TextView) convertView.findViewById(R.id.tv_priority);
        number = (TextView) convertView.findViewById(R.id.tv_number);
        date = (TextView) convertView.findViewById(R.id.tv_date);
        type = (TextView) convertView.findViewById(R.id.tv_type);

        title.setText(mList.get(position).getDescription());
        priority.setText(mList.get(position).getPriority());
        number.setText(mList.get(position).getNumber());
        date.setText(mList.get(position).getDate());
        type.setText(mList.get(position).getType());


        return convertView;
    }

    public void setData(ArrayList<WorkOrder> mWOList) {
        this.mList = mWOList;
    }
}
