package com.mj.agritech;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;




public class searchadapter extends RecyclerView.Adapter<searchadapter.ImageViewHolder> implements Filterable {
    public Context mContext;
    public List<Farmer> mUploads;
    public List<Farmer> mUploadscopy;
    public  List<Farmer>mUploadscity;


    public searchadapter(Context context, List<Farmer> uploads) {
        mContext = context;

        mUploads = uploads;
        mUploadscopy = uploads;
        mUploadscity = uploads;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.searchcardview, parent, false);


        return new ImageViewHolder(v);
    }
    @Override
    public void onBindViewHolder(final ImageViewHolder holder, int position) {

        Farmer uploadCurrent = mUploads.get(position);
        holder.farmername.setText(uploadCurrent.getFarmername());
        holder.farmerno.setText(uploadCurrent.getFarmerphone());
        holder.farmeradd.setText(uploadCurrent.getFarmeraddress());
        holder.baseline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext,Baseline.class);
                intent.putExtra("id", mUploads.get(holder.getAdapterPosition()).getFarmerphone());
                intent.putExtra("name", mUploads.get(holder.getAdapterPosition()).getFarmername());
                mContext.startActivity(intent);

            }
        });
        holder.intervention.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext,Interventionclass.class);
                intent.putExtra("id", mUploads.get(holder.getAdapterPosition()).getFarmerphone());
                intent.putExtra("name", mUploads.get(holder.getAdapterPosition()).getFarmername());
                mContext.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return mUploads.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {
        public TextView farmername;
        public TextView farmerno;
        public TextView farmeradd;
        public Button baseline;
        public Button intervention;
        public ImageViewHolder(View itemView) {
            super(itemView);

            farmername = itemView.findViewById(R.id.farmername);
            farmerno = itemView.findViewById(R.id.farmerno_);
            farmeradd = itemView.findViewById(R.id.farmeradd);
            baseline=itemView.findViewById(R.id.baseline);
            intervention=itemView.findViewById(R.id.intervention);
        }
    }

    @Override
   public Filter getFilter() {
        return exampleFilter;
    }
    private  Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Farmer> filteredList = new ArrayList<>();
            if(constraint ==null || constraint.length()== 0){
                filteredList.addAll(mUploadscopy);
            } else{
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (Farmer item : mUploadscopy){
                    if(item.getFarmername().toLowerCase().contains(filterPattern)){
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return  results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mUploads.clear();
            mUploads.addAll((List)results.values);
            notifyDataSetChanged();
        }
    };

  /*    public Filter getFiltercity() {
        return exampleFiltercity;
    }
  private  Filter exampleFiltercity = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Student> filteredList = new ArrayList<>();
            if(constraint ==null || constraint.length()== 0){
                filteredList.addAll(mUploadscity);
            } else{
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (Student item : mUploadscity){
                    if(item.getmSelleraddress().toLowerCase().contains(filterPattern)){
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return  results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mUploads.clear();
            mUploads.addAll((List)results.values);
            notifyDataSetChanged();
        }
    };*/

}