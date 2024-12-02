package hust.soict.dsai.aims.media;

import java.util.Objects;

public class Track implements Playable{
    private String title;
    private int length;

    //constructor
    public Track(){

    }

    public Track(String title, int length){
        this.title = title;
        this.length = length;
    }

    //getter
    public int getLength() {
        return length;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public void play() {
        System.out.println("Playing track: " + getTitle());
        System.out.println("Length track: " + getLength());
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Track)) return false;
        else {
            return Objects.equals(this.title, ((Track) obj).getTitle()) && this.length == ((Track) obj).getLength();
        }
    }
}
