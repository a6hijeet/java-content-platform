import java.net.InetSocketAddress;
import handler.JsonHandler;
import handler.PostHandler;
import handler.StaticFileHandler;
import com.sun.net.httpserver.HttpServer;

public class App {
  public static void main(String[] args) throws Exception {
    HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
    server.createContext("/", new StaticFileHandler("frontend"));
    server.createContext("/getjson", new JsonHandler("storage"));
    server.createContext("/posts", new PostHandler());
    server.start();
    System.out.println("Server started at https://localhost:8080/");
  }
}