package kata5P2.view;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kata5P2.model.Mail;

public class MailListReaderDB {
    
    private final String dbName;
    
    public MailListReaderDB(String dbName) {
        this.dbName = dbName;
    }
    
    public Iterable<Mail> mails() {
        return new Iterable<Mail>() {
            @Override
            public Iterator<Mail> iterator() {
                try {
                    return createIterator();
                } catch (FileNotFoundException ex) {
                    return null;
                }
            }
        };
    }
    
    private Iterator<Mail> createIterator() throws FileNotFoundException {
        return new Iterator<Mail>() {
            
            Iterator<Mail> ite = iteratorMail();
            
            @Override
            public boolean hasNext() {
                return ite.hasNext();
            }

            @Override
            public Mail next() {
                return ite.next();
            }
            
            private Connection connect() {
                String url = "jdbc:sqlite:" + dbName;
                Connection conn = null;
                try {
                    conn = DriverManager.getConnection(url);
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
                return conn;
            }
            
            private Iterator<Mail> iteratorMail() {
                List<Mail> listMail = new ArrayList<>();
                String sql = "SELECT * FROM direcc_email";
                try (Connection conn = connect();
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(sql)){
                    while (rs.next()) {
                        listMail.add(new Mail(rs.getString("direccion")));
                    }
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
                Iterator<Mail> ite = listMail.iterator();
                return ite;
            }
        };
    }
}