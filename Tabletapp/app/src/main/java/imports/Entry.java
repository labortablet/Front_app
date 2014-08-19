package imports;
/*
*
* This Class is for building the Entry object we need in the Activity
*
* */


public class Entry extends RemoteEntry {
	/**
	 *Sync field
	 * @value
	 * @since 1.0
	 */
	protected boolean sync = false;

	public Entry(RemoteEntry a){
		super(a);
	};

	public Entry(Integer id, String title, String attachment, String attachment_type, String sync_time, String entry_time, String user, Integer experiment_id,boolean sync) {
		super(id, title, attachment, attachment_type, sync_time, entry_time, user, experiment_id);
		this.sync = sync;
	}

	/**
	 * Returns the Sync Value
	 * @return    status of synced
	 */
	public boolean isSync(){
		return sync;
	}
	/**
	 * Changes the status of the sync
	 * @param sync  status of sync
	 */

	public void setSync(boolean sync) {
		this.sync = sync;
	}


	public void set_id(Integer id){
		this.id = id;
	};

	public void set_sync_time(String sync_time){
		this.sync_time = sync_time;
	};
}