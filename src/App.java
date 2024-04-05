import java.util.*;


public class App {
	public static void main(String[] args) throws Exception {
        // implement the two classes Read and Sort
        List<Read.Car> cars = Read.readFile();
        Read.writeFile(cars);

		Sort sort = new Sort(cars);
		sort.BubbleSort();
		sort.InsertionSort();
		sort.HeapSort();
		sort.QuickSort();
		sort.MergeSort();


    }
}

