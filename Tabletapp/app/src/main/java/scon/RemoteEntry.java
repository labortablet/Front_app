package scon;

import imports.BaseEntry;
import imports.User;

/**
 * Created by Grit on 07.09.2014.
 */
public class RemoteEntry extends BaseEntry {


    public RemoteEntry(RemoteEntry a) {
       this.Project_id = a.Project_id;
       this.attachment = a.attachment;
       this.attachment_type =a.attachment_type;
       this.entry_time =a.entry_time;
       this.Experiment_id =a.Experiment_id;
       this.remote_id = a.remote_id;
       this.sync_time = a.sync_time;
       this.title = a.title;
       this.user = a.user;
    }
    public RemoteEntry(int Project_id,Object attachment,int attachment_type,String entry_time,int Experiment_id,String sync_time, String title, User user)
    {

        this.Project_id = Project_id;
        this.attachment = attachment;
        this.attachment_type =attachment_type;
        this.entry_time =entry_time;
        this.Experiment_id =Experiment_id;
        this.sync_time = sync_time;
        this.title = title;
        this.user = user;





    }
    public RemoteEntry(){



    }
}
