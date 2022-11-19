package Employeedb;

import Employeedb.Dao.jdbcConn;
import Employeedb.model.Employee;

import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {

        int result;

        Employee employee = new Employee();

        jdbcConn jdbc = new jdbcConn();
        jdbc.DataBase();

        System.out.println("Welcome to Employee CRUD App");

        boolean select = true;

        Scanner sys = new Scanner(System.in);

        while(select) {

            System.out.println("1: Insert");
            System.out.println("2: Update");
            System.out.println("3: Delete");
            System.out.println("4: Search");
            System.out.println("5: Exit");

            System.out.println("Enter Your Choice : ");

            int choice = Integer.parseInt(sys.nextLine());

            switch (choice){

                case 1: {
                    System.out.println("Enter the Id to be Inserted : ");
                    employee.setEmpId(Integer.parseInt(sys.nextLine()));
                    System.out.println("Enter the Name to be Inserted :");
                    employee.setEmpName(sys.nextLine());
                    System.out.println("Enter the Salary to be Inserted :");
                    employee.setEmpSalary(Double.parseDouble(sys.nextLine()));
                    result = jdbc.empInsert(employee);

                    System.out.println(result + " records got Inserted");
                    break;

                }

                case 2 : {

                    System.out.println("Enter the Id to be Updated : ");
                    employee.setEmpId(Integer.parseInt(sys.nextLine()));
                    System.out.println("Enter the Name to be Inserted");
                    employee.setEmpName(sys.nextLine());
                    System.out.println("Enter the Salary to be Inserted");
                    employee.setEmpSalary(Double.parseDouble(sys.nextLine()));
                    result = jdbc.empUpdate(employee);

                    System.out.println(result + " records got Updated");
                    break;

                }

                case 3 : {

                    System.out.println("Enter the Id to be Deleted : ");
                    int eid = Integer.parseInt(sys.nextLine());
                    result = jdbc.empDelete(eid);

                    System.out.println(result + " records got Deleted");
                    break;

                }

                case 4 : {

                    System.out.println("Enter the Id to be Searched : ");
                    int eid = Integer.parseInt(sys.nextLine());
                    employee = jdbc.empSearch(eid);

                    System.out.println("The Details of the employee you searched is :");
                    System.out.println(employee);
                    break;

                }
                case 5 : {

                    select = false;
                    break;
                }



            }



        }


    }

}
