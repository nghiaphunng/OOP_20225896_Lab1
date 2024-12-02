package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable{
    private String director;
    private int length;

    //static
    private static int nbDigitalVideoDiscs = 0;

    //constructor
    public DigitalVideoDisc(String title) {
        super(title, null, 0, 0, null);
    }

    public DigitalVideoDisc(String category, String title, float cost) {
        super(title, category, cost, 0, null);
    }

    public DigitalVideoDisc(String director, String category, String title, float cost) {
        super(title, category, cost, 0, director);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, cost, length, director);
    }

    //getter
    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    //setter
    public void setDirector(String director) {
        this.director = director;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "DVD - " + getTitle() + " - " + getCategory() + " - " + director + " - " + length + ": " + getCost() + " $";
    }

    @Override
    public void play() {
        System.out.println("Playing DVD: " + getTitle());
        System.out.println("Length DVD: " + getLength());
    }

}
