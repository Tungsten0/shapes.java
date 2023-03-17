package cis283;

import java.util.Scanner;
import java.util.logging.*;
import java.sql.*;

//@authors Marco, Amali Teck

public class Main {
    public static void main(String[] args) {
        // Collect info and create solid array
        Solid[] solids = protocol_0();

        // display inertia and torque
        printStuff(solids);

        // Using bubble sort
        Solid[] sorted = sortBubble(solids);

        // display the torque of the sorted array
        System.out.println("Sorted Array:");
        printStuff(sorted);

        // mysql connection and upload of data
        usbWebServer(sorted);
    }

    public static void usbWebServer(Solid[] solid) {

        String URL = "jdbc:mysql://localhost:3307/shapes";
        String USER = "root";
        String PASS = "usbw";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASS);

            String sql = "insert into solids (Mass, Radius, Angular_Acceleration, Inertia, Torque) values (?, ?, ?, ?, ?)";
            PreparedStatement stmt;

            stmt = con.prepareStatement(sql);

            for (int x = 0; x < solid.length; x++) {
                stmt.setDouble(1, solid[x].getMass());
                stmt.setDouble(2, solid[x].getRadius());
                stmt.setDouble(3, solid[x].getAngularAcceleration());
                stmt.setDouble(4, solid[x].getInertia());
                stmt.setDouble(5, solid[x].getTorque());
                stmt.executeUpdate();
            }

            stmt.close();
            con.close();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void printStuff(Solid[] solids) {
        for (Solid solid : solids) {
            System.out.println("Inertia: " + solid.getInertia());
            System.out.println("Torque: " + solid.getTorque());
        }
    }

    public static void Display() {
        System.out.println("\n\n\nAvailable shapes able to be created:");
        System.out.println("IDNum   |     Solid     |      Correct r values (m)      |    Correct mass values (kg)");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("1       |     cone      |      0.024 <= r <= 0.070       |    0.230 <= mass <= 9.7");
        System.out.println("2       |     sphere    |      0.015 <= r <= 0.045       |    0.110 <= mass <= 10");
        System.out.println("3       |     disk      |      0.093 <= r <= 0.207       |    0.088 <= mass <= 11");
    }

    // method to collect info and make solids
    public static Solid[] protocol_0() {
        Scanner in = new Scanner(System.in);
        double mass, radius, angular_acceleration;
        int option;
        Solid[] solids = new Solid[5];

        for (int i = 0; i < solids.length; i++) {
            Display();
            System.out.println("Please enter the ID number of which solid you'd like to create: ");
            option = in.nextInt();

            // loop to check if input entered is within the options of: 1 - 3
            while (option < 1 && option > 3) {
                System.out.println("Please enter a valid ID number: ");
                option = in.nextInt();
            }

            System.out.println("\n\nCreating solid " + (i + 1) + "... \n");

            switch (option) {
                // Cone
                case 1:
                    mass = askMass();
                    // loop to check range of mass input
                    while (Cone.checkMass(mass) == false) {
                        mass = askMass();
                    }

                    radius = askRadius();
                    // loop to check range of radius input
                    while (Cone.checkRadius(radius) == false) {
                        radius = askRadius();
                    }

                    angular_acceleration = askAngAcc();

                    solids[i] = new Cone(mass, radius, angular_acceleration);
                    break;

                // Sphere
                case 2:
                    mass = askMass();
                    // loop to check range of mass input
                    while (Sphere.checkMass(mass) == false) {
                        mass = askMass();
                    }

                    radius = askRadius();
                    // loop to check range of radius input
                    while (Sphere.checkRadius(radius) == false) {
                        radius = askRadius();
                    }

                    angular_acceleration = askAngAcc();

                    solids[i] = new Sphere(mass, radius, angular_acceleration);
                    break;

                // Disk
                case 3:
                    mass = askMass();
                    // loop to check range of mass input
                    while (Disk.checkMass(mass) == false) {
                        mass = askMass();
                    }

                    radius = askRadius();
                    // loop to check range of radius input
                    while (Disk.checkRadius(radius) == false) {
                        radius = askRadius();
                    }

                    angular_acceleration = askAngAcc();

                    solids[i] = new Disk(mass, radius, angular_acceleration);
                    break;
                default:
                    break;
            }
        }
        return solids;
    }

    public static double askMass() {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the correct mass of the solid thats within the range: ");
        double mass = in.nextDouble();
        return mass;
    }

    public static double askRadius() {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the correct radius of the solid thats within the range: ");
        double radius = in.nextDouble();
        return radius;
    }

    public static double askAngAcc() {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the angular acceleration of the solid: ");
        double angacc = in.nextDouble();
        return angacc;
    }

    // Bubble sorting algorithm
    public static Solid[] sortBubble(Solid[] solids) {
        Solid[] sortArr = solids;
        boolean sorted = false;
        Solid temp;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < sortArr.length - 1; i++) {
                if (sortArr[i].getTorque() > sortArr[i + 1].getTorque()) {
                    temp = sortArr[i];
                    sortArr[i] = sortArr[i + 1];
                    sortArr[i + 1] = temp;
                    sorted = false;
                }
            }
        }
        return sortArr;
    }
}
