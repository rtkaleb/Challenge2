package org.example.io;

import org.example.model.RecordItem;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CsvWriterTest {

    @Test
    void writesCsvWithSemicolon() throws Exception {
        CsvWriter writer = new CsvWriter();
        File out = File.createTempFile("out", ".csv");
        List<RecordItem> data = List.of(
                new RecordItem("1","A",1.1),
                new RecordItem("2","B",2.2)
        );

        writer.writeItems(out.getAbsolutePath(), data, ';');

        String content = Files.readString(out.toPath());
        assertTrue(content.contains("id;name;value"));
        assertTrue(content.contains("1;A;1.1"));
    }
}
