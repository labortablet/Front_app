package imports;

/**
 * Created by Grit on 19.06.2014.
 */
public class Keyboard_input {
    String title;
    StringBuilder content;

    public Keyboard_input(StringBuilder temp){
        content = new StringBuilder();
        content = temp;
        title = new String();
    }
    public Keyboard_input(){

    title = new String();
    content = new StringBuilder();
}

    public void set_String(StringBuilder temp)
    {
        content = temp;
    }

    public StringBuilder get_String()
    {
        return content;
    }

    private void delete() throws Throwable {
        try {
            this.finalize();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }
}
