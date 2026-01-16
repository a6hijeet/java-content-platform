package handler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import controller.PostController;
import model.Post;


public class PostHandler implements HttpHandler{

    private static final PostController postController = new PostController();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void handle(HttpExchange exchange) throws IOException {
       try{ 
        switch (exchange.getRequestMethod()) {
            case "GET":
                handleGet(exchange);
                break;
            case "POST":
                handlePost(exchange);
                break;
            case "PUT":
                handlePut(exchange);
                break;
            case "DELETE":
                handleDelete(exchange);
                break;
            default:
                break;
        }

        
        }
        catch(Exception e) {
            exchange.sendResponseHeaders(500, -1);
        }
    }

    private void handleGet(HttpExchange exchange) throws Exception {
        List<Post> posts = postController.getAll();
        String response = objectMapper.writeValueAsString(posts);
        sendJson(exchange, 200, response);
    }

    private void handlePost(HttpExchange exchange) throws Exception {
        String body = new String(exchange.getRequestBody().readAllBytes());
        System.out.println(body);
        /* String response = objectMapper.writerWithDefaultPrettyPrinter()
                                .writeValueAsString(posts);

        sendJson(exchange, 200, response);

        try (OutputStream os = exchange.getResponseBody()) {
            os.write(response.getBytes());
        } */
    }

    private void handlePut(HttpExchange exchange) throws Exception {
        List<Post> posts = postController.getAll();

        String response = objectMapper.writerWithDefaultPrettyPrinter()
                                .writeValueAsString(posts);

        sendJson(exchange, 200, response);

        try (OutputStream os = exchange.getResponseBody()) {
            os.write(response.getBytes());
        }
    }

    private void handleDelete(HttpExchange exchange) throws Exception {
        List<Post> posts = postController.getAll();

        String response = objectMapper.writerWithDefaultPrettyPrinter()
                                .writeValueAsString(posts);

        sendJson(exchange, 200, response);

        try (OutputStream os = exchange.getResponseBody()) {
            os.write(response.getBytes());
        }
    }

    private void sendJson(HttpExchange exchange, int status, String body) throws IOException {
        exchange.getResponseHeaders().add("Content-Type", "application/json");
        exchange.sendResponseHeaders(status, body.getBytes().length);
         try (OutputStream os = exchange.getResponseBody()) {
            os.write(body.getBytes());
        }
    }
    
}
