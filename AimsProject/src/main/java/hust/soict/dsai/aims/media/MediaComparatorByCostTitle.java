package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {

    @Override
    public int compare(Media media1, Media media2) {
        int costComparison = Float.compare(media2.getCost(), media1.getCost()); //giá giảm
        if(costComparison == 0){
            return media1.getTitle().compareTo(media2.getTitle()); //sx theo tên nếu giá ==
        }
        return costComparison;
    }
}
