package uk.org.adacollege;

import java.util.concurrent.TimeUnit;

class Benchmark {
  static String run(Runnable computation) {
    long start = System.currentTimeMillis();
    computation.run();
    long end = System.currentTimeMillis();

    return format(end - start);
  }

  private static String format(long time) {
    long minutes = TimeUnit.MILLISECONDS.toMinutes(time);
    long seconds = TimeUnit.MILLISECONDS.toSeconds(time) - TimeUnit.MINUTES.toSeconds(minutes);
    long milliseconds = time - (TimeUnit.SECONDS.toMillis(seconds) + TimeUnit.MINUTES.toMillis(minutes));

    return String.format("%dm %ds %dms", minutes, seconds, milliseconds);
  }
}
