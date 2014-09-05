package imports;

/*
*
* This Class is for building the Entry object we need in the Activity
*
* */


public class Entry implements Comparable<Entry> {
    /**
     *This is the Local ID an Entry can gets From the tab.
     * @value
     * @since 1.0
     */
    private Integer local_id;
    /**
     *This is the Remote ID an Entry can get if it comes from the Server.
     * @value
     * @since 1.0
     */
    private Integer remote_id;
    /**
     *This is the title of an Entry
     * @value
     * @since 1.0
     */
    private String title;
    /**
     *This is the Attachment Object Where every entry hold its content.
     * @value
     * @since 1.0
     */
    private Object attachment; //no access yet
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

    private boolean sync;

    /**This is a 2D array which holds the content of the Table.
     *
     * @value
     * @since 1.0
     */

    /**
     * Konstruktor For the Keyboard_entry
     * @param rem_id   The Remote ID
     *@param local_id The Local ID
     * @param title Title of the Entry
     *@param attachment Content of the Entry
     *@param sync_time Sync time of the Entry
     *@param entry_time Time when the entry was created
     *@param user The name of the Entry creator
     *@param experiment_id The ID where the Entry is assigned to
     *@param sync The value which says if the Entry already on the Server
     */

    public Entry(Integer rem_id,int local_id, String title, String attachment, String sync_time, String entry_time, String user, Integer experiment_id,boolean sync) {
        this.remote_id = rem_id;
        this.local_id = local_id;
        this.title = title;
        this.attachment = new AttachmentText(attachment);
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



    /**
     * Konstruktor For the Table_entry
     * @param rem_id   The Remote ID
     * @param local_id The Local ID
     * @param title Title of the Entry
     *@param sync_time Sync time of the Entry
     *@param entry_time Time when the entry was created
     *@param user The name of the Entry creator
     *@param experiment_id The ID where the Entry is assigned to
     *                     @param array The array holds the Content of the Table_entry
     *@param sync The value which says if the Entry already on the Server
     *
     */

    public Entry(Integer rem_id,int local_id, String title, String sync_time, String entry_time, String user, Integer experiment_id, String[][] array,boolean sync) {
        this.remote_id = rem_id;
        this.local_id = local_id;
        this.title = title;
        this.attachment_type = 2;
        this.sync_time = sync_time;
        this.entry_time = entry_time;
        this.user = user;
        this.experiment_id = experiment_id;
        this.attachment = new AttachmentTable(array);
        this.sync = sync;


    }


    @Override
    public int compareTo(Entry other_entry) {
        return this.entry_time.compareTo(other_entry.getEntry_time());
    }


    public Integer getLocal_id() {
        return local_id;
    }

    public Integer getRemote_id() {
        return remote_id;
    }

    public String getTitle() {
        return title;
    }

    public Object getAttachment() {
        return attachment;
    }

    public int getAttachment_type() {
        return attachment_type;
    }

    public String getSync_time() {
        return sync_time;
    }

    public String getEntry_time() {
        return entry_time;
    }

    public String getUser() {
        return user;
    }

    public Integer getExperiment_id() {
        return experiment_id;
    }
}