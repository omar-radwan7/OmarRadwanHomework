package Containers;

public abstract class Container {
    private double height, width, length;

    public Container(double height, double width, double length) {
        this.height = height;
        this.width = width;
        this.length = length;
    }

    public double getHeight() { return height; }
    public double getWidth() { return width; }
    public double getLength() { return length; }

    public double calculateVolume() {
        return height * width * length;
    }

    public void displayInfo() {
        System.out.println("Container dimensions: " + height + "x" + width + "x" + length + " meters");
        System.out.println("Volume: " + calculateVolume() + " cubic meters");
    }
}
