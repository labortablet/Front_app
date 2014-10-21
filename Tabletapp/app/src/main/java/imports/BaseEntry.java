package imports;

/**
 * Created by Grit on 07.09.2014.
 */
public class BaseEntry {

    /**
     *This is the Remote ID an LocalEntry can get if it comes from the Server.
     * @value
     * @since 1.0
     */
    protected Integer remote_id;
    /**
     *This is the title of an LocalEntry
     * @value
     * @since 1.0
     */
    protected Integer Project_id;
    /**
     *This is the title of an LocalEntry
     * @value
     * @since 1.0
     */
    protected Integer Experiment_id;
    /**
     *This is the title of an LocalEntry
     * @value
     * @since 1.0
     */
    protected String title;
    /**
     *This is the Attachment Object Where every entry hold its content.
     * @value
     * @since 1.0
     */
    protected Object attachment; //no access yet
    /**
     *This is the Attachment Typ every LocalEntry got.
     * @value
     * @since 1.0
     */
    protected int attachment_type = 0; //no access yet
    //FIXME these might need to be changed to Integer or Timestamp
    /**
     *This is the sync_time a entry only got if it's synced with the Server, this means that it is the time when the server received the LocalEntry.
     * @value
     * @since 1.0
     */
    protected String sync_time;
    /**
     *This is the entry_time it holds the time, the LocalEntry was finished in the app.
     * @value
     * @since 1.0
     */
    protected String entry_time;
    /**
     *This is the entry_time it holds the time, the LocalEntry was finished in the app.
     * @value
     * @since 1.0
     */
    protected String change_time;
    /**
     *This Value holds the UserObject.
     * @value
     * @since 1.0
     */
    protected User user;


    public Integer getExperiment_id() {
        return this.Experiment_id;
    }

    public Integer getRemote_id() {
        return this.remote_id;
    }

    public String getTitle() {
        return this.title;
    }

    public Object getAttachment() {
        return this.attachment;
    }

    public int getAttachment_type() {
        return this.attachment_type;
    }

    public String getSync_time() {
        return this.sync_time;
    }

    public String getEntry_time() {
        return this.entry_time;
    }

    public String getChange_time() {
        return this.change_time;
    }

    public User getUser() {
        return this.user;
    }

}