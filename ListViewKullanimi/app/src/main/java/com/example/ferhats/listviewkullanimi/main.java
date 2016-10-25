package com.example.ferhats.listviewkullanimi;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class main extends AppCompatActivity {
   private String iller[] = {
            "Adana",
            "Antalya",
            "Bursa",
            "Bilecik",
            "Çanakkale",
            "Denizli",
            "Edirne",
            "Gümüşhane",
            "Hatay",
            "Isparta",
            "İstanbul",
            "Kastamonu"
    };
    private ListView myLovelyList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myLovelyList = (ListView)findViewById(R.id.lv1);
        MyArrayAdapter myArrayAdapter = new MyArrayAdapter(main.this);
        myLovelyList.setAdapter(myArrayAdapter);

    }

    private class MyArrayAdapter extends ArrayAdapter<String>{
        public MyArrayAdapter(Context context) {
            super(context,R.layout.custom_list_item,iller);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rootView = layoutInflater.inflate(R.layout.custom_list_item, parent, false);

            ImageView ivListItemAvatar = (ImageView)rootView.findViewById(R.id.ivItemListAvatar);
            TextView  tvListItemPost = (TextView)rootView.findViewById(R.id.ivItemListPost);
            TextView tvListItemTime = (TextView) rootView.findViewById(R.id.ivItemListTime);

            tvListItemPost.setText(iller[position]);

            if (position %5 == 0){
                ivListItemAvatar.setImageDrawable(getDrawable(R.drawable.adana));
                tvListItemTime.setText("1 dakika önce");
            }else  if (position %5 == 1){
                ivListItemAvatar.setImageDrawable(getDrawable(R.drawable.antalya));
                tvListItemTime.setText("3 dakika önce");
            }else  if (position %5 == 2){
                ivListItemAvatar.setImageDrawable(getDrawable(R.drawable.istanbul));
                tvListItemTime.setText("10 dakika önce");
            }else  if (position %5 == 3){
                ivListItemAvatar.setImageDrawable(getDrawable(R.drawable.yellowstone));
                tvListItemTime.setText("50 dakika önce");
            }else  if (position %5 == 4){
                ivListItemAvatar.setImageDrawable(getDrawable(R.drawable.freedomstatue));
                tvListItemTime.setText("1 saat önce");
            }

            return rootView;
        }

        @Override
        public int getItemViewType(int position) {
            return super.getItemViewType(position);
        }
    }
}
