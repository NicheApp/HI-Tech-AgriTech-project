package com.mj.agritech;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

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

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import static com.mj.agritech.Baseline.baseline_intervention;

public class showdataadapter extends BaseAdapter implements ListAdapter {
    private List<String> list,list1 ;
    private Context context;
    int position1;
    FragmentManager fm;
    String FAMILY_ID;
    JSONArray jsonArray;
    public  static  JSONArray showjsonarray;
    public  static int mainposition;


public showdataadapter(List<String> list,Context context,int position1,FragmentManager fm,String Family_id,List<String> list1,JSONArray jsonArray) {
        this.list = list;
        this.list1=list1;
        this.context = context;
        this.position1=position1;
        this.fm=fm;
        this.FAMILY_ID=Family_id;
        this.jsonArray=jsonArray;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int pos) {
        return list.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return 0;
        //just return 0 if your list items do not have an Id variable.
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.showdataitem, null);
        }

        //Handle TextView and display string from your list
        TextView listItemText = (TextView)view.findViewById(R.id.list_item_string);
        listItemText.setText(list.get(position));

        //Handle buttons and add onClickListeners
        Button deleteBtn = (Button)view.findViewById(R.id.delete_btn);
        Button addBtn = (Button)view.findViewById(R.id.add_btn);

        deleteBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //do something
                list.remove(position); //or some other task
                notifyDataSetChanged();
            }
        });
        addBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                showjsonarray=jsonArray;
                mainposition=position;
               fm.popBackStackImmediate();
                if(baseline_intervention==0) {
                    if (position1 == 0) {
                        FragmentTransaction ft = fm.beginTransaction();
                        Fragment prev = fm.findFragmentByTag("dialog");
                        if (prev != null) {
                            ft.remove(prev);

                        }
                        ft.addToBackStack(null);
                        DialogFragment dialogFragment = new locationdialog(FAMILY_ID, list1, fm);
                        dialogFragment.show(ft, "dialog");
                    }
                    if (position1 == 1) {
                        FragmentTransaction ft = fm.beginTransaction();
                        Fragment prev = fm.findFragmentByTag("dialog");
                        if (prev != null) {
                            ft.remove(prev);
                        }
                        ft.addToBackStack(null);
                        DialogFragment dialogFragment = new GeneralInfoDialog(FAMILY_ID, list1, fm);
                        dialogFragment.show(ft, "dialog");
                    }

                    if (position1 == 2) {
                        FragmentTransaction ft = fm.beginTransaction();
                        Fragment prev = fm.findFragmentByTag("dialog");
                        if (prev != null) {
                            ft.remove(prev);
                        }
                        ft.addToBackStack(null);
                        DialogFragment dialogFragment = new FamilymemberDialog(FAMILY_ID, list1, fm);
                        dialogFragment.show(ft, "dialog");
                    }
                    if (position1 == 3) {
                        FragmentTransaction ft = fm.beginTransaction();
                        Fragment prev = fm.findFragmentByTag("dialog");
                        if (prev != null) {
                            ft.remove(prev);
                        }
                        ft.addToBackStack(null);
                        DialogFragment dialogFragment = new IncomeDetailsDialog(FAMILY_ID, list1, fm);
                        dialogFragment.show(ft, "dialog");

                        // dialogFragment = new IncomeDetailsDialog();
                    }
                    if (position1 == 4) {
                        FragmentTransaction ft = fm.beginTransaction();
                        Fragment prev = fm.findFragmentByTag("dialog");
                        if (prev != null) {
                            ft.remove(prev);
                        }
                        ft.addToBackStack(null);
                        DialogFragment dialogFragment = new LandHolding(FAMILY_ID, list1, fm);
                        dialogFragment.show(ft, "dialog");
                        //    dialogFragment = new LandHolding();
                    }
                    if (position1 == 5) {
                        FragmentTransaction ft = fm.beginTransaction();
                        Fragment prev = fm.findFragmentByTag("dialog");
                        if (prev != null) {
                            ft.remove(prev);
                        }
                        ft.addToBackStack(null);
                        DialogFragment dialogFragment = new CropCultivationDialog(FAMILY_ID, list1, fm);
                        dialogFragment.show(ft, "dialog");
                        //    dialogFragment = new CropCultivationDialog();
                    }
                    if (position1 == 6) {
                        FragmentTransaction ft = fm.beginTransaction();
                        Fragment prev = fm.findFragmentByTag("dialog");
                        if (prev != null) {
                            ft.remove(prev);
                        }
                        ft.addToBackStack(null);
                        DialogFragment dialogFragment = new livestockDialog(FAMILY_ID, list1, fm);
                        dialogFragment.show(ft, "dialog");

                        //    dialogFragment = new livestockDialog();
                    }
                    if (position1 == 7) {

                        FragmentTransaction ft = fm.beginTransaction();
                        Fragment prev = fm.findFragmentByTag("dialog");
                        if (prev != null) {
                            ft.remove(prev);
                        }
                        ft.addToBackStack(null);
                        DialogFragment dialogFragment = new AgrialliedDialog(FAMILY_ID, list1, fm);
                        dialogFragment.show(ft, "dialog");

                        //    dialogFragment = new AgrialliedDialog();
                    }
                    if (position1 == 8) {
                        FragmentTransaction ft = fm.beginTransaction();
                        Fragment prev = fm.findFragmentByTag("dialog");
                        if (prev != null) {
                            ft.remove(prev);
                        }
                        ft.addToBackStack(null);
                        DialogFragment dialogFragment = new DailyWageDialoge(FAMILY_ID, 2013 + "", list1, fm);
                        dialogFragment.show(ft, "dialog");
                        //    dialogFragment = new DailyWageDialoge();
                    }
                    if (position1 == 9) {
                        FragmentTransaction ft = fm.beginTransaction();
                        Fragment prev = fm.findFragmentByTag("dialog");
                        if (prev != null) {
                            ft.remove(prev);
                        }
                        ft.addToBackStack(null);
                        DialogFragment dialogFragment = new SkillMappingdialog(FAMILY_ID, 2012 + "", list1, fm);
                        dialogFragment.show(ft, "dialog");

                        //    dialogFragment = new SkillMappingdialog();
                    }
                    if (position1 == 10) {
                        FragmentTransaction ft = fm.beginTransaction();
                        Fragment prev = fm.findFragmentByTag("dialog");
                        if (prev != null) {
                            ft.remove(prev);
                        }
                        ft.addToBackStack(null);
                        DialogFragment dialogFragment = new EnterpriseDetailsDialog(FAMILY_ID, list1, fm);
                        dialogFragment.show(ft, "dialog");
                        //    dialogFragment = new EnterpriseDetailsDialog();
                    }

                }else if(baseline_intervention==1)
                {

                    if (position1 == 0) {
                        FragmentTransaction ft = fm.beginTransaction();
                        Fragment prev = fm.findFragmentByTag("dialog");
                        if (prev != null) {
                            ft.remove(prev);

                        }
                        ft.addToBackStack(null);
                        DialogFragment dialogFragment = new Cropintervention(FAMILY_ID, list1, fm);
                        dialogFragment.show(ft, "dialog");
                    }
                    if (position1 == 1) {
                        FragmentTransaction ft = fm.beginTransaction();
                        Fragment prev = fm.findFragmentByTag("dialog");
                        if (prev != null) {
                            ft.remove(prev);
                        }
                        ft.addToBackStack(null);
                        DialogFragment dialogFragment = new livestockintervention(FAMILY_ID, list1, fm);
                        dialogFragment.show(ft, "dialog");
                    }

                    if (position1 == 2) {
                        FragmentTransaction ft = fm.beginTransaction();
                        Fragment prev = fm.findFragmentByTag("dialog");
                        if (prev != null) {
                            ft.remove(prev);
                        }
                        ft.addToBackStack(null);
                        DialogFragment dialogFragment = new Alliedintervention(FAMILY_ID, list1, fm);
                        dialogFragment.show(ft, "dialog");
                    }
                    if (position1 == 3) {
                        FragmentTransaction ft = fm.beginTransaction();
                        Fragment prev = fm.findFragmentByTag("dialog");
                        if (prev != null) {
                            ft.remove(prev);
                        }
                        ft.addToBackStack(null);
                        DialogFragment dialogFragment = new dailywageintervention(FAMILY_ID, list1, fm);
                        dialogFragment.show(ft, "dialog");

                        // dialogFragment = new IncomeDetailsDialog();
                    }
                    if (position1 == 4) {
                        FragmentTransaction ft = fm.beginTransaction();
                        Fragment prev = fm.findFragmentByTag("dialog");
                        if (prev != null) {
                            ft.remove(prev);
                        }
                        ft.addToBackStack(null);
                        DialogFragment dialogFragment = new skillmappingintervention(FAMILY_ID, list1, fm);
                        dialogFragment.show(ft, "dialog");
                        //    dialogFragment = new LandHolding();
                    }
                    if (position1 == 5) {
                        FragmentTransaction ft = fm.beginTransaction();
                        Fragment prev = fm.findFragmentByTag("dialog");
                        if (prev != null) {
                            ft.remove(prev);
                        }
                        ft.addToBackStack(null);
                        DialogFragment dialogFragment = new Enterpriseintervention(FAMILY_ID, list1, fm);
                        dialogFragment.show(ft, "dialog");
                        //    dialogFragment = new CropCultivationDialog();
                    }
                    

                }


              //  notifyDataSetChanged();

            }
        });

        return view;
    }
}