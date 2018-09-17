package com.temp.demoapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class WorkOrderListActivity extends Activity {

    private ArrayList<WorkOrder> mWOList;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.work_order_list);

        initData();
        ListView lv = findViewById(R.id.work_order_lv);
        WorkOrderAdapter adapter = new WorkOrderAdapter();
        adapter.setData(mWOList);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(WorkOrderListActivity.this, WorkOrderDetailsActivity.class);
                intent.putExtra("WO",mWOList.get(position));
                startActivity(intent);

            }
        });
    }


    private void initData() {
        mWOList = new ArrayList<>();

        WorkOrder workOrder = new WorkOrder("Inscpect pump moter","1000-Hamburg","MECHANIK-Mechanical Maintenance",
                "PM51","PZ01-Maintainance Order", "00-B01-2-Pump set 2","","","124578","Very High","05/06/2018");

        WorkOrder workOrder1 = new WorkOrder("Inscpect electric pump moter","1000-Hamburg","MECHANIK-Mechanical Maintenance",
                "PM55","AD01-Maintainance Order", "00-B01-2-Pump set 2","","","124578","Medium","23/08/2018");

        WorkOrder workOrder2 = new WorkOrder("Inscpect electric pump","5670-Hamburg","MECHANIK-Mechanical Maintenance",
                "PM06","ZZ01-Maintainance Order", "00-B01-2-Pump set 2","","","45678","High","15/06/2018");

        WorkOrder workOrder3 = new WorkOrder("Inscpect moter","1230-Hamburg","MECHANIK-Mechanical Maintenance",
                "PM091","PK01-Maintainance Order", "00-B01-2-Pump set 2","","","765578","Very High","22/07/2018");


       ArrayList<String> notes = new ArrayList<>();
       notes.add("Status RECEIVED by user DEUSER");
       notes.add("Status MOVED to defferent location");
       notes.add("Status INTRANSIT");

        workOrder.setNotes(notes);
        workOrder1.setNotes(notes);
        workOrder2.setNotes(notes);
        workOrder3.setNotes(notes);



        mWOList.add(workOrder);
        mWOList.add(workOrder1);
        mWOList.add(workOrder2);
        mWOList.add(workOrder3);
    }
}
