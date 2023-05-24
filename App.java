import java.sql.*;
import java.util.Scanner;
public class App{
    public static void main (String args[]){
       
        Scanner sc = new Scanner(System.in);
        
        try{  

        System.out.println("Enter your name: ");
        String Name = sc.nextLine();

        System.out.println("Enter NID no: ");
        String NID = sc.nextLine();

        System.out.println("Enter phone no: ");
        String phone = sc.nextLine();

        System.out.println("Enter Location: ");
        String location = sc.nextLine();

        System.out.println("Write down the name of the items you need eg. Food,Drinks,Cloths,Medicine etc.");
        String Necessity = sc.nextLine();


        
        Class.forName("com.mysql.cj.jdbc.Driver");  
        Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/reliefManagementSystem","root","root"); 
        
      
        String query1 = "Insert into relief" + "(Name,NID,Phone_no,Location,Necessity)"+ "values(?,?,?,?,?)";
        PreparedStatement stmt = con.prepareStatement(query1);
      
        stmt.setString(1,Name);
        stmt.setString(2, NID);
        stmt.setString(3,phone);
        stmt.setString(4,location);
        stmt.setString(5, Necessity);  
        stmt.executeUpdate();

        
        
        ResultSet rs = stmt.executeQuery("select * from relief");
        while(rs.next()){
        System.out.print(rs.getInt("Name"));
        System.out.print(rs.getInt("NID"));
        System.out.print(rs.getInt("Phone_no"));
        System.out.print(rs.getInt("Location"));
        System.out.print(rs.getInt("Necessity"));
        }
        
        con.close();
        sc.close();
        
        }
        catch(Exception e){
            System.out.println(e); 
            } 
    }
}