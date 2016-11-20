package scott.simul;

import static spark.Spark.*;

import scott.simul.games.GameRunner;

public class Application {

    public static void main(String args[]) {
       // port(8080);
        //get("/hello", (req, res) -> "Hello World " + req.queryParams("who"));

        GameRunner gr = new GameRunner();
        gr.runGame();

    }
}
