package Assignment12;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class AnimationApp extends JFrame implements ActionListener {
    private JPanel panel;
    private JLabel imageLabel, messageLabel;
    private Thread imageThread, messageThread;
    private int x = 0, y = 0, dx = 5, dy = 5;
    private int messageIndex = 0;
    private String[] messages = {"Welcome", "Enjoy", "Thanks", "Visit Again"};
    private String[] imagePaths = {"istockphoto-1343130293-1024x1024.jpg", "—Pngtree—pink blue neon border light_9157194.png", "—Pngtree—classic yellow stars clipart_5568033.png", "pexels-karolina-grabowska-4197491.jpg"};
    private ImageIcon[] images;

    public AnimationApp() {
        createGUI();
        loadImages();
        startThreads();
    }

    private void createGUI() {
        panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.BLACK); // Set background color
                g.fillRect(0, 0, getWidth(), getHeight());
                if (images != null) {
                    g.drawImage(images[0].getImage(), x, y, this);
                }
            }
        };
        panel.setLayout(null);
        panel.setBackground(Color.BLACK); // Set background color

        imageLabel = new JLabel();
        imageLabel.setBounds(0, 0, 500, 500);
        panel.add(imageLabel);

        messageLabel = new JLabel("", SwingConstants.CENTER);
        messageLabel.setFont(new Font("Arial", Font.BOLD, 24));
        messageLabel.setForeground(Color.WHITE); // Set text color
        messageLabel.setBounds(0, 450, 500, 50);
        panel.add(messageLabel);

        add(panel);

        setSize(500, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void loadImages() {
        images = new ImageIcon[imagePaths.length];
        for (int i = 0; i < imagePaths.length; i++) {
            try {
                BufferedImage image = ImageIO.read(new File(imagePaths[i]));
                images[i] = new ImageIcon(image);
                System.out.println("Loaded image: " + imagePaths[i]);
            } catch (IOException e) {
                System.out.println("Error loading image: " + e.getMessage());
            }
        }
    }

    private void startThreads() {
        imageThread = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(10);
                        x += dx;
                        y += dy;

                        if (x < 0 || x > 450) {
                            dx *= -1;
                        }
                        if (y < 0 || y > 450) {
                            dy *= -1;
                        }

                        SwingUtilities.invokeLater(new Runnable() {
                            public void run() {
                                panel.repaint();
                                imageLabel.setIcon(images[(x / 50) % images.length]);
                            }
                        });
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        });
        imageThread.start();

        messageThread = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(2000);
                        SwingUtilities.invokeLater(new Runnable() {
                            public void run() {
                                messageLabel.setText(messages[messageIndex]);
                                messageIndex = (messageIndex + 1) % messages.length;
                            }
                        });
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        });
        messageThread.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AnimationApp();
            }
        });
    }
}