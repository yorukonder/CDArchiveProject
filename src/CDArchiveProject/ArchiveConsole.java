package CDArchiveProject;

import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;


public class ArchiveConsole {
    JFrame window;
    List<CDRecord> records;

    public  ArchiveConsole()
    {
        records = RecordsStorage.LoadRecordList("records.data");

        window = new JFrame("Archive Management Console");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent windowEvent) {

            }

            @Override
            public void windowClosing(WindowEvent windowEvent) {

            }

            @Override
            public void windowClosed(WindowEvent windowEvent) {

                // recordStorage.saveRecordList( "record.data,"records )
            }

            @Override
            public void windowIconified(WindowEvent windowEvent) {

            }

            @Override
            public void windowDeiconified(WindowEvent windowEvent) {

            }

            @Override
            public void windowActivated(WindowEvent windowEvent) {

            }

            @Override
            public void windowDeactivated(WindowEvent windowEvent) {

            }
        });

        window.getContentPane().setLayout(new GridBagLayout());

        createUI();

        window.pack();
        window.setMinimumSize(new Dimension(1400,800));
        window.setSize(new Dimension(700,400));
        window.setVisible(true);


    }
    private  void createUI(){

        JLabel searchLabel = new JLabel(" Search String  ");
        addComponent(
                window.getContentPane(), searchLabel,
                GridBagConstraints.BOTH,
                0,0,
                1,1,
                0.0f, 0.0f

        );

        JTextField searchText = new JTextField();
        addComponent(
                window.getContentPane(),searchText,
                GridBagConstraints.BOTH,
                1,0,
                1,1,
                20.0f, 0.0f

        );

        JButton searchButton = new JButton( " Search");
        addComponent(
                window.getContentPane(), searchButton,
                GridBagConstraints.EAST,
                2,0,
                1,1,
                20.0f, 0.0f

        );

      JPanel archiveListPanel = createArchiveListPanel();
      addComponent(
              window.getContentPane(), archiveListPanel,
              GridBagConstraints.BOTH,
              0,1,3,1,
              70.0f, 40.0f
      );
      JPanel processLogPanel = createProcessLogPanel();
      addComponent(
              window.getContentPane(), processLogPanel,
              GridBagConstraints.BOTH,
              0,2,
              3,1,
              70.0f, 40.f
      );

      JPanel recordPanel = createRecordPanel();
      addComponent(
              window.getContentPane(), recordPanel,
              GridBagConstraints.BOTH,
              3,0,3,2,
              30.0f, 40.0f
      );

      JPanel actionRequestPanel = createActionRequestPanel();
      addComponent(
              window.getContentPane(), actionRequestPanel,
              GridBagConstraints.BOTH,
              3,2,
              1,1,
              30.0f, 40.0f

      );

    }
    private  JPanel createArchiveListPanel(){
        JPanel panel =new JPanel();
        panel.setLayout( new GridBagLayout());
        panel.setBackground(Color.GREEN);

        JLabel titleLabel = new JLabel( " Archive CDs");
        addComponent(
                panel,titleLabel,
                GridBagConstraints.BOTH,
                0,0,
                4,1,
                100.0f, 0.0f,
                new Insets(0,10,0,0), GridBagConstraints.WEST

        );

        JTable cdRecordTable = new JTable();

        // set test data pr....,..


        CDRecordTableModel tableData = new CDRecordTableModel(records);
        cdRecordTable.setModel(tableData);

        cdRecordTable.setFillsViewportHeight(true);
        JScrollPane cdRecordTableScrollPane = new JScrollPane(cdRecordTable);
        addComponent(
                panel, cdRecordTableScrollPane,
                GridBagConstraints.BOTH,
                0,1,
                4,1,
                100.0f, 10.0f
        );

        JLabel sortLabel = new JLabel( "sort ");
        addComponent(
                panel, sortLabel,
                GridBagConstraints.BOTH,
                0,2,
                1,1,
                0.0f, 0.0f,
                new Insets(0,10,0,0), GridBagConstraints.WEST
        );

        JButton sortByTitleButton = new JButton( "By Title");
        addComponent(
                panel,sortByTitleButton,
                GridBagConstraints.VERTICAL,
                1,2,
                1,1,
                0.0f,0.0f,
                new Insets(0,10,0,0), GridBagConstraints.WEST
        );

        JButton sortByBarcodeButton = new JButton( "By Barcode");
        addComponent(
                panel,sortByBarcodeButton,
                GridBagConstraints.VERTICAL,
                3,2,
                1,1,
                0.0f,0.0f,
                 new Insets(0,10,0,0), GridBagConstraints.WEST
        );

        JButton sortByAuthorButton = new JButton( "By Author");
        addComponent(
                panel,sortByAuthorButton,
                GridBagConstraints.VERTICAL,
                2,2,
                1,1,
                0.0f,0.0f,
                new Insets(0,10,0,0), GridBagConstraints.WEST
        );

        return  panel;
    }
    private  JPanel createProcessLogPanel() {
        JPanel panel = new JPanel();
        panel.setLayout( new GridBagLayout());
        panel.setBackground(Color.YELLOW);

        JLabel processLogLabel = new JLabel(" Process Log :  ");
        addComponent(
                panel, processLogLabel,
                GridBagConstraints.BOTH,
                0,0,
                1,1,
                0.0f, 0.0f

        );
        JTextField processLogText = new JTextField();
        addComponent(
                panel,processLogText,
                GridBagConstraints.BOTH,
                0,6,
                4,4,
                20.0f, 10.0f

        );

        JLabel displayBinaryTreeLabel = new JLabel(" Display Binary Tree :  ");
        addComponent(
                panel, displayBinaryTreeLabel,
                GridBagConstraints.BOTH,
                0,10,
                1,1,
                0.0f, 0.0f
        );
        JLabel hashMapLabel = new JLabel(" HashMap/Set :  ");
        addComponent(
                panel, hashMapLabel,
                GridBagConstraints.BOTH,
                0,12,
                1,1,
                0.0f, 0.0f
        );

                JButton processLogButton = new JButton( " Process Log ");
        addComponent(
                panel, processLogButton,
                GridBagConstraints.NONE,
                3,0,
                1,1,
                0.0f, 0.0f,
                 new Insets(0,10,0,10), GridBagConstraints.EAST

        );

        JButton preOrderButton = new JButton( " Pre-Order ");
        addComponent(
                panel, preOrderButton,
                GridBagConstraints.BOTH,
                1,10,
                1,1,
                0.0f, 0.0f,
                new Insets(0,10,0,0), GridBagConstraints.WEST

        );
        JButton inOrderButton = new JButton( " In-Order ");
        addComponent(
                panel, inOrderButton,
                GridBagConstraints.BOTH,
                2,10,
                1,1,
                0.0f, 0.0f,
                new Insets(0,10,0,0), GridBagConstraints.WEST

        );
        JButton postOrderButton = new JButton( " Post-Order ");
        addComponent(
                panel, postOrderButton,
                GridBagConstraints.NONE,
                3,10,
                1,1,
                0.0f, 0.0f,
        new Insets(0,10,0,0), GridBagConstraints.WEST

        );
        JButton saveButton = new JButton( " Save ");
        addComponent(
                panel, saveButton,
                GridBagConstraints.BOTH,
                1,12,
                1,1,
                0.0f, 0.0f,
                new Insets(0,10,0,0), GridBagConstraints.WEST

        );
        JButton displayButton = new JButton( " Display ");
        addComponent(
                panel, displayButton,
                GridBagConstraints.BOTH,
                2,12,
                1,1,
                0.0f, 0.0f,
                new Insets(0,10,0,0), GridBagConstraints.WEST

        );


        return panel;
    }
    private  JPanel createRecordPanel() {
        JPanel panel = new JPanel();
        panel.setLayout( new GridBagLayout());
        panel.setBackground(Color.RED);

        JLabel titleLabel = new JLabel( "    TITLE : ");
        addComponent(
                panel,titleLabel,
                GridBagConstraints.BOTH,
                0,0,
                1,1,
                0.0f, 0.0f,
                new Insets(10,10,10,10), GridBagConstraints.WEST

        );

        JLabel authorLabel = new JLabel( "   AUTHOR : ");
        addComponent(
                panel, authorLabel,
                GridBagConstraints.BOTH,
                0,1,
                1,1,
                0.0f, 0.0f,
                new Insets(10,10,10,10), GridBagConstraints.WEST
        );
        JLabel sectionLabel = new JLabel( "   SECTION : ");
        addComponent(
                panel, sectionLabel,
                GridBagConstraints.BOTH,
                0,2,
                1,1,
                0.0f, 0.0f,
                new Insets(10,10,10,10), GridBagConstraints.WEST
        );
        JLabel xLabel = new JLabel( "   X : ");
        addComponent(
                panel, xLabel,
                GridBagConstraints.BOTH,
                0,3,
                1,1,
                0.0f, 0.0f,
                new Insets(10,10,10,10), GridBagConstraints.WEST
        );
        JLabel yLabel = new JLabel( "   Y : ");
        addComponent(
                panel, yLabel,
                GridBagConstraints.BOTH,
                0,4,
                1,1,
                0.0f, 0.0f,
                new Insets(10,10,10,10), GridBagConstraints.WEST
        );
        JLabel barcodeLabel = new JLabel( "   BARCODE : ");
        addComponent(
                panel, barcodeLabel,
                GridBagConstraints.BOTH,
                0,5,
                1,1,
                0.0f, 0.0f,
                new Insets(10,10,10,10), GridBagConstraints.WEST
        );
        JLabel descriptionLabel = new JLabel( "   DESCRIPTION : ");
        addComponent(
                panel, descriptionLabel,
                GridBagConstraints.BOTH,
                0,6,
                1,1,
                0.0f, 0.0f,
                new Insets(10,10,10,10), GridBagConstraints.WEST
        );
        JTextField titleText = new JTextField();
        addComponent(
                panel,titleText,
                GridBagConstraints.BOTH,
                1,0,
                1,1,
                0.0f, 0.0f,
                new Insets(10,10,10,10), GridBagConstraints.WEST
        );
        JTextField authorText = new JTextField();
        addComponent(
                panel,authorText,
                GridBagConstraints.BOTH,
                1,1,
                1,1,
                0.0f, 0.0f,
                new Insets(10,10,10,10), GridBagConstraints.WEST
        );
        JTextField sectionText = new JTextField();
        addComponent(
                panel,sectionText,
                GridBagConstraints.BOTH,
                1,2,
                1,1,
                0.0f, 0.0f,
                new Insets(10,10,10,10), GridBagConstraints.WEST
        );
        JTextField xText = new JTextField();
        addComponent(
                panel,xText,
                GridBagConstraints.BOTH,
                1,3,
                1,1,
                0.0f, 0.0f,
                new Insets(10,10,10,10), GridBagConstraints.WEST
        );
        JTextField yText = new JTextField();
        addComponent(
                panel,yText,
                GridBagConstraints.BOTH,
                1,4,
                1,1,
                0.0f, 0.0f,
                new Insets(10,10,10,10), GridBagConstraints.WEST
        );
        JTextField barcodeText = new JTextField();
        addComponent(
                panel,barcodeText,
                GridBagConstraints.BOTH,
                1,5,
                1,1,
                0.0f, 0.0f,
                new Insets(10,10,10,10), GridBagConstraints.WEST
        );
        JTextField descriptionText = new JTextField();
        addComponent(
                panel,descriptionText,
                GridBagConstraints.BOTH,
                1,6,
                1,3,
                0.0f, 0.0f,
                new Insets(10,10,10,10), GridBagConstraints.WEST
        );
        JButton newItemButton = new JButton( "New Item");
        addComponent(
                panel,newItemButton,
                GridBagConstraints.VERTICAL,
                0,14,
                1,1,
                0.0f,0.0f,
                new Insets(10,10,10,10), GridBagConstraints.WEST
        );
        JButton saveButton = new JButton( "Save/Update");
        addComponent(
                panel,saveButton,
                GridBagConstraints.VERTICAL,
                1,14,
                1,1,
                0.0f,0.0f,
                new Insets(10,10,10,10), GridBagConstraints.WEST
        );

        return panel;
    }
    private  JPanel createActionRequestPanel() {
        JPanel panel = new JPanel();
        panel.setLayout( new GridBagLayout());
        panel.setBackground(Color.CYAN);

        JLabel autoLabel = new JLabel( "   AUTOMATION   ACTION   REQUEST   FOR   THE   ITEM    ABOVE   : ");
        addComponent(
                panel, autoLabel,
                GridBagConstraints.BOTH,
                0,0,
                1,1,
                100.0f, 0.0f,
                new Insets(10,10,10,10), GridBagConstraints.WEST
        );
        JButton retrieveButton = new JButton( "    Retrieve    ");
        addComponent(
                panel,retrieveButton,
                GridBagConstraints.VERTICAL,
                0,2,
                1,1,
                1.0f,0.0f,
                new Insets(10,10,10,10), GridBagConstraints.WEST
        );
        JButton removeButton = new JButton( "        Remove        ");
        addComponent(
                panel, removeButton,
                GridBagConstraints.VERTICAL,
                1,2,
                1,1,
                1.0f,0.0f,
                new Insets(10,10,10,10), GridBagConstraints.WEST
        );
        JButton returnButton = new JButton( "      Return      ");
        addComponent(
                panel, returnButton,
                GridBagConstraints.NONE,
                0,5,
                10,1,
                10.0f,0.0f,
                new Insets(10,10,10,10), GridBagConstraints.WEST
        );
        JButton addButton = new JButton( "Add to Collection");
        addComponent(
                panel, addButton,
                GridBagConstraints.VERTICAL,
                1,5,
                1,1,
                1.0f,0.0f,
                new Insets(10,10,10,10), GridBagConstraints.WEST
        );
        JButton randomCollectionButton = new JButton( "Random Collection Sort");
        addComponent(
                panel, randomCollectionButton,
                GridBagConstraints.VERTICAL,
                0,8,
                1,1,
                2.0f,0.0f,
                new Insets(10,10,10,10), GridBagConstraints.WEST
        );
        JButton mostlySortedButton = new JButton( "     Mostly Sorted Sort     ");
        addComponent(
                panel, mostlySortedButton,
                GridBagConstraints.VERTICAL,
                0,9,
                1,1,
                2.0f,0.0f,
                new Insets(10,10,10,10), GridBagConstraints.WEST
        );
        JButton reverseOrderButton = new JButton( "    Reverse Order Sort    ");
        addComponent(
                panel, reverseOrderButton,
                GridBagConstraints.VERTICAL,
                0,10,
                1,1,
                2.0f,0.0f,
                new Insets(10,10,10,10), GridBagConstraints.WEST
        );
        JButton exitButton = new JButton( "                E X I T                 ");
        addComponent(
                panel, exitButton,
                GridBagConstraints.VERTICAL,
                0,12,
                1,1,
                3.0f,0.0f,
                new Insets(10,10,10,10), GridBagConstraints.WEST
        );
        JLabel sortLabel = new JLabel( "   SORT     SECTION   :  ");
        addComponent(
                panel, sortLabel,
                GridBagConstraints.BOTH,
                0,6,
                1,1,
                0.0f, 0.0f,
                new Insets(10,10,10,10), GridBagConstraints.WEST
        );
        JTextField sortText = new JTextField();
        addComponent(
                panel,sortText,
                GridBagConstraints.BOTH,
                1,6,
                2,2,
                0.0f, 0.0f,
                new Insets(10,10,10,10), GridBagConstraints.EAST
        );


        return panel;
    }
    private <C extends Component> void addComponent(
            Container  contentPane, C component,
            int fill, int gridx, int gridy,
            int gridwidth, int gridheight,
            float weightx, float weighty
    ){
       GridBagConstraints constraints = new GridBagConstraints();
       constraints.fill = fill;
       constraints.gridx = gridx;
       constraints.gridy = gridy;
       constraints.gridwidth = gridwidth;
       constraints.gridheight = gridheight;
       constraints.weightx = weightx;
       constraints.weighty = weighty;

       contentPane.add(component, constraints);

    }
    private < C extends Component> void addComponent(
            Container  contentPane, C component,
            int fill, int gridx, int gridy,
            int gridwidth, int gridheight,
            float weightx, float weighty,
            Insets insets, int anchor
    ){
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = fill;
        constraints.gridx = gridx;
        constraints.gridy = gridy;
        constraints.gridwidth = gridwidth;
        constraints.gridheight = gridheight;
        constraints.weightx = weightx;
        constraints.weighty = weighty;
        constraints.insets = insets;
        constraints.anchor = anchor;


        contentPane.add(component, constraints);

    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ArchiveConsole();

            }
        });
    }

}
