package me.rsole.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Benchmark {
  private List<Thread> threads = new ArrayList<>();

  public void add(String name, Runnable computation) {
    Thread t = new Thread(
      () -> System.out.printf("%s took %s.\n", name, run(computation))
    );

    threads.add(t);
  }

  public void run() {
    for (Thread t : threads) t.run();
  }

  private String run(Runnable computation) {
    long start = System.currentTimeMillis();
    computation.run();
    long end = System.currentTimeMillis();

    return format(end - start);
  }

  private String format(long time) {
    long minutes = TimeUnit.MILLISECONDS.toMinutes(time);
    long seconds = TimeUnit.MILLISECONDS.toSeconds(time) - TimeUnit.MINUTES.toSeconds(minutes);
    long milliseconds = time - (TimeUnit.SECONDS.toMillis(seconds) + TimeUnit.MINUTES.toMillis(minutes));

    return String.format("%dm %ds %dms", minutes, seconds, milliseconds);
  }
}
