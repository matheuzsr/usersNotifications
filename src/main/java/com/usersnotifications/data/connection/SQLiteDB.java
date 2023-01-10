package com.usersnotifications.data.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import io.github.cdimascio.dotenv.Dotenv;

public class SQLiteDB {
    private Connection conn = null;
    private Statement stmt;
    private ResultSet rs;

    private static SQLiteDB instance;

    public SQLiteDB() {
    }

    public static SQLiteDB getInstance() {
        if (instance == null) {
            instance = new SQLiteDB();
        }

        return instance;
    }

    public Connection conectar() throws SQLException {
        String uri = this.getUriConexao();
        conn = DriverManager.getConnection(uri);

        return conn;

    }

    public boolean atualizar(String comando) throws Exception {
        this.stmt = conn.createStatement();
        stmt.executeUpdate(comando);
        return true;

    }

    public ResultSet consultar(String query) throws Exception {
        this.stmt = conn.createStatement();
        this.rs = stmt.executeQuery(query);

        return this.rs;
    }

    public void close() throws SQLException {
        this.conn.close();
    }

    public ResultSet getRs() {
        return rs;
    }

    private String getUriConexao() {
        Dotenv dotenv = Dotenv.configure().load();
        return dotenv.get("DB_CONECTION");
    }

}
