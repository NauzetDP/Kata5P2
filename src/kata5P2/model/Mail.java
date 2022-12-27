package kata5P2.model;

public class Mail {
    
    private final String mail;

    public Mail(String mail) {
        this.mail = mail;
    }
    
    public String getDomain() {
        String result = this.mail.substring(this.mail.indexOf("@")+1);
        return result;
    }
}