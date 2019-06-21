package com.ass.dao;

import com.ass.common.C3P0Util;
import com.ass.web.been.NUser;
import com.ass.web.been.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

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
//Nuser
public boolean findUser(String userName) throws Exception{
    String sql = "SELECT userName FROM nuser WHERE userName=?";
    QueryRunner qr =new QueryRunner(C3P0Util.getDataSource());
    String email1 =null;
    email1 =(String)qr.query(sql, new ScalarHandler(1),userName);


    if(email1!=null){
        return true;
    }
    return false;
}
    public boolean findEmail(String email) throws Exception{
        String sql = "SELECT email FROM nuser WHERE email=?";
        QueryRunner qr =new QueryRunner(C3P0Util.getDataSource());
         String email1 =null;
        email1 =(String)qr.query(sql, new ScalarHandler(1),email);


        if(email1!=null){
            return true;
        }
        return false;
    }
public boolean deleteNUser (String userName) throws Exception {

    String sql = "DELETE FROM nuser WHERE userName=?";
    stmt = conn.prepareStatement(sql);
    stmt.setString(1,userName);
    int re = stmt.executeUpdate();

    if(re>0){
        return true;
    }
    return false;
}
 public NUser searchNUser(String userName) throws Exception {

     NUser users =null;
     String str ="SELECT * FROM nuser where userName=?";
     QueryRunner qr =new QueryRunner(C3P0Util.getDataSource());
     users =qr.query(str,new BeanHandler<NUser>(NUser.class),userName);
     return users;

}
    public List<NUser> getUsers() throws Exception{
        List<NUser> users =null;
        String str ="SELECT * FROM nuser";
        QueryRunner qr =new QueryRunner(C3P0Util.getDataSource());
        users =qr.query(str,new BeanListHandler<NUser>(NUser.class));
        return users;
    }
    public boolean addUser(NUser user) throws Exception{

        String sql ="INSERT INTO nuser (userName,userKey,gender,email,selfIntro,birthday,hobby) VALUES(?,?,?,?,?,?,?)";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1,user.getUserName());
        stmt.setString(2,user.getUserKey());
        stmt.setBoolean(3,user.getGender());
        stmt.setString(4,user.getEmail());
        stmt.setString(5,user.getSelfIntro());
        stmt.setString(6,user.getBirthday());
        stmt.setString(7,user.getHobby());
        int re =stmt.executeUpdate();
        if(re>0){
            return true;
        }
        return  false;
    }
    public int getNuserCount() throws Exception{
        int count=-1;
        String sql ="SELECT COUNT(*) FROM nuser";

        stmt = conn.prepareStatement(sql);
        rs =stmt.executeQuery();
        while (rs.next()){
            count=rs.getInt(1);
        }
        return count;
    }
//user
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
