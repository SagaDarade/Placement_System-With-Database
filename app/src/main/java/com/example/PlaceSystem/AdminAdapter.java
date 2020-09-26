package com.example.PlaceSystem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.PlaceSystem.Retrofit.AdminPolo;

import java.util.List;

public class AdminAdapter extends RecyclerView.Adapter<AdminAdapter.AdminViewHolder> {

    private Context mCtx;
    private List<AdminPolo> studentlist;


    public  AdminAdapter(Context mCtx,List<AdminPolo> studentlist){

        this.mCtx = mCtx;
        this.studentlist=studentlist;
        System.out.println("Total Customers: "+getItemCount());
    }

    @NonNull
    @Override
    public AdminViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.timepass1,parent,false);
        AdminViewHolder cholder = new AdminAdapter.AdminViewHolder(view,mCtx);
        return cholder;


    }

    @Override
    public void onBindViewHolder(@NonNull AdminAdapter.AdminViewHolder holder, int position) {

        AdminPolo product=studentlist.get(position);

        holder.tx_sname.setText(studentlist.get(position).getAname());
        holder.tx_smobile.setText(studentlist.get(position).getAph1());
        holder.tx_sgender.setText(studentlist.get(position).getAgen());
        holder.tx_saddress.setText(studentlist.get(position).getAaddress());

    }

    @Override
    public int getItemCount() {
        return studentlist.size();
    }

    public class AdminViewHolder extends RecyclerView.ViewHolder {
        TextView tx_sid, tx_sname, tx_smobile, tx_sgender,tx_saddress;
        LinearLayout ly1;

        public AdminViewHolder(@NonNull View itemView, Context mCtx) {
            super(itemView);

            tx_sid = itemView.findViewById(R.id.tv_sid);
            tx_sname = itemView.findViewById(R.id.tv_sname);
            tx_smobile = itemView.findViewById(R.id.tv_smobile);
            tx_sgender = itemView.findViewById(R.id.tv_sgender);
            tx_saddress = itemView.findViewById(R.id.tv_saddress);
            ly1 = itemView.findViewById(R.id.ly1);
        }
    }
}

