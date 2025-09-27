package common.utilities;

import common.dto.AllureResultDTO;
import common.interfaces.GenericDAO;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;

import static java.nio.charset.StandardCharsets.UTF_8;

public class JDBCHelper implements GenericDAO {

    private static final String con = "jdbc:mysql://localhost:3306/testdb";
    private static final String username = "testuser";
    private static final String password = "testpassword";


    @Override
    public void insert(String uuid, String testName, String status, String startTime, String stopTime) {
        String path = "src/test/resources/sql/insert-table-schema.sql";

        try {
            String sql = new String(Files.readAllBytes(Paths.get(path)), UTF_8);

            try (Connection conn = DriverManager.getConnection(con, username, password);
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setString(1, uuid);
                pstmt.setString(2, testName);
                pstmt.setString(3, status);
                pstmt.setString(4, startTime);
                pstmt.setString(5, stopTime);

                int rowsAffected = pstmt.executeUpdate();
                System.out.println("Inserted " + rowsAffected + " row(s) successfully.");

            } catch (SQLException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void create() {
        String path = "src/test/resources/sql/create-table-schema.sql";
        try {

            String sql = new String(Files.readAllBytes(Paths.get(path)), "UTF-8");

            try (Connection conn = DriverManager.getConnection(con, username, password);
                 Statement stmt = conn.createStatement()) {

                for (String query : sql.split(";")) {
                    if (!query.trim().isEmpty()) {
                        stmt.execute(query);
                    }
                }

                System.out.println("✅ schema.sql executed successfully!");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void get(AllureResultDTO allure) {
        insert(allure.getUuid(),
                allure.getName(),
                allure.getStatus(),
                allure.getStart(),
                allure.getStop()
        );

    }


}
