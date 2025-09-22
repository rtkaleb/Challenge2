package org.example.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Represents one item parsed from JSON and later written into CSV.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RecordItem {
    private String id;
    private String name;
    private double value;

    public RecordItem() {} // Jackson needs a no-args constructor

    public RecordItem(String id, String name, double value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }

    /** @return unique identifier */
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    /** @return display name */
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    /** @return numeric value */
    public double getValue() { return value; }
    public void setValue(double value) { this.value = value; }
}
