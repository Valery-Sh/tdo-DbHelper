/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tdo.db.helper;

/**
 *
 * @author valery
 */
public class DerbyClient extends CommonClient {
    
    
    public DerbyClient(String host, int port) {
        super(host,port,null,null,null);
    }
    
    public DerbyClient(String host, int port, String database) {
        super(host,port,database,null,null);
    }

    public DerbyClient(String host, int port, String database, String user,String password) {
        super(host,port,database,user,password);
    }

    public DerbyClient(String database, String user,String password) {
        this("localhost",1527,database,user,password);
    }

    /**
     * 
     * @return
     */
    @Override
    public String getConnectionString() {
        return "jdbc:derby://" + getHost() + ":" + getPort() + 
                "/" + getDatabase();
    }
    
    /**
     * 
     * @return
     */
    @Override
    public String getDriverName() {
        return "org.apache.derby.jdbc.ClientDriver";

    }
    
}//class DerbyClient
