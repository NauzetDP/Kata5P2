package kata5P2.view;

import java.util.Iterator;
import kata5P2.model.Histogram;
import kata5P2.model.Mail;

public class MailHistogramBuilder {
    
    public Histogram<String> build(Iterable<Mail> mailList) {
        Histogram<String> histo = new Histogram();
        Iterator i = mailList.iterator();
        while (i.hasNext()) {
            Mail m = (Mail)i.next();
            if (m == null) {
                break;
            }
            histo.increment(m.getDomain());
        }
        return histo;
    }
}