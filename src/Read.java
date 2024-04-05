
import java.io.*;
import java.util.*;

public class Read {
    private static final String ID = "13"; // replace with your KU ID's last two digits
    private static final String CSV_FILE = "cars.csv";
    private static final String OUTPUT_FILE = "formatted_cars.txt";
    private static final String DELIMITER = ",";
    private static final int START_NO = Integer.parseInt(ID) + 1;
    private static final int END_NO = START_NO + 999;

    public static void main(String[] args) {
        List<Car> cars = readFile();
        writeFile(cars);
    }

    public static List<Car> readFile() {
        List<Car> cars = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE))) {
            String line;
            br.readLine(); // skip header
            while ((line = br.readLine()) != null) {
                String[] values = line.split(DELIMITER);
                cars.add(new Car(values[0] + ID, values[1], values[2]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cars;
    }

    public static void writeFile(List<Car> cars) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(OUTPUT_FILE))) {
            pw.printf("%-5s %-20s %-12s %-20s%n", "No.", "Name", "DOB", "VIN");
            for (int i = START_NO; i <= END_NO; i++) {
                Car car = cars.get(i - START_NO);
                pw.printf("%-5d %-20s %-12s %-20s%n", i, car.getName(), car.getDob(), car.getVin());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class Car {
        private String vin;
        private String name;
        private String dob;

        public Car(String vin, String name, String dob) {
            this.vin = vin;
            this.name = name;
            this.dob = dob;
        }

        public String getVin() {
            return vin;
        }

        public String getName() {
            return name;
        }

        public String getDob() {
            return dob;
        }
    }
}
