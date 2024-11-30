import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class Generador_Archivo
{
    public void guardarDatos(Conversor conversor) throws IOException
    {
        if(conversor == null)
        {
            throw new IllegalArgumentException("El conversor no puede ser null");
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter escritura = new FileWriter(conversor.base_code() + "to" + conversor.target_code() + ".json"))
        {
            escritura.write(gson.toJson(conversor));
        }
    }
}
