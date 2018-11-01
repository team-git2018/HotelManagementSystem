package databaseoperations;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

interface UserDAO {

    List<User> findAll()throws ClassNotFoundException, SQLException;

    User findByEmail(String email)throws ClassNotFoundException, SQLException;

    boolean insertUser(User user)throws ClassNotFoundException, SQLException;

    void updateUser(User user)throws ClassNotFoundException, SQLException;

    void deleteUser(User user)throws ClassNotFoundException, SQLException;

}

public class User {

    public String first_name, last_name, email, password, address;
    public long phone_no;
    public int user_id;

    public User(){}
    
    public User(
            String first_name, String last_name, String email,
            String password, String address, long phone_no
    ) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phone_no = phone_no;

    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNo(long phone_no) {
        this.phone_no = phone_no;
    }

    public String getFirstName() {
        return this.first_name;
    }

    public String getLastName() {
        return this.last_name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public String getAddress() {
        return this.address;
    }

    public long getPhoneNo() {
        return this.phone_no;
    }
}

class UserDAOImplementation implements UserDAO
{

    @Override
    public List<User> findAll()throws ClassNotFoundException, SQLException {
        List<User> listOfUsers = new ArrayList<User>();
        Connection con = DatabaseOperations.establishConnection();
        Statement statement = con.createStatement();
        ResultSet resulSet = statement.executeQuery("select * from users");
        while(resulSet.next())
        {
            User userObject = new User();
            userObject.first_name = resulSet.getString(1);
            userObject.last_name = resulSet.getString(2);
            userObject.email = resulSet.getString(3);
            userObject.password = resulSet.getString(4);
            userObject.address = resulSet.getString(5);
            userObject.phone_no = resulSet.getInt(6);            
            listOfUsers.add(userObject);
        }
        con.close();
        return listOfUsers;
    }

    @Override
    public User findByEmail(String email)throws ClassNotFoundException, SQLException {
        Connection con = DatabaseOperations.establishConnection();
        Statement statement = con.createStatement();
        ResultSet resulSet = statement.executeQuery("select * from users where email ="+email);
        User userObject = null;
        while(resulSet.next())
        {
            userObject = new User();
            userObject.first_name = resulSet.getString(1);
            userObject.last_name = resulSet.getString(2);
            userObject.email = resulSet.getString(3);
            userObject.password = resulSet.getString(4);
            userObject.address = resulSet.getString(5);
            userObject.phone_no = resulSet.getInt(6);            
        }
        return userObject;
    }

    @Override
    public boolean insertUser(User user)throws ClassNotFoundException, SQLException {
        Connection con = DatabaseOperations.establishConnection();
        String query = "Insert into users(first_name, last_name, email, password, address, phone_no) values (?,?,?,?,?,?)";
        PreparedStatement st = con.prepareStatement(query);
        st.setString(1, user.first_name);
        st.setString(2, user.last_name);
        st.setString(3, user.email);
        st.setString(4, user.password);
        st.setString(5, user.address);
        st.setLong(6, user.phone_no);
        int count = 0;
        count = st.executeUpdate();
        if(count > 0){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public void updateUser(User user)throws ClassNotFoundException, SQLException {
        Connection con = DatabaseOperations.establishConnection();
        int user_id = user.user_id;
        String first_name = user.first_name;
        String last_name = user.last_name;
        String email = user.email;
        String password = user.password;
        String address = user.address;
        long phone_no = user.phone_no;
        String query = "update users "
                + "set first_name = "+first_name+","
                + "last_name = "+last_name+","
                + "email = "+email+","
                + "password = "+password+","
                + "address = "+address+","
                + "phone_no = "+phone_no
                + "where user_id ="+user_id;
        Statement statement = con.createStatement();
        statement.executeUpdate(query);                               
    }

    @Override
    public void deleteUser(User user)throws ClassNotFoundException, SQLException {
        Connection con = DatabaseOperations.establishConnection();
        int user_id = user.user_id;
        String query = "delete from users where user_id = "+user_id;  
        Statement statement = con.createStatement();
        statement.executeUpdate(query);
    }

}