package com.mj.agritech;
import android.content.Context;
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
import com.mj.agritech.Dialoges.CropCultivationDialog;
import com.mj.agritech.Dialoges.DailyWageDialoge;
import com.mj.agritech.Dialoges.EnterpriseDetailsDialog;
import com.mj.agritech.Dialoges.FamilymemberDialog;
import com.mj.agritech.Dialoges.GeneralInfoDialog;
import com.mj.agritech.Dialoges.IncomeDetailsDialog;
import com.mj.agritech.Dialoges.LandHolding;
import com.mj.agritech.Dialoges.SkillMappingdialog;
import com.mj.agritech.Dialoges.livestockDialog;
import com.mj.agritech.Dialoges.locationdialog;


import java.util.ArrayList;
import java.util.List;


public class baselineadapter extends RecyclerView.Adapter<baselineadapter.ImageViewHolder> {
    public Context mContext;
    public List<String> mUploads;
    public List<String> mUploadscopy;
    public  List<String>mUploadscity;
    public static FragmentManager fm;
    String FAMILY_ID;


    ProgressBar progressbaritem;
    int i=0;
    public baselineadapter(Context context, List<String> uploads,FragmentManager fm,String FAMILY_ID) {
        mContext = context;
        mUploads = uploads;
        this.fm = fm;
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
ls.add("location");ls.add("info");ls.add("familymember");ls.add("incomedetails");ls.add("land_holding");ls.add("crop_cultivation");
ls.add("livestock");ls.add("allied");ls.add("daily_wage");ls.add("skillmapping");ls.add("enterprise_details");
                   showdetailsbackground showdetailsbackground=new showdetailsbackground(mContext,fm);
                        showdetailsbackground.execute(ls.get(position),FAMILY_ID);

            }
        });
        holder.filldetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Intent intent=new Intent(mContext,Baseline.class);
               // mContext.startActivity(intent);


                if(position==0){
                    FragmentTransaction ft = fm.beginTransaction();
                    Fragment prev = fm.findFragmentByTag("dialog");
                    if (prev != null) {
                        ft.remove(prev);
                    }
                    ft.addToBackStack(null);
                    DialogFragment dialogFragment = new locationdialog(FAMILY_ID);
                    dialogFragment.show(ft, "dialog");
                }
                if(position==1){
                    FragmentTransaction ft = fm.beginTransaction();
                    Fragment prev = fm.findFragmentByTag("dialog");
                    if (prev != null) {
                        ft.remove(prev);
                    }
                    ft.addToBackStack(null);
                    DialogFragment dialogFragment = new GeneralInfoDialog(FAMILY_ID);
                    dialogFragment.show(ft, "dialog");}

                if(position==2){
                    FragmentTransaction ft = fm.beginTransaction();
                    Fragment prev = fm.findFragmentByTag("dialog");
                    if (prev != null) {
                        ft.remove(prev);
                    }
                    ft.addToBackStack(null);
                    DialogFragment dialogFragment = new FamilymemberDialog(FAMILY_ID);
                    dialogFragment.show(ft, "dialog");}
                if(position==3){
                    FragmentTransaction ft = fm.beginTransaction();
                    Fragment prev = fm.findFragmentByTag("dialog");
                    if (prev != null) {
                        ft.remove(prev);
                    }
                    ft.addToBackStack(null);
                    DialogFragment dialogFragment = new IncomeDetailsDialog(FAMILY_ID);
                    dialogFragment.show(ft, "dialog");

                   // dialogFragment = new IncomeDetailsDialog();
                }
                if(position==4){
                    FragmentTransaction ft = fm.beginTransaction();
                    Fragment prev = fm.findFragmentByTag("dialog");
                    if (prev != null) {
                        ft.remove(prev);
                    }
                    ft.addToBackStack(null);
                    DialogFragment dialogFragment = new LandHolding(FAMILY_ID);
                    dialogFragment.show(ft, "dialog");
                //    dialogFragment = new LandHolding();
                }
                if(position==5){
                    FragmentTransaction ft = fm.beginTransaction();
                    Fragment prev = fm.findFragmentByTag("dialog");
                    if (prev != null) {
                        ft.remove(prev);
                    }
                    ft.addToBackStack(null);
                    DialogFragment dialogFragment = new CropCultivationDialog(FAMILY_ID);
                    dialogFragment.show(ft, "dialog");
                //    dialogFragment = new CropCultivationDialog();
                }
                if(position==6){
                    FragmentTransaction ft = fm.beginTransaction();
                    Fragment prev = fm.findFragmentByTag("dialog");
                    if (prev != null) {
                        ft.remove(prev);
                    }
                    ft.addToBackStack(null);
                    DialogFragment dialogFragment = new livestockDialog(FAMILY_ID);
                    dialogFragment.show(ft, "dialog");

                //    dialogFragment = new livestockDialog();
                }
                if(position==7){

                    FragmentTransaction ft = fm.beginTransaction();
                    Fragment prev = fm.findFragmentByTag("dialog");
                    if (prev != null) {
                        ft.remove(prev);
                    }
                    ft.addToBackStack(null);
                    DialogFragment dialogFragment = new AgrialliedDialog(FAMILY_ID);
                    dialogFragment.show(ft, "dialog");

                //    dialogFragment = new AgrialliedDialog();
                }
                if(position==8){
                    FragmentTransaction ft = fm.beginTransaction();
                    Fragment prev = fm.findFragmentByTag("dialog");
                    if (prev != null) {
                        ft.remove(prev);
                    }
                    ft.addToBackStack(null);
                    DialogFragment dialogFragment = new DailyWageDialoge(FAMILY_ID,2013+"");
                    dialogFragment.show(ft, "dialog");
                //    dialogFragment = new DailyWageDialoge();
                }
                if(position==9){
                    FragmentTransaction ft = fm.beginTransaction();
                    Fragment prev = fm.findFragmentByTag("dialog");
                    if (prev != null) {
                        ft.remove(prev);
                    }
                    ft.addToBackStack(null);
                    DialogFragment dialogFragment = new SkillMappingdialog(FAMILY_ID,2012+"");
                    dialogFragment.show(ft, "dialog");

                //    dialogFragment = new SkillMappingdialog();
                }
                if(position==10){
                    FragmentTransaction ft = fm.beginTransaction();
                    Fragment prev = fm.findFragmentByTag("dialog");
                    if (prev != null) {
                        ft.remove(prev);
                    }
                    ft.addToBackStack(null);
                    DialogFragment dialogFragment = new EnterpriseDetailsDialog(FAMILY_ID);
                    dialogFragment.show(ft, "dialog");
                //    dialogFragment = new EnterpriseDetailsDialog();
                }
                if(position==11){
                //    dialogFragment = new locationdialog();
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