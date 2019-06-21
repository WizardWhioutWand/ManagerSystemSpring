package com.ass.service;

import com.ass.dao.UserDao;
import com.ass.web.been.NUser;
import com.ass.web.been.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private UserDao userDao =new UserDao();
    //Nuser
    public boolean findUser(String userName){
        boolean delete=false;
        try {
            delete = userDao.findUser(userName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return delete;
    }
    public boolean findEmail(String Email){
        boolean delete=false;
        try {
            delete = userDao.findEmail(Email);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return delete;
    }
    public  boolean deleteNUser(String userName) {
        boolean delete=false;
        try {
            delete = userDao.deleteNUser(userName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return delete;
    }
    public NUser searchNUser(String userName) {
        NUser user =null;
        try {
            user = userDao.searchNUser(userName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
    public List<NUser> getNusers(){
        List<NUser> users =null;
        try {
            users = userDao.getUsers();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }
 public boolean  addUser(NUser user){
     boolean re=false;
     try {
         re= userDao.addUser(user);
     } catch (Exception e) {
         e.printStackTrace();
     }
     return re;
 }
    public int getNusersCount() {
        int count=0;
        try {
            count=userDao.getNuserCount();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
 //user
    public User searchUser(String userName) {
        User user =null;
        try {
            user = userDao.searchUser(userName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
   public int getCount(){
       int count=0;
       try {
           count=userDao.getCount();
       } catch (Exception e) {
           e.printStackTrace();
       }
       return count;
   }
   public List<User> getUsers(int currentPage, int pageSize){
        int head=(currentPage-1)*pageSize;
        int rear =head+pageSize;
        List<User> users =new ArrayList<User>();
       try {
           users=userDao.getUsers(head,rear);
       } catch (Exception e) {
           e.printStackTrace();
       }
       return  users;
   }
    public  boolean deleteUser(String userName) {
        boolean delete=false;
        try {
            delete = userDao.deleteUser(userName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return delete;
    }

    public  boolean addUser(User user) {

        try {
            if(userDao.addUser(user))
                return true;
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
    public void close(){
        userDao.close();
    }


}
