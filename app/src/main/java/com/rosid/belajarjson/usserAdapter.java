package com.rosid.belajarjson;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rosid.belajarjson.R;

import java.util.ArrayList;

public class usserAdapter extends RecyclerView.Adapter<usserAdapter.UsserViewHolder> {

    private ArrayList<Usser> dataList;

    public usserAdapter(ArrayList<Usser> dataList) {
            this.dataList = dataList;
    }

    @Override

    public UsserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_view, parent, false);
        return new UsserViewHolder(view);
    }

        @Override

        public void onBindViewHolder(UsserViewHolder holder, int position) {
            holder.txtID.setText(dataList.get(position).getId());
            holder.txtNama.setText(dataList.get(position).getNama());
            holder.txtEmail.setText(dataList.get(position).getEmail());

        }
        @Override
        public int getItemCount() {
            return (dataList != null) ? dataList.size() : 0;
        }

        public class UsserViewHolder extends RecyclerView.ViewHolder{
            private TextView txtID, txtNama, txtEmail;

            public UsserViewHolder(View itemView) {
                super(itemView);
                txtID = (TextView) itemView.findViewById(R.id.textID);
                txtNama = (TextView) itemView.findViewById(R.id.textNama);
                txtEmail = (TextView) itemView.findViewById(R.id.textEmail);
            }
        }
}
