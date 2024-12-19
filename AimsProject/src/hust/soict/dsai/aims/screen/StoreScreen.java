package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;
import javafx.collections.ObservableList;

import javax.naming.LimitExceededException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class StoreScreen extends JFrame{
    private Store store;
    private JButton btnAddToCart, btnPlay;

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");
        smUpdateStore.add(new JMenuItem("Add Book"));
        smUpdateStore.add(new JMenuItem("Add CD"));
        smUpdateStore.add(new JMenuItem("Add DVD"));

        menu.add(smUpdateStore);
        menu.add(new JMenuItem("View Store"));
        menu.add(new JMenuItem("View Cart"));

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        JButton cart = new JButton("View cart");
        cart.setPreferredSize(new Dimension(100, 50));
        cart.setMaximumSize(new Dimension(100, 50));

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cart);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        ObservableList<Media> mediaInStore = store.getItemsInStore();
        for(Media m: mediaInStore) {
            MediaStore cell = new MediaStore(m);
            center.add(cell);
        }

        return center;
    }

    public class MediaStore extends JPanel {
        private Media media;
        ButtonListener btnListener = new ButtonListener();

        public MediaStore(Media media) {
            this.media = media;
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            JLabel title = new JLabel(media.getTitle());
            title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
            title.setAlignmentX(CENTER_ALIGNMENT);

            JLabel cost = new JLabel("" + media.getCost() + " $");
            cost.setAlignmentX(CENTER_ALIGNMENT);

            JPanel container = new JPanel();
            container.setLayout(new FlowLayout(FlowLayout.CENTER));

            btnAddToCart = new JButton("Add to cart");
            container.add(btnAddToCart);
            btnAddToCart.addActionListener(btnListener);
            if(media instanceof Playable) {
                btnPlay = new JButton("Play");
                container.add(btnPlay);
                btnPlay.addActionListener(btnListener);
            }

            this.add(Box.createVerticalGlue());
            this.add(title);
            this.add(cost);
            this.add(Box.createVerticalGlue());
            this.add(container);

            this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }
    }

    public class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String button = e.getActionCommand();
            if(button.charAt(0) == 'A') {
                JFrame frame = new JFrame("JOptionPane ");
                JOptionPane.showMessageDialog(frame,
                        "The media has been added",
                        "Add To Cart",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            else if (button.charAt(0) == 'P') {
                JFrame frame = new JFrame("JOptionPane ");
                JOptionPane.showMessageDialog(frame,
                        "Play The Media",
                        "Play",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public StoreScreen(Store store) {
        this.store = store;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setVisible(true);
        setTitle("Store");
        setSize(1024, 768);
    }

    public static void main(String[] args) throws LimitExceededException {
        Store store = new Store();
        // Book
        Book initBook = new Book("The Great Novel", "Book", 100.00f,
                Arrays.asList("John Doe", "Jane Smith"));

        // Book
        Book initBook2 = new Book("OOP1", "Book", 100.00f,
                Arrays.asList("Tuan", "Dung"));

        // Book
        Book initBook3 = new Book("OOP2", "Book", 100.00f,
                Arrays.asList("Dat", "Duong"));

        // DVD
        DigitalVideoDisc initDVD = new DigitalVideoDisc("Inception", "DVD",
                "Christopher Nolan", 150, 35.88f);

        // CD
        ArrayList<Track> tracks = new ArrayList<>();
        tracks.add(new Track("Song 1", 3));
        tracks.add(new Track("Song 2", 4));
        CompactDisc initCD = new CompactDisc("The Best Hits", "CD", 90.00f,
                "Various Artists", tracks);

        store.addMedia(initBook);
        store.addMedia(initBook2);
        store.addMedia(initBook3);
        store.addMedia(initCD);
        store.addMedia(initDVD);

        // Additional Books
        Book additionalBook1 = new Book("Introduction to Algorithms", "Book", 120.00f,
                Arrays.asList("Thomas H. Cormen", "Charles E. Leiserson", "Ronald L. Rivest", "Clifford Stein"));

        Book additionalBook2 = new Book("Design Patterns: Elements of Reusable Object-Oriented Software", "Book", 85.00f,
                Arrays.asList("Erich Gamma", "Richard Helm", "Ralph Johnson", "John Vlissides"));

        // Additional DVD
        DigitalVideoDisc additionalDVD = new DigitalVideoDisc("The Shawshank Redemption", "DVD",
                "Frank Darabont", 142, 24.99f);

        // Additional CD
        ArrayList<Track> additionalTracks = new ArrayList<>();
        additionalTracks.add(new Track("Bohemian Rhapsody", 6));
        additionalTracks.add(new Track("Hotel California", 5));
        CompactDisc additionalCD = new CompactDisc("Classic Rock Hits", "CD", 110.00f,
                "Various Artists", additionalTracks);

        store.addMedia(additionalBook1);
        store.addMedia(additionalBook2);
        store.addMedia(additionalDVD);
        store.addMedia(additionalCD);

        new StoreScreen(store);
    }
}