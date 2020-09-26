package com.example.PlaceSystem;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.PlaceSystem.Retrofit.AdminPolo;

import java.util.List;

public class AdapterAdmin extends RecyclerView.Adapter<AdapterAdmin.StudentViewHolder>
{
    private Context mCtx;
    private List<AdminPolo> productList;
    static int s_id;

    public AdapterAdmin(List<AdminPolo> productList, Context mCtx) {
        this.mCtx = mCtx;
        this.productList = productList;
        System.out.println("Total Stusents: "+getItemCount());
    }



    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.timepass1,parent,false);
        StudentViewHolder pholder = new StudentViewHolder(view,mCtx);
        return  pholder;

    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, final int position) {

        final AdminPolo studPojo = productList.get(position);
        //s_id = ad.getSid();
//        holder.tx_sid.setText(productList.get(position).getAid());
        holder.tx_sname.setText(productList.get(position).getAname());
        holder.tx_smobile.setText(productList.get(position).getAph1());
        holder.tx_sgender.setText(productList.get(position).getAgen());
        holder.tx_saddress.setText(productList.get(position).getAaddress());


        final String rs = ""+productList.get(position).getAid()+") "+productList.get(position).getAname()
                +" "+productList.get(position).getAph1()+" "+productList.get(position).getAgen()+
                " "+productList.get(position).getAaddress();

       holder.ly1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(mCtx, rs, Toast.LENGTH_SHORT).show();
                Intent i = new Intent(mCtx, SendPlaceStudent.class);
                Bundle ban = new Bundle();
                //ban.putString("c00cid", "" + productList.get(position).getSid());
                ban.putString("c01Name", productList.get(position).getAname());
               // ban.putString("c02Addr", productList.get(position).getAddrs());
                //ban.putString("c03BDate", productList.get(position).getBirthdate());
                ban.putString("c04Ph1", productList.get(position).getAph1());
                //ban.putString("c05Ph2", productList.get(position).getMob2());
                //ban.putString("c06Gen", productList.get(position).getGender());
                //ban.putString("c07Hsc", productList.get(position).getHsc());
                //ban.putString("c08Ssc", productList.get(position).getSsc());
                //ban.putString("c09ug", productList.get(position).getUg());
                //ban.putString("c10pg", productList.get(position).getPg());
                ban.putString("c12compname", productList.get(position).getAcompname());
                i.putExtras(ban);
                mCtx.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder {


        TextView tx_sid, tx_sname, tx_smobile, tx_sgender,tx_saddress;
        LinearLayout ly1;

        public StudentViewHolder(@NonNull View itemView, Context mCtx) {
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
