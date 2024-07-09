package pack1.com;

import java.sql.*;

public class DataStorage {
    private Connection connection;

    public DataStorage() {
        try {
            // Replace with your database URL, user, and password
            String url = "jdbc:mysql://localhost:3306/career_management";
            String user = "root";
            String password = "";
            connection = DriverManager.getConnection(url, user, password);
            if (connection != null) {
                System.out.println("Connected to the database.");
            } else {
                System.out.println("Failed to connect to the database.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addUser(User1 user) {
        if (connection == null) {
            System.out.println("No database connection.");
            return;
        }

        String query = "INSERT INTO users (name, education, experience, skills, career_goals) VALUES (?, ?, ?, ?, ?)";
        try {
        	PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, user.getName());
            statement.setString(2, user.getEducation());
            statement.setString(3, user.getExperience());
            statement.setString(4, user.getSkills());
            statement.setString(5, user.getCareerGoals());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User1 getUser(String name) {
        if (connection == null) {
            System.out.println("No database connection.");
            return null;
        }

        String query = "SELECT * FROM users WHERE name = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User1 user = new User1(resultSet.getString("name"));
                user.setEducation(resultSet.getString("education"));
                user.setExperience(resultSet.getString("experience"));
                user.setSkills(resultSet.getString("skills"));
                user.setCareerGoals(resultSet.getString("career_goals"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateUser(String name, User1 user) {
        if (connection == null) {
            System.out.println("No database connection.");
            return;
        }

        String query = "UPDATE users SET education = ?, experience = ?, skills = ?, career_goals = ? WHERE name = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getEducation());
            statement.setString(2, user.getExperience());
            statement.setString(3, user.getSkills());
            statement.setString(4, user.getCareerGoals());
            statement.setString(5, name);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUser(String name) {
        if (connection == null) {
            System.out.println("No database connection.");
            return;
        }

        String query = "DELETE FROM users WHERE name = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
