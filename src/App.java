import java.io.*;

public class App {

	private static final String ID = "13"; // replace with your KU ID's last two digits
    private static final String CSV_FILE = "cars.csv";
    private static final String OUTPUT_FILE = "formatted_cars.txt";
    private static final String DELIMITER = ",";
    private static final int START_NO = Integer.parseInt(ID) + 1;
    private static final int END_NO = START_NO + 999;

	public static void main(String[] args) throws FileNotFoundException {

		long startTime, endTime;
		double time;

		// Task 1
		Sort sorter = new Sort(1000);

		sorter.readFile("cars.csv"); //read the file
		String str = String.format("%-4s\t%-20s\t%-10s\t\t%-19s", "No.","Name", "DOB", "VIN"); //format the first line
		sorter.writeToFile(OUTPUT_FILE, str);

		//Task 2 and 3

		// Bubble sort on 250 unsorted elements
		Sort bubble250 =new Sort(250);
		bubble250.readEndingFile("formatted_cars.txt");
		startTime = System.nanoTime();
		bubble250.bubbleSort();
		endTime = System.nanoTime();
		time = (endTime - startTime) / 1000;
		System.out.printf("Bubble Sort on 250 Unsorted Elements: %d comparisons, %d swaps%n", bubble250.comparisonCount, bubble250.swapCount);
		System.out.printf("Time taken for Bubble Sort with 250 elements: %.2f ms%n", time);

		System.out.println("");

		//Bubble sort on 250 sorted elements
		bubble250.comparisonCount=0;
		bubble250.swapCount=0;
		startTime = System.nanoTime();
		bubble250.bubbleSort();
		endTime = System.nanoTime();
		time = (endTime - startTime) / 1000;
		System.out.println("For 250 sorted elements using Bubble Sort: " + bubble250.comparisonCount + " comparisons, " + bubble250.swapCount + " swaps");
		System.out.println("Time taken for Bubble Sort with 250 elements: " + time + " ms");

		System.out.println("");

		//Bubble sort on 500 unsorted elements
		Sort bubble500 =new Sort(500);
		bubble500.readEndingFile("formatted_cars.txt");
		startTime = System.nanoTime();
		bubble500.bubbleSort();
		endTime = System.nanoTime();
		time = (endTime - startTime) / 1000;
		System.out.println("For 500 unsorted elements using Bubble Sort: " + bubble500.comparisonCount + " comparisons, " + bubble500.swapCount + " swaps");
		System.out.println("Time taken for Bubble Sort with 500 elements: " + time + " ms");

		System.out.println("");

		//Bubble sort on 500 sorted elements
		bubble500.comparisonCount=0;
		bubble500.swapCount=0;
		startTime = System.nanoTime();
		bubble500.bubbleSort();
		endTime = System.nanoTime();
		time = (endTime - startTime) / 1000;
		System.out.println("For 500 sorted elements using Bubble Sort: " + bubble500.comparisonCount + " comparisons, " + bubble500.swapCount + " swaps");
		System.out.println("Time taken for Bubble Sort with 500 elements: " + time + " ms");

		System.out.println("");

		//Bubble sort on 750 unsorted elements
		Sort bubble750 = new Sort(750);
		bubble750.readEndingFile("formatted_cars.txt");
		startTime = System.nanoTime();
		bubble750.bubbleSort();
		endTime = System.nanoTime();
		time = (endTime - startTime) / 1000;
		System.out.println("For 750 unsorted elements using Bubble Sort: " + bubble750.comparisonCount + " comparisons, " + bubble750.swapCount + " swaps");
		System.out.println("Time taken for Bubble Sort with 750 elements: " + time + " ms");
		System.out.println("");

		//Bubble sort on 750 sorted elements
		bubble750.comparisonCount=0;
		bubble750.swapCount=0;
		startTime = System.nanoTime();
		bubble750.bubbleSort();
		endTime = System.nanoTime();
		time = (endTime - startTime) / 1000;
		System.out.println("For 750 sorted elements using Bubble Sort: " + bubble750.comparisonCount + " comparisons, " + bubble750.swapCount + " swaps");
		System.out.println("Time taken for Bubble Sort with 750 elements: " + time + " ms");
		System.out.println("");

		//Bubble sort on 1000 unsorted elements
		Sort bubble1000 = new Sort(1000);
		bubble1000.readEndingFile("formatted_cars.txt");
		startTime = System.nanoTime();
		bubble1000.bubbleSort();
		endTime = System.nanoTime();
		time = (endTime - startTime) / 1000;
		System.out.println("For 1000 unsorted elements using Bubble Sort: " + bubble1000.comparisonCount + " comparisons, " + bubble1000.swapCount + " swaps");
		System.out.println("Time taken for Bubble Sort with 1000 elements: " + time + " ms");
		bubble1000.writeToFile("bsorted.txt", str);

		System.out.println("");

		//Bubble sort on 1000 sorted elements
		bubble1000.comparisonCount=0;
		bubble1000.swapCount=0;
		startTime = System.nanoTime();
		bubble1000.bubbleSort();
		endTime = System.nanoTime();
		time = (endTime - startTime) / 1000;
		System.out.println("Bubble Sort on 1000 Sorted Elements: Comparisons= " + bubble1000.comparisonCount + ", Swaps= " + bubble1000.swapCount);
		System.out.println("Time take for Bubble Sort With 1000 Elements Time: " + time + " ms");

		System.out.println("");


		///////////////////////////////////////////////////////////////////////////////////Quick sort

		//Quick sort on 250 unsorted elements
		Sort quick250 = new Sort(250);
		quick250.readEndingFile("formatted_cars.txt");
		startTime = System.nanoTime();
		quick250.quickSort(quick250.cars, 0, 249);
		endTime = System.nanoTime();
		time = (endTime - startTime) / 1000;
		System.out.println("For 250 unsorted elements using Quick Sort: " + quick250.comparisonCount + " comparisons, " + quick250.swapCount + " swaps");
		System.out.println("Time taken for Quick Sort with 250 elements: " + time + " ms");

		System.out.println("");

		//Quick sort on 250 sorted elements
		quick250.comparisonCount=0;
		quick250.swapCount=0;
		startTime = System.nanoTime();
		quick250.quickSort(quick250.cars, 0, 249);
		endTime = System.nanoTime();
		time = (endTime - startTime) / 1000;
		System.out.println("For 250 sorted elements using Quick Sort: " + quick250.comparisonCount + " comparisons, " + quick250.swapCount + " swaps");
		System.out.println("Time taken for Quick Sort with 250 elements: " + time + " ms");

		System.out.println("");

		//Quick sort on 500 unsorted elements
		Sort quick500 = new Sort(500);
		quick500.readEndingFile("formatted_cars.txt");
		startTime = System.nanoTime();
		quick500.quickSort(quick500.cars, 0, 499);
		endTime = System.nanoTime();
		time = (endTime - startTime) / 1000;
		System.out.println("For 500 unsorted elements using Quick Sort: " + quick500.comparisonCount + " comparisons, " + quick500.swapCount + " swaps");
		System.out.println("Time taken for Quick Sort with 500 elements: " + time + " ms");

		System.out.println("");

		//Quick sort on 500 sorted elements
		quick500.comparisonCount=0;
		quick500.swapCount=0;
		startTime = System.nanoTime();
		quick500.quickSort(quick500.cars, 0, 499);
		endTime = System.nanoTime();
		time = (endTime - startTime) / 1000;
		System.out.println("For 500 sorted elements using Quick Sort: " + quick500.comparisonCount + " comparisons, " + quick500.swapCount + " swaps");
		System.out.println("Time taken for Quick Sort with 500 elements: " + time + " ms");

		System.out.println("");

		//Quick sort on 750 unsorted elements
		Sort quick750 = new Sort(750);
		quick750.readEndingFile("formatted_cars.txt");
		startTime = System.nanoTime();
		quick750.quickSort(quick750.cars, 0, 749);
		endTime = System.nanoTime();
		time = (endTime - startTime) / 1000;
		System.out.println("For 750 unsorted elements using Quick Sort: " + quick750.comparisonCount + " comparisons, " + quick750.swapCount + " swaps");
		System.out.println("Time taken for Quick Sort with 750 elements: " + time + " ms");

		System.out.println("");

		//Quick sort on 750 sorted elements
		quick750.comparisonCount=0;
		quick750.swapCount=0;
		startTime = System.nanoTime();
		quick750.quickSort(quick750.cars, 0, 749);
		endTime = System.nanoTime();
		time = (endTime - startTime) / 1000;
		System.out.println("For 750 sorted elements using Quick Sort: " + quick750.comparisonCount + " comparisons, " + quick750.swapCount + " swaps");
		System.out.println("Time taken for Quick Sort with 750 elements: " + time + " ms");

		System.out.println("");

		//Quick sort on 1000 unsorted elements
		Sort quick1000 = new Sort(1000);
		quick1000.readEndingFile("formatted_cars.txt");
		startTime = System.nanoTime();
		quick1000.quickSort(quick1000.cars, 0, 999);
		endTime = System.nanoTime();
		time = (endTime - startTime) / 1000;
		System.out.println("For 1000 unsorted elements using Quick Sort: " + quick1000.comparisonCount + " comparisons, " + quick1000.swapCount + " swaps");
		System.out.println("Time taken for Quick Sort with 1000 elements: " + time + " ms");
		quick1000.writeToFile("qsorted.txt", str);

		System.out.println("");

		//Quick sort on 1000 sorted elements
		quick1000.comparisonCount=0;
		quick1000.swapCount=0;
		startTime = System.nanoTime();
		quick1000.quickSort(quick1000.cars, 0, 999);
		endTime = System.nanoTime();
		time = (endTime - startTime) / 1000;
		System.out.println("For 1000 sorted elements using Quick Sort: " + quick1000.comparisonCount + " comparisons, " + quick1000.swapCount + " swaps");
		System.out.println("Time taken for Quick Sort with 1000 elements: " + time + " ms");

		System.out.println("");

		/////////////////////////////////////////////////////////////////////////////////Heap sort

		// Heap sort on 250 unsorted elements
		Sort heap250 = new Sort(250);
		heap250.readEndingFile("formatted_cars.txt");
		startTime = System.nanoTime();
		heap250.heapSort(heap250.cars, 250);
		endTime = System.nanoTime();
		time = (endTime - startTime) / 1000;
		System.out.println("For 250 unsorted elements using Heap Sort: " + heap250.comparisonCount + " comparisons, " + heap250.swapCount + " swaps, " + heap250.reheapDownCount + " reheap downs");
		System.out.println("Time taken for Heap Sort with 250 elements: " + time + " ms");

		System.out.println("");

		//Heap sort on 250 sorted elements
		heap250.comparisonCount=0;
		heap250.swapCount=0;
		heap250.reheapDownCount=0;
		startTime = System.nanoTime();
		heap250.heapSort(heap250.cars, 250);
		endTime = System.nanoTime();
		time = (endTime - startTime) / 1000;
		System.out.println("For 250 sorted elements using Heap Sort: " + heap250.comparisonCount + " comparisons, " + heap250.swapCount + " swaps, " + heap250.reheapDownCount + " reheap downs");
		System.out.println("Time taken for Heap Sort with 250 elements: " + time + " ms");

		// Heap sort on 500 elements
		Sort heap500 = new Sort(500);
		heap500.readEndingFile("formatted_cars.txt");
		startTime = System.nanoTime();
		heap500.heapSort(heap500.cars, 500);
		endTime = System.nanoTime();
		time = (endTime - startTime) / 1000;
		System.out.println("For 500 unsorted elements using Heap Sort: " + heap500.comparisonCount + " comparisons, " + heap500.swapCount + " swaps, " + heap500.reheapDownCount + " reheap downs");
		System.out.println("Time taken for Heap Sort with 500 elements: " + time + " ms");

		System.out.println("");

		//Heap sort on 500 sorted elements
		heap500.comparisonCount=0;
		heap500.swapCount=0;
		heap500.reheapDownCount=0;
		startTime = System.nanoTime();
		heap500.heapSort(heap500.cars, 500);
		endTime = System.nanoTime();
		time = (endTime - startTime) / 1000;
		System.out.println("For 500 sorted elements using Heap Sort: " + heap500.comparisonCount + " comparisons, " + heap500.swapCount + " swaps, " + heap500.reheapDownCount + " reheap downs");
		System.out.println("Time taken for Heap Sort with 500 elements: " + time + " ms");
		System.out.println("");
		//Heap sort on 750 unsorted elements
		Sort heap750 = new Sort(750);
		heap750.readEndingFile("formatted_cars.txt");
		startTime = System.nanoTime();
		heap750.heapSort(heap750.cars, 750);
		endTime = System.nanoTime();
		time = (endTime - startTime) / 1000;
		System.out.println("For 750 unsorted elements using Heap Sort: " + heap750.comparisonCount + " comparisons, " + heap750.swapCount + " swaps, " + heap750.reheapDownCount + " reheap downs");
		System.out.println("Time taken for Heap Sort with 750 elements: " + time + " ms");
		System.out.println("");

		//Heap sort on 750 sorted elements
		heap750.comparisonCount=0;
		heap750.swapCount=0;
		heap750.reheapDownCount=0;
		startTime = System.nanoTime();
		heap750.heapSort(heap750.cars, 750);
		endTime = System.nanoTime();
		time = (endTime - startTime) / 1000;
		System.out.println("For 750 sorted elements using Heap Sort: " + heap750.comparisonCount + " comparisons, " + heap750.swapCount + " swaps, " + heap750.reheapDownCount + " reheap downs");
		System.out.println("Time taken for Heap Sort with 750 elements: " + time + " ms");

		System.out.println("");

		//Heap sort on 1000 unsorted elements
		Sort heap1000 = new Sort(1000);
		heap1000.readEndingFile("formatted_cars.txt");
		startTime = System.nanoTime();
		heap1000.heapSort(heap1000.cars, 1000);
		endTime = System.nanoTime();
		time = (endTime - startTime) / 1000;
		System.out.println("For 1000 unsorted elements using Heap Sort: " + heap1000.comparisonCount + " comparisons, " + heap1000.swapCount + " swaps, " + heap1000.reheapDownCount + " reheap downs");
		System.out.println("Time taken for Heap Sort with 1000 elements: " + time + " ms");
		heap1000.writeToFile("hsorted.txt", str);

		System.out.println("");

		//Heap sort on 1000 sorted elements
		heap1000.comparisonCount=0;
		heap1000.swapCount=0;
		heap1000.reheapDownCount=0;
		startTime = System.nanoTime();
		heap1000.heapSort(heap1000.cars, 1000);
		endTime = System.nanoTime();
		time = (endTime - startTime) / 1000;
		System.out.printf("Heap Sort on 1000 Sorted Elements: %d comparisons, %d swaps, %d reheap downs%n", heap1000.comparisonCount, heap1000.swapCount, heap1000.reheapDownCount);
		System.out.printf("Time taken for Heap Sort with 1000 elements: %.2f ms%n", time);
		System.out.println("");


		// Merge Sort

		// Merge sort, 250 unsorted elements
		Sort merge250 = new Sort(250);
		merge250.readEndingFile("formatted_cars.txt");
		startTime = System.nanoTime();
		merge250.mergeSort(merge250.cars, 0, 249);
		endTime = System.nanoTime();
		time = (endTime - startTime) / 1000;
		System.out.println("For 250 unsorted elements using Merge Sort: " + merge250.comparisonCount + " comparisons, " + merge250.merge + " merge calls");
		System.out.println("Time taken for Merge Sort with 250 elements: " + time + " ms");

		System.out.println("");

		//Merge sort, 250 sorted elements
		merge250.comparisonCount=0;
		merge250.merge=0;
		startTime = System.nanoTime();
		merge250.mergeSort(merge250.cars, 0, 249);
		endTime = System.nanoTime();
		time = (endTime - startTime) / 1000;
		System.out.println("For 250 sorted elements using Merge Sort: " + merge250.comparisonCount + " comparisons, " + merge250.merge + " merge calls");
		System.out.println("Time taken for Merge Sort with 250 elements: " + time + " ms");

		System.out.println("");

		// Merge sort, 500 unsorted elements
		Sort merge500 = new Sort(500);
		merge500.readEndingFile("formatted_cars.txt");
		startTime = System.nanoTime();
		merge500.mergeSort(merge500.cars, 0, 499);
		endTime = System.nanoTime();
		time = (endTime - startTime) / 1000;
		System.out.println("For 500 unsorted elements using Merge Sort: " + merge500.comparisonCount + " comparisons, " + merge500.merge + " merge calls");
		System.out.println("Time taken for Merge Sort with 500 elements: " + time + " ms");

		System.out.println("");

		//Merge sort, 500 sorted elements
		merge500.comparisonCount=0;
		merge500.merge=0;
		startTime = System.nanoTime();
		merge500.mergeSort(merge500.cars, 0, 499);
		endTime = System.nanoTime();
		time = (endTime - startTime) / 1000;
		System.out.println("For 500 sorted elements using Merge Sort: " + merge500.comparisonCount + " comparisons, " + merge500.merge + " merge calls");
		System.out.println("Time taken for Merge Sort with 500 elements: " + time + " ms");

		System.out.println("");
		// Merge sort, 750 unsorted elements
		Sort merge750 = new Sort(750);
		merge750.readEndingFile("formatted_cars.txt");
		startTime = System.nanoTime();
		merge750.mergeSort(merge750.cars, 0, 749);
		endTime = System.nanoTime();
		time = (endTime - startTime) / 1000;
		System.out.println("For 750 unsorted elements using Merge Sort: " + merge750.comparisonCount + " comparisons, " + merge750.merge + " merge calls");
		System.out.println("Time taken for Merge Sort with 750 elements: " + time + " ms");

		System.out.println("");

		//Merge sort, 750 sorted elements
		merge750.comparisonCount=0;
		merge750.merge=0;
		startTime = System.nanoTime();
		merge750.mergeSort(merge750.cars, 0, 749);
		endTime = System.nanoTime();
		time = (endTime - startTime) / 1000;
		System.out.println("For 750 sorted elements using Merge Sort: " + merge750.comparisonCount + " comparisons, " + merge750.merge + " merge calls");
		System.out.println("Time taken for Merge Sort with 750 elements: " + time + " ms");

		System.out.println("");

		// Merge sort, 1000 unsorted elements
		Sort merge1000 = new Sort(1000);
		merge1000.readEndingFile("formatted_cars.txt");
		startTime = System.nanoTime();
		merge1000.mergeSort(merge1000.cars, 0, 999);
		endTime = System.nanoTime();
		time = (endTime - startTime) / 1000;
		System.out.println("For 1000 unsorted elements using Merge Sort: " + merge1000.comparisonCount + " comparisons, " + merge1000.merge + " merge calls");
		System.out.println("Time taken for Merge Sort with 1000 elements: " + time + " ms");
		merge1000.writeToFile("msorted.txt", str);

		System.out.println("");

		//Merge sort, 1000 sorted elements
		merge1000.comparisonCount=0;
		merge1000.merge=0;
		startTime = System.nanoTime();
		merge1000.mergeSort(merge1000.cars, 0, 999);
		endTime = System.nanoTime();
		time = (endTime - startTime) / 1000;
		System.out.println("For 1000 sorted elements using Merge Sort: " + merge1000.comparisonCount + " comparisons, " + merge1000.merge + " merge calls");
		System.out.println("Time taken for Merge Sort with 1000 elements: " + time + " ms");

		System.out.println("");

		// Insertion sort, 250 unsorted elements
		Sort insert250 = new Sort(250);
		insert250.readEndingFile("formatted_cars.txt");
		startTime = System.nanoTime();
		insert250.InsertionSort();
		endTime = System.nanoTime();
		time = (endTime - startTime) / 1000;
		System.out.println("For 250 unsorted elements using Insertion Sort: " + insert250.comparisonCount + " comparisons, " + insert250.swapCount + " swaps");
		System.out.println("Time taken for Insertion Sort with 250 elements: " + time + " ms");
		System.out.println("");

		// Insertion sort, 250 sorted elements
		insert250.comparisonCount=0;
		insert250.swapCount=0;
		startTime = System.nanoTime();
		insert250.InsertionSort();
		endTime = System.nanoTime();
		time = (endTime - startTime) / 1000;
		System.out.println("For 250 sorted elements using Insertion Sort: " + insert250.comparisonCount + " comparisons, " + insert250.swapCount + " swaps");
		System.out.println("Time taken for Insertion Sort with 250 elements: " + time + " ms");
		System.out.println("");


		// Insertion sort, 500 unsorted elements
		Sort insert500 = new Sort(500);
		insert500.readEndingFile("formatted_cars.txt");
		startTime = System.nanoTime();
		insert500.InsertionSort();
		endTime = System.nanoTime();
		time = (endTime - startTime) / 1000;
		System.out.println("For 500 unsorted elements using Insertion Sort: " + insert500.comparisonCount + " comparisons, " + insert500.swapCount + " swaps");
		System.out.println("Time taken for Insertion Sort with 500 elements: " + time + " ms");

		System.out.println("");

		// Insertion sort, 500 sorted elements
		insert500.comparisonCount=0;
		insert500.swapCount=0;
		startTime = System.nanoTime();
		insert500.InsertionSort();
		endTime = System.nanoTime();
		time = (endTime - startTime) / 1000;
		System.out.println("For 500 sorted elements using Insertion Sort: " + insert500.comparisonCount + " comparisons, " + insert500.swapCount + " swaps");
		System.out.println("Time taken for Insertion Sort with 500 elements: " + time + " ms");
		System.out.println("");

		// Insertion sort, 750 unsorted elements
		Sort insert750 = new Sort(750);
		insert750.readEndingFile("formatted_cars.txt");
		startTime = System.nanoTime();
		insert750.InsertionSort();
		endTime = System.nanoTime();
		time = (endTime - startTime) / 1000;
		System.out.println("For 750 unsorted elements using Insertion Sort: " + insert750.comparisonCount + " comparisons, " + insert750.swapCount + " swaps");
		System.out.println("Time taken for Insertion Sort with 750 elements: " + time + " ms");

		System.out.println("");

		// Insertion sort, 750 sorted elements
		insert750.comparisonCount=0;
		insert750.swapCount=0;
		startTime = System.nanoTime();
		insert750.InsertionSort();
		endTime = System.nanoTime();
		time = (endTime - startTime) / 1000;
		System.out.println("For 750 sorted elements using Insertion Sort: " + insert750.comparisonCount + " comparisons, " + insert750.swapCount + " swaps");
		System.out.println("Time taken for Insertion Sort with 750 elements: " + time + " ms");
		System.out.println("");


		// Insertion sort, 1000 unsorted elements
		Sort insert1000 = new Sort(1000);
		insert1000.readEndingFile("formatted_cars.txt");
		startTime = System.nanoTime();
		insert1000.InsertionSort();
		endTime = System.nanoTime();
		time = (endTime - startTime) / 1000;
		System.out.println("For 1000 unsorted elements using Insertion Sort: " + insert1000.comparisonCount + " comparisons, " + insert1000.swapCount + " swaps");
		System.out.println("Time taken for Insertion Sort with 1000 elements: " + time + " ms");
		insert1000.writeToFile("isorted.txt", str);
		System.out.println("");

		// Insertion sort, 1000 sorted elements
		insert1000.comparisonCount=0;
		insert1000.swapCount=0;
		startTime = System.nanoTime();
		insert1000.InsertionSort();
		endTime = System.nanoTime();
		time = (endTime - startTime) / 1000;
		System.out.println("For 1000 sorted elements using Insertion Sort: " + insert1000.comparisonCount + " comparisons, " + insert1000.swapCount + " swaps");
		System.out.println("Time taken for Insertion Sort with 1000 elements: " + time + " ms");
		System.out.println("");


	}
}
