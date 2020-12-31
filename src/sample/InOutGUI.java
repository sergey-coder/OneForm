package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InOutGUI {
    protected String SQLlog;
    protected String SQLpas;
    public ResultSet DataSet1;
    public ResultSet DataSet2;

    public void EntSQL(String log, String pas) {
        SQLlog = log;
        SQLpas = pas;
    }

    public void GetDataset1() throws SQLException {
        String URL = "jdbc:postgresql://localhost/OneForm";

        String Que = "SELECT * FROM docs";
        String Create = "CREATE TABLE IF NOT EXISTS docs(id SERIAL PRIMARY KEY,"
                + " author varchar(30), name varchar(50), can real, feh real, rank real, disp real);";
        EntSQL("OneF", "r814ae");

        Connection con = DriverManager.getConnection(URL, SQLlog, SQLpas);
        Statement st = con.createStatement();
        st.executeUpdate(Create);

        DataSet1 = st.executeQuery(Que);
        con.close();
    }

    public void GetDataset2() throws SQLException {
        String URL = "jdbc:postgresql://localhost/OneForm";
        String Que = "SELECT * FROM lems";
        String Create = "CREATE TABLE IF NOT EXISTS lems(id SERIAL PRIMARY KEY,"
                + "doc_id integer, lem_num integer, "
                + "rank real, disp real, picf varchar(50));";

        EntSQL("OneF", "r814ae");
        Connection con = DriverManager.getConnection(URL, SQLlog, SQLpas);
        Statement st = con.createStatement();
        st.executeUpdate(Create);
        DataSet2 = st.executeQuery(Que);
        con.close();
    }

    public void UpdateSQLDS1(int id, String author, String name) throws SQLException {
        String URL = "jdbc:postgresql://localhost/OneForm";
        String Update = "UPDATE docs SET author ='" + author + "', name='" + name + "' WHERE id='" + id + "';";
        EntSQL("OneF", "r814ae");
        Connection con = DriverManager.getConnection(URL, SQLlog, SQLpas);
        Statement st = con.createStatement();
        st.executeUpdate(Update);
        con.close();
    }

    public void UpdateSQLDS2(int id, String PicRoute) throws SQLException {
        String URL = "jdbc:postgresql://localhost/OneForm";
        String Update = "UPDATE lems SET picf ='" + PicRoute + "' WHERE id='" + id + "';";
        EntSQL("OneF", "r814ae");
        Connection con = DriverManager.getConnection(URL, SQLlog, SQLpas);
        Statement st = con.createStatement();
        st.executeUpdate(Update);
        con.close();
    }

}
