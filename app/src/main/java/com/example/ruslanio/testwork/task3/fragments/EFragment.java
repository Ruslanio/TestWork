package com.example.ruslanio.testwork.task3.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ruslanio.testwork.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ruslanio on 27.08.2017.
 */

public class EFragment extends Fragment {
    private EditText etInput;
    private RecyclerView rvMain;
    private RvAdapter adapter;
    private Button btnAdd;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_3_e,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        etInput = (EditText) view.findViewById(R.id.et_input);
        rvMain = (RecyclerView) view.findViewById(R.id.rv_main_e);
        rvMain.setLayoutManager(new LinearLayoutManager(getContext()));

        List<String> strings = new ArrayList<>();
        adapter = new RvAdapter(strings);
        rvMain.setAdapter(adapter);

        btnAdd = (Button) view.findViewById(R.id.btn_3_e);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etInput.getText().toString() != ""){
                    adapter.add(etInput.getText().toString());
                }
            }
        });

    }

    private class RvAdapter extends RecyclerView.Adapter{
        private List<String> strings;

        public RvAdapter(List<String> strings) {
            this.strings = strings;
        }

        public void add(String s){
            strings.add(s);
            notifyDataSetChanged();
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ItemHolder(LayoutInflater.from(getContext()).inflate(R.layout.item_3_e,parent,false));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ((ItemHolder) holder).bind(position);
        }

        @Override
        public int getItemCount() {
            return strings.size();
        }

        private class ItemHolder extends RecyclerView.ViewHolder{
            private TextView tvText;

            public ItemHolder(View itemView) {
                super(itemView);

                tvText = (TextView) itemView.findViewById(R.id.tv_3_e);
            }

            void bind(final int position){
                tvText.setText(strings.get(position));
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        strings.remove(position);
                        notifyDataSetChanged();
                    }
                });
            }
        }
    }

}
