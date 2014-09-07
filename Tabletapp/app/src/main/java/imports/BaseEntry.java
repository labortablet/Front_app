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
    Integer remote_id;
    /**
     *This is the title of an LocalEntry
     * @value
     * @since 1.0
     */
    String title;
    /**
     *This is the Attachment Object Where every entry hold its content.
     * @value
     * @since 1.0
     */
     Object attachment; //no access yet
    /**
     *This is the Attachment Typ every LocalEntry got.
     * @value
     * @since 1.0
     */
   int attachment_type = 0; //no access yet
    /**
     *This is the sync_time a entry only got if it's synced with the Server, this means that it is the time when the server received the LocalEntry.
     * @value
     * @since 1.0
     */
    String sync_time;
    /**
     *This is the entry_time it holds the time, the LocalEntry was finished in the app.
     * @value
     * @since 1.0
     */
     String entry_time;
    /**
     *This Value holds the UserObject.
     * @value
     * @since 1.0
     */
    User user;


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

    public User getUser() {
        return user;
    }
}