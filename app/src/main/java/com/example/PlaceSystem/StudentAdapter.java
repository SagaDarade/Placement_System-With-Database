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

import com.example.PlaceSystem.Retrofit.StudPojo;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder>
{
private Context mCtx;
private List<StudPojo> productList;
static int s_id;

public StudentAdapter(List<StudPojo> productList, Context mCtx) {
    this.mCtx = mCtx;
    this.productList = productList;
    System.out.println("Total Stusents: "+getItemCount());
}



@NonNull
@Override
public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.time_pass_layout,parent,false);
    StudentViewHolder pholder = new StudentViewHolder(view,mCtx);
    return  pholder;

}

@Override
public void onBindViewHolder(@NonNull StudentViewHolder holder, final int position) {

    final StudPojo studPojo = productList.get(position);
   s_id = studPojo.getSid();
    //tx_sid.setText(productList.get(position).getSid());
    holder.tx_sname.setText(productList.get(position).getName());
    holder.tx_smobile.setText(productList.get(position).getMob1());
    holder.tx_sgender.setText(productList.get(position).getGender());
    holder.tx_saddress.setText(productList.get(position).getAddrs());

    final String rs = ""+productList.get(position).getSid()+") "+productList.get(position).getName()
            +" "+productList.get(position).getMob1()+" "+productList.get(position).getGender()+
            " "+productList.get(position).getAddrs();

    holder.ly.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

           Toast.makeText(mCtx, rs, Toast.LENGTH_SHORT).show();
            Intent i = new Intent(mCtx, Student_Info_Show.class);
            Bundle ban = new Bundle();
            ban.putString("c00cid", "" + productList.get(position).getSid());
            ban.putString("c01Name", productList.get(position).getName());
            ban.putString("c02Addr", productList.get(position).getAddrs());
            ban.putString("c03BDate", productList.get(position).getBirthdate());
            ban.putString("c04Ph1", productList.get(position).getMob1());
            ban.putString("c05Ph2", productList.get(position).getMob2());
            ban.putString("c06Gen", productList.get(position).getGender());
            ban.putString("c07Hsc", productList.get(position).getHsc());
            ban.putString("c08Ssc", productList.get(position).getSsc());
            ban.putString("c09ug", productList.get(position).getUg());
            ban.putString("c10pg", productList.get(position).getPg());
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
    LinearLayout ly;

    public StudentViewHolder(@NonNull View itemView, Context mCtx) {
        super(itemView);

        tx_sid = itemView.findViewById(R.id.tv_sid);
        tx_sname = itemView.findViewById(R.id.tv_sname);
        tx_smobile = itemView.findViewById(R.id.tv_smobile);
        tx_sgender = itemView.findViewById(R.id.tv_sgender);
        tx_saddress = itemView.findViewById(R.id.tv_saddress);
        ly = itemView.findViewById(R.id.ly);


    }
}
}
