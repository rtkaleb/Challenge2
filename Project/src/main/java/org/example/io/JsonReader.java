package org.example.io;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.RecordItem;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Utility to read and parse JSON files into Java objects.
 */
/**
 * Lee un arreglo JSON y lo mapea a List<RecordItem>.
 * - Ignora propiedades desconocidas
 * - Usa el deserializador flexible de RecordItem para 'value'
 */
public class JsonReader {

    private final ObjectMapper mapper = new ObjectMapper();

    /**
     * Opens and parses a JSON file into a list of RecordItem.
     *
     * @param jsonFile the JSON file to open
     * @return list of RecordItem parsed from the file
     * @throws IOException if the file cannot be read or parsed
     */
    public List<RecordItem> readItems(File jsonFile) throws IOException {
        if (jsonFile == null || !jsonFile.exists()) {
            throw new IOException("JSON file not found: " + jsonFile);
        }
        // Example JSON expected: [{ "id":"1", "name":"A", "value":12.3 }, ...]
        return mapper.readValue(jsonFile, new TypeReference<List<RecordItem>>() {});
    }
}
