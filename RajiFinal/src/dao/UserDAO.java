package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import entites.User;


public class UserDAO {
 
    public User checkLogin(String email, String pwd,String role) throws SQLException,
            ClassNotFoundException {
        String jdbcURL = "jdbc:mysql://localhost:3306/raji";
        String dbUser = "root";
        String dbPassword = "";
 
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
        String sql = "SELECT * FROM user WHERE email = ? and pwd = ? and role = ?;";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, email);
        statement.setString(2, pwd);
        statement.setString(3, role);
        ResultSet result = statement.executeQuery();
 
        User user = null;
 
        if (result.next()) {
            user = new User();
            user.setName(result.getString("name"));
            user.setEmail(email);
            user.setRole(role);
        }
 
        connection.close();
 
        return user;
    }
    public UserDAO() {}
    private String jdbcURL = "jdbc:mysql://localhost:3306/raji";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";
    
    
    private static final String INSERT_USERS_SQL = "INSERT INTO user" + "  (name,email,role,pwd) VALUES " +
            " (?, ?, ?, ?);";

        private static final String SELECT_USER_BY_ID = "select * from user where id =?";
        private static final String SELECT_ALL_USERS = "select id,name, email, role, pwd from user";
        private static final String SELECT_ALL_ENS = "select id,name, email, role, pwd from user where role='enseignant'";

        private static final String DELETE_USERS_SQL = "delete from user where id = ?;";
        private static final String UPDATE_USERS_SQL = "update user set name = ?,email= ?, role =?, pwd =? where id = ?;";
        
        protected Connection getConnection() {
            Connection connection = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return connection;
        }
        
        //ajout
        public void insertUser(User user) throws SQLException {
            System.out.println(INSERT_USERS_SQL);
            // try-with-resource statement will auto close the connection.
            try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
                preparedStatement.setString(1, user.getName());
              
                preparedStatement.setString(2, user.getEmail());
                preparedStatement.setString(3, user.getRole());
            
                preparedStatement.setString(4, user.getPwd());
                System.out.println(preparedStatement);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
             
            }
        }
    
    

        public User selectUser(int id) {
            User user = null;
            // Step 1: Establishing a Connection
            try (Connection connection = getConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
                preparedStatement.setInt(1, id);
                System.out.println(preparedStatement);
                // Step 3: Execute the query or update query
                ResultSet rs = preparedStatement.executeQuery();

                // Step 4: Process the ResultSet object.
                while (rs.next()) {
                    String name = rs.getString("name");
                    
                    String email = rs.getString("email");
                    String role = rs.getString("role");
                
                    String pwd = rs.getString("pwd");
                   
                   
                    user = new User(id, name,  email,  role,  pwd);
                }
            } catch (SQLException e) {
                printSQLException(e);
            }
            return user;
        }

        public List < User > selectAllUsers() {

            // using try-with-resources to avoid closing resources (boiler plate code)
            List < User > users = new ArrayList < > ();
            // Step 1: Establishing a Connection
            try (Connection connection = getConnection();

                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
                System.out.println(preparedStatement);
                // Step 3: Execute the query or update query
                ResultSet rs = preparedStatement.executeQuery();

                // Step 4: Process the ResultSet object.
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    String role = rs.getString("role");
                    String pwd = rs.getString("pwd");
                 
                    users.add(new User(id, name,  email,  role,  pwd));
                   
                }
            } catch (SQLException e) {
                printSQLException(e);
            }
            return users;
        }
        public List < User > selectEns() {

            // using try-with-resources to avoid closing resources (boiler plate code)
            List < User > users = new ArrayList < > ();
            // Step 1: Establishing a Connection
            try (Connection connection = getConnection();

                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ENS);) {
                System.out.println(preparedStatement);
                // Step 3: Execute the query or update query
                ResultSet rs = preparedStatement.executeQuery();

                // Step 4: Process the ResultSet object.
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    String role = rs.getString("role");
                    String pwd = rs.getString("pwd");
                 
                    users.add(new User(id, name,  email,  role,  pwd));
                   
                }
            } catch (SQLException e) {
                printSQLException(e);
            }
            return users;
        }

        public boolean deleteUser(int id) throws SQLException {
            boolean rowDeleted;
            try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
                statement.setInt(1, id);
                rowDeleted = statement.executeUpdate() > 0;
            }
            return rowDeleted;
        }
      

public boolean updateUser(User user) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			statement.setString(1, user.getName());
			statement.setString(2, user.getEmail());
			statement.setString(3, user.getRole());
statement.setString(4, user.getPwd());
			statement.setInt(5, user.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
        private void printSQLException(SQLException ex) {
            for (Throwable e: ex) {
                if (e instanceof SQLException) {
                    e.printStackTrace(System.err);
                    System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                    System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                    System.err.println("Message: " + e.getMessage());
                    Throwable t = ex.getCause();
                    while (t != null) {
                        System.out.println("Cause: " + t);
                        t = t.getCause();
                    }
                }
            }
        }
    }