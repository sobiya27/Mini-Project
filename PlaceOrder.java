package awtdemo;



import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PlaceOrder extends JFrame {

 JLabel heading;
 JLabel fooditems;

 JLabel item1, item2, item3;
 JCheckBox cb_item1, cb_item2, cb_item3;

 JPanel order_panel;
 JLabel your_order, price;

 JTextArea ordered_items;
 JLabel result;

 JLabel gst, total;
 JTextField gst_tf, total_tf;

 JButton done, exit;

 static String items = "";

 double amount = 0.0;

 public PlaceOrder() {

  heading = new JLabel("Please Find List of All Food items offered by us");
  heading.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 30));
  heading.setBounds(300, 50, 640, 50);

  fooditems = new JLabel("FOOD ITEMS");
  fooditems.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
  fooditems.setBounds(300, 100, 300, 50);

  item1 = new JLabel("1. Pizza.....................Rs.500");
  item2 = new JLabel("2. Burger....................Rs.299");
  item3 = new JLabel("3. Coffee....................Rs.149");

  item1.setBounds(300, 130, 300, 50);
  item2.setBounds(300, 160, 300, 50);
  item3.setBounds(300, 190, 300, 50);

  cb_item1 = new JCheckBox();
  cb_item2 = new JCheckBox();
  cb_item3 = new JCheckBox();

  cb_item1.setBounds(600, 130, 50, 50);
  cb_item2.setBounds(600, 160, 50, 50);
  cb_item3.setBounds(600, 190, 50, 50);

  order_panel = new JPanel();

  your_order = new JLabel("Your Order");
  your_order.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
  // your_order.setBounds(700, 100, 300,50);

  price = new JLabel("Price");
  price.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
  // price.setBounds(900, 100, 300,50);

  ordered_items = new JTextArea(10,100);
  // ordered_items.setBounds(700, 140, 300,50);

  result = new JLabel("Price of each item");
  // result.setBounds(900, 140, 300,50);
  gst = new JLabel("GST Applicable");
  total = new JLabel("Total");

  gst_tf = new JTextField(40);
  total_tf = new JTextField(40);

  done = new JButton("Done");
  exit = new JButton("Exit");

  order_panel.setBounds(700, 100, 300, 350);
  order_panel.add(your_order);
  order_panel.add(price);
  order_panel.add(ordered_items);
  order_panel.add(result);
  order_panel.add(gst);
  order_panel.add(gst_tf);
  order_panel.add(total);
  order_panel.add(total_tf);
  order_panel.add(done);
  order_panel.add(exit);

  order_panel.setLayout(new GridLayout(5, 2));

  this.add(heading);
  this.add(fooditems);
  this.add(item1);
  this.add(cb_item1);
  this.add(item2);
  this.add(cb_item2);
  this.add(item3);
  this.add(cb_item3);
  this.add(order_panel);
  // this.add(your_order);
  // this.add(price);

  // this.add(ordered_items);
  // this.add(result);

  this.setLayout(null);
  this.setSize(300, 300);
  this.setVisible(true);

  cb_item1.addItemListener(new ItemListener() {

   @Override
   public void itemStateChanged(ItemEvent e) {

    if (e.getStateChange() == 1) {
     String result = "Pizza - Rs 500.";
     amount += 500.00;
     // System.out.println(items);
     items=items.concat(result);

    }

   }
  });

  cb_item2.addItemListener(new ItemListener() {

   @Override
   public void itemStateChanged(ItemEvent e) {

    if (e.getStateChange() == 1) {
     items = items.concat(" \n Burger- Rs 299.");
     amount += 299.00;
    }

   }
  });

  cb_item3.addItemListener(new ItemListener() {

   @Override
   public void itemStateChanged(ItemEvent e) {

    if (e.getStateChange() == 1) {
     items = items.concat("\n Coffee - Rs 149.");
     amount += 149.00;
    }

   }
  });

  done.addActionListener(new ActionListener() {

   @Override
   public void actionPerformed(ActionEvent e) {

    ordered_items.setText(" ");
    String message = "Thank You for placing order.";
    double gst = Double.parseDouble(gst_tf.getText().trim());
    amount = amount + (amount * (gst) / 100);
    System.out.println(items);

    total_tf.setText("Rs. " + amount);

    ordered_items.setText(items);
    result.setText(" Amount: " + amount);
    
    message=message.concat(result.getText());
    //JOptionPane.showMessageDialog(this,message,"Bill",JOptionPane.INFORMATION_MESSAGE);
    JOptionPane.showMessageDialog(null, ""+message,
      "Bill", JOptionPane.INFORMATION_MESSAGE);
    Bill b=new Bill();
   }
  });
  
  exit.addActionListener(new ActionListener() {
   
   @Override
   public void actionPerformed(ActionEvent e) {
       System.exit(0);
    
   }
  });

 }

 public static void main(String[] args) {
  new PlaceOrder();
 }

}
