package DAOTEORIA;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    private Connection connection;

    public EmployeeDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addEmployee(Employee employee) {
        String sql = "INSERT INTO EMPLOYEES (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE, HIRE_DATE, JOB_TITLE) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, employee.getEmployeeId());
            stmt.setString(2, employee.getName());
            stmt.setString(3, employee.getLastName());
            stmt.setString(4, employee.getEmail());
            stmt.setString(5, employee.getPhone());
            stmt.setDate(6, new java.sql.Date(employee.getHireDate().getTime())); // Convertir a java.sql.Date
            stmt.setString(7, employee.getJobTitle());
            stmt.executeUpdate();
            System.out.println("Empleado agregado con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Employee getEmployeeById(int id) {
        String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Employee(rs.getInt("EMPLOYEE_ID"), rs.getString("FIRST_NAME"),rs.getString("LAST_NAME") , rs.getString("EMAIL"), rs.getString("PHONE"),rs.getDate("HIRE_DATE"), rs.getString("JOB_TITLE"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM EMPLOYEES";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                employees.add(new Employee(rs.getInt("EMPLOYEE_ID"), rs.getString("FIRST_NAME"),rs.getString("LAST_NAME") , rs.getString("EMAIL"), rs.getString("PHONE"),rs.getDate("HIRE_DATE"), rs.getString("JOB_TITLE")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public void updateEmployee(Employee employee) {
        String sql = "UPDATE EMPLOYEES SET FIRST_NAME = ?, LAST_NAME = ?, EMAIL = ?, PHONE = ?, HIRE_DATE = ?, JOB_TITLE = ? WHERE EMPLOYEE_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, employee.getName());
            stmt.setString(2, employee.getLastName());
            stmt.setString(3, employee.getEmail());
            stmt.setString(4, employee.getPhone());
            stmt.setDate(5, employee.getHireDate());
            stmt.setString(6, employee.getJobTitle());
            stmt.setInt(7, employee.getEmployeeId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(int id) {
        String sql = "DELETE FROM EMPLOYEES WHERE EMPLOYEE_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> getEmployeesWithOrders() {
        List<Employee> employeesWithOrders = new ArrayList<>();
        String sql = "SELECT DISTINCT e.EMPLOYEE_ID, e.FIRST_NAME, e.LAST_NAME " +
                     "FROM EMPLOYEES e " +
                     "JOIN ORDERS o ON e.EMPLOYEE_ID = o.SALESMAN_ID";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                employeesWithOrders.add(new Employee(
                        rs.getInt("EMPLOYEE_ID"),
                        rs.getString("FIRST_NAME"),
                        rs.getString("LAST_NAME"),
                        null, 
                        null, 
                        null, 
                        null  
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeesWithOrders;
    }

    @Override
    public List<Employee> getOrdersByEmployeeId(int employeeId) {
        List<Employee> orders = new ArrayList<>();
        String sql = "SELECT o.ORDER_ID, o.STATUS, o.ORDER_DATE " +
                     "FROM ORDERS o " +
                     "WHERE o.SALESMAN_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, employeeId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("Order ID: " + rs.getInt("ORDER_ID") +
                                   ", Status: " + rs.getString("STATUS") +
                                   ", Order Date: " + rs.getDate("ORDER_DATE"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    // Nuevas consultas adicionales

    // Obtener empleados con salario mayor a un valor específico
    @Override
    public List<Employee> getEmployeesWithSalaryAbove(double salary) {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM EMPLOYEES WHERE SALARY > ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDouble(1, salary);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                employees.add(new Employee(
                    rs.getInt("EMPLOYEE_ID"),
                    rs.getString("FIRST_NAME"),
                    rs.getString("LAST_NAME"),
                    rs.getString("EMAIL"),
                    rs.getString("PHONE"),
                    rs.getDate("HIRE_DATE"),
                    rs.getString("JOB_TITLE")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    // Obtener el número total de órdenes de un empleado específico
    @Override
    public int getOrderCountByEmployeeId(int employeeId) {
        String sql = "SELECT COUNT(*) FROM ORDERS WHERE SALESMAN_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, employeeId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    // Obtener empleados contratados después de una fecha específica
    @Override
    public List<Employee> getEmployeesHiredAfter(Date hireDate) {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM EMPLOYEES WHERE HIRE_DATE > ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDate(1, hireDate);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                employees.add(new Employee(
                    rs.getInt("EMPLOYEE_ID"),
                    rs.getString("FIRST_NAME"),
                    rs.getString("LAST_NAME"),
                    rs.getString("EMAIL"),
                    rs.getString("PHONE"),
                    rs.getDate("HIRE_DATE"),
                    rs.getString("JOB_TITLE")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    // Obtener empleados y sus órdenes, mostrando también el número de órdenes asociadas a cada uno
    @Override
    public List<Employee> getEmployeesWithOrderCount() {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT e.EMPLOYEE_ID, e.FIRST_NAME, e.LAST_NAME, COUNT(o.ORDER_ID) AS ORDER_COUNT " +
                     "FROM EMPLOYEES e " +
                     "LEFT JOIN ORDERS o ON e.EMPLOYEE_ID = o.SALESMAN_ID " +
                     "GROUP BY e.EMPLOYEE_ID, e.FIRST_NAME, e.LAST_NAME";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                employees.add(new Employee(
                    rs.getInt("EMPLOYEE_ID"),
                    rs.getString("FIRST_NAME"),
                    rs.getString("LAST_NAME"),
                    null, null, null, null
                ));
                System.out.println("Employee: " + rs.getString("FIRST_NAME") + " " + rs.getString("LAST_NAME") +
                                   " - Orders: " + rs.getInt("ORDER_COUNT"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    // Obtener empleados que tienen un título de trabajo específico
    @Override
    public List<Employee> getEmployeesByJobTitle(String jobTitle) {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM EMPLOYEES WHERE JOB_TITLE = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, jobTitle);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                employees.add(new Employee(
                    rs.getInt("EMPLOYEE_ID"),
                    rs.getString("FIRST_NAME"),
                    rs.getString("LAST_NAME"),
                    rs.getString("EMAIL"),
                    rs.getString("PHONE"),
                    rs.getDate("HIRE_DATE"),
                    rs.getString("JOB_TITLE")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    // Obtener empleados que no tienen ninguna orden asignada
    @Override
    public List<Employee> getEmployeesWithoutOrders() {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM EMPLOYEES e " +
                     "WHERE NOT EXISTS (SELECT 1 FROM ORDERS o WHERE o.SALESMAN_ID = e.EMPLOYEE_ID)";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                employees.add(new Employee(
                    rs.getInt("EMPLOYEE_ID"),
                    rs.getString("FIRST_NAME"),
                    rs.getString("LAST_NAME"),
                    rs.getString("EMAIL"),
                    rs.getString("PHONE"),
                    rs.getDate("HIRE_DATE"),
                    rs.getString("JOB_TITLE")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    // Obtener salario promedio de empleados por título de trabajo
    @Override
    public double getAverageSalaryByJobTitle(String jobTitle) {
        String sql = "SELECT AVG(SALARY) FROM EMPLOYEES WHERE JOB_TITLE = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, jobTitle);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
}


