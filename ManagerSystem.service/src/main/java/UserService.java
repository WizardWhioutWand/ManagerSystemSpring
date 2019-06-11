import java.util.ArrayList;
import java.util.List;

public class UserService {
    private  UserDao userDao =new UserDao();

    public  User searchUser(String userName) {
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
   public List<User> getUsers(int currentPage,int pageSize){
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
