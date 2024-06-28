package Model;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import View.ApprenticeForm;

public class ApprenticeDAO {

    PreparedStatement ps;
    ResultSet rs;
    Connection Connection;
    Conection connect = Conection.getInstance();
    ApprenticeForm form;

    public List List() {
        List<Apprentice> data = new ArrayList<>();
        try {
            Connection = connect.Connect();
            ps = Connection.prepareStatement("SELECT * FROM apprentice");
            rs = ps.executeQuery();
            while (rs.next()) {

                Apprentice ap = new Apprentice();
                ap.setId(rs.getInt(1));
                ap.setDoctype(rs.getString(2));
                ap.setDocNumber(rs.getString(3));
                ap.setName(rs.getString(4));
                ap.setBirthDate(rs.getDate(5));
                ap.setGender(rs.getNString(6));
                ap.setCity(rs.getNString(7));
                data.add(ap);

            }
        } catch (SQLException e) {
            form.txtMessage.setText("Not listed, error: " + e);
        }
        return data;
    }

    public int Add(Apprentice Appr) {
        int r = 0;
        String sql = "INSERT INTO apprentice(TypeDoc,NumberDoc,Name,BirthDate,Gender,City)VALUES(?,?,?,?,?,?)";
        try {
            Connection = connect.Connect();
            ps = Connection.prepareStatement(sql);
            ps.setString(1, GetdocType(Appr.getDoctype()));
            ps.setString(2, Appr.getDocNumber());
            ps.setString(3, Appr.getName());
            java.util.Date date = Appr.getBirthDate();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String format = sdf.format(date);
            ps.setString(4, format);
            ps.setString(5, Appr.getGender());
            ps.setString(6, Appr.getCity());
            r = ps.executeUpdate();

        } catch (SQLException e) {
            form.txtMessage.setText("Not added, error: " + e);
        }
        return r;
    }

    public int Update(Apprentice Appr) {
        int r = 0;
        String sql = "UPDATE apprentice SET TypeDoc=? ,NumberDoc=? ,Name=? ,BirthDate=? ,Gender=? ,City=? WHERE id=?";
        try {
            Connection = connect.Connect();
            ps = Connection.prepareStatement(sql);
            ps.setString(1, GetdocType(Appr.getDoctype()));
            ps.setString(2, Appr.getDocNumber());
            ps.setString(3, Appr.getName());
            java.util.Date date = Appr.getBirthDate();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String format = sdf.format(date);
            ps.setString(4, format);
            ps.setString(5, Appr.getGender());
            ps.setString(6, Appr.getCity());
            ps.setInt(7, Appr.getId());

            r = ps.executeUpdate();
            if (r == 1) {
                return 1;

            } else {
                return 0;
            }

        } catch (SQLException e) {
            form.txtMessage.setText("Not updated, error: " + e);
        }
        return r;
    }

    public int Delete(int id) {
        int r = 0;
        String sql = "DELETE FROM apprentice WHERE id =" + id;
        try {
            Connection = connect.Connect();
            ps = Connection.prepareStatement(sql);
            r = ps.executeUpdate();
        } catch (SQLException e) {
            form.txtMessage.setText("Not deleted, error: " + e);
        }
        return r;
    }

    private String GetdocType(String documenttype) {
        return switch (documenttype) {
            /*
            Citizenship card
Foreigner id
Identity card
Civil registration
Passport
             */
            case "Citizenship card" ->
                "CC";
            case "Foreigner id" ->
                "CE";
            case "Identity card" ->
                "TI";
            case "Civil registration" ->
                "RC";
            case "Passport" ->
                "PS";
            default ->
                "";

        };
    }
}
