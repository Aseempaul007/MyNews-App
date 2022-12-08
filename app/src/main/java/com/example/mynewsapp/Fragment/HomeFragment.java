package com.example.mynewsapp.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mynewsapp.Adapters.MyPagerAdapter;
import com.example.mynewsapp.Adapters.MyRecyclerViewAdapter;
import com.example.mynewsapp.Models.ModelClass;
import com.example.mynewsapp.Models.UpperModelClass;
import com.example.mynewsapp.R;
import com.example.mynewsapp.RetrofitInterface;
import com.example.mynewsapp.Utilities.MyUtilities;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {

    String apiKey = "d09c1fd9b8194977a1a8534e70e73334";
    ArrayList<ModelClass> modelClassArrayList;
    MyRecyclerViewAdapter adapter;
    String country = "in";
    private RecyclerView recyclerViewHome;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerViewHome = view.findViewById(R.id.recyclerView_home);
        modelClassArrayList = new ArrayList<>();
        recyclerViewHome.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new MyRecyclerViewAdapter(getContext(),modelClassArrayList);
        recyclerViewHome.setAdapter(adapter);

        findNews();

        return view;
    }

    private void findNews() {

        MyUtilities.getRetrofitInstance().getMyNews(country,apiKey)
                .enqueue(new Callback<UpperModelClass>() {
                    @Override
                    public void onResponse(Call<UpperModelClass> call, Response<UpperModelClass> response) {
                        if(response.isSuccessful()){
                            response.body().getArticles();
                            adapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onFailure(Call<UpperModelClass> call, Throwable t) {

                    }
                });
    }
}