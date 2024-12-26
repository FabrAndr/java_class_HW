

public class laptop {
    private String name;
    private String serialNumber;
    private String cost;
    private String ORD;
    private String color;
    private String os;
    private static Integer count = 0;
    private final Integer index;

    public laptop(String name, String serialNumber, String cost, String ORD, String color, String os) {
        this.name = name;
        this.serialNumber = serialNumber;
        this.cost = cost;
        this.ORD = ORD;
        this.color = color;
        this.os = os;
        this.index = count +=1;
        final laptop lap = this;
        filter.addNewLaptop(lap);
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setORD(String ORD) {
        this.ORD = ORD;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public Integer getIndex() {
        return index;
    }

    public String getColor() {
        return color;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public String getORD() {
        return ORD;
    }

    public String getOs() {
        return os;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        laptop lap = (laptop) o;
        return cost.equals(lap.cost) && ORD.equals(lap.ORD);
    }

    @Override
    public int hashCode() {
        return serialNumber.hashCode();
    }

    @Override
    public String toString() {
        return String.format("Компьютер: %s, %s, %s, %s, %s, %s",
                name, serialNumber, cost, ORD, color, os);
    }
    
}
