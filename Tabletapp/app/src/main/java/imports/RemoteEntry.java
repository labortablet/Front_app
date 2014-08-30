package imports;
/*
*
* This Class is for building the RemoteEntry object as they are returned by the Server Connection Library.
* These are immutable as they are directly coming from the server.
*
* */
public class RemoteEntry implements Comparable<RemoteEntry> {
	/**
	 *This is the Remote ID an synced Entry has on the server.
	 * @value
	 * @since 1.0
	 */
	protected Integer id;
		/**
		 *This is the title of an Entry
		 * @value
		 * @since 1.0
		 */
	protected String title;
	/**
	 *This is the Attachment of the Entry, basically the Entrydata.
	 * @value
	 * @since 1.0
	 */
	protected String attachment;
	/**
	 *This is the Attachment type so we know how to parse the attachment.
	 * @value
	 * @since 1.0
	 */
	protected String attachment_type;
	/**
	 *This is the time when the entry was synced on the server.
	 * @value
	 * @since 1.0
	 */
	protected String sync_time;
	/**
	 *This is the time the user put in.
	 * @value
	 * @since 1.0
	 */
	protected String entry_time;
	/**
	 *This is the user name of the user who made this entry.
	 * @value
	 * @since 1.0
	 */
	protected String user;
	/**
	 *This is the id of the experiment where this entry was added.
	 * @value
	 * @since 1.0
	 */
	protected Integer experiment_id;

	/**
	 *This constructor was only added to make inheritance for the Entry class easier.
	 * With this, you can just translate a RemoteEntry object to an Entry object easier.
	 * @value
	 * @since 1.0
	 */
	public RemoteEntry(RemoteEntry a){
		this.id = a.id;
		this.title = a.title;
		this.attachment = a.attachment;
		this.attachment_type = a.attachment_type;
		this.sync_time = a.sync_time;
		this.entry_time = a.entry_time;
		this.user = a.user;
		this.experiment_id = a.experiment_id;
	};

	/**
	 *Constructor used by the Server side library
	 * @value
	 * @since 1.0
	 * @param id   The Remote ID
	 * @param title Title of the Entry
	 * @param attachment Content of the Entry
	 * @param attachment_type type of the content
	 * @param sync_time Sync time of the Entry
	 * @param entry_time Time when the entry was created
	 * @param user The name of the Entry creator
	 * @param experiment_id The ID where the Entry is assigned to
	 */
	public RemoteEntry(Integer id, String title, String attachment, String attachment_type, String sync_time, String entry_time, String user, Integer experiment_id) {
		this.id = id;
		this.title = title;
		this.attachment = attachment;
		this.attachment_type = attachment_type;
		this.sync_time = sync_time;
		this.entry_time = entry_time;
		this.user = user;
		this.experiment_id = experiment_id;
	};

	/**
	 *Sorting for RemoteEntries. They will always be sorted by the entry date.
	 * @value
	 * @since 1.0
	 */
	@Override
	public int compareTo(RemoteEntry other_Remote_entry) {
		return this.entry_time.compareTo(other_Remote_entry.entry_time);
	};

	/**
	 *Comparison function between RemoteEntries.
	 * If they are not yet synced they will always be unequal.
	 * If they were synced, the remote id will be compared.
	 * @value
	 * @since 1.0
	 */
	public Boolean equals(RemoteEntry other_Remote_entry){
		//unsynced entries always compare to False
		//else we can jsut check the remote id
		if((this.id == null) || (other_Remote_entry == null)){
			return Boolean.FALSE;
		}else{
			return this.id.equals(other_Remote_entry.get_id());
		}
	};

	/**
	 *Accessor for the id
	 * @value
	 * @since 1.0
	 */
	public Integer get_id(){
		return this.id;
	};
	/**
	 *Accessor for the title
	 * @value
	 * @since 1.0
	 */
	public String get_title(){
		return this.title;
	};
	/**
	 *Accessor for the sync_time
	 * @value
	 * @since 1.0
	 */
	public String get_sync_time(){
		return this.sync_time;
	};
	/**
	 *Accessor for the entry_time
	 * @value
	 * @since 1.0
	 */
	public String get_entry_time(){
		return this.entry_time;
	};
	/**
	 *Accessor for the experiment_id
	 * @value
	 * @since 1.0
	 */
	public Integer get_experiment_id(){
		return this.experiment_id;
	};
	/**
	 *Accessor for the user string
	 * @value
	 * @since 1.0
	 */
	public String get_user(){
		return this.user;
	};
	/**
	 *Accessor for the attachment
	 * @value
	 * @since 1.0
	 */
	public String get_attachment(){
		return this.attachment;
	};
	/**
	 *Accessor for the attachment type
	 * @value
	 * @since 1.0
	 */
	public String get_attachment_type(){
		return this.attachment_type;
	};
};