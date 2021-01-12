package BuilderPattern;

public class BuilderPattern2 {
    public static void main(String[] args) {
        final Product customCar = new CarBuilderImpl().addHeadLights(5)
                .insertWheels(10)
                .buildBody("Plastic")
                .constructCar();
        System.out.println(customCar);

        CarBuilder carBuilder = new CarBuilderImpl();
        final Product customCar2 = carBuilder.buildBody("Carbon")
                .addHeadLights(4)
                .startUpOperations("Let's build a race car.")
                .endOperations("Pimping this ride!")
                .constructCar();
        System.out.println(customCar2);
    }
}

interface CarBuilder {
    CarBuilder startUpOperations(String startUpMessage);

    CarBuilder buildBody(String bodyType);

    CarBuilder insertWheels(int numberOfWheels);

    CarBuilder addHeadLights(int numberOfHeadlights);

    CarBuilder endOperations(String endOperationsMessage);

    Product constructCar();

    Product getConstructedCar();
}

class CarBuilderImpl implements CarBuilder {
    private String startUpMessage = "Building the product.";
    private String bodyType = "Steel";
    private int numberOfWheels = 4;
    private int numberOfHeadlights = 4;
    private String endOperationsMessage = "The product was successfully created.";
    Product product;

    @Override
    public CarBuilder startUpOperations(String startUpMessage) {
        this.startUpMessage = startUpMessage;
        return this;
    }

    @Override
    public CarBuilder buildBody(String bodyType) {
        this.bodyType = bodyType;
        return this;
    }

    @Override
    public CarBuilder insertWheels(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
        return this;
    }

    @Override
    public CarBuilder addHeadLights(int numberOfHeadlights) {
        this.numberOfHeadlights = numberOfHeadlights;
        return this;
    }

    @Override
    public CarBuilder endOperations(String endOperationsMessage) {
        this.endOperationsMessage = endOperationsMessage;
        return this;
    }

    @Override
    public Product constructCar() {
        product = new Product(this.startUpMessage, this.bodyType, this.numberOfWheels, this.numberOfHeadlights, this.endOperationsMessage);
        return product;
    }

    @Override
    public Product getConstructedCar() {
        return product;
    }
}

final class Product {
    private final String startUpMessage;
    private final String bodyType;
    private final int numberOfWheels;
    private final int numberOfHeadlights;
    private final String endOperationsMessage;

    public Product(String startUpMessage, String bodyType, int numberOfWheels, int numberOfHeadlights, String endOperationsMessage) {
        this.startUpMessage = startUpMessage;
        this.bodyType = bodyType;
        this.numberOfWheels = numberOfWheels;
        this.numberOfHeadlights = numberOfHeadlights;
        this.endOperationsMessage = endOperationsMessage;
    }

    @Override
    public String toString() {
        return "Product{" +
                "startUpMessage='" + startUpMessage + '\'' +
                ", bodyType='" + bodyType + '\'' +
                ", numberOfWheels=" + numberOfWheels +
                ", numberOfHeadlights=" + numberOfHeadlights +
                ", endOperationsMessage='" + endOperationsMessage + '\'' +
                '}';
    }
}