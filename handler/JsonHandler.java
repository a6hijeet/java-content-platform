package handler;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;


public class JsonHandler implements HttpHandler{

    private final Path root;

    public JsonHandler(String rootDir) {
        this.root = Paths.get(rootDir).toAbsolutePath().normalize();
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
       try{ 
            if(!"GET".equals(exchange.getRequestMethod())) {
              exchange.sendResponseHeaders(405, -1);
            }

            String uriPath = exchange.getRequestURI().getPath();

            if(uriPath.equals("/getjson")) {
                uriPath = "/users.json";
            }

            Path file = root.resolve("." + uriPath).normalize();

            if(!file.startsWith(root) || !Files.exists(file)) {
                 exchange.sendResponseHeaders(404, -1);
            }

            String contentType = Files.probeContentType(file);
            if(contentType == null) {
                contentType = "application/json";
            }

            byte[] data = Files.readAllBytes(file);
            exchange.getResponseHeaders().add("Content-Type", contentType);

            exchange.sendResponseHeaders(200, data.length);

            try (OutputStream os = exchange.getResponseBody()) {
            os.write(data);
            }
        }
        catch(Exception e) {
            exchange.sendResponseHeaders(500, -1);
        }
    }
    
}
