package fr.p2i.desk.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;

public class Database {
    private final String user;
    public String database;
    private final String password;
    private final String port;
    private final String hostname;

    private Connection connection;


    public Database() {
        this.hostname = "127.0.0.1";
        this.port = "3306";
        this.database = "db";
        this.user = "root";
        this.password = "MasterNox0";
        this.connection = null;
    }

    public Connection openConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://"
                        + this.hostname + ":" + this.port + "/" + this.database,
                this.user, this.password);
        return connection;
    }

    public boolean checkConnection() {
        return connection != null;
    }

    public Connection getConnection() throws Exception {
        try {
            openConnection();
            return connection;
        } catch (Exception e) {
            throw e;
        }
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                    System.out.println("Error closing MySQL");
                    e.printStackTrace();
            }
        }
    }

    // Sognus code:
    public void insert(SensorData sd) throws Exception {


        Connection c = getConnection();
        Statement s = null;


        s = c.createStatement();


        StringBuilder queries = new StringBuilder("INSERT INTO " + sd.type + " VALUES (");
        String[] st = sd.toString().split(";");
        for (String a : st){
            queries.append(a).append(",");
        }
        queries.append(");");
        s.executeQuery(queries.toString());
    }
}
