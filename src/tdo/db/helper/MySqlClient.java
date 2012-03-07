/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tdo.db.helper;

/**
 *
 * @author valery
 */
public class MySqlClient extends CommonClient{
    
    /**
     * 
     * @param host
     * @param port
     */
    public MySqlClient(String host, int port) {
        super(host,port,null,null,null);
    }
    
    /**
     * 
     * @param host
     * @param port
     * @param database
     */
    public MySqlClient(String host, int port, String database) {
        super(host,port,database,null,null);
    }

    /**
     * 
     * @param host
     * @param port
     * @param database
     * @param user
     * @param password
     */
    public MySqlClient(String host, int port, String database, String user,String password) {
        super(host,port,database,user,password);
    }

    /**
     * 
     * @param database
     * @param user
     * @param password
     */
    public MySqlClient(String database, String user,String password) {
        this("localhost",3306,database,user,password);
    }
    
    @Override
    public String getConnectionString() {
        return "jdbc:mysql://" + 
                 getHost() + ":" + 
                 getPort() + "/" + 
                 getDatabase();
    }
    
    @Override
    public String getDriverName() {
        return "com.mysql.jdbc.Driver";

    }

}//class FbClient
