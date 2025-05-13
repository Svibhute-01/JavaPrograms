import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ImageSelector extends JFrame implements ItemListener {

    JComboBox<String> imageList;
    JLabel imageLabel;

    String[] imageNames = {"Image1", "Image2", "Image3"};
    String[] imagePaths = {"image1.jpeg", "image2.jpeg", "image3.jpeg"}; 

    public ImageSelector() {
        setTitle("Image Selector");
        setSize(500, 400);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        imageList = new JComboBox<>(imageNames);
        imageList.setBounds(150, 20, 200, 30);
        add(imageList);

        imageLabel = new JLabel();
        imageLabel.setBounds(100, 70, 300, 250);
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        add(imageLabel);

        imageList.addItemListener(this);

        setVisible(true);
    }

    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            int index = imageList.getSelectedIndex();
            ImageIcon icon = new ImageIcon(imagePaths[index]);

            Image img = icon.getImage().getScaledInstance(300, 250, Image.SCALE_SMOOTH);
            icon = new ImageIcon(img);

            imageLabel.setIcon(icon);
        }
    }

    public static void main(String[] args) {
        new ImageSelector();
    }
}
