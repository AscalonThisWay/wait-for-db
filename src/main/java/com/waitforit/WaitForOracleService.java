package com.waitforit;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.sql.Connection;
import java.sql.SQLException;

@ApplicationScoped
public class WaitForOracleService {
    public String checkConnection(String url, String user, String password) {

        DriverManagerDataSource ds = new DriverManagerDataSource(url, user, password);
        ds.setDriverClassName(oracle.jdbc.driver.OracleDriver.class.getName());
        try {
            Connection con = ds.getConnection();
            if (con != null) {
                return "DB is ready.";
            }
        } catch(SQLException e) {
            throw new WebApplicationException(e.getMessage(), Response.Status.SERVICE_UNAVAILABLE);
        }
        return "The connection is null. No error was thrown.";

    }
}
