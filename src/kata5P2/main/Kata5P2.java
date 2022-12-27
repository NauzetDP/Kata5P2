
package kata5P2.main;


import kata5P2.view.MailListReader;
import kata5P2.view.HistogramDisplay;
import kata5P2.view.MailHistogramBuilder;
import kata5P2.model.Mail;
import kata5P2.model.Histogram;

public class Kata5P2 {
    
    public static void main(String[] args) {
        execute();
    }
    
    public static void execute() {
        Iterable<Mail> itMail = input("email.txt");
        Histogram<String> histo = process(itMail);
        output(histo);
    }
    
    public static Iterable<Mail> input(String fileName) {
        Iterable<Mail> itMail = new MailListReader(fileName).mails();
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
