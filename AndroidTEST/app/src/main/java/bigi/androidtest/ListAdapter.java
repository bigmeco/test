package bigi.androidtest;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by bigi on 28.03.2017.
 */

public class ListAdapter extends ArrayAdapter<ListFail> {

    public ListAdapter(Context context, List<ListFail> listFails) {
        super(context, 0, listFails);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListFail listFail = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.elementspisk, parent, false);
        }
        TextView title = (TextView) convertView.findViewById(R.id.textView2);
        TextView sum = (TextView) convertView.findViewById(R.id.textView);
        title.setText(listFail.title);
        sum.setText(listFail.sum);

        return convertView;
    }
}
