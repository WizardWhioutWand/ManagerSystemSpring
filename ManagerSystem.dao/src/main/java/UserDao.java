

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    Connection conn;
    PreparedStatement stmt;
    ResultSet rs;

    {
        try {
            conn = C3P0Util.getConnection();

        } catch (Exception e) {
            System.out.println("连接失败");
            e.printStackTrace();
        }
    }


    public User searchUser(String userName) throws Exception {

        String name=null;
        String passwd=null;
        String sql = "SELECT userName,passwd FROM users WHERE userName=?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, userName);
        ResultSet rs =stmt.executeQuery();
        while (rs.next()){
            name=rs.getString(1);
            passwd=rs.getString(2);
        }
        if(name!=null&&passwd!=null){
            return new User(name,passwd);
        }
        return  null;
    }
    public boolean deleteUser (String userName) throws Exception {

        String sql = "DELETE FROM users WHERE userName=?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1,userName);
        int re = stmt.executeUpdate();

        if(re>0){
            return true;
        }
        return false;
    }

    public boolean addUser (User user) throws Exception{
        String sql ="INSERT INTO users (userName,passwd) VALUES(?,?)";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1,user.getName());
        stmt.setString(2,user.getPasswd());
        int re =stmt.executeUpdate();
        if(re>0){
            return true;
        }
        return  false;
    }
    public int getCount() throws Exception{
        int count=-1;
        String sql ="SELECT COUNT(*) FROM users";
        stmt = conn.prepareStatement(sql);
        rs =stmt.executeQuery();
       while (rs.next()){
           count=rs.getInt(1);
       }
       return count;
    }
    public List<User> getUsers(int first,int rear)throws Exception{
        List<User> users =new ArrayList<User>();
        String sql ="SELECT * FROM users LIMIT ?,?";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1,first);
        stmt.setInt(2,rear);
       rs=stmt.executeQuery();
       while (rs.next()){
           User user =new User();
           user.setName(rs.getString(2));
           user.setPasswd(rs.getString(3));
           users.add(user);

       }
        return users;
    }
    public void close(){
        C3P0Util.release(conn,stmt,rs);
    }
}
