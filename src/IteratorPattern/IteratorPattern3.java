package IteratorPattern;

import java.util.Iterator;

public class IteratorPattern3 {
    public static void main(String[] args) {
        Items crayons = new Colors();
        ColorIterator iteratorForColors = crayons.createIterator();
        System.out.println("All crayon colors:");
        while (iteratorForColors.hasNext()) {
            System.out.println(iteratorForColors.next());
        }
        iteratorForColors.first();
        System.out.println("Currently pointing to: " + iteratorForColors.currentItem());
    }
}

interface Items {
    ColorIterator createIterator();
}

class Colors implements Items {
    private String[] crayons;

    public Colors() {
        crayons = new String[]{"Red", "Blue", "Green", "Yellow"};
    }

    @Override
    public ColorIterator createIterator() {
        return new ColorIterator(crayons);
    }
}

class ColorIterator implements Iterator<String> {
    private String[] crayons;
    private int position;

    public ColorIterator(String[] crayons) {
        this.crayons = crayons;
        position = 0;
    }

    public void first() {
        position = 0;
    }

    public String currentItem() {
        return crayons[position];
    }

    @Override
    public boolean hasNext() {
        return position < crayons.length;
    }

    @Override
    public String next() {
        return crayons[position++];
    }
}