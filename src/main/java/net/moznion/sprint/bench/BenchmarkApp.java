package net.moznion.sprint.bench;

import net.moznion.sprint.Sprint;

import me.geso.nanobench.Benchmark;
import me.geso.nanobench.Benchmark.Bench;

public final class BenchmarkApp {
    private static final int DEFAULT_N = 100000;

    public static void main(String[] args) throws Exception {
        final int n = args.length > 0 ? Integer.parseInt(args[0], 10) : DEFAULT_N;
        new Benchmark(new StringBuilderBenchmark()).warmup(10).run(n).timethese().cmpthese();
    }

    public static final class StringBuilderBenchmark {
        private static final Sprint SPRINT = new Sprint();
        private static final Exception EX = new Exception("e");

        @Bench
        public static void sprintff() {
            SPRINT.ff("{}, {} sec, err: {}", "test", 123, EX);
        }

        @Bench
        public static void stringFormat() {
            String.format("%s, %s sec, err: %s", "test", 123, EX);
        }
    }
}
