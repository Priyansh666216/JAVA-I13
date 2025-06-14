import java.util.Scanner;

    public class sheet {
        protected double length;
        protected double width;
        protected static final double COST_PER_SQ_FT = 40;


        public sheet(double length, double width) {
            this.length = length;
            this.width = width;
        }


        public double calculateArea() {
            return length * width;
        }


        public double calculateCost() {
            return calculateArea() * COST_PER_SQ_FT;
        }


        public void readDimensions() {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the length of the sheet: ");
            length = sc.nextDouble();
            System.out.print("Enter the width of the sheet: ");
            width = sc.nextDouble();
        }
    }

