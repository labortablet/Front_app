package imports;
import java.security.MessageDigest;

public class User {
    private String lastname;
    private String firstname;
    private String user_email;
    private byte[] pw_hashb;

    private void setpw(String password){
        byte[] resultb = null;
        MessageDigest sha256 = null;
        try {
            sha256 = MessageDigest.getInstance("SHA-256");
        }catch (java.security.NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-265 not available, this should really not happen");
        }
        sha256.reset();
        try {
            resultb = sha256.digest(password.getBytes("UTF-8"));
        }catch (java.io.UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 encoding not available, this should really not happen");
        }
        this.pw_hashb = resultb;
    }

    public User(String firstname, String lastname, String user_email, String password){
        this.lastname = lastname;
        this.firstname = firstname;
        this.setpw(password);
        this.user_email = user_email;
    }
    public User(String user_email, String password){
        this.setpw(password);
        this.user_email = user_email;
    }

    public String display(Boolean lastname_first, String separator){
        if(this.lastname != null && this.firstname != null){
            if(lastname_first){
                return this.lastname + separator + this.firstname;
            }else{
                return this.firstname + separator + this.lastname;
            }
        }else{
            return this.user_email;
        }
    }

    public String display(){
        return this.display(Boolean.FALSE, " ");
    }

    public void setName(String firstname, String lastname){
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public void setLogin(String user_email, String password){
        this.user_email = user_email;
        this.setpw(password);
    }

    public String getUser_email(){
        return this.user_email;
    }

    public byte[] getPw_hashb(){
        return this.pw_hashb;
    }

    public String getUser_id(){
        //Added this so we are not bound to use the email as an id
        return this.user_email;
    }
}