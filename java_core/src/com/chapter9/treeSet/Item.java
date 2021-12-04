package com.chapter9.treeSet;

import java.util.Objects;

/**
 * @author xsj
 * @create 2020-10-29 19:08
 */
public class Item implements Comparable<Item>{
    private String description;
    private  int partNumber;

    public Item(String description, int partNumber) {
        this.description = description;
        this.partNumber = partNumber;
    }

    @Override
    public String toString() {
        return "Item{" +
                "description='" + description + '\'' +
                ", partNumber=" + partNumber +
                '}';
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPartNumber() {
        return partNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return partNumber == item.partNumber &&
                Objects.equals(description, item.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, partNumber);
    }

    public void setPartNumber(int partNumber) {
        this.partNumber = partNumber;
    }

    @Override
    public int compareTo(Item o) {
        int diff=Integer.compare(partNumber,o.partNumber);
        return diff!=0?diff:description.compareTo(o.description);
    }
}
