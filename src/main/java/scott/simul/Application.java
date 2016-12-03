package scott.simul;

import static spark.Spark.*;

import java.util.stream.Collectors;

import com.google.gson.Gson;

import scott.simul.games.GameRunner;

public class Application {

    public static void main(String args[]) {
        GameRunner gr = new GameRunner();
        gr.runGame();

        staticFiles.externalLocation("dist");
        port(8000);
        get("/hello", (req, res) -> "Hello World " + req.queryParams("who"));


        Gson gson = new Gson();

        get("/gamesrv/report/:id", (req, res) -> {
                return gr.getReport( Long.parseLong( req.params(":id") ) );
            },
            gson::toJson);

    }

}

