import java.util.*;
import java.io.*;

public class Sort {
    long startTime;
    long endTime;
    Car[] cars;
	int operationCount;
	int comparisonCount = 0;
	int swapCount = 0;
	int reheapDownCount = 0;
	int merge = 0;

    public Sort(int n) {
		cars = new Car[n];
	}

	public void bubbleSort() {
		boolean sorted = false; // when an iteration has no swaps we stop sorting
		int n = cars.length; // data must be a class variable array

		// Reduce the size of array A by 1 every iteration ignore comparisons in loop condition
		for (int Last = n - 1; (Last >= 1) && (!sorted); Last--) {
			sorted = true; // assume array A is sorted
			for (int index = 0; index < Last; index++) {
				// add a line to increment the number of comparisons by 1 here
				comparisonCount++;
				if ((cars[index].getName()).compareTo(cars[index+1].getName()) > 0) {
					swap(cars, index, index + 1);
					// add a line to increment the number of swaps here
					swapCount++;
					sorted = false;
				}
			}
		}
	}



	public static void swap(Car[] cars, int i, int j) {
		Car temp = cars[i];
		cars[i] = cars[j];
		cars[j] = temp;
	}

    // Implement other sorting methods: InsertionSort()
	public void InsertionSort() {
		int len = cars.length;

		for (int i = 1; i < len; i++) {
			int j = i;
			Car key = cars[j];

			// Moving elements greater than key, one position ahead of their current position
			while (j > 0 && cars[j - 1].getName().compareTo(key.getName()) > 0) {
				comparisonCount++; // Increment for each comparison
				swapCount++; // Increment for each swap
				cars[j] = cars[j - 1];
				j--;
			}
			comparisonCount++; // Additional comparison when the while loop condition fails
			cars[j] = key;
		}
	}

	public void quickSort(Car cars[], int F, int L) { // note that L is an index =A.length-1
		int lastS1;
		String pivot;
		// insert a line to increment the number of comparisons here
		comparisonCount++;
		if (F < L) {
			pivot = cars[F].getName();
			lastS1 = F;
			for (int FU = F + 1; FU <= L; FU++) {
				// insert a line to increment the number of comparisons here
				comparisonCount++;
				if ((cars[FU].getName()).compareTo(pivot) < 0) {
					lastS1++;
					// insert a line to increment the number of comparisons here
					comparisonCount++;
					if (FU != lastS1) {
						// insert a line to increment the number of swaps here
						swapCount++;
						swap(cars, FU, lastS1);
					}
				}
			}
			// insert a line to increment the number of comparisons here
			comparisonCount++;
			if (F != lastS1) {
				// insert a line to increment the number of swaps here
				swapCount++;
				swap(cars, F, lastS1);
			}
			// insert a line to increment the number of comparisons here
			comparisonCount++;
			if (F < lastS1 - 1) {
				quickSort(cars, F, lastS1 - 1);
			}
			// insert a line to increment the number of comparisons here
			comparisonCount++;
			if (lastS1 + 1 < L) {
				quickSort(cars, lastS1 + 1, L);
			}
		}
	}

	public static void heapSwap(Car[] data, int i, int j)
	{
		Car temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	public void heapSort(Car[] cars, int length) {
		// Build the heap
		for (int i = (length / 2) - 1; i >= 0; i--) {

			reheapDown(cars, i, length);
		}

		// One by one extract an element from heap
		for (int i = length - 1; i > 0; i--) {
			// Move current root to end
			swapCount++;
			heapSwap(cars, 0, i);

			// call max heapify on the reduced heap
			reheapDown(cars, 0, i);
		}
	}

	public void reheapDown(Car[] cars, int i, int n) {
		int largest = i; // Initialize largest as root
		int left = 2 * i + 1; // left = 2*i + 1
		int right = 2 * i + 2; // right = 2*i + 2
		reheapDownCount++;

		// If left child is larger than root
		if (left < n && cars[left].compareTo(cars[largest]) > 0)
			largest = left;

		// If right child is larger than largest so far
		if (right < n && cars[right].compareTo(cars[largest]) > 0)
			largest = right;

		// If largest is not root
		if (largest != i) {
			heapSwap(cars, i, largest);

			// Recursively heapify the affected sub-tree
			reheapDown(cars, largest, n);
		}
	}

    public void mergeSort(Car cars[], int first_element, int last_element) {
		comparisonCount++; 	//increment the number of comparisons
		mergeSortHelper(first_element, last_element);
    }

    private void mergeSortHelper(int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSortHelper(left, mid);
            mergeSortHelper(mid + 1, right);
            merge(left, mid, right);
			merge++; //increment the number of merge calls
        }
    }

    private void merge(int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
		int operationCount = 0;

        Car[] L = new Car[n1];
        Car[] R = new Car[n2];
        for (int i = 0; i < n1; ++i)
            L[i] = cars[left + i];
        for (int j = 0; j < n2; ++j)
            R[j] = cars[mid + 1 + j];
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            operationCount++;
            if (L[i].getName().compareTo(R[j].getName()) <= 0) {
                cars[k] = L[i];
                i++;
            } else {
                cars[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            cars[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            cars[k] = R[j];
            j++;
            k++;
        }

    }



    public void writeToFile(String filename, String msg) throws FileNotFoundException {
		PrintWriter fout = new PrintWriter(filename); //open new file
		fout.println(msg); // to print the first line in the output file
		for (int i = 0; i < cars.length; i++) {
			if (cars[i] != null) {
				fout.printf("%-4d\t%-20s\t%-10s\t\t%-19s\n", i + 14, cars[i].getName(), cars[i].getDob(), (cars[i].getVin() + "13"));
			} else {
				System.out.printf("Null");
			}
		}
		fout.close(); //close the file
	}

	public void readFile(String filename) throws FileNotFoundException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            br.readLine(); // skip header
            int index = 0;
            while ((line = br.readLine()) != null && index < cars.length) {
                String[] values = line.split(",");
                cars[index] = new Car(values[0] + "13", values[1], values[2]);
                index++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	public void readEndingFile(String filename) throws FileNotFoundException  {
		Scanner s = new Scanner(new File(filename)); //open new file
			int i = 0;
			String str=s.nextLine();
			while (s.hasNext() && i < cars.length) {
				str=s.nextLine().trim(); //read the file line by line
				cars[i++] = new Car(str.substring(38, 55).trim(), str.substring(5, 25).trim(), str.substring(26, 37).trim()); //extract the data from the line and save them in cars array
			}
			s.close(); //close the fil
		}

}
