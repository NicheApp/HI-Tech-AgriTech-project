package com.mj.agritech;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ReportAdapter extends RecyclerView.Adapter {
    List<ReportModelclass> reportModelclassListList;

    public ReportAdapter(List<ReportModelclass> reportModelclassListList) {
        this.reportModelclassListList = reportModelclassListList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.table_list_item, parent, false);

        return new RowViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        RowViewHolder rowViewHolder = (RowViewHolder) holder;

        int rowPos = rowViewHolder.getAdapterPosition();

        if (rowPos == 0) {
            // Header Cells. Main Headings appear here
            rowViewHolder.serial.setBackgroundResource(R.drawable.table_header_cell_bg);
            rowViewHolder.respondent.setBackgroundResource(R.drawable.table_header_cell_bg);
            rowViewHolder.caste.setBackgroundResource(R.drawable.table_header_cell_bg);
            rowViewHolder.village.setBackgroundResource(R.drawable.table_header_cell_bg);
            rowViewHolder.interventions.setBackgroundResource(R.drawable.table_header_cell_bg);
            rowViewHolder.baseline.setBackgroundResource(R.drawable.table_header_cell_bg);
            rowViewHolder.currentyear.setBackgroundResource(R.drawable.table_header_cell_bg);
            rowViewHolder.percentage.setBackgroundResource(R.drawable.table_header_cell_bg);

            rowViewHolder.serial.setText("S.No");
            rowViewHolder.respondent.setText("Respondent's Name");
            rowViewHolder.caste.setText("Caste");
            rowViewHolder.village.setText("Village");
            rowViewHolder.interventions.setText("Name of Interventions");
            rowViewHolder.baseline.setText("Baseline Income");
            rowViewHolder.currentyear.setText("Current Year");
            rowViewHolder.percentage.setText("Percentage Progress)");
        } else {
            ReportModelclass modal = reportModelclassListList.get(rowPos-1);

            // Content Cells. Content appear here

            rowViewHolder.serial.setBackgroundResource(R.drawable.table_content_cell_bg);
            rowViewHolder.respondent.setBackgroundResource(R.drawable.table_content_cell_bg);
            rowViewHolder.caste.setBackgroundResource(R.drawable.table_content_cell_bg);
            rowViewHolder.village.setBackgroundResource(R.drawable.table_content_cell_bg);
            rowViewHolder.interventions.setBackgroundResource(R.drawable.table_content_cell_bg);
            rowViewHolder.baseline.setBackgroundResource(R.drawable.table_content_cell_bg);
            rowViewHolder.currentyear.setBackgroundResource(R.drawable.table_content_cell_bg);
            rowViewHolder.percentage.setBackgroundResource(R.drawable.table_content_cell_bg);

            rowViewHolder.serial.setText(modal.getSerial()+"");
            rowViewHolder.respondent.setText(modal.getRespondent()+"");
            rowViewHolder.caste.setText(modal.getCaste()+"");
            rowViewHolder.village.setText(modal.getVillage()+"");
            rowViewHolder.interventions.setText(modal.getIntervention()+"");
            rowViewHolder.baseline.setText(modal.getBaselineincome()+"");
            rowViewHolder.currentyear.setText(modal.getCurrentyear()+"");
            rowViewHolder.percentage.setText(modal.getPercentage()+"");
        }
    }

    @Override
    public int getItemCount() {
        return reportModelclassListList.size()+1; // one more to add header row
    }

    public class RowViewHolder extends RecyclerView.ViewHolder {
        TextView serial,respondent,caste,village,interventions,baseline,currentyear,percentage;

        public RowViewHolder(View itemView) {
            super(itemView);
           serial=itemView.findViewById(R.id.serial);
           respondent = itemView.findViewById(R.id.respondent);
            caste = itemView.findViewById(R.id.caste);
            village = itemView.findViewById(R.id.village);
            interventions = itemView.findViewById(R.id.interventions);
            baseline = itemView.findViewById(R.id.baselineincome);
            currentyear = itemView.findViewById(R.id.currentyear);
            percentage = itemView.findViewById(R.id.Progress);


        }
    }
}