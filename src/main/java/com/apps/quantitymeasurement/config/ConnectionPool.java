package com.apps.quantitymeasurement.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
    private final String url;
    private final String user;
    private final String password;
    private final List<Connection> connectionPool;
    private final List<Connection> usedConnections = new ArrayList<>();
    private final int MAX_POOL_SIZE;

    public ConnectionPool(String url, String user, String password, int poolSize) throws SQLException {
        this.url = url;
        this.user = user;
        this.password = password;
        this.MAX_POOL_SIZE = poolSize;
        this.connectionPool = new ArrayList<>(poolSize);

        for (int i = 0; i < poolSize; i++) {
            connectionPool.add(createConnection(url, user, password));
        }
    }

    public Connection getConnection() throws SQLException {
        if (connectionPool.isEmpty()) {
            if (usedConnections.size() < MAX_POOL_SIZE) {
                connectionPool.add(createConnection(url, user, password));
            } else {
                throw new RuntimeException("Maximum pool size reached, no available connections!");
            }
        }

        Connection connection = connectionPool.remove(connectionPool.size() - 1);
        
        if (!connection.isValid(2)) {
            connection = createConnection(url, user, password);
        }
        
        usedConnections.add(connection);
        return connection;
    }

    public boolean releaseConnection(Connection connection) {
        connectionPool.add(connection);
        return usedConnections.remove(connection);
    }

    private static Connection createConnection(String url, String user, String password) throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public int getSize() {
        return connectionPool.size() + usedConnections.size();
    }
    
    public int getAvailableConnections() {
        return connectionPool.size();
    }
}
