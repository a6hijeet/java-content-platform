package util;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicLong;

public final class IdGenerator {
  private static final AtomicLong COUNTER = new AtomicLong(100);
  private static final Path FILE = Paths.get("storage/id-seq.txt");

  private IdGenerator(){}

  public static synchronized long next() {
    try {
      if(!Files.exists(FILE)) {
        Files.createDirectory(FILE.getParent());
        Files.write(FILE, "1000".getBytes());
      }
      String currentCount = Files.readString(FILE).trim();
      long current = 1000;
      if (currentCount != "")
        current = Long.parseLong(currentCount);

      long next = current + 1;

      Files.write(FILE, String.valueOf(next).getBytes());
    }
    catch (Exception e) {
      throw new RuntimeException("Failed to generate ID");
      
    }
    return COUNTER.incrementAndGet();
  }
}
