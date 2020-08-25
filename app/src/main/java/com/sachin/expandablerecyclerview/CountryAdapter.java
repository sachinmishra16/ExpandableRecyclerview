package com.sachin.expandablerecyclerview;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryHolder>
{

    Context context;
    ArrayList<Capitals> capitalsArrayList;
    int expand=0;

    public CountryAdapter(Context context, ArrayList<Capitals> capitalsArrayList) {
        this.context = context;
        this.capitalsArrayList = capitalsArrayList;
    }

    @NonNull
    @Override
    public CountryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.details_item_view,parent,false);
        return new CountryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CountryHolder holder, final int position) {

        int pos=position;

        holder.expandableLayout.setVisibility(View.GONE);
        holder.tv_Country.setText(capitalsArrayList.get(position).getCountry());
        Glide.with(context).load(capitalsArrayList.get(position).getImages_flag()).into(holder.imFlag);
        holder.tv_capital.setText(capitalsArrayList.get(position).getCapital());

        boolean isExpand=capitalsArrayList.get(position).isExpand();


           // holder.expandableLayout.setVisibility(isExpand? View.VISIBLE:View.GONE);

            if (isExpand)
            {
                holder.expandableLayout.setVisibility(View.VISIBLE);
            }
            else
            {
                holder.expandableLayout.setVisibility(View.GONE);
            }

       holder. itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Capitals capitals=capitalsArrayList.get(position);

                //capitals.setExpand(!capitals.isExpand());
                if (capitals.isExpand()==false)
                {
                    capitals.setExpand(true);
                }
                else
                {
                    capitals.setExpand(false);
                }
                notifyItemChanged(position);

            }
        });

    }

    @Override
    public int getItemCount() {
        return capitalsArrayList.size();
    }

    public class CountryHolder extends RecyclerView.ViewHolder {

        LinearLayout expandableLayout;
        ImageView imFlag;
        TextView tv_Country,tv_capital;
        public CountryHolder(@NonNull View itemView) {
            super(itemView);

            imFlag=itemView.findViewById(R.id.imageViewflag);
            tv_capital=itemView.findViewById(R.id.tvCapital);
            tv_Country=itemView.findViewById(R.id.tvCountry);
            expandableLayout=itemView.findViewById(R.id.expandableLayout);

          /*  itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Capitals capitals=capitalsArrayList.get(getAdapterPosition());
                    capitals.setExpand(!capitals.isExpand());
                    notifyItemChanged(getAdapterPosition());

                }
            });*/

        }
    }
}
