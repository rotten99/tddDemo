package facade;

import java.sql.*;
import java.util.ArrayList;

public class DBMapper {


    Connection con = null;

    {
        try {
            con = DBconnector.connection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> allNames() throws SQLException {
        String sql = "SELECT fname FROM startcode_test.usertable";
        ArrayList<String> list = new ArrayList<>();
        try (ResultSet set = con.prepareStatement(sql).executeQuery()) {
            while (set.next()) {
                String actual = set.getString("fname");
                list.add(actual);
            }
        }
        return list;
    }

    public ArrayList<String> specificUser(String name) throws SQLException {
        String sql = "SELECT * FROM startcode_test.usertable where fname = ?";
        ArrayList<String> list = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, name);
            ResultSet set = ps.executeQuery();
            while (set.next()) {
                String fname = set.getString("fname");
                String lname = set.getString("lname");
                String pw = set.getString("pw");
                String phone = set.getString("phone");
                String address = set.getString("address");

                list.add(fname);
                list.add(lname);
                list.add(pw);
                list.add(phone);
                list.add(address);
            }
        }
        return list;
    }

    public int editUser(String change, String name, String column) throws SQLException {
        String sql = "UPDATE startcode_test.usertable set fname = ? where fname = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
//            ps.setString(1, column);
            ps.setString(1, change);
            ps.setString(2, name);
            int affected = ps.executeUpdate();
            return affected;


        }
    }


}