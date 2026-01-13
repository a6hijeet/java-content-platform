package util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonFile {
  private static final ObjectMapper mapper = new ObjectMapper();
  // Writing data to jason.
  public static <T> void writeList(String path, List<T> data) {
    try {
      mapper.writerWithDefaultPrettyPrinter().writeValue(new File(path), data);
    }
    catch(Exception e) {
      throw new RuntimeException(e);
    }
  }

  // Read data from json.
  public static <T> List<T> readList(String path, TypeReference<List<T>> type) {

    try {
      File file = new File(path);
      if(!file.exists())
        return new ArrayList<>();

      return mapper.readValue(file, type);
    }
    catch(Exception e) {
      throw new RuntimeException(e);
    }

  }

}
