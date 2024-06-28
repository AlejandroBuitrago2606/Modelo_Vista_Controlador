package Model;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import View.TokenForm;

public class TokenDAO {

    PreparedStatement ps;
    ResultSet rs;
    Connection conectionn;
    Conection conect = Conection.getInstance();
    TokenForm form;

    public List List() {
        List<Token> data = new ArrayList<>();
        try {
            conectionn = conect.Connect();
            ps = conectionn.prepareStatement("SELECT * FROM token JOIN apprentice ON token.IdAppren = apprentice.id");
            rs = ps.executeQuery();
            while (rs.next()) {

                Token ap1 = new Token();
                ap1.setId(rs.getInt(1));
                ap1.setIdAppren(rs.getInt(2));
                ap1.setNumTok(rs.getInt(3));
                ap1.setNameprog(rs.getString(4));
                ap1.setSite(rs.getString(5));
                ap1.setCity(rs.getString(6));

                data.add(ap1);

            }
        } catch (SQLException e) {
            form.txtMessage.setText("Not Listed, error: " + e);
        }
        return data;
    }

    public int Add(Token tok) {
        int r = 0;
        String sql = "INSERT INTO token (IdAppren,NumTok,NameProg,Site,City)VALUES(?,?,?,?,?)";
        try {
            conectionn = conect.Connect();
            ps = conectionn.prepareStatement(sql);
            ps.setInt(1, tok.getIdAppren());
            ps.setInt(2, tok.getNumTok());
            ps.setString(3, tok.getNameprog());
            ps.setString(4, getSide(tok.getSite()));
            ps.setString(5, tok.getCity());

            r = ps.executeUpdate();

        } catch (SQLException e) {
            form.txtMessage.setText("Not added, error: " + e);
        }
        return r;
    }

    public int Update(Token tok) {
        int r = 0;
        String sql = "UPDATE token SET IdAppren=? ,NumTok=? ,NameProg=? ,Site=? ,City=? WHERE id=?";
        try {
            conectionn = conect.Connect();
            ps = conectionn.prepareStatement(sql);
            ps.setInt(1, tok.getId());
            ps.setInt(2, tok.getIdAppren());
            ps.setInt(3, tok.getNumTok());
            ps.setString(4, tok.getNameprog());
            ps.setString(5, tok.getSite());
            ps.setString(6, tok.getCity());
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

    public int Delete(int idTok) {
        int r = 0;
        String sql = "DELETE FROM token WHERE id=" + idTok;
        try {
            conectionn = conect.Connect();
            ps = conectionn.prepareStatement(sql);
            r = ps.executeUpdate();
        } catch (SQLException e) {
            form.txtMessage.setText("Not deleted, error: " + e);
        }
        return r;
    }

    private String getSide(String Side) {
        return switch (Side) {

            case "Center Industrial Maintenance and Manufacturing" ->
                "CIMM";
            case "Center for Agricultural and Agroindustrial development" ->
                "CEDEAGRO";
            case "Center for administrative management and business strengthening" ->
                "CEGAFE";
            case "Mining Center" ->
                "MINING";
            default ->
                "";

        };
    }

}
