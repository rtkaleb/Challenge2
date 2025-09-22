package org.example;

import org.example.io.CsvWriter;
import org.example.io.JsonReader;
import org.example.model.RecordItem;

import java.io.File;
import java.util.List;

/**
 * Entry point. Example:
 * java -jar json-csv-tool.jar input.json output.csv ;
 */
public class Main {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.err.println("Usage: <input.json> <output.csv> <delimiter>");
            System.err.println("Example: data.json export.csv ;");
            System.exit(1);
        }
        String input = args[0];
        String output = args[1];
        char delimiter = args[2].charAt(0);

        JsonReader reader = new JsonReader();
        CsvWriter writer = new CsvWriter();

        try {
            List<RecordItem> items = reader.readItems(new File(input));
            writer.writeItems(output, items, delimiter);
            System.out.println("CSV written: " + output + " (rows: " + items.size() + ")");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(2);
        }
    }
}
