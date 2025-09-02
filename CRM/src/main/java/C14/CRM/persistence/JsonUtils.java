package C14.CRM.persistence;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonUtils {
    private static final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    public static <T> void salvar(String caminho, T objeto) {
        try (FileWriter writer = new FileWriter(caminho)) {
            gson.toJson(objeto, writer);
        } catch (IOException e) {
            System.err.println("Erro ao salvar: " + caminho);
        }
    }

    public static <T> T carregar(String caminho, Class<T> clazz) {
        try (FileReader reader = new FileReader(caminho)) {
            return gson.fromJson(reader, clazz);
        } catch (IOException e) {
            System.err.println("Erro ao carregar: " + caminho);
            return null;
        }
    }
}