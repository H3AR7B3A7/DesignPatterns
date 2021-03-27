package FacadePattern;

public class FacadePattern2 {
    public static void main(String[] args) {
        RobotFacade robotFacade = new RobotFacade();
        robotFacade.constructMilanoRobot();

        robotFacade.constructRobonautRobot();

        robotFacade.destroyMilanoRobot();
        robotFacade.destroyRobonautRobot();
    }
}

class RobotBody {
    public static void createRobot() {
        System.out.println("Refer the manual before creating a robot.");
    }

    public void createHands() {
        System.out.println("Hands manufactured...");
    }

    public void createRemainingParts() {
        System.out.println("Remaining parts manufactured...");
    }

    public static void destroyRobot() {
        System.out.println("Refer the manual before destroying a robot.");
    }

    public void destroyHands() {
        System.out.println("Destroying hands...");
    }

    public void destroyRemainingParts() {
        System.out.println("Destroying remaining parts...");
    }
}

class RobotColor {
    public void setDefaultColor() {
        System.out.println("Steel color...");
    }

    public void setGreenColor() {
        System.out.println("Green color...");
    }
}

class RobotHands {
    public void setMilanoHands() {
        System.out.println("Milano hands...");
    }

    public void setRobonautHands() {
        System.out.println("Robonaut hands...");
    }

    public void resetMilanoHands() {
        System.out.println("Resetting milano hands...");
    }

    public void resetRobonautHands() {
        System.out.println("Resetting robonaut hands...");
    }
}

class RobotFacade {
    RobotColor robotColor;
    RobotHands robotHands;
    RobotBody robotBody;

    public RobotFacade() {
        this.robotColor = new RobotColor();
        this.robotHands = new RobotHands();
        this.robotBody = new RobotBody();
    }

    public void constructMilanoRobot() {
        RobotBody.createRobot();
        System.out.println("*** Creation of Milano Robot started. ***");
        robotColor.setDefaultColor();
        robotHands.setMilanoHands();
        robotBody.createHands();
        robotBody.createRemainingParts();
        System.out.println("*** Milano Robot has been created. ***\r\n");
    }

    public void constructRobonautRobot() {
        RobotBody.createRobot();
        System.out.println("*** Creation of Robonaut Robot started. ***");
        robotColor.setGreenColor();
        robotHands.setRobonautHands();
        robotBody.createHands();
        robotBody.createRemainingParts();
        System.out.println("*** Robonaut Robot has been created. ***\r\n");
    }

    public void destroyMilanoRobot() {
        RobotBody.destroyRobot();
        System.out.println("*** Destruction of Milano Robot started. ***");
        robotHands.resetMilanoHands();
        robotBody.destroyHands();
        robotBody.destroyRemainingParts();
        System.out.println("*** Milano Robot has been destroyed. ***\r\n");
    }

    public void destroyRobonautRobot() {
        RobotBody.destroyRobot();
        System.out.println("*** Destruction of Robonaut Robot started. ***");
        robotHands.resetRobonautHands();
        robotBody.destroyHands();
        robotBody.destroyRemainingParts();
        System.out.println("*** Robonaut Robot has been destroyed. ***\r\n");
    }
}