import java.util.*;
import java.io.*;

// import a class inside current directory called Read
// Assuming Read is the name of the class in the current directory

public class Sort {
    private long operationCount;
    private long startTime;
    private long endTime;
    private List<Read.Car> cars;

    public Sort(List<Read.Car> cars) {
        this.cars = cars;
    }

    public void BubbleSort() {
        operationCount = 0;
        startTime = System.currentTimeMillis();
        int n = cars.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                operationCount++;
                if (cars.get(j).getName().compareTo(cars.get(j + 1).getName()) > 0) {
                    // swap cars.get(j+1) and cars.get(j)
                    Read.Car temp = cars.get(j);
                    cars.set(j, cars.get(j + 1));
                    cars.set(j + 1, temp);
                }
            }
        }
        endTime = System.currentTimeMillis();
        writeToFile("bsorted.txt");
    }

    // Implement other sorting methods: InsertionSort(), QuickSort(), HeapSort(), MergeSort()
    public void InsertionSort() {
        operationCount = 0;
        startTime = System.currentTimeMillis();
        int n = cars.size();
        for (int i = 1; i < n; ++i) {
            Read.Car key = cars.get(i);
            int j = i - 1;
            operationCount++;
            while (j >= 0 && cars.get(j).getName().compareTo(key.getName()) > 0) {
                cars.set(j + 1, cars.get(j));
                j = j - 1;
            }
            cars.set(j + 1, key);
        }
        endTime = System.currentTimeMillis();
        writeToFile("isorted.txt");
    }

    public void QuickSort() {
        operationCount = 0;
        startTime = System.currentTimeMillis();
        quickSortHelper(0, cars.size() - 1);
        endTime = System.currentTimeMillis();
        writeToFile("qsorted.txt");
    }

    private void quickSortHelper(int low, int high) {
        if (low < high) {
            int pi = partition(low, high);
            quickSortHelper(low, pi - 1);
            quickSortHelper(pi + 1, high);
        }
    }

    private int partition(int low, int high) {
        Read.Car pivot = cars.get(high);
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            operationCount++;
            if (cars.get(j).getName().compareTo(pivot.getName()) < 0) {
                i++;
                Read.Car temp = cars.get(i);
                cars.set(i, cars.get(j));
                cars.set(j, temp);
            }
        }
        Read.Car temp = cars.get(i + 1);
        cars.set(i + 1, cars.get(high));
        cars.set(high, temp);
        return i + 1;
    }

    public void HeapSort() {
        operationCount = 0;
        startTime = System.currentTimeMillis();
        int n = cars.size();
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(n, i);
        for (int i = n - 1; i >= 0; i--) {
            Read.Car temp = cars.get(0);
            cars.set(0, cars.get(i));
            cars.set(i, temp);
            heapify(i, 0);
        }
        endTime = System.currentTimeMillis();
        writeToFile("hsorted.txt");
    }

    private void heapify(int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && cars.get(left).getName().compareTo(cars.get(largest).getName()) > 0)
            largest = left;
        if (right < n && cars.get(right).getName().compareTo(cars.get(largest).getName()) > 0)
            largest = right;
        if (largest != i) {
            Read.Car swap = cars.get(i);
            cars.set(i, cars.get(largest));
            cars.set(largest, swap);
            heapify(n, largest);
        }
    }

    public void MergeSort() {
        operationCount = 0;
        startTime = System.currentTimeMillis();
        mergeSortHelper(0, cars.size() - 1);
        endTime = System.currentTimeMillis();
        writeToFile("msorted.txt");
    }

    private void mergeSortHelper(int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSortHelper(left, mid);
            mergeSortHelper(mid + 1, right);
            merge(left, mid, right);
        }
    }

    private void merge(int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        List<Read.Car> L = new ArrayList<>();
        List<Read.Car> R = new ArrayList<>();
        for (int i = 0; i < n1; ++i)
            L.add(cars.get(left + i));
        for (int j = 0; j < n2; ++j)
            R.add(cars.get(mid + 1 + j));
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            operationCount++;
            if (L.get(i).getName().compareTo(R.get(j).getName()) <= 0) {
                cars.set(k, L.get(i));
                i++;
            } else {
                cars.set(k, R.get(j));
                j++;
            }
            k++;
        }
        while (i < n1) {
            cars.set(k, L.get(i));
            i++;
            k++;
        }
        while (j < n2) {
            cars.set(k, R.get(j));
            j++;
            k++;
        }
    }

    public void writeToFile(String fileName) {
        try {
            PrintWriter writer = new PrintWriter(new File(fileName));
            for (Read.Car car : cars) {
                writer.println(car);
            }
            writer.println("Operation count: " + operationCount);
            writer.println("Time taken: " + (endTime - startTime) + "ms");
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
