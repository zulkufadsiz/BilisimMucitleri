package com.example.ferhats.recyclecardandrefreshlayoutdenemesi;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ferhats.recyclecardandrefreshlayoutdenemesi.modal.City;
import com.squareup.picasso.Picasso;

import java.util.List;

public class main extends AppCompatActivity {
    private String TAG = main.class.getSimpleName();
    private Context mContext = this;

    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private MyCityListAdapter myCityListAdapter;


    private List<City> mcityList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getListItems();
        setSwipeRefreshLayout();
        setRecyclerView();
    }

    private void getListItems(){
        mcityList = City.createCityList();
    }

    private void setSwipeRefreshLayout(){
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);

        mSwipeRefreshLayout.setColorSchemeResources(
                R.color.refresh_progress_1,
                R.color.refresh_progress_2,
                R.color.refresh_progress_3
        );
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //Refresh işlemi
                getNewCity();
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    private void getNewCity(){
        City antalya = new City();
        antalya.setName("Antalya");
        antalya.setCountry("Turkey");
        antalya.setPopulation("2.2 million");
        antalya.setImage("http://antalyaz.com/wp-content/uploads/st_uploadfont/tr9-300x300.jpeg");

        mcityList.add(0,antalya);

        myCityListAdapter.notifyItemInserted(0);
        mLinearLayoutManager.scrollToPosition(0);
    }

    private void setRecyclerView(){
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setHasFixedSize(true);
        mLinearLayoutManager = new LinearLayoutManager(mContext);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        myCityListAdapter = new MyCityListAdapter();
        mRecyclerView.setAdapter(myCityListAdapter);
    }

    private class MyCityListAdapter extends RecyclerView.Adapter<MyCityListAdapter.MyCityHolder>{
        @Override
        public MyCityHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View rootView = LayoutInflater.from(mContext).inflate(R.layout.custom_recycler_view_row,parent,false);
            return new MyCityHolder(rootView);
        }

        @Override
        public void onBindViewHolder(MyCityHolder holder, int position) {
            City city = mcityList.get(position);

            holder.tvNameOfCity.setText(city.getName());
            holder.tvCountryOfCity.setText(city.getCountry());
            holder.tvPopulationOfCity.setText(city.getPopulation());

            //Image Kısmı
            Picasso.with(mContext)
                    .load(city.getImage())
                    .resize(300, 300)
                    .centerCrop()
                    .into(holder.ivImageOfCity);
        }

        @Override
        public int getItemCount() {
            return mcityList.size();
        }

        public class MyCityHolder extends RecyclerView.ViewHolder{
            ImageView ivImageOfCity;
            TextView tvNameOfCity, tvCountryOfCity, tvPopulationOfCity;

            public MyCityHolder(View rootView) {
                super(rootView);
                ivImageOfCity = (ImageView) rootView.findViewById(R.id.ImageOfCity);

                tvNameOfCity = (TextView) rootView.findViewById(R.id.tvNameOfCity);
                tvCountryOfCity = (TextView) rootView.findViewById(R.id.tvCountryOfCity);
                tvPopulationOfCity = (TextView) rootView.findViewById(R.id.tvPopulationOfCity);

            }
        }
    }
}
