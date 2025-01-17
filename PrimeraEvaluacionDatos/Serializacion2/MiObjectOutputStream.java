package Serializacion2;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MiObjectOutputStream extends ObjectOutputStream {

    // Constructor que recibe el OutputStream
    public MiObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    // Sobrescribimos el método writeStreamHeader para evitar escribir la cabecera nuevamente
    @Override
    protected void writeStreamHeader() throws IOException {
        // No hace nada en la segunda vez que se llama para evitar la duplicación de la cabecera
        reset();
    }
}
