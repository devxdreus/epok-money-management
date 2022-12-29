package swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

public class TableHeader extends JLabel {
    public TableHeader(String text) {
    super(text);
    setOpaque(true);
    setBackground(Color.WHITE);
    setFont(new Font("Segoe UI", 1, 12));
    setForeground(new Color(51,51,51));
    setBorder(new EmptyBorder(10, 5, 10, 5));
    }
    
    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        grphcs.setColor(new Color(169, 175, 126));
        grphcs.drawLine(0, getHeight() - 1, getWidth(), getHeight() - 1);
    }
}
