package Items;

public class item {


    private String name;
    private double length, width, height, weight;

    public item(String name, double length, double width, double height, double weight) {
        this.name = name;
        this.length = length;
        this.width = width;
        this.height = height;
        this.weight = weight;
    }

    public String getName() { return name; }
    public double getLength() { return length; }
    public double getWidth() { return width; }
    public double getHeight() { return height; }
    public double getWeight() { return weight; }

    public double calculateVolume() {
        return (length / 100) * (width / 100) * (height / 100);
    }

    public void displayInfo() {
        System.out.println("Item: " + name);
        System.out.println("Size: " + length + "x" + width + "x" + height + " cm");
        System.out.println("Weight: " + weight + " kg");
        System.out.println("Volume: " + calculateVolume() + " cubic meters");
    }
}
