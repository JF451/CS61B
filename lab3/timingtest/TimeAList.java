package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        AList <Integer> list = new AList<>();
        AList <Double> double_list = new AList<>();
        AList <Integer> count_list = new AList<>();
        AList <Integer> Ns = new AList<>();


        Stopwatch sw = new Stopwatch();
        int tick = 0;
        int ops = 0;
        for(int i = 0; i < 128000; ++i)
        {
            list.addLast(i);
            ops += 1;
            double_list.addLast(sw.elapsedTime());
            count_list.addLast(ops);
            Ns.addLast(list.size());
        }

        printTimingTable(Ns, double_list, count_list);
    }
}
