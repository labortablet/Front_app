package company;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.test1.tabletapp.app.R;

import java.util.List;

/**
 * @author  Grit on 02.08.2014.
 * Shows the Specified Entry Attributes
 */
public class Entry_Details extends Activity{
    /**
     * This is the Entry Which is Selected for closer Details
     * Selected Entry {@value} .
     *
     * @since 1.0
     */

private Integer entry_Selected = Entry_show.getEntry_Selected();

    /**
     * This is the experiment, where the Entry  belongs to
     * Selected Experiment {@value} .
     *
     * @since 1.0
     */
private Integer experiment_Selected = Project_show.getExperiment_Selected();

    /**
     * This is the Project, where the Experiment  belongs to
     * Selected Project {@value} .
     *
     * @since 1.0
     */
private Integer project_Selected = Project_show.getProject_Selected();
    /**
     * This is the ProjectExperimentEntries Object which contains all Project, Experiments and Entries.
     * Selected Object {@value} .
     *
     * @since 1.0
     */
private static List<ProjectExperimentEntry> projectExperimentEntries = Project_show.getProjectExperimentEntries();
    /**
     * TextView for Title
     * Title {@value} .
     *
     * @since 1.0
     */
    TextView textView;
    /**
     * TextView for Attachment
     * Attachment {@value} .
     *
     * @since 1.0
     */
    TextView textView2;
    /**
     * TextView for entry_time
     * Entry_time {@value} .
     *
     * @since 1.0
     */
    TextView textView3;
    /**
     * TextView for user
     * User name{@value} .
     *
     * @since 1.0
     */
    TextView textView4;
    /**
     * TableLayout only if Detail view of a Table
     * TableView {@value} .
     *
     * @since 1.0
     */
    TableLayout table;


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        ActivityRegistry.register(this);
        switch (projectExperimentEntries.get(project_Selected).getExperimentEntry().get(experiment_Selected).getEntriesList().get(entry_Selected).getAttachment_type())
        {
            case 1: // For Keyboard Entry
                setContentView(R.layout.entry_keyboarddetails); // Setting Layout

                textView = (TextView)findViewById(R.id.textView2);
                textView2 = (TextView)findViewById(R.id.textView4);
                textView3 = (TextView)findViewById(R.id.textView6);
                textView4 = (TextView)findViewById(R.id.textView8);

                textView.setText(projectExperimentEntries.get(project_Selected).getExperimentEntry().get(experiment_Selected).getEntriesList().get(entry_Selected).get_title());
                textView2.setText(projectExperimentEntries.get(project_Selected).getExperimentEntry().get(experiment_Selected).getEntriesList().get(entry_Selected).getAttachment());
                textView3.setText(projectExperimentEntries.get(project_Selected).getExperimentEntry().get(experiment_Selected).getEntriesList().get(entry_Selected).get_entry_time());
                textView4.setText(projectExperimentEntries.get(project_Selected).getExperimentEntry().get(experiment_Selected).getEntriesList().get(entry_Selected).get_user());
            break;
            case 2: //For Table Entry

                 setContentView(R.layout.entry_tabledetails);  // Setting Layout

                 textView = (TextView)findViewById(R.id.textView2);
                 textView2 = (TextView)findViewById(R.id.textView4);
                 textView3 = (TextView)findViewById(R.id.textView6);
                 table = (TableLayout)findViewById(R.id.tableLayout2);

                 textView.setText(projectExperimentEntries.get(project_Selected).getExperimentEntry().get(experiment_Selected).getEntriesList().get(entry_Selected).get_title());
                 textView2.setText(projectExperimentEntries.get(project_Selected).getExperimentEntry().get(experiment_Selected).getEntriesList().get(entry_Selected).get_entry_time());
                 textView3.setText(projectExperimentEntries.get(project_Selected).getExperimentEntry().get(experiment_Selected).getEntriesList().get(entry_Selected).get_user());

                 String[][] strings =  projectExperimentEntries.get(project_Selected).getExperimentEntry().get(experiment_Selected).getEntriesList().get(entry_Selected).getTable_array();


                for(String[] s: strings) { // Starting Table output
                    TableRow row = new TableRow(this);
                    row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                            TableRow.LayoutParams.WRAP_CONTENT));

                    for (String string : s) {
                        TextView tv = new TextView(this);
                        tv.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                                TableRow.LayoutParams.WRAP_CONTENT));

                        tv.setPadding(5, 5, 5, 5);
                        tv.setText(string);

                        row.addView(tv);
                    }

                    table.addView(row);
                    } // End Table output
                break;
                }
        }



    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.start, menu);
        return true;

    }  // Standart Android Methoden für apps
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }  // Standart Android Methoden für apps

    public void buttonEventHandler(View v) {  // butten events

        switch(v.getId()) {  // switch ID button
            case R.id.button: // Exit button
                ActivityRegistry.finishAll();
                System.exit(0);
                break;
            case R.id.button2: // back button
                this.finish();
                break;
        }


    }


}
