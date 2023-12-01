package com.jagat.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Employee implements Serializable {
    private static final long serialVersionUID = 1L; // SerialVersionUID for version control
    private String name;
    private int employeeId;
    private double salary;

    public Employee(String name, int employeeId, double salary) {
        this.name = name;
        this.employeeId = employeeId;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee [name=" + name + ", employeeId=" + employeeId + ", salary=" + salary + "]";
    }
}

 class EmployeeSerializationExample {
    public static void main(String[] args) {
        // Create some Employee objects
        Employee emp1 = new Employee("John Doe", 101, 50000.0);
        Employee emp2 = new Employee("Jane Smith", 102, 60000.0);

        // Serialize and write objects to a file
        String filePath = "employee_data.ser";
        serializeToFile(filePath, emp1, emp2);

        // Print the location of the file
        System.out.println("Objects serialized and written to file: " + filePath);
        // Deserialize and read objects from the file
        Employee[] employees = deserializeFromFile("employee_data.ser");

        // Display the deserialized objects
        if (employees != null) {
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }

    private static void serializeToFile(String filename, Employee... employees) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            for (Employee employee : employees) {
                oos.writeObject(employee);
            }
            System.out.println("Objects serialized and written to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Employee[] deserializeFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            int numberOfEmployees = ois.readInt();
            Employee[] employees = new Employee[numberOfEmployees];
            
            for (int i = 0; i < numberOfEmployees; i++) {
                employees[i] = (Employee) ois.readObject();
            }

            System.out.println("Objects deserialized from file.");
            return employees;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
}
