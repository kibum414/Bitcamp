import java.sql.*;

class JdbcT {
    JdbcT() {
        Connection con;
        Statement stmt;

        // (1) 오라클 드라이버 로딩
        try {
            // Class.forName("oracle.jdbc.driver.OracleDriver"); // oracle
            // Class.forName("com.mysql.jdbc.Driver"); // mysql
            Class.forName("com.mariadb.jdbc.Driver"); // mariadb
            System.out.println("(1) 오라클 드라이버 로딩 성공");
        } catch(ClassNotFoundException cf) {
            System.out.println("(1) 오라클 드라이버 로딩 실패");
        }

        // (2) 커넥션 생성
        try {
            // String url = "jdbc:oracle:thin:@127.0.0.1:1521:JAVA"; // oracle
            // String url = "jdbc:mysql://localhost:3306/root"; // mysql
            String url = "jdbc:mariadb://localhost:3306/root"; // mariadb
            // con = DriverManager.getConnection(url, "scott", "tiger"); // oracle
            // con = DriverManager.getConnection(url, "root", "Hyosung"); // mysql
            con = DriverManager.getConnection(url, "root", "Hyosung"); // mariadb
            System.out.println("(2) 오라클과 커넥션 생성 성공");
        } catch(SQLException se) {
            System.out.println("(2) 오라클과 커넥션 생성 실패");
        }

        // (3) Statement 생성 / 실행
        ResultSet rs = null;
        try {
            String sql = "select * from DEPT;";
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            System.out.println("(3) Statement 생성 / 실행 성공");
        } catch(SQLException se) {
            System.out.println("(3) Statement 생성 / 실행 실패 ");
        }

        // (4) ResultSet 데이터 추출
        try {
            System.out.println("번호\t부서 이름\t위치");
            System.out.println("-------------------------------------");
            while (rs.next()) {
                int no = rs.getInt(1);
                String dname = rs.getString(2);
                String loc = rs.getString(3);
                System.out.println(no + "\t" + dname + "\t" + loc);
            }
        } catch (SQLException se) {
        }

        // (5) 연결 객체 닫기
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (con != null) con.close();
            System.out.println("(5) 연결 객체 닫기 성공");
        } catch (SQLException se) {
        }

    }

    public static void main(String[] args) {
        new JdbcT();
    }
}
