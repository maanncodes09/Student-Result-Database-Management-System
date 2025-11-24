package DatabaseManager;

import Model.Student;
import java.sql.*;
import java.util.ArrayList;

public class DatabaseManagement {

    private static final String URL = "jdbc:mysql://localhost:3306/studentdatabasemanager";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "180705"; // XAMPP default

    private Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public void addStudent(Student s) {
        String sql = "INSERT INTO students(id, name, course) VALUES (?, ?, ?)";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, s.getId());
            ps.setString(2, s.getName());
            ps.setString(3, s.getCourse());

            ps.executeUpdate();
            System.out.println("Student Added!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Student> getAllStudents() {
        ArrayList<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM students";

        try (Connection con = getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String course = rs.getString("course");

                list.add(new Student(id, name, course));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public void updateCourse(int id, String newCourse) {
        String sql = "UPDATE students SET course=? WHERE id=?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, newCourse);
            ps.setInt(2, id);

            ps.executeUpdate();
            System.out.println("Course Updated!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE id=?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

            System.out.println("Student Deleted!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}