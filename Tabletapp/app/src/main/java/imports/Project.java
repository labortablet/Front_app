package imports;

import java.util.Dictionary;
import java.util.Hashtable;

public class Project implements Comparable<Project>{
    private Integer local_id;
    private Integer remote_id = null;
    private String name;
    private String description;
    private Dictionary experiments = new Hashtable();

    public Project(Integer id, String name, String description){
        this.local_id = id;
        this.name = name;
        this.description = description;
    };

    public Project(Integer id, String name){
        this.local_id = id;
        this.name = name;
    };

    @Override
    public int compareTo(Project other_project) {
        return this.local_id.compareTo(other_project.get_local_id());
    };

    public Integer get_local_id(){
        return this.local_id;
    };

    public Integer get_remote_id(){
        return this.remote_id;
    };

    public void set_remote_id(Integer id){
        this.remote_id = id;
    };


    public String get_name(){
        return this.name;
    };

    public void set_name(String new_name){
        this.name = new_name;
    };

    public String get_description(){
        return this.description;
    };

    public void set_description(String new_description){
        this.description = new_description;
    };





    /**
 // Variablen für projekt
    int project_ID = -1 ;
    String project_Name = null ;
    String project_Description ;
    boolean project_Sync;
    int project_UserID ;
    int project_ServerID;

    // variablen für entry
   int entry_ID = -1 ;
   int entry_Typ;
   String entry_Title = null;
   String entry_Content;
   String entry_Date;
   Boolean entry_Sync;
   int entry_ServerID;

// Variablen für Tabelle
    int table_ID = -1;
    int table_Typ;
    String table_Headline = null;// Inhalt der Datenbank tabelle Table
    ArrayList<String> table = new ArrayList<String>(); //Inhalt der Tabelle rows
    boolean table_Sync ;

    //Konstruktor für Tabellen
    public Project(int ID, int typ,String headline,ArrayList<String> tableList,boolean sync,String prName )
    {
        table_ID = ID;
        table_Typ = typ;
        table_Headline = headline;
        table = tableList;
        table_Sync = sync;
        project_Name = prName;
    }



    // Konstrucktor für projekte
   public Project(int ID,String name,String desc,boolean sync,int PrServerID){
       project_ID = ID;
       project_Name = name;
       project_Description = desc;
       project_Sync = sync;
       project_ServerID = PrServerID;
   }
    // Konstruktor für entries
    public Project(int ID,int typ,String title,String content,String date,boolean sync,int enServerID,String prName){
        entry_ID = ID;
        entry_Typ = typ;
        entry_Title = title;
        entry_Content = content;
        entry_Date = date;
        entry_Sync = sync;
        entry_ServerID = enServerID;
        project_Name = prName;
    }

    public int getTable_ID() {
        return table_ID;
    }

    public void setTable_ID(int table_ID) {
        this.table_ID = table_ID;
    }

    public int getTable_Typ() {
        return table_Typ;
    }

    public void setTable_Typ(int table_Typ) {
        this.table_Typ = table_Typ;
    }

    public String getTable_Headline() {
        return table_Headline;
    }

    public void setTable_Headline(String table_Headline) {
        this.table_Headline = table_Headline;
    }

    public ArrayList<String> getTable() {
        return table;
    }

    public void setTable(ArrayList<String> table) {
        this.table = table;
    }

    public boolean isTable_Sync() {
        return table_Sync;
    }

    public void setTable_Sync(boolean table_Sync) {
        this.table_Sync = table_Sync;
    }

    public int getProject_ServerID() {
        return project_ServerID;
    }

    public void setProject_ServerID(int project_ServerID) {
        this.project_ServerID = project_ServerID;
    }

    public Boolean getEntry_Sync() {
        return entry_Sync;
    }

    public void setEntry_Sync(Boolean entry_Sync) {
        this.entry_Sync = entry_Sync;
    }

    public int getEntry_ServerID() {
        return entry_ServerID;
    }

    public void setEntry_ServerID(int entry_ServerID) {
        this.entry_ServerID = entry_ServerID;
    }

    public int getEntry_ID() {
        return entry_ID;
    }

    public void setEntry_ID(int entry_ID) {
        this.entry_ID = entry_ID;
    }

    public int getEntry_Typ() {
        return entry_Typ;
    }

    public void setEntry_Typ(int entry_Typ) {
        this.entry_Typ = entry_Typ;
    }

    public String getEntry_Title() {
        return entry_Title;
    }

    public void setEntry_Title(String entry_Title) {
        this.entry_Title = entry_Title;
    }

    public String getEntry_Content() {
        return entry_Content;
    }

    public void setEntry_Content(String entry_Content) {
        this.entry_Content = entry_Content;
    }

    public String getEntry_Date() {
        return entry_Date;
    }

    public void setEntry_Date(String entry_Date) {
        this.entry_Date = entry_Date;
    }

    public boolean isEntry_Sync() {
        return entry_Sync;
    }

    public void setEntry_Sync(boolean entry_Sync) {
        this.entry_Sync = entry_Sync;
    }

    public String getProject_Description() {
        return project_Description;
    }

    public void setProject_Description(String project_Description) {
        this.project_Description = project_Description;
    }

    public boolean getProject_Sync() {
        return project_Sync;
    }

    public void setProject_Sync(boolean project_Sync) {
        this.project_Sync = project_Sync;
    }

    public int getProject_UserID() {
        return project_UserID;
    }

    public void setProject_UserID(int project_UserID) {
        this.project_UserID = project_UserID;
    }

    public int getProject_ID() {
        return project_ID;
    }

    public void setProject_ID(int project_ID) {
        this.project_ID = project_ID;
    }

    public String getProject_Name() {
        return project_Name;
    }

    public void setProject_Name(String project_Name) {
        this.project_Name = project_Name;
    }
     */
}
