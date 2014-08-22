package imports;
/*
*
* This Class is for building the Entry object we need in the Activity
*
* */


public class Entry implements Comparable<Entry> {
    /**
     *This is the Remote ID an Entry can get if it comes from the Server.
     * @value
     * @since 1.0
     */
    private Integer id;
    /**
     *This is the title of an Entry
     * @value
     * @since 1.0
     */
    private String title;
    /**
     *This is the Attachment a Keyboard entry hold.
     * @value
     * @since 1.0
     */
    private String attachment; //no access yet
    /**
     *This is the Attachment Typ every Entry got.
     * @value
     * @since 1.0
     */
    private int attachment_type = 0; //no access yet
    /**
     *This is the sync_time a entry only got if it's synced with the Server, this means that it is the time when the server received the Entry.
     * @value
     * @since 1.0
     */
    private String sync_time;
    /**
     *This is the entry_time it holds the time, the Entry was finished in the app.
     * @value
     * @since 1.0
     */
    private String entry_time;
    /**
     *This Value holds the User who created the Entry.
     * @value
     * @since 1.0
     */
    private String user;
    /**
     *This is the Experiment id, where the entry is was assigned to.
     * @value
     * @since 1.0
     */
    private Integer experiment_id;

    /**
     *This is the sync value it says, if the entry is already on the server or not.
     * @value
     * @since 1.0
     */

private boolean sync = false;

    /**This is a 2D array which holds the content of the Table.
     *
     * @value
     * @since 1.0
     */

    private String[][] table_array;
    /**
     * Returns the 2D Array, which holds the content of the Table
     * @return   table_array
     */
    public String[][] getTable_array() {
        return table_array;
    }



    /**
     * Konstruktor For the Keyboard_entry
     * @param id   The Remote ID
     * @param title Title of the Entry
     *@param attachment Content of the Entry
     *@param sync_time Sync time of the Entry
     *@param entry_time Time when the entry was created
     *@param user The name of the Entry creator
     *@param experiment_id The ID where the Entry is assigned to
     *@param sync The value which says if the Entry already on the Server
     */

    public Entry(Integer id, String title, String attachment, String sync_time, String entry_time, String user, Integer experiment_id,boolean sync) {
        this.id = id;
        this.title = title;

        this.attachment = attachment;
        this.attachment_type = 1;
        this.sync_time = sync_time;
        this.entry_time = entry_time;
        this.user = user;
        this.experiment_id = experiment_id;
        this.sync = sync;
    }

    /**
     * Returns the Sync Value
     * @return    status of synced
     */
    public boolean isSync() {
        return sync;
    }
    /**
     * Changes the status of the sync
     * @param sync  status of sync
     */

    public void setSync(boolean sync) {
        this.sync = sync;
    }

    /**
     * Konstruktor For the Table_entry
     * @param id   The Remote ID
     * @param title Title of the Entry
     *@param sync_time Sync time of the Entry
     *@param entry_time Time when the entry was created
     *@param user The name of the Entry creator
     *@param experiment_id The ID where the Entry is assigned to
     *                     @param array The array holds the Content of the Table_entry
     *@param sync The value which says if the Entry already on the Server
     *
     */

    public Entry(Integer id, String title, String sync_time, String entry_time, String user, Integer experiment_id, String[][] array,boolean sync) {
        this.id = id;
        this.title = title;
        this.attachment_type = 2;
        this.sync_time = sync_time;
        this.entry_time = entry_time;
        this.user = user;
        this.experiment_id = experiment_id;
        this.table_array = array;
        this.sync = sync;


    }


    @Override
    public int compareTo(Entry other_entry) {
        return this.entry_time.compareTo(other_entry.get_entry_time());
    }


    public Integer get_id() {
        return this.id;
    }


    public String get_title() {
        return this.title;
    }


    public String get_sync_time() {
        return this.sync_time;
    }


    public String get_entry_time() {
        return this.entry_time;
    }


    public Integer get_experiment_id() {
        return this.experiment_id;
    }


    public String get_user() {
        return this.user;
    }


    public int getAttachment_type() {
        return attachment_type;
    }


    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public String getTitle() {
        return title;
    }

    public String getSync_time() {
        return sync_time;
    }

    public String getEntry_time() {
        return entry_time;
    }


}