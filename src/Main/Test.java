package Main;

import Items.Laptop;
import Items.Mouse;
import Items.Desktop;
import Items.Lcdscreens;
import Methods.Calculation;

public class Test {
    public static void main(String[] args) {
        if (args.length < 4) {
            System.out.println("Please provide quantities for laptops, mice, desktops, and LCD screens.");
            return;
        }

        int laptops = Integer.parseInt(args[0]);
        int mice = Integer.parseInt(args[1]);
        int desktops = Integer.parseInt(args[2]);
        int lcdScreens = Integer.parseInt(args[3]);

        if (laptops <= 0 && mice <= 0 && desktops <= 0 && lcdScreens <= 0) {
            System.out.println("Please place an order.");
            return;
        }

        Calculation calculation = new Calculation();

        for (int i = 0; i < laptops; i++) {
            calculation.addItem(new Laptop());
        }
        for (int i = 0; i < mice; i++) {
            calculation.addItem(new Mouse());
        }
        for (int i = 0; i < desktops; i++) {
            calculation.addItem(new Desktop());
        }
        for (int i = 0; i < lcdScreens; i++) {
            calculation.addItem(new Lcdscreens());
        }

        calculation.displayOrderInfo();
    }
}
