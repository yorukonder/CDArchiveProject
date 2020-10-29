package sockets;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;

public class ChatClientUI {
    JFrame window;
    Client client;
    JList chatHistory;
    ArrayList<String> chatHistoryData;

    public ChatClientUI(){

        window = new JFrame( "Chat Client");
                window.setMinimumSize(new Dimension(400,400));
        window.setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));

        Container content = window.getContentPane();
        content.setLayout(new GridBagLayout());

        chatHistoryData = new ArrayList<>();

        createUI();

        window.pack();
        window.setVisible(true);


    }
    private void createUI(){

     JTextField serverAddress = new JTextField();
     addComponent(serverAddress, 0,0,2,1,0f,0f);

     JButton connect = new JButton( "connect");
     addComponent( connect, 0,1,2,1,0f, 0f);
     connect.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             System.out.println("Open new connection to: : " + serverAddress.getText());
             client = new Client(serverAddress.getText(), new MessageListener() {
                 @Override
                 public void message(String msg, MessageSender sender) {
                     // add new message to chat history
                     chatHistoryData.add(msg);
                     chatHistory.setListData(chatHistoryData.toArray());

                 }
             });
         }
     });

     chatHistory = new JList();
     addComponent( chatHistory, 0, 2, 2,1, 1f,1f);

     JTextField chatBox = new JTextField();
     addComponent( chatBox, 0,3,1,1,1f,0f);

     JButton send = new JButton("send");
     addComponent(send,1,3,1,1,0f,0f);
     send.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             System.out.println( "send message: " + chatBox.getText());
             if (client != null){
                 client.sendMessage(chatBox.getText());
             }
             chatBox.setText(" ");
         }
     });

    }

    private <C extends Component> C addComponent( C component, int gridX, int gridY,
                                                  int gridWidth, int gridHeight, float weightX,
                                                  float weightY){
      GridBagConstraints constraints = new GridBagConstraints();
      constraints.fill = GridBagConstraints.BOTH;
      constraints.gridx = gridX;
      constraints.gridy = gridY;
      constraints.gridwidth = gridWidth;
      constraints.gridheight = gridHeight;
      constraints.weightx = weightX;
      constraints.weighty = weightY;
       window.getContentPane().add(component, constraints);

       return component;

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ChatClientUI client = new ChatClientUI();
            }
        });
    }
}
