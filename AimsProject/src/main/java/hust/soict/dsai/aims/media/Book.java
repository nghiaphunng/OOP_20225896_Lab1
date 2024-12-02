package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{
    private List<String> authors = new ArrayList<String>();

    public Book(){
        super();
    }

    public Book(String title, String category, float cost){
        super(title, category, cost);
    }

    public List<String> getAuthors() {
        return authors;
    }

    //add author
    public void addAuthor(String authorName){
        if(!authors.contains(authorName)) authors.add(authorName);
        else System.out.println("Author already exists");
    }

    //remove author
    public void removeAuthor(String authorName){
        if(authors.contains(authorName)) authors.remove(authorName);
        else System.out.println("Author not found");
    }

    @Override
    public String toString() {
        return super.toString() + " Authors: " + String.join(", ", authors);
    }
}
