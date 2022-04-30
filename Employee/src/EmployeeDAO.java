
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

 
public class EmployeeDAO {
 
    public int registerEmployee(Employee employee) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO employee" +
            "  (first_name, last_name, username, password, address, contact) VALUES " +
            " (?, ?, ?, ?,?,?)";
 
        int result = 0;
 
        Class.forName("oracle.jdbc.driver.OracleDriver");
 
        //Step 1: Established the connection with database
      try (Connection con=DriverManager.getConnection("jdbc:oracle:thin:@10.1.67.153:1521:orcl","MSC19PW35","MSC19PW35");
 
        // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement =  con.prepareStatement(INSERT_USERS_SQL)) {                preparedStatement.setString(1,employee.getFirstName());
            preparedStatement.setString(2,employee.getLastName());
            preparedStatement.setString(3,employee.getUsername());
            preparedStatement.setString(4,employee.getPassword());
            preparedStatement.setString(5, employee.getAddress());
            preparedStatement.setString(6, employee.getContact());
 
        // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();
 
        } catch(Exception e){ 
			System.out.println(e);
		}  
        return result;
    }
 
    
}
