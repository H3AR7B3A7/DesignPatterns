package FlyweightPattern;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class FlyweightPattern2 {
    public static void main(String[] args) throws Exception {
        RobotFactory robotFactory = new RobotFactory();

        Robot myRobot;
        for (int i = 0; i < 3; i++) {
            myRobot = RobotFactory.getRobotFromFactory("small");
            Thread.sleep(1000);
            myRobot.showMe(getRandomColor());
        }
        int numOfDistinctRobots = robotFactory.totalObjectsCreated();
        System.out.println("Total number of distinct robots = " + numOfDistinctRobots);

        for (int i = 0; i < 5; i++) {
            myRobot = RobotFactory.getRobotFromFactory("large");
            Thread.sleep(1000);
            myRobot.showMe(getRandomColor());
        }
        numOfDistinctRobots = robotFactory.totalObjectsCreated();
        System.out.println("Total number of distinct robots = " + numOfDistinctRobots);

        for (int i = 0; i < 4; i++) {
            myRobot = RobotFactory.getRobotFromFactory("fixed");
            Thread.sleep(1000);
            myRobot.showMe(getRandomColor());
        }
        numOfDistinctRobots = robotFactory.totalObjectsCreated();
        System.out.println("Total number of distinct robots = " + numOfDistinctRobots);
    }

    private static String getRandomColor() {
        Random r = new Random();
        int random = r.nextInt();
        if (random % 2 == 0) {
            return "red";
        } else {
            return "green";
        }
    }
}

interface Robot {
    void showMe(String color);
}

class SmallRobot implements Robot {
    private final String robotTypeCreated;

    public SmallRobot() {
        this.robotTypeCreated = "Small robot created...";
        System.out.println(robotTypeCreated);
    }

    @Override
    public void showMe(String color) {
        System.out.println("...with " + color + " color.");
    }
}

class LargeRobot implements Robot {
    private final String robotTypeCreated;

    public LargeRobot() {
        this.robotTypeCreated = "Large robot created ...";
        System.out.println(robotTypeCreated);
    }

    @Override
    public void showMe(String color) {
        System.out.println("...with " + color + " color.");
    }
}

class FixedSizeRobot implements Robot {
    private final String robotTypeCreated;

    public FixedSizeRobot() {
        this.robotTypeCreated = "Fixed size robot created ...";
        System.out.println(robotTypeCreated);
    }

    @Override
    public void showMe(String color) {
        System.out.println("...with blue (default) color.");
    }
}

class RobotFactory {
    static Map<String, Robot> robotFactory = new HashMap<>();

    public int totalObjectsCreated() {
        return robotFactory.size();
    }

    public static synchronized Robot getRobotFromFactory(String robotType) throws Exception {
        Robot robotCategory = robotFactory.get(robotType);
        if (robotCategory == null) {
            switch (robotType) {
                case "small" -> {
                    System.out.println("No small robots in stock, constructing ...");
                    robotCategory = new SmallRobot();
                }
                case "large" -> {
                    System.out.println("No large robots in stock, constructing...");
                    robotCategory = new LargeRobot();
                }
                case "fixed" -> {
                    System.out.println("No fixed robots in stock, constructing...");
                    robotCategory = new FixedSizeRobot();
                }
                default -> throw new ClassNotFoundException("Can only create small, large or fixed robots.");
            }
            robotFactory.put(robotType, robotCategory);
        } else {
            System.out.println("Using existing " + robotType + " robot and coloring it.");
        }
        return robotCategory;
    }
}