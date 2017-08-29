package com.example.ruslanio.testwork.task3.fragments;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.ruslanio.testwork.R;
import com.example.ruslanio.testwork.task3.listeners.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ruslanio on 27.08.2017.
 */

public class AFragment extends Fragment implements OnItemClickListener {
    private RecyclerView rvMain;
    private RvAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_3_a, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvMain = (RecyclerView) view.findViewById(R.id.rv_main_a);
        rvMain.setLayoutManager(new LinearLayoutManager(getContext()));
        List<ItemA> items = new ArrayList<>();
        for (int i = 0; i < 100; i++){
            items.add(new ItemA("Some Text"));
        }
        adapter = new RvAdapter(items,this);
        rvMain.setAdapter(adapter);


    }

    @Override
    public void onLastElementClick() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Warning!").setMessage("Last Element").setCancelable(true);
        AlertDialog alert = builder.create();
        alert.show();
    }

    private class RvAdapter extends RecyclerView.Adapter {
        private List<ItemA> items;
        private OnItemClickListener onItemClickListener;

        public RvAdapter(List<ItemA> items, OnItemClickListener onItemClickListener) {
            this.items = items;
            this.onItemClickListener = onItemClickListener;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ItemHolder(LayoutInflater.from(getContext()).inflate(R.layout.item_3_a, parent, false));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ((ItemHolder) holder).bind(position);
        }

        @Override
        public int getItemCount() {
            return items.size();
        }

        private class ItemHolder extends RecyclerView.ViewHolder {
            private TextView tvSomeText;
            private Button btnClick;

            public ItemHolder(View itemView) {
                super(itemView);
                tvSomeText = (TextView) itemView.findViewById(R.id.tv_3_a);
                btnClick = (Button) itemView.findViewById(R.id.btn_3_a);
            }

            void bind(final int position) {
                btnClick.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (position == items.size() - 1) {
                            onItemClickListener.onLastElementClick();
                        } else {
                            tvSomeText.setText("Hello World!");
                        }
                    }
                });
            }

        }
    }

    private class ItemA {
        private String text;

        public ItemA(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }

}
