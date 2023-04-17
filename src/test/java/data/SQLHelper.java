package data;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLHelper {

    private static QueryRunner runner = new QueryRunner();

    private SQLHelper() {
    }

    private static Connection getConnection()
            throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass");
    }

    @SneakyThrows
    public static String getPaymentStatus() {
        var status = "SELECT status FROM payment_entity ORDER BY created DESC LIMIT 1;";
        return runner.query(getConnection(), status, new ScalarHandler<>());
    }

    @SneakyThrows
    public static String getCreditStatus() {
        var status = "SELECT status FROM credit_request_entity ORDER BY created DESC LIMIT 1;";
        return runner.query(getConnection(), status, new ScalarHandler<>());
    }

    @SneakyThrows
    public static String getPaymentId() {
        var paymentId = "SELECT payment_id FROM order_entity ORDER BY created DESC LIMIT 1";
        return runner.query(getConnection(), paymentId, new ScalarHandler<>());
    }

    @SneakyThrows
    public static String getTransactionId() {
        var transactionId = "SELECT transaction_id FROM payment_entity ORDER BY created DESC LIMIT 1";
        return runner.query(getConnection(), transactionId, new ScalarHandler<>());
    }

    @SneakyThrows
    public static String getCreditId() {
        var creditId = "SELECT credit_id FROM order_entity ORDER BY created DESC LIMIT 1";
        return runner.query(getConnection(), creditId, new ScalarHandler<>());
    }




}



