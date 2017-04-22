package com.example.tonto.cooky;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by tonto on 4/22/2017.
 */

public class CustomAdapter extends BaseAdapter {
    private Context context;
    private List<RowItem> rowItems;

    public CustomAdapter(Context context, List<RowItem> rowItems) {
        this.context = context;
        this.rowItems = rowItems;
    }

    @Override
    public int getCount() {
        return rowItems.size();
    }

    @Override
    public Object getItem(int position) {
        return rowItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return rowItems.indexOf(getItem(position));
    }

    class ViewHolder {
        ImageView image;
        TextView description;
        TextView title;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item, null);
            viewHolder = new ViewHolder();

            viewHolder.image = (ImageView) convertView.findViewById(R.id.iv_preview);
            viewHolder.description = (TextView) convertView.findViewById(R.id.tv_description);
            viewHolder.title = (TextView) convertView.findViewById(R.id.tv_title);
            RowItem row_pos = rowItems.get(position);
            new DownloadImageTask(viewHolder.image).execute(row_pos.getImage());
            viewHolder.description.setText(row_pos.getDescription());
            viewHolder.title.setText(row_pos.getTitle());

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }
}
