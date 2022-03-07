package edu.neumont.database;

import edu.neumont.controller.AirlineController;
import edu.neumont.model.Person;

import java.sql.*;
import java.util.ArrayList;

public class MySQL {

    private Connection connection;
    private AirlineController airlineController = new AirlineController();

    private void createConnection() throws Exception {
        // create a mysql database connection
        String myDriver = "com.mysql.cj.jdbc.Driver";
        String myUrl = "jdbc:mysql://localhost:3306/airportmanagement";
        Class.forName(myDriver);
        connection = DriverManager.getConnection(myUrl, "airport", "airportManagement!");
    }

    public void selectSQLUsers(ArrayList<Person> customers) {
        try {
            createConnection();

            String query = "SELECT * from users";

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                int user_id = rs.getInt("user_id");
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                boolean is_minor = rs.getBoolean("is_minor");
                int age = rs.getInt("age");
                int balance = rs.getInt("balance");
                int user_pin = rs.getInt("user_pin");

                customers.add(new Person(first_name, last_name, balance, age, is_minor, user_pin));

            }

            close();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void addUser(String firstName, String lastName, boolean isMinor, int age, int balance, int userPin) {
        try {
            createConnection();

            // The insert statement
            String query = "insert into users(first_name, last_name, is_minor, age, balance, user_pin) VALUES (?, ?, ?, ?, ?, ?);";

            // Create the Prepare Statement

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setBoolean(3, isMinor);
            preparedStatement.setInt(4, age);
            preparedStatement.setInt(5, balance);
            preparedStatement.setInt(6, userPin);

            preparedStatement.execute();

            close();

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public Person checkUserExistence(String firstName, String lastName, int userPin) {
        try {
            createConnection();

            // Create the query
            String query = "SELECT * from users WHERE first_name=? AND last_name=? AND user_pin=?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, userPin);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                boolean is_minor = resultSet.getBoolean("is_minor");
                int age = resultSet.getInt("age");
                int balance = resultSet.getInt("balance");
                return new Person(firstName, lastName, balance, age, is_minor, userPin);
            } else {
                System.out.println("They do not exist!");
            }

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return null;
    }

    public void viewAirlines() {
        try {
            createConnection();

            String query = "SELECT * from airline";

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                int airline_id = rs.getInt("airline_id");
                String airline_name = rs.getString("airline_name");

                System.out.format("%s: %s\n", airline_id, airline_name);
            }

            close();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void addAirline(String airline_name) {
        try {
            createConnection();

            // The insert statement
            String query = "SELECT * from airline WHERE airline_name=?";

            // Create the Prepare Statement
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, airline_name);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                System.out.println("The airline " + airline_name + " already exists!");
            } else {
                query = "insert into airline(airline_name) VALUES (?);";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, airline_name);
                preparedStatement.execute();
                System.out.println("The airline " + airline_name + " has been created!");
            }

            close();

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void removeAirline(int airline_id) {
        try {
            createConnection();

            // The insert statement
            String query = "DELETE from airline WHERE airline_id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, airline_id);
            preparedStatement.execute();

            close();

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public String selectAirline(int airline_id) {
        try {
            createConnection();

            // The insert statement
            String query = "SELECT * from airline WHERE airline_id=?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, airline_id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("airline_name");
            } else {
                System.out.println("ERROR!");
                return "";
            }

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return null;
    }

    public String selectPlane(int plane_id) {
        try {
            createConnection();

            // The insert statement
            String query = "SELECT * from plane WHERE plane_id=?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, plane_id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("plane_name");
            } else {
                System.out.println("ERROR!");
                return "";
            }

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return null;
    }



    public void viewPlanes() {
        try {
            createConnection();

            String query = "SELECT * from plane";

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                int plane_id = rs.getInt("plane_id");
                String plane_name = rs.getString("plane_name");
                boolean snacks = rs.getBoolean("snacks");
                int total_seats = rs.getInt("total_seats");

                System.out.format("%s: %s  | Snacks: %s  | Total Seats: %s\n", plane_id, plane_name, snacks, total_seats);
            }

            close();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void addPlane(String plane_name, Boolean snacks, int total_seats) {
        try {
            createConnection();

            // The insert statement
            String query = "SELECT * from plane WHERE plane_name=? AND snacks=? AND total_seats=?";

            // Create the Prepare Statement
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, plane_name);
            preparedStatement.setBoolean(2, snacks);
            preparedStatement.setInt(3, total_seats);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                System.out.println("The plane " + plane_name + " already exists!");
            } else {
                query = "insert into plane(plane_name, snacks, total_seats) VALUES(?, ?, ?);";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, plane_name);
                preparedStatement.setBoolean(2, snacks);
                preparedStatement.setInt(3, total_seats);
                preparedStatement.execute();
                System.out.println("The plane " + plane_name + " has been created!");
            }

            close();

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void removePlane(int plane_id) {
        try {
            createConnection();

            // The insert statement
            String query = "DELETE from plane WHERE plane_id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, plane_id);
            preparedStatement.execute();

            close();

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void viewFlights() {
        try {
            createConnection();

            String query = "SELECT * from flights";

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                int flight_id = rs.getInt("flight_id");
                String flight_name = rs.getString("flight_name");
                String location_departure = rs.getString("location_departure");
                String location_arrival = rs.getString("location_arrival");
                String duration = rs.getString("duration");
                int price = rs.getInt("price");
                int total_seats = rs.getInt("total_seats");
                int plane_id = rs.getInt("plane_id");
                int airline_id = rs.getInt("airline_id");

                System.out.format("%s: Departing: %s  |  Arriving: %s\n  | Duration: %s  | Price: %s\n  | Total Seats: %s  | Plane: %s  | Airline: %s\n",
                        flight_id, location_departure, location_arrival, duration, price, total_seats, selectPlane(plane_id), selectAirline(airline_id));
            }

            close();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void addFlight(String flight_name, String location_departure, String locational_arrival, String duration, int price, int total_seats, int plane_id, int airline_id) {
        try {
            createConnection();

            // The insert statement
            String query = "insert into flights(flight_name, location_departure, location_arrival, duration, price, total_seats, plane_id, airline_id)  VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

            // Create the Prepare Statement
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, flight_name);
            preparedStatement.setString(2, location_departure);
            preparedStatement.setString(3, locational_arrival);
            preparedStatement.setString(4, duration);
            preparedStatement.setInt(5, price);
            preparedStatement.setInt(6, total_seats);
            preparedStatement.setInt(7, plane_id);
            preparedStatement.setInt(8, airline_id);

            preparedStatement.execute();

            close();

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void viewFlightPassengers(String user_id) {

    }



    private void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }


}
