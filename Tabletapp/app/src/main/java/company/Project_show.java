package company;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;

import com.example.test1.tabletapp.app.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import imports.Entry;
import imports.Experiment;
import imports.Project;

public class Project_show extends Activity {

    private static int experiment_Selected;
    private static int project_Selected;


    private static List<ExperimentEntry>  experimentEntries;
    private static List<ExperimentEntry>  experimentEntries1;
   private static List<ProjectExperimentEntry> projectExperimentEntries;
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    public static int getExperiment_Selected() {
        return experiment_Selected;
    }
    public static int getProject_Selected() {
        return project_Selected;
    }

    public static void setProjectExperimentEntries(List<ProjectExperimentEntry> projectExperimentEntries) {
        Project_show.projectExperimentEntries = projectExperimentEntries;
    }

    public static List<ProjectExperimentEntry> getProjectExperimentEntries() {
        return projectExperimentEntries;
    }

    @Override

        public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.project_show);
        ActivityRegistry.register(this);

        List<Entry> entries;
        List<Entry> entries1;
        List<Entry> entries2;
        entries = new ArrayList<Entry>() ;
        entries1 = new ArrayList<Entry>() ;
        entries2 = new ArrayList<Entry>();

        entries1.add(new Entry(1,"hallo","Inhalt 1","","","",1,true));
        entries1.add(new Entry(2,"hallo2","Inhalt 2","","","",1,true));

        entries2.add(new Entry(1,"1234","Inhalt 1","","","",1,true  ));
        entries2.add(new Entry(2,"1342","Inhalt 2","","","",1,true));

        entries.add(new Entry(1,"test","","","","",1,true));
        entries.add(new Entry(2,"test2","","","","",1,true));
        entries.add(new Entry(1,"test3","","","","",1,true));
        entries.add(new Entry(2,"test4","","","","",1,true));
        experimentEntries = new ArrayList<ExperimentEntry>();
        experimentEntries1 = new ArrayList<ExperimentEntry>();

        experimentEntries1.add(new ExperimentEntry(new Experiment(1,1,"Experiment1","beschreibung1"),entries2));

        projectExperimentEntries = new ArrayList<ProjectExperimentEntry>();


        experimentEntries.add(new ExperimentEntry(new Experiment(1,1,"Experiment1","beschreibung1"),entries));
        experimentEntries.add(new ExperimentEntry(new Experiment(2,1,"Experiment2","beschreibung2"),entries1));



        projectExperimentEntries.add(new ProjectExperimentEntry(new Project(1,"Project1","Beschreibung 1"),experimentEntries));
        projectExperimentEntries.add(new ProjectExperimentEntry(new Project(1,"Project2","Beschreibung 2"),experimentEntries1));



        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

    }
        /*
         * Preparing the list data
         */
        private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();
        // Adding child data
        for(int i = 0; i< projectExperimentEntries.size();i++) {

            listDataHeader.add(projectExperimentEntries.get(i).getProject().get_name());
            List<String> list = new ArrayList<String>();

            for (int j = 0; j < projectExperimentEntries.get(i).getExperimentEntry().size(); j++) {

                list.add(projectExperimentEntries.get(i).getExperimentEntry().get(j).getExperiments().get_name());
            }
            listDataChild.put(listDataHeader.get(i), list);

        }



// Listview on child click listener
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                experiment_Selected = childPosition;
                project_Selected = groupPosition;
                startnew_action();
                return false;
            }
        });
            expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

                @Override
                public void onGroupExpand(int groupPosition) {



                }

            });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.project_show, menu);
        return true;


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void buttonEventHandler(View v) {  // butten events

        switch (v.getId()) {  // switch ID button

            case R.id.button:   // button back

                this.finish();         // back button

                break;

            case R.id.button2:  // button exit

            ActivityRegistry.finishAll(); // exit button
            System.exit(0);
            break;


        }
    }

    private void startnew_action(){
        Intent intent;
        intent = new Intent(this, Entry_show.class);
        startActivity(intent);

    }
}
