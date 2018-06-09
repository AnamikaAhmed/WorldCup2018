package com.codingdemos.worldcup;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ScheduleFragment extends Fragment {

    View view;
    public ListView listView;


    public ScheduleFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.fragment_schedule, container, false);
        listView = (ListView) view.findViewById(R.id.lvMain);


        setupListView();
        return view;

    }


    private void setupListView() {

        String[] title = getResources().getStringArray(R.array.Main);
        String[] description1 = getResources().getStringArray(R.array.Description1);
        String[] description2 = getResources().getStringArray(R.array.Description2);
        String[] description3 = getResources().getStringArray(R.array.Description3);

        SimpleAdapter simpleAdapter = new SimpleAdapter(getActivity(), title, description1, description2, description3);
        listView.setAdapter(simpleAdapter);


    }


    public class SimpleAdapter extends BaseAdapter {

        private Context mContext;
        private LayoutInflater layoutInflater;
        private TextView title, description1, description2, description3;
        private String[] titleArray;
        private String[] description01;
        private String[] description02;
        private String[] description03;


        public SimpleAdapter(Context context, String[] title, String[] description1, String[] description2, String[] description3) {
            mContext = context;
            titleArray = title;
            description01 = description1;
            description02 = description2;
            description03 = description3;
            layoutInflater = LayoutInflater.from(context);
        }


        @Override
        public int getCount() {
            return titleArray.length;
        }

        @Override
        public Object getItem(int position) {
            return titleArray[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = layoutInflater.inflate(R.layout.main_activity_single_item, null);
            }

            title = (TextView) convertView.findViewById(R.id.tvMain);
            description1 = (TextView) convertView.findViewById(R.id.tvDescription);
            description2 = (TextView) convertView.findViewById(R.id.description2);
            description3 = (TextView) convertView.findViewById(R.id.description3);

            title.setText(titleArray[position]);
            description1.setText(description01[position]);
            description2.setText(description02[position]);
            description3.setText(description03[position]);


            return convertView;

        }


    }
}