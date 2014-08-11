package imports;

import java.util.ArrayList;

/**
 * Created by Grit on 19.06.2014.
 */
public class Table_wizard {

String title = new String();

ArrayList<String> table;

    public Table_wizard() {
        table = new ArrayList<String>();
    }


    public void set_array(String temp) {
  table.add(temp);
}

public ArrayList get_array(){
   return table;
}

    private void delete() throws Throwable {
        try {
            this.finalize();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }

}
