package org.example;

public class Recursive {
    public static int recursiveSearch(String item, String[] items, int index) {
        if (index >= items.length) {
            return -1;
        }
        if (items[index].equals(item)) {
            return index;
        }

        return recursiveSearch(item, items, index + 1);
    }

    public static void main(String[] args) {
        String[] items = {"hi", "there", "you"};
        String itemToFind = "hey";
        int result = recursiveSearch(itemToFind, items, 0);

        if (result != -1) {
            System.out.println("Index of '" + itemToFind + "' is: " + result);
        } else {
            System.out.println("'" + itemToFind + "' not found in the list.");
        }
    }
}

