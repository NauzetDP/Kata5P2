
package kata5P2.main;

import kata5P2.view.*;
import kata5P2.model.*;

public class Kata5P2 {
    
    public static void main(String[] args) {
        execute();
    }
    
    public static void execute() {
        Iterable<Mail> itMail = input("mail.db");
        Histogram<String> histo = process(itMail);
        output(histo);
    }
    
    public static Iterable<Mail> input(String dbName) {
        Iterable<Mail> itMail = new MailListReaderDB(dbName).mails();
        return itMail;
    }
    
    public static Histogram<String> process(Iterable<Mail> itMail) {
        Histogram<String> histo = new MailHistogramBuilder().build(itMail);
        return histo;
    }
    
    public static void output(Histogram<String> histo) {
        new HistogramDisplay(histo).execute();
    }
}
