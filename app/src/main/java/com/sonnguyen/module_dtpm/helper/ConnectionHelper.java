package com.sonnguyen.module_dtpm.helper;

import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionHelper {
    Connection conn;
    String ip,port,username,password,databaseName;

    public Connection connectionClass(){
        ip = "192.168.0.107";
        port = "49713";
        username = "son";
        password = "sonnguyen123";
        databaseName = "test";

        StrictMode.ThreadPolicy tp = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(tp);
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            String connectionUrl = "jdbc:jtds:sqlserver://" + ip + ":" + port + ";databasename=" + databaseName + ";User=" + username + ";password=" + password + ";";
            conn = DriverManager.getConnection(connectionUrl);
        } catch (Exception exception) {
            Log.e("Error", exception.getMessage());
        }
        return conn;
    }
}
