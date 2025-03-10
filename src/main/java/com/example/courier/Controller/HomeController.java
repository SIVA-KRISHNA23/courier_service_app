package com.example.courier.Controller;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@CrossOrigin
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "Welcome to the home page!";
    }
    @GetMapping("/home")
    public String homePage() {
        return "This is the home page!";
    }
    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @GetMapping("/check-database")
    public String checkDatabaseConnection() {
        try (Connection conn = dataSource.getConnection()) {
            return "Connected to database: " + conn.getMetaData().getDatabaseProductName();
        } catch (SQLException e) {
            return "Failed to connect to database: " + e.getMessage();
        }
    }
    @GetMapping("/execute-query")
    public String executeQuery() {
        try {
            int rowCount = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM your_table", Integer.class);
            return "Query executed successfully. Row count: " + rowCount;
        } catch (Exception e) {
            return "Failed to execute query: " + e.getMessage();
        }
    }
}
