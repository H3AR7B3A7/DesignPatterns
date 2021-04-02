package IteratorPattern;

public class IteratorPattern2 {
    public static void main(String[] args) {
        Subjects artsSubjects = new Arts();
        Iter iterForArts = artsSubjects.createIterator();
        System.out.println("Arts subjects are as follows:");
        while (iterForArts.hasNext()) {
            System.out.println(iterForArts.next());
        }
        iterForArts.first();
        System.out.println("Currently pointing back to: " + iterForArts.currentItem());
    }
}

interface Subjects {
    Iter createIterator();
}

class Arts implements Subjects {
    private final String[] papers;

    public Arts() {
        this.papers = new String[]{"English", "History", "Geography", "Psychology"};
    }

    @Override
    public Iter createIterator() {
        return new ArtsIterator(papers);
    }
}

interface Iter {
    void first();

    String next();

    String currentItem();

    boolean hasNext();
}

class ArtsIterator implements Iter {
    private final String[] papers;
    private int position;

    public ArtsIterator(String[] papers) {
        this.papers = papers;
        position = 0;
    }

    @Override
    public void first() {
        position = 0;
    }

    @Override
    public String next() {
        return papers[position++];
    }

    @Override
    public String currentItem() {
        return papers[position];
    }

    @Override
    public boolean hasNext() {
        return position < papers.length;
    }
}