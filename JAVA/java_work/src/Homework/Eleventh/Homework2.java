package Homework.Eleventh;

class Vehicle {
    private String type;
    private String Company;
    private String model;
    private String color;

    public Vehicle(String type, String company, String model, String color) {
        this.type = type;
        Company = company;
        this.model = model;
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public String getCompany() {
        return Company;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "type='" + type + '\'' +
                ", Company='" + Company + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}

class Car extends Vehicle {
    private String gearShift;
    private String displacement;

    public Car(String type, String company, String model, String color,
               String gearShift, String displacement) {
        super(type, company, model, color);
        this.gearShift = gearShift;
        this.displacement = displacement;
    }

    @Override
    public String toString() {
        return "Car{" + "type='" + super.getType() +
                "', Company='" + super.getCompany() +
                "', model='" + super.getModel() +
                "', color='" + super.getColor() +
                "', gearShift='" + gearShift +
                "', displacement='" + displacement + '\'' +
                '}';
    }
}

class Airplane extends Vehicle {
    private String capacity;

    public Airplane(String type, String company, String model, String color, String capacity) {
        super(type, company, model, color);
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Airplane{" + "type='" + super.getType() +
                "', Company='" + super.getCompany() +
                "', model='" + super.getModel() +
                "', color='" + super.getColor() +
                "', capacity='" + capacity + '\'' +
                '}';
    }
}

public class Homework2 {
    public static void main(String[] args) {
        // ???????????? ??? ????????????.
        // ???????????? ??? ????????????.
        // ?????? ????????? ???????????? ????????? ?????????.

        Vehicle v = new Vehicle("?????????", "??????????????????", "?????? ?????????", "?????????");
        System.out.println(v);

        Car c = new Car("?????? ??????", "??????", "S500", "?????????", "?????? ?????????", "2996cc");
        System.out.println(c);

        Airplane a = new Airplane("?????? ?????????", "????????????", "A380", "??????", "550???");
        System.out.println(a);
    }
}
