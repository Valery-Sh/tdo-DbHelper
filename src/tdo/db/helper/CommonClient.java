/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tdo.db.helper;

import java.sql.*;

/**
 *
 * @author valery
 */
public class CommonClient {
    
    /**
     * 
     */
    
    private String user;
    private String password;
    private String host;
    private int port;
    private String database;
    
    
    /**
     * 
     * @param host
     * @param port
     */
    public CommonClient(String host, int port) {
        this(host,port,null,null,null);
    }
    
    /**
     * 
     * @param host
     * @param port
     * @param database
     */
    public CommonClient(String host, int port, String database) {
        this(host,port,database,null,null);
    }

    /**
     * 
     * @param host
     * @param port
     * @param database
     * @param user
     * @param password
     */
    public CommonClient(String host, int port, String database, String user,String password) {
        this.host = host;
        this.port = port;
        this.database = database;
        this.user = user;
        this.password = password;
    }

    /**
     * По умолчанию используется <code>Java DB</code>.
     * @param database
     * @param user
     * @param password
     */
    public CommonClient(String database, String user,String password) {
        this("localhost",1527,database,user,password);
    }

    /**
     * 
     * @return
     */
    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    /**
     * 
     * @return
     * @throws java.lang.Exception
     */
    public Connection getConnection() throws Exception{
        return getConnection( getConnectionString(), user,password);                
    }
    
    public String getConnectionString() {
        return "jdbc:derby://" + getHost() + ":" + getPort() + 
                "/" + getDatabase();
    }
    
    public String getDriverName() {
        return "org.apache.derby.jdbc.ClientDriver";

    }
    protected Connection getConnection(String connString, String user, String password ) throws Exception{
        Connection conn;//My 06.03.2012 = null;
        
        Class.forName(getDriverName());
        conn = DriverManager.getConnection(connString, user,password);                
        
        return conn;
        
    }
    
    /**
     * 
     * @param conn
     * @param query
     * @return
     * @throws java.lang.Exception
     */
    public ResultSet getResultSet(Connection conn,String query) throws Exception {
        Statement stmt;//My 06.03.2012 = null;
        ResultSet rs = null;
        try {
            // To test our connection, we will try to do a select from the system catalog tables
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            
        } catch (SQLException sqle) {
            System.out.println("SQLException when querying on the database connection; " + sqle);
            throw sqle;
        } 
        
        return rs;
    }
}//class CommonClient
