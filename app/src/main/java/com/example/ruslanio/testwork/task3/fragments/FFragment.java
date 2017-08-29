package com.example.ruslanio.testwork.task3.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ruslanio.testwork.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ruslanio on 27.08.2017.
 */

public class FFragment extends Fragment {
    private RecyclerView rvMain;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_3_f,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvMain = (RecyclerView) view.findViewById(R.id.rv_main_f);
        rvMain.setLayoutManager(new LinearLayoutManager(getContext()));

        List<Integer> items = new ArrayList<>();
        for (int i = 0; i < 20; i++){
            items.add(i);
        }
        rvMain.setAdapter(new RvAdapter(items));

    }

    private class RvAdapter extends RecyclerView.Adapter{
        private List<Integer> items;

        public RvAdapter(List<Integer> items) {
            this.items = items;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ItemHolder(LayoutInflater.from(getContext()).inflate(R.layout.item_3_f,parent,false));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return items.size();
        }

        private class ItemHolder extends RecyclerView.ViewHolder{

            public ItemHolder(View itemView) {
                super(itemView);
            }
        }
    }
}
