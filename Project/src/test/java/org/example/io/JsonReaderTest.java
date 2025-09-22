package org.example.io;

import org.example.model.RecordItem;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonReaderTest {

    @Test
    void readsValidJsonArray() throws Exception {
        File tmp = File.createTempFile("items", ".json");
        try (FileWriter fw = new FileWriter(tmp)) {
            fw.write("""
                [
                  {"id":"1","name":"Alpha","value":10.5},
                  {"id":"2","name":"Beta","value":20.0}
                ]
            """);
        }

        JsonReader reader = new JsonReader();
        List<RecordItem> items = reader.readItems(tmp);

        assertEquals(2, items.size());
        assertEquals("Alpha", items.get(0).getName());
    }
}
