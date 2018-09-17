package com.temp.demoapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class WorkOrderDetailsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_layout);


        TextView description = (TextView) findViewById(R.id.tv_description);
        TextView planningPlant = (TextView) findViewById(R.id.tv_planningPlant);
        TextView workCenter = (TextView) findViewById(R.id.tv_workCenter);
        TextView typeDescription = (TextView) findViewById(R.id.tv_type);
        TextView functionLoc = (TextView) findViewById(R.id.tv_functionLoc);
        TextView number = (TextView) findViewById(R.id.tv_number);
        ListView notes = (ListView) findViewById(R.id.lv_notes);

        WorkOrder mWorkOrder=(WorkOrder) getIntent().getSerializableExtra("WO");

        description.setText(mWorkOrder.getDescription());
        planningPlant.setText(mWorkOrder.getPlanningPlant());
        workCenter.setText(mWorkOrder.getWorkCenter());
        typeDescription.setText(mWorkOrder.getTypeDesription());
        functionLoc.setText(mWorkOrder.getFunctionLoc());
        number.setText(mWorkOrder.getNumber());
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,mWorkOrder.getNotes());
        notes.setAdapter(adapter);

    }
}
