import java.util.ArrayList;
import java.util.List;
import sort.InsertionSort;
import sort.QuickSort;
import sort.Sort;
import sort.SortableComparableData;
import sort.SortableData;
import sort.SortableDataWithStatistics;
import sort.SortableDataWithTracer;
import sort.SwapableList;

public class TestSort {

	public static void sortAndPrint(SortableData<?> sd, Sort sort) {
		sort.doSort(sd);
		for (int i = 0; i < sd.size(); ++i) {
			System.out.print(sd.get(i) + " ");
		}
		System.out.println();
	}

	public static <T> void initList(List<T> l, T[] a) {
		l.clear();
		for (T t : a) {
			l.add(t);
		}
	}

	public static void main(String[] args) {
		Sort isort = new InsertionSort();
		Sort qsort = new QuickSort();
		List<String> ls = new ArrayList<String>();

		initList(ls, args);
		SortableDataWithStatistics<String> sdws = new SortableDataWithStatistics<String>(
				new SortableDataWithTracer<String>(
						new SortableComparableData<String>(
								new SwapableList<String>(ls))));
		sortAndPrint(sdws, isort);
		System.out.println("Stats: " + sdws.getSwapStat() + " swap, "
				+ sdws.getCompareStat() + " compare");

		initList(ls, args);
		sdws = new SortableDataWithStatistics<String>(
				new SortableDataWithTracer<String>(
						new SortableComparableData<String>(
								new SwapableList<String>(ls))));
		sortAndPrint(sdws, qsort);
		System.out.println("Stats: " + sdws.getSwapStat() + " swap, "
				+ sdws.getCompareStat() + " compare");
	}

}