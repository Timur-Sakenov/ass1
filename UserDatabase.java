package newpackage;

import java.sql.*;

public class UserDatabase {
    Connection con ;

    public UserDatabase(Connection con) {
        this.con = con;
    }
    
    public boolean saveUser(User user){
        boolean set = false;
        try{
            String query = null;
            PreparedStatement pt = this.con.prepareStatement(query);
            pt.setString(1, user.getName());
            pt.setString(2, user.getEmail());
            pt.setString(3, user.getPassword());

            pt.executeUpdate();
            set = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return set;
    }
}