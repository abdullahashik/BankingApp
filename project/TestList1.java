  import java.awt.*;
  import java.awt.event.*;
  import javax.swing.*;
  import java.border.*;
  public class TablePanel extends JPanel
  {
     private final JTable table;
     public TablePanel()
     {
        Object[] columnNames = {"Swing", "Awt"}; //prepare two arrays for a table
        Object[][] componentNames = {{"JApplet","Applet"}, {"JButton", "Button"},
                                     {"JCheckBox", "CheckBox"},
                                     {"JCheckBoxMenuItem", "CheckBoxMenuItem"},
                                     {"JColorChooser", "ColorChooser"},
                                     {"JComboBox", "ComboBox"},
                                     {"JComponent", "Component"},
                                     {"JDesktopPane", "DesktopPane"},
                                     {"JDialog", "Dialog"}, {"JFrame", "Frame"},
                                     {"JLabel", "Label"}, {"JList", "List"}};
table = new JTable(componentNames, columnNames); //initialize a Table object
      table.setPreferredScrollableViewportSize(new Dimension(320, 160));

      //Create the scroll pane and add it to the table.
      JScrollPane scrollPane = new JScrollPane(table);

      //Add the scroll pane to this window.
      add(scrollPane);
   }
}class ListPanel extends JPanel
   implements ListSelectionListener
{
   public  ListPanel1()
   {
      selectedSwingComponentTextField = new JTextField(14);
      JLabel textFieldLabel = new JLabel("Selected Component:");

      //initializing a list
      swingComponentList = new JList( new String [] {"JApplet",
                                      "JButton", "JCheckBox", "JCheckBoxMenuItem",
                                      "JColorChooser", "JComboBox", "JComponent",
                                      "JDesktopPane", "JDialog", "JFrame", "JLabel",
                                      "JList", "JMenu", "JMenuBar", "JMenuItem",
                                      "JOptionPane", "JPanel", "JPasswordField",
                                      "JPopupMenu", "JPopupMenu.Separator", "JProgressBar",
                                      "JRadioButton", "JRadioButtonMenuItem",
                                      "JScrollBar", "JScrollPane", "JTabbedPane", "JTable",
                                      "JTextArea", "JTextField", "JTextPane"});
swingComponentList.setVisibleRowCount(5); //set the visible rows
      swingComponentList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      JLabel listLabel = new JLabel("Component List:");
      JPanel p = new JPanel();

      //declare and initialize a SCROLL PANE
      JScrollPane listScroll = new JScrollPane(swingComponentList);
      p.add(listScroll); //add the scroll pane to a panel

      //declare and initialize a GridBagLayout object
      GridBagLayout gbl = new GridBagLayout();
      setLayout(gbl); //let the layout manager be GridBagLayout
      //declare and initialize a GridBagConstraints object
      GridBagConstraints gbc = new GridBagConstraints();
     //apply GridBagConstraints to a GUI component and add it to this panel
      gbc.fill = GridBagConstraints.NONE;
      gbc.weightx = 100;
      gbc.weighty = 100;
      add(textFieldLabel, gbc, 0, 0, 1, 1);

      gbc.fill = GridBagConstraints.NONE;
      gbc.weightx = 100;
      gbc.weighty = 100;
      add(selectedSwingComponentTextField, gbc, 1, 0, 1, 1);

      gbc.fill = GridBagConstraints.NONE;
      gbc.weightx = 100;
      gbc.weighty = 100;
      add(listLabel, gbc, 0, 3, 1, 1);
     gbc.fill = GridBagConstraints.NONE;
      gbc.weightx = 100;
      gbc.weighty = 100;
      add(p, gbc, 1, 1, 1, 5);
      Border raised = BorderFactory.createRaisedBevelBorder();
      setBorder(raised);
      swingComponentList.addListSelectionListener(this); //register an event listener
   }
   //overload method ADD with GridBagConstraints
   public void add(Component c, GridBagConstraints gbc,
                   int x, int y, int w, int h)
   {
      gbc.gridx = x;
      gbc.gridy = y;
      gbc.gridwidth = w;
      gbc.gridheight = h;
      add(c, gbc);
   }

class TabPanel extends JPanel
{
   public TabPanel()
   {
      tabbedPane = new JTabbedPane(); //initialize a JTabbedPane object
      tabPanel_1 = new TablePanel();
      tabPanel_2 = new ListPanel();
      tabPanel_3 = new ListPanel1();
      tabbedPane.addTab("Table", tabPanel_1); //add GUI components to Tabbed Pane
      tabbedPane.setSelectedIndex(0);
      tabbedPane.addTab("List 1", tabPanel_2);
      tabbedPane.addTab("List 2", tabPanel_3);
      add(tabbedPane);
   }
   private JTabbedPane tabbedPane;
   private JPanel tabPanel_1, tabPanel_2, tabPanel_3;
}
}
class ListFrame extends JFrame
{
   public ListFrame()
   {
      setTitle("Test List");
      setSize(360, 180);
      //get screen size and set the location of the frame
      Toolkit tk = Toolkit.getDefaultToolkit();
      Dimension d = tk.getScreenSize();
      int screenHeight = d.height;
      int screenWidth = d.width;
      setLocation( screenWidth / 2 - 180, screenHeight / 4);

      addWindowListener (new WindowAdapter()  //handle window closing event
         {  public void windowClosing (WindowEvent e)
            { System.exit(0);
            }
         });
     JPanel testListPanel = new ListPanel();
      Container contentPane = getContentPane(); //add a panel to a frame
      contentPane.add(testListPanel);
   }
}

public class TestList1  //main class of this program
{  public static void main(String [] args)
   { JFrame frame = new ListFrame(); //initialize a JFrame object
     frame.show(); //display the frame
   }
}
