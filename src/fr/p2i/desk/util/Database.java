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
    public void insert() throws Exception {


        Connection c = null;
        Statement s = null;


        s = c.createStatement();


        String[] queries = new String[]{"CREATE TABLE ",""};
        for (String query : queries) {
            if (query != null && query != "")
                s.execute(query);
        }

    }
}
