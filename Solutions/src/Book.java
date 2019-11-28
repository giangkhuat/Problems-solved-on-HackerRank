public class Book implements Comparable<Book> {
    public String name, id, author, publisher;
    public Book(String name, String id, String author, String publisher) {
        this.name = name;
        this.id = id;
        this.author = author;
        this.publisher = publisher;
    }
    public String toString() {
        return ("(" + name + ", " + id + ", " + author + ", " + publisher + ")");
    }
    @Override
    public int compareTo(Book o) {
        // usually toString should not be used,
        // instead one of the attributes or more in a comparator chain
        return toString().compareTo(o.toString()).thenCompareTo;
    }
    
    public static void main (String[] args) throws Exception {
      
    }
    
}
