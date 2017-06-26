package insertionsort;

import interfaces.SortPerformer;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 
 * @author kedar.parikh
 *
 */
public class InsertionSortStarter {

	public static void main(String[] args) {

		int sourceDataToSort[] = new int[100000];

		for (int i = 0; i < sourceDataToSort.length; i++) {
			sourceDataToSort[i] = ThreadLocalRandom.current().nextInt();
		}

		SortPerformer insertionSort = (int[] inputDataToSort) -> {
			for (int i = 1; i < inputDataToSort.length; i++) {
				int key = inputDataToSort[i];
				int j = i - 1;
				while (j >= 0 && inputDataToSort[j] < key) {
					inputDataToSort[j + 1] = inputDataToSort[j];
					j = j - 1;

				}
				inputDataToSort[j + 1] = key;
			}
		};

		long init = System.currentTimeMillis();
		insertionSort.sort(sourceDataToSort);
		System.out.println(System.currentTimeMillis() - init);
		//		Arrays.stream(sourceDataToSort).forEach(System.out::println);
	}
}
