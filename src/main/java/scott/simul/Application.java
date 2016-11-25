package scott.simul;

import static spark.Spark.*;

import java.util.stream.Collectors;

import com.google.gson.Gson;

import scott.simul.games.GameRunner;

public class Application {

    public static void main(String args[]) {
        GameRunner gr = new GameRunner();
        gr.runGame();

        staticFiles.externalLocation("webapp");
        port(8080);
        get("/hello", (req, res) -> "Hello World " + req.queryParams("who"));


        Gson gson = new Gson();

        get("/appData", (req, res) ->
            gr.getGameTypes()
                .stream()
                .map(c -> c.getSimpleName())
                .collect(Collectors.toList()),
            gson::toJson);

    }
}

