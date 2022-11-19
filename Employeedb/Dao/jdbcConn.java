package Employeedb.Dao;

import Employeedb.model.Employee;

import java.sql.*;

public class jdbcConn {

    Connection con;

    PreparedStatement pstmt;

    ResultSet rs;

    public void DataBase() {

        try {
            Class.forName("oracle.jdbc.OracleDriver");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {

            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "sandeep02");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int empInsert(Employee emp) {

        String sql = "Insert into tblEmployee values (?,?,?)";

        try {

            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,emp.getEmpId());
            pstmt.setString(2,emp.getEmpName());
            pstmt.setDouble(3,emp.getEmpSalary());

            return pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }


    }

    public int empUpdate(Employee emp) {

        String sql = "Update tblEmployee set empName = ?, empSalary= ? where empId = ?";

        try {

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,emp.getEmpName());
            pstmt.setDouble(2,emp.getEmpSalary());
            pstmt.setInt(3,emp.getEmpId());

            return pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public int empDelete(int Eid) {

        String sql = "Delete from tblEmployee where empId = ?";

        try {

            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,Eid);

            return pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Employee empSearch(int Eid) {

        Employee emp = new Employee();

        String sql= "Select * from tblEmployee where empId = ?";

        try {

            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,Eid);

            rs = pstmt.executeQuery();
            rs.next();

            emp.setEmpId(rs.getInt(1));
            emp.setEmpName(rs.getString(2));
            emp.setEmpSalary(rs.getDouble(3));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return emp;

    }


}
