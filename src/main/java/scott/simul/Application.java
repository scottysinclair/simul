package scott.simul;

import static spark.Spark.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import scott.simul.charts.amchart.Bullet;
import scott.simul.charts.amchart.Chart;
import scott.simul.charts.amchart.LineType;
import scott.simul.charts.amchart.Position;
import scott.simul.games.prisonersdilemma.PrisonersDilemmaSimRunner;

public class Application {

    private static <E extends Enum<E>> void registerDefaultEnumTypeAdapter(GsonBuilder gsonBuilder , Class<E> enumType) {
        TypeAdapter<Enum<E>> ta = new TypeAdapter<Enum<E>>() {
            @Override
            public void write(JsonWriter out, Enum<E> value) throws IOException {
                if (value == null) {
                    out.nullValue();
                }
                else {
                    out.value(value.toString());
                }
            }

            @Override
            public Enum<E> read(JsonReader in) throws IOException {
                String value = in.nextString();
                if (value != null) {
                    for (E eValue : enumType.getEnumConstants()) {
                        if (eValue.toString().equals(value)) {
                            return eValue;
                        }
                    }
                }
                return null;
            }
        };
        gsonBuilder.registerTypeAdapter(enumType, ta);
    }

    public static void main(String args[]) {
        PrisonersDilemmaSimRunner gr = new PrisonersDilemmaSimRunner();
        gr.runGame();

        staticFiles.externalLocation("dist");
        port(8000);
        get("/hello", (req, res) -> "Hello World " + req.queryParams("who"));


        GsonBuilder gsonBuilder = new GsonBuilder();
        registerDefaultEnumTypeAdapter(gsonBuilder, Chart.Type.class);
        registerDefaultEnumTypeAdapter(gsonBuilder, Chart.Theme.class);
        registerDefaultEnumTypeAdapter(gsonBuilder, Bullet.class);
        registerDefaultEnumTypeAdapter(gsonBuilder, LineType.class);
        registerDefaultEnumTypeAdapter(gsonBuilder, Position.class);

        Gson gson = gsonBuilder.create();

        get("/gamesrv/report/:id", (req, res) -> {
                try {
                    return gr.getReport( Long.parseLong( req.params(":id") ) );
                }
                catch(RuntimeException x) {
                    x.printStackTrace(System.err);
                    throw x;
                }
            },
            gson::toJson);

        get("/gamesrv/chart/:id", (req, res) -> {
            try {
                Chart chart =  gr.getChart( Long.parseLong( req.params(":id") ) );
                write(gson.toJson(chart));
                return chart;
            }
            catch(RuntimeException x) {
                x.printStackTrace(System.err);
                throw x;
            }
        },
        gson::toJson);

    }

    private static void write(String data) {
        data = data.replaceAll("},", "},\n").replaceAll(",", ",\n");
        try ( Writer out = new FileWriter(new File("generated.txt")) ) {
            out.write(data);
            out.flush();
        }
        catch(Exception x) {
            x.printStackTrace();
        }
    }

}

