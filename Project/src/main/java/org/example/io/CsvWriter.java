package org.example.io;

import com.opencsv.CSVWriter;
import org.example.model.RecordItem;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Utility to write data into a CSV file.
 */
public class CsvWriter {

    /**
     * Writes a list of RecordItem to a CSV file.
     *
     * @param outputPath  path to the CSV file to create/overwrite
     * @param items       list of items to write
     * @param delimiter   delimiter character (e.g., ',', ';', '\t')
     * @throws IOException if an error occurs during writing
     */
    public void writeItems(String outputPath, List<RecordItem> items, char delimiter) throws IOException {
        try (CSVWriter writer = new CSVWriter(
                new FileWriter(outputPath),
                delimiter,
                CSVWriter.DEFAULT_QUOTE_CHARACTER,
                CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                CSVWriter.DEFAULT_LINE_END)
        ) {
            // header
            writer.writeNext(new String[]{"id", "name", "value"});

            // rows
            for (RecordItem it : items) {
                writer.writeNext(new String[]{
                        it.getId(),
                        it.getName(),
                        String.valueOf(it.getValue())
                });
            }
        }
    }
}
