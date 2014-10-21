package company;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.test1.tabletapp.app.R;

import java.util.List;

import imports.AttachmentTable;
import imports.AttachmentText;

/**
 * @author  Grit on 02.08.2014.
 * Shows the Specified LocalEntry Attributes
 */
public class Entry_Details extends Activity{
    /**
     * This is the LocalEntry Which is Selected for closer Details
     * Selected LocalEntry {@value} .
     *
     * @since 1.0
     */

private Integer entry_Selected = Entry_show.getEntry_Selected();

    /**
     * This is the experiment, where the LocalEntry  belongs to
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
            case 1: // For Keyboard LocalEntry
                if(projectExperimentEntries.get(project_Selected).getExperimentEntry().get(experiment_Selected).getEntriesList().get(entry_Selected).isSync())
                setContentView(R.layout.entry_keyboarddetails_synctrue); // Setting Layout
                else
                setContentView(R.layout.entry_keyboarddetails_syncfalse);

                textView = (TextView)findViewById(R.id.textView2);
                textView2 = (TextView)findViewById(R.id.textView4);
                textView3 = (TextView)findViewById(R.id.textView6);
                textView4 = (TextView)findViewById(R.id.textView8);

                textView.setText(projectExperimentEntries.get(project_Selected).getExperimentEntry().get(experiment_Selected).getEntriesList().get(entry_Selected).getTitle());
                AttachmentText text = (AttachmentText) projectExperimentEntries.get(project_Selected).getExperimentEntry().get(experiment_Selected).getEntriesList().get(entry_Selected).getAttachment();
                textView2.setText(text.getText());
                textView3.setText(projectExperimentEntries.get(project_Selected).getExperimentEntry().get(experiment_Selected).getEntriesList().get(entry_Selected).getEntry_time().toString());
                textView4.setText(projectExperimentEntries.get(project_Selected).getExperimentEntry().get(experiment_Selected).getEntriesList().get(entry_Selected).getUser().display("  "));
            break;
            case 2: //For Table LocalEntry
                if(projectExperimentEntries.get(project_Selected).getExperimentEntry().get(experiment_Selected).getEntriesList().get(entry_Selected).isSync())
                 setContentView(R.layout.entry_tabledetails_synctrue);  // Setting Layout
                else
                setContentView(R.layout.entry_tabledetails_syncfalse);

                 textView = (TextView)findViewById(R.id.textView2);
                 textView2 = (TextView)findViewById(R.id.textView4);
                 textView3 = (TextView)findViewById(R.id.textView6);
                 table = (TableLayout)findViewById(R.id.tableLayout2);

                 textView.setText(projectExperimentEntries.get(project_Selected).getExperimentEntry().get(experiment_Selected).getEntriesList().get(entry_Selected).getTitle());
                 textView2.setText(projectExperimentEntries.get(project_Selected).getExperimentEntry().get(experiment_Selected).getEntriesList().get(entry_Selected).getEntry_time().toString());
                 textView3.setText(projectExperimentEntries.get(project_Selected).getExperimentEntry().get(experiment_Selected).getEntriesList().get(entry_Selected).getUser().display("  "));
                 AttachmentTable table1 = (AttachmentTable) projectExperimentEntries.get(project_Selected).getExperimentEntry().get(experiment_Selected).getEntriesList().get(entry_Selected).getAttachment();
                 String[][] strings = table1.getTable_array();


                for(String[] s: strings) { // Starting Table output
                    TableRow row = new TableRow(this);
                    row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                            TableRow.LayoutParams.WRAP_CONTENT));

                    for (String string : s) {
                        EditText tv = new EditText(this);
                        tv.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                                TableRow.LayoutParams.WRAP_CONTENT));

                        tv.setPadding(5, 5, 5, 5);
                        tv.setText(string);
                        tv.setKeyListener(null);

                        row.addView(tv);
                        row.setGravity(Gravity.CENTER);
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
