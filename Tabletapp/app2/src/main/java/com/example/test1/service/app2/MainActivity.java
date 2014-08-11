package com.example.test1.service.app2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {
   // TextView textView;
  //  DBAdapter DB_Handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Generate_Tree> Entry_list = new ArrayList<Generate_Tree>();
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry(1,"test","","","","","",1));
        Entry_list.add(new Generate_Tree(new Project(1,"Project1","Beschreibung 1"),new Experiment(1,"Experiment1","beschreibung1"),entries));




       TextView TextView = (TextView) findViewById(R.id.textView);



      /*   DB_Handler = DBAdapter.getDBAdapterInstance(this);
        try {
            DB_Handler.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            DB_Handler.openDataBase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        textView     = (TextView) findViewById(R.id.textView);
    }*/
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }
    public void buttonEventHandler(View v) {  // butten events

        switch(v.getId()) {  // switch ID button

            case R.id.button:   // button Login
                finish();
System.exit(0);
                break;
        }}
}
