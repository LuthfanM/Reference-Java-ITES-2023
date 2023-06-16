import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JLabel;

//Simple App using Java Swing to connect to database and display one record of data as an example

public class GuiBookstore extends JFrame {

    String url = "jdbc:mysql://localhost:3306/Bookstore";//sesuaikan dengan port dan nama db
    String username = "root";//user database
    String password = "";//jika ada password maka diisi
    Connection con;
    Statement stmt;
    ResultSet rs;

    JLabel lblID = new JLabel("Test");
    JLabel lblTitle = new JLabel("Test");
    JLabel lblAuthor = new JLabel("Test");
    JLabel lblAmount = new JLabel("Test");

    public GuiBookstore() {
        this.getContentPane().setLayout(null);
        this.setSize(500, 500);
        this.setVisible(true);
        
        lblID.setBounds(10, 10, 300, 10);

        lblTitle.setBounds(10, 30, 300, 10);

        lblAuthor.setBounds(10, 50, 300, 10);

        lblAmount.setBounds(10, 70, 300, 10);
        
        this.getContentPane().add(lblTitle);
        this.getContentPane().add(lblAuthor);
        this.getContentPane().add(lblAmount);
        this.getContentPane().add(lblID);
    }

    public static void main(String[] args) {
        GuiBookstore gbs = new GuiBookstore();

        try {

            gbs.con = DriverManager.getConnection(gbs.url, gbs.username, gbs.password);
            gbs.stmt = gbs.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            gbs.rs = gbs.stmt.executeQuery("SELECT * FROM Bookstore.books");
            gbs.rs.next();

            gbs.lblID.setText(""+gbs.rs.getInt("id"));
            gbs.lblTitle.setText(""+gbs.rs.getString("title"));
            gbs.lblAuthor.setText(""+gbs.rs.getString("author"));
            gbs.lblAmount.setText(""+gbs.rs.getInt("amount"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
