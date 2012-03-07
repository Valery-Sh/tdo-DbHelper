/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tdo.db.helper;

/**
 *
 * @author valery
 */
public class FbClient extends CommonClient {
    
    
    public FbClient(String host, int port) {
        this(host,port,null,null,null);
    }
    
    public FbClient(String host, int port, String database) {
        super(host,port,database,null,null);
    }

    public FbClient(String host, int port, String database, String user,String password) {
        super(host,port,database,user,password);
    }
    
    public FbClient(String database, String user,String password) {
        this("localhost",3050,database,user,password);
    }
    /**
     * 
     * @return
     */
    @Override
    public String getConnectionString() {
        return "jdbc:firebirdsql:" + 
                 getHost() + "/" + 
                 getPort() + ":" + 
                 getDatabase();
    }
    /**
     * 
     * @return
     */
    @Override
    public String getDriverName() {
        return "org.firebirdsql.jdbc.FBDriver";
    }

}//class FbClient
