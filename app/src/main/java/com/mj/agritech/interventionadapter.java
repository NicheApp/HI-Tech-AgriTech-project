package com.mj.agritech;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.mj.agritech.Dialoges.AgrialliedDialog;
import com.mj.agritech.Dialoges.Alliedintervention;
import com.mj.agritech.Dialoges.CropCultivationDialog;
import com.mj.agritech.Dialoges.Cropintervention;
import com.mj.agritech.Dialoges.DailyWageDialoge;
import com.mj.agritech.Dialoges.EnterpriseDetailsDialog;
import com.mj.agritech.Dialoges.Enterpriseintervention;
import com.mj.agritech.Dialoges.FamilymemberDialog;
import com.mj.agritech.Dialoges.GeneralInfoDialog;
import com.mj.agritech.Dialoges.IncomeDetailsDialog;
import com.mj.agritech.Dialoges.LandHolding;
import com.mj.agritech.Dialoges.SkillMappingdialog;
import com.mj.agritech.Dialoges.dailywageintervention;
import com.mj.agritech.Dialoges.livestockDialog;
import com.mj.agritech.Dialoges.livestockintervention;
import com.mj.agritech.Dialoges.locationdialog;
import com.mj.agritech.Dialoges.skillmappingintervention;


import java.util.ArrayList;
import java.util.List;


public class interventionadapter extends RecyclerView.Adapter<interventionadapter.ImageViewHolder> {
    public Context mContext;
    public List<String> mUploads;
    public List<String> mUploadscopy;
    public  List<String>mUploadscity;
    public static FragmentManager fm;
    String FAMILY_ID,year;


    ProgressBar progressbaritem;
    int i=0;
    public interventionadapter(Context context, List<String> uploads,FragmentManager fm,String FAMILY_ID,String year) {
        mContext = context;
        mUploads = uploads;
        this.fm = fm;
        this.year=year;
        this.FAMILY_ID=FAMILY_ID;
        mUploadscopy = new ArrayList<>(mUploads);
        mUploadscity = new ArrayList<>(mUploads);
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_baseline, parent, false);


        return new ImageViewHolder(v);
    }
    @Override
    public void onBindViewHolder(ImageViewHolder holder, final int position) {

        // String uploadCurrent = mUploads.get(position);
        holder.baseline_name.setText(mUploads.get(position));

        holder.showdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                List<String> ls=new ArrayList<>();

                ls.add("crop_cultivation");
                ls.add("livestock");ls.add("allied");ls.add("daily_wage");ls.add("skillmapping");ls.add("enterprise_details");
                interventionshowdetails showdetailsbackground=new interventionshowdetails(mContext,fm,position);
                showdetailsbackground.execute(ls.get(position),FAMILY_ID);

            }
        });
        holder.filldetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent intent=new Intent(mContext,Baseline.class);
                // mContext.startActivity(intent);

                List<String> lsnew=new ArrayList<>();

                if(position==0){

                    FragmentTransaction ft = fm.beginTransaction();
                    Fragment prev = fm.findFragmentByTag("dialog");
                    if (prev != null) {
                        ft.remove(prev);
                    }
                    ft.addToBackStack(null);

                    DialogFragment  dialogFragment = new Cropintervention(FAMILY_ID,lsnew,fm);
                    dialogFragment.show(ft, "dialog");
                    //    dialogFragment = new CropCultivationDialog();
                }
                if(position==1){
                    FragmentTransaction ft = fm.beginTransaction();
                    Fragment prev = fm.findFragmentByTag("dialog");
                    if (prev != null) {
                        ft.remove(prev);
                    }
                    ft.addToBackStack(null);

                    DialogFragment  dialogFragment = new livestockintervention(FAMILY_ID,lsnew,fm);
                    dialogFragment.show(ft, "dialog");

                    //    dialogFragment = new livestockDialog();
                }
                if(position==2){


                    FragmentTransaction ft = fm.beginTransaction();
                    Fragment prev = fm.findFragmentByTag("dialog");
                    if (prev != null) {
                        ft.remove(prev);
                    }
                    ft.addToBackStack(null);

                    DialogFragment  dialogFragment = new Alliedintervention(FAMILY_ID,lsnew,fm);
                    dialogFragment.show(ft, "dialog");

                }
                if(position==3){
                    FragmentTransaction ft = fm.beginTransaction();
                    Fragment prev = fm.findFragmentByTag("dialog");
                    if (prev != null) {
                        ft.remove(prev);
                    }
                    ft.addToBackStack(null);

                    DialogFragment  dialogFragment = new dailywageintervention(FAMILY_ID,lsnew,fm);
                    dialogFragment.show(ft, "dialog");
                }
                if(position==4){

                    FragmentTransaction ft = fm.beginTransaction();
                    Fragment prev = fm.findFragmentByTag("dialog");
                    if (prev != null) {
                        ft.remove(prev);
                    }
                    ft.addToBackStack(null);

                    DialogFragment  dialogFragment = new skillmappingintervention(FAMILY_ID,lsnew,fm);
                    dialogFragment.show(ft, "dialog");
                }
                if(position==5){

                    FragmentTransaction ft = fm.beginTransaction();
                    Fragment prev = fm.findFragmentByTag("dialog");
                    if (prev != null) {
                        ft.remove(prev);
                    }
                    ft.addToBackStack(null);

                    DialogFragment  dialogFragment = new Enterpriseintervention(FAMILY_ID,lsnew,fm);
                    dialogFragment.show(ft, "dialog");
                }




            }
        });

    }

    @Override
    public int getItemCount() {
        return mUploads.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {
        public Button filldetails,showdetails;
        public  TextView baseline_name;
        public ImageViewHolder(View itemView) {
            super(itemView);


            filldetails=itemView.findViewById(R.id.filldetailslocation);
            showdetails=itemView.findViewById(R.id.showdetails);
            baseline_name=itemView.findViewById(R.id.baseline_name);


        }
    }

}