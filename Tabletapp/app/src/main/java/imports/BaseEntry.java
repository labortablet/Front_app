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
    protected Integer project_id;
    /**
     *This is the title of an LocalEntry
     * @value
     * @since 1.0
     */
    protected Integer experiment_id;
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
    /**
     *This is the sync_time a entry only got if it's synced with the Server, this means that it is the time when the server received the LocalEntry.
     * @value
     * @since 1.0
     */
    protected Integer sync_time;
    /**
     *This is the entry_time it holds the time, the LocalEntry was finished in the app.
     * @value
     * @since 1.0
     */
    protected Integer entry_time;
    /**
     *This is the entry_time it holds the time, the LocalEntry was finished in the app.
     * @value
     * @since 1.0
     */
    protected Integer change_time;
    /**
     *This Value holds the UserObject.
     * @value
     * @since 1.0
     */
    protected User user;

    public BaseEntry(User user, Integer project_id, Integer experiment_id, Integer remote_id, Integer entry_time, Integer sync_time, Integer change_time, String title, Object attachment, int attachment_type) {
        this.attachment = attachment;
        this.attachment_type = attachment_type;
        this.entry_time = entry_time;
        this.sync_time = sync_time;
        this.change_time = change_time;
        this.title = title;
        this.user = user;
        this.project_id = project_id;
        this.experiment_id = experiment_id;
        this.remote_id = remote_id;
    }


    public Integer getProject_id() {
        return this.project_id;
    }

    public Integer getExperiment_id() {
        return this.experiment_id;
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

    public Integer getSync_time() {
        return this.sync_time;
    }

    public Integer getEntry_time() {
        return this.entry_time;
    }

    public Integer getChange_time() {
        return this.change_time;
    }

    public User getUser() {
        return this.user;
    }

}