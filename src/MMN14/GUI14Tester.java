package MMN14;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

public class GUI14Tester extends javax.swing.JFrame {

  // <editor-fold defaultstate="collapsed" desc="Array Presets">
  private static final int[][] minDiffPresets = {
    {1, 3, 5, 4, 8, 2, 4, 3, 6, 5},
    {1, 2, 3, 4, 5},
    {5, 3, 5, 3, 5, 3, 5},
    {4, 1, 7, 5, 3, 9, 4, 6, 3, 1}
  };

  private static final int[][][] searchPresets = {
    {
      {2, 6},
      {12, 10}
    }, {
      {1, 2},
      {4, 3}
    }, {
      {1, 5},
      {9, 7}
    }, {
      {1, 3, 7, 9},
      {6, 4, 15, 11},
      {36, 50, 21, 23},
      {60, 55, 30, 26}
    }, {
      {4, 9, 24, 26},
      {19, 16, 35, 32},
      {67, 73, 42, 49},
      {81, 75, 60, 55}
    }, {
      {6, 7, 17, 23, 65, 68, 76, 78},
      {12, 9, 32, 29, 75, 69, 82, 80},
      {55, 56, 35, 36, 100, 103, 85, 90},
      {60, 57, 48, 42, 111, 108, 94, 93},
      {148, 149, 159, 163, 113, 114, 123, 125},
      {155, 151, 169, 167, 121, 118, 130, 128},
      {190, 195, 172, 176, 139, 140, 131, 132},
      {199, 196, 181, 179, 146, 142, 138, 135}
    }, {
      {7, 12, 25, 26, 74, 76, 90, 95},
      {19, 16, 36, 29, 85, 79, 102, 99},
      {62, 65, 43, 49, 123, 124, 107, 111},
      {73, 66, 56, 52, 130, 127, 122, 117},
      {195, 196, 209, 212, 131, 138, 149, 150},
      {205, 200, 215, 214, 147, 143, 154, 153},
      {240, 241, 221, 228, 178, 180, 160, 165},
      {252, 247, 239, 232, 188, 183, 172, 169}
    }, {
      {3, 5, 14, 16, 70, 72, 86, 89, 275, 278, 287, 292, 338, 344, 354, 355},
      {11, 9, 26, 19, 79, 73, 94, 90, 284, 280, 301, 299, 353, 347, 362, 361},
      {53, 59, 30, 37, 111, 117, 97, 99, 319, 324, 302, 307, 374, 379, 363, 369},
      {63, 62, 46, 43, 128, 121, 106, 102, 333, 328, 313, 309, 390, 383, 372, 371},
      {209, 210, 218, 219, 135, 138, 149, 155, 468, 470, 487, 493, 397, 403, 417, 422},
      {212, 211, 231, 226, 147, 145, 167, 160, 481, 476, 495, 494, 414, 408, 425, 424},
      {258, 263, 237, 242, 194, 197, 173, 176, 516, 523, 502, 505, 447, 452, 428, 433},
      {272, 268, 252, 248, 203, 199, 188, 183, 533, 530, 512, 508, 461, 455, 441, 435},
      {806, 808, 821, 822, 864, 869, 881, 887, 535, 538, 549, 552, 606, 613, 620, 623},
      {817, 811, 832, 828, 874, 872, 897, 891, 547, 540, 558, 557, 616, 615, 633, 629},
      {850, 851, 835, 839, 926, 933, 899, 906, 587, 592, 565, 572, 656, 659, 634, 641},
      {860, 858, 847, 846, 942, 938, 919, 912, 599, 593, 582, 576, 668, 663, 649, 648},
      {997, 1004, 1016, 1021, 946, 951, 961, 962, 733, 740, 751, 757, 672, 676, 684, 689},
      {1013, 1008, 1028, 1025, 960, 956, 970, 966, 747, 745, 768, 761, 679, 677, 696, 690},
      {1047, 1054, 1030, 1035, 981, 984, 972, 973, 789, 793, 771, 774, 717, 724, 698, 705},
      {1063, 1057, 1045, 1040, 992, 988, 979, 976, 803, 799, 784, 780, 727, 726, 714, 712}
    }
  };
  
  private static final int[][] equalSplitPresets = {
    {-3, 5, 12, 14, -9, 13},
    {-3, 5, -12, 14, -9, 13},
    {-3, 5, -12, 14, -9, 13},
    {1, 2, 3, 4, 4, 3, 2, 1},
    {2, 2, 3, 3, 2, 1},
    { 4, 5, 8, 10, 7, 6},
    { 7, 10, 3, 2, 4, 6 },
    { 3, 8, 4, 5, 9, 3},
    { 4, 6, 7, 3, 3, 9, 8, 4},
    { 2, 5, 9, 3, 4, 7, 2, 9 }
  };
  // </editor-fold>

  private JTextField[] txtMinDiffArray;
  private JTextField[][] txtSearchArray;
  private JTextField[] txtSplitArray;
  private int[] specials;

  public GUI14Tester() {
    initComponents();
    setLocationRelativeTo(null);

    initMinDiff();
    initSearch();
    initSplit();
    initSpecial();
  }

  // ============== minDiff =================
  private void initMinDiff() {
    ((PlainDocument) txtX.getDocument()).setDocumentFilter(intFilter);
    ((PlainDocument) txtY.getDocument()).setDocumentFilter(intFilter);

    txtMinDiffArray = new JTextField[0];
    createMinDiffArray((int) sprMinDiffLength.getValue());
  }

  private void createMinDiffArray(int length) {
    if (length < 0) {
      return;
    }

    final Font FONT_DEF = new JTextField().getFont();
    final Font FONT_BIG = FONT_DEF.deriveFont(Math.max(FONT_DEF.getSize2D(), 30f));

    pnlMinDiffArray.removeAll();
    JTextField[] temp = new JTextField[length];

    for (int i = 0; i < length; i++) {
      if (i < txtMinDiffArray.length) {
        temp[i] = txtMinDiffArray[i];
        pnlMinDiffArray.add(temp[i]);
        continue;
      }
      JTextField txt = new JTextField();
      txt.setFont(FONT_BIG);
      txt.setPreferredSize(new Dimension(50, 50));
      txt.setHorizontalAlignment(JTextField.CENTER);
      ((PlainDocument) txt.getDocument()).setDocumentFilter(intFilter);
      temp[i] = txt;
      pnlMinDiffArray.add(txt);
    }
    pnlMinDiffArray.revalidate();
    
    Dimension min = getMinimumSize();
    setMinimumSize(getSize());
    pack();
    setMinimumSize(min);

    txtMinDiffArray = temp;
  }

  private void fillMinDiffPreset(int preseti) {
    if (preseti < 0 || preseti >= minDiffPresets.length) {
      return;
    }

    int[] preset = minDiffPresets[preseti];
    sprMinDiffLength.setValue(preset.length);
    createMinDiffArray(preset.length);

    for (int i = 0; i < preset.length; i++) {
      txtMinDiffArray[i].setText("" + preset[i]);
    }
  }

  // ============= search ================
  private void initSearch() {
    ((PlainDocument) txtSearch.getDocument()).setDocumentFilter(intFilter);
    
    Hashtable<Integer, JLabel> table = new Hashtable<>();
    table.put(1, new JLabel("2"));
    table.put(2, new JLabel("4"));
    table.put(3, new JLabel("8"));
    table.put(4, new JLabel("16"));
    sldSearchLength.setLabelTable(table);
    
    txtSearchArray = new JTextField[0][0];
    sldSearchLength.setValue(1);
  }

  private void createSearchArray(int length) {
    if (length < 0) {
      return;
    }

    final Font FONT_DEF = new JTextField().getFont();
    final Font FONT_BIG = FONT_DEF.deriveFont(Math.max(FONT_DEF.getSize2D(), 30f));
    
    pnlSearchArray.removeAll();
    JTextField[][] temp = new JTextField[length][length];
    pnlSearchArray.setLayout(new GridLayout(length, length));
    
    for (int r = 0; r < length; r++) {
      for (int c = 0; c < length; c++) {
        if (r < txtSearchArray.length && c < txtSearchArray[r].length) {
          temp[r][c] = txtSearchArray[r][c];
          pnlSearchArray.add(temp[r][c]);
          continue;
        }
        JTextField txt = new JTextField();
        txt.setFont(FONT_BIG);
        txt.setPreferredSize(new Dimension(75, 50));
        txt.setHorizontalAlignment(JTextField.CENTER);
        ((PlainDocument) txt.getDocument()).setDocumentFilter(intFilter);
        temp[r][c] = txt;
        pnlSearchArray.add(txt);
      }
    }
    
    txtSearchArray = temp;
    pnlSearchArray.revalidate();
    
    Dimension min = getMinimumSize();
    setMinimumSize(getSize());
    pack();
    setMinimumSize(min);
  }

  private void fillSearchPreset(int preseti) {
    if (preseti < 0 || preseti >= searchPresets.length) {
      return;
    }
    
    int[][] preset = searchPresets[preseti];
    updateSldSearchLength(preset.length);
    createMinDiffArray(preset.length);

    for (int r = 0; r < preset.length; r++) {
      for (int c = 0; c < preset.length; c++) {
        txtSearchArray[r][c].setText("" + preset[r][c]);
      }
    }
  }
  
  // ============= equalSplit ==============
  private void initSplit() {
    txtSplitArray = new JTextField[0];
    createSplitArray((int) sprSplitLength.getValue());
  }

  private void createSplitArray(int length) {
    if (length < 0) {
      return;
    }

    final Font FONT_DEF = new JTextField().getFont();
    final Font FONT_BIG = FONT_DEF.deriveFont(Math.max(FONT_DEF.getSize2D(), 30f));

    pnlSplitArray.removeAll();
    JTextField[] temp = new JTextField[length];

    for (int i = 0; i < length; i++) {
      if (i < txtSplitArray.length) {
        temp[i] = txtSplitArray[i];
        pnlSplitArray.add(temp[i]);
        continue;
      }
      JTextField txt = new JTextField();
      txt.setFont(FONT_BIG);
      txt.setPreferredSize(new Dimension(50, 50));
      txt.setHorizontalAlignment(JTextField.CENTER);
      ((PlainDocument) txt.getDocument()).setDocumentFilter(intFilter);
      temp[i] = txt;
      pnlSplitArray.add(txt);
    }
    pnlSplitArray.revalidate();
    
    Dimension min = getMinimumSize();
    setMinimumSize(getSize());
    pack();
    setMinimumSize(min);

    txtSplitArray = temp;
  }

  private void fillSplitPreset(int preseti) {
    if (preseti < 0 || preseti >= equalSplitPresets.length) {
      return;
    }

    int[] preset = equalSplitPresets[preseti];
    sprSplitLength.setValue(preset.length);
    createSplitArray(preset.length);

    for (int i = 0; i < preset.length; i++) {
      txtSplitArray[i].setText("" + preset[i]);
    }
  }
  
  // =============== isSpecial ==============
  private void initSpecial() {
    ((PlainDocument) txtSpecialCheck.getDocument()).setDocumentFilter(intFilter);
    calculateSpecialArray((int)sprSpecialMax.getValue());
  }
  
  private void calculateSpecialArray(int end) {
    specials = new int[end];
    int len = specials.length;
    for(int i = 0; i < len; i++) specials[i] = i + 1;
    
    for (int step = 2; step <= len; step++) {
      int count = 0;
      for (int i = 0; i < len; i++) {
        if ((i+1) % step == 0) count++;
        else if (count != 0) {
          specials[i - count] = specials[i];
          specials[i] = -1;
        }
      }
      len -= count;
    }
    
    specials = Arrays.copyOf(specials, len);
    
    StringBuilder arr = new StringBuilder("{ ").append(specials[0]);
    for (int i = 1; i < specials.length; i++) {
      arr.append(", ").append(specials[i]);
    }
    arr.append(" }");
    lblSpecialArray.setText(arr.toString());
  }
  
  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    tabPane = new javax.swing.JTabbedPane();
    tabMinDiff = new javax.swing.JPanel();
    pnlMidDiffChoose = new javax.swing.JPanel();
    cmbMinDiffChoose = new javax.swing.JComboBox<>();
    lblMinDiffLength = new javax.swing.JLabel();
    sprMinDiffLength = new javax.swing.JSpinner();
    btnMinDiffRand = new javax.swing.JButton();
    pnlMinDiffArray = new javax.swing.JPanel();
    pnlMinDiffInput = new javax.swing.JPanel();
    lblX = new javax.swing.JLabel();
    txtX = new javax.swing.JTextField();
    lblY = new javax.swing.JLabel();
    txtY = new javax.swing.JTextField();
    btnMinDiffFind = new javax.swing.JButton();
    btnMinDiffTest = new javax.swing.JButton();
    tabSearch = new javax.swing.JPanel();
    pnlSearchChoose = new javax.swing.JPanel();
    cmbSearchChoose = new javax.swing.JComboBox<>();
    btnSearchRand = new javax.swing.JButton();
    sldSearchLength = new javax.swing.JSlider();
    pnlSearchInput = new javax.swing.JPanel();
    lblSearch = new javax.swing.JLabel();
    txtSearch = new javax.swing.JTextField();
    btnSeach = new javax.swing.JButton();
    btnSearchTest = new javax.swing.JButton();
    pnlSearchArray = new javax.swing.JPanel();
    tabSplit = new javax.swing.JPanel();
    pnlSplitChoose = new javax.swing.JPanel();
    cmbSplitChoose = new javax.swing.JComboBox<>();
    lblSplitLength = new javax.swing.JLabel();
    sprSplitLength = new javax.swing.JSpinner();
    btnSplitRand = new javax.swing.JButton();
    pnlSplitArray = new javax.swing.JPanel();
    pnlSplitInput = new javax.swing.JPanel();
    btnSplit = new javax.swing.JButton();
    btnSplitTest = new javax.swing.JButton();
    btnSplitTestPresets = new javax.swing.JButton();
    tabSpecial = new javax.swing.JPanel();
    pnlSpecialChoose = new javax.swing.JPanel();
    lblSpecialMax = new javax.swing.JLabel();
    sprSpecialMax = new javax.swing.JSpinner();
    btnSpecialCalc = new javax.swing.JButton();
    pnlScrollSpecialArray = new javax.swing.JScrollPane();
    lblSpecialArray = new javax.swing.JLabel();
    pnlSpecialInput = new javax.swing.JPanel();
    lblSpecialCheck = new javax.swing.JLabel();
    txtSpecialCheck = new javax.swing.JTextField();
    btnSpecialCheck = new javax.swing.JButton();
    btnSpecialTest = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Maman 14 Tester");

    tabPane.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

    tabMinDiff.setLayout(new javax.swing.BoxLayout(tabMinDiff, javax.swing.BoxLayout.PAGE_AXIS));

    pnlMidDiffChoose.setMaximumSize(new java.awt.Dimension(65577, 30));
    pnlMidDiffChoose.setLayout(new javax.swing.BoxLayout(pnlMidDiffChoose, javax.swing.BoxLayout.LINE_AXIS));

    cmbMinDiffChoose.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Preset 1", "Preset 2", "Preset 3", "Preset 4" }));
    cmbMinDiffChoose.setSelectedIndex(-1);
    cmbMinDiffChoose.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        cmbMinDiffChooseActionPerformed(evt);
      }
    });
    pnlMidDiffChoose.add(cmbMinDiffChoose);

    lblMinDiffLength.setText("Length: ");
    pnlMidDiffChoose.add(lblMinDiffLength);

    sprMinDiffLength.setModel(new javax.swing.SpinnerNumberModel(5, 1, 20, 1));
    sprMinDiffLength.addChangeListener(new javax.swing.event.ChangeListener() {
      public void stateChanged(javax.swing.event.ChangeEvent evt) {
        sprMinDiffLengthStateChanged(evt);
      }
    });
    pnlMidDiffChoose.add(sprMinDiffLength);

    btnMinDiffRand.setText("Random");
    btnMinDiffRand.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnMinDiffRandActionPerformed(evt);
      }
    });
    pnlMidDiffChoose.add(btnMinDiffRand);

    tabMinDiff.add(pnlMidDiffChoose);

    pnlMinDiffArray.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
    pnlMinDiffArray.setLayout(new javax.swing.BoxLayout(pnlMinDiffArray, javax.swing.BoxLayout.LINE_AXIS));
    tabMinDiff.add(pnlMinDiffArray);

    pnlMinDiffInput.setMaximumSize(new java.awt.Dimension(2147483647, 22));
    pnlMinDiffInput.setLayout(new javax.swing.BoxLayout(pnlMinDiffInput, javax.swing.BoxLayout.LINE_AXIS));

    lblX.setText(" x: ");
    pnlMinDiffInput.add(lblX);
    pnlMinDiffInput.add(txtX);

    lblY.setText(" y: ");
    pnlMinDiffInput.add(lblY);
    pnlMinDiffInput.add(txtY);

    btnMinDiffFind.setText("Find");
    btnMinDiffFind.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnMinDiffFindActionPerformed(evt);
      }
    });
    pnlMinDiffInput.add(btnMinDiffFind);

    btnMinDiffTest.setText("TEST");
    btnMinDiffTest.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnMinDiffTestActionPerformed(evt);
      }
    });
    pnlMinDiffInput.add(btnMinDiffTest);

    tabMinDiff.add(pnlMinDiffInput);

    tabPane.addTab("findMinDiff", tabMinDiff);

    tabSearch.setLayout(new javax.swing.BoxLayout(tabSearch, javax.swing.BoxLayout.PAGE_AXIS));

    pnlSearchChoose.setLayout(new javax.swing.BoxLayout(pnlSearchChoose, javax.swing.BoxLayout.LINE_AXIS));

    cmbSearchChoose.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Preset 1", "Preset 2", "Preset 3", "Preset 4", "Preset 5", "Preset 6", "Preset 7", "Preset 8" }));
    cmbSearchChoose.setSelectedIndex(-1);
    cmbSearchChoose.setMaximumSize(new java.awt.Dimension(32767, 22));
    cmbSearchChoose.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        cmbSearchChooseActionPerformed(evt);
      }
    });
    pnlSearchChoose.add(cmbSearchChoose);

    btnSearchRand.setText("Random");
    btnSearchRand.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnSearchRandActionPerformed(evt);
      }
    });
    pnlSearchChoose.add(btnSearchRand);

    tabSearch.add(pnlSearchChoose);

    sldSearchLength.setMajorTickSpacing(1);
    sldSearchLength.setMaximum(4);
    sldSearchLength.setMinimum(1);
    sldSearchLength.setPaintLabels(true);
    sldSearchLength.setPaintTicks(true);
    sldSearchLength.setSnapToTicks(true);
    sldSearchLength.setValue(2);
    sldSearchLength.addChangeListener(new javax.swing.event.ChangeListener() {
      public void stateChanged(javax.swing.event.ChangeEvent evt) {
        sldSearchLengthStateChanged(evt);
      }
    });
    tabSearch.add(sldSearchLength);

    pnlSearchInput.setMaximumSize(new java.awt.Dimension(2147483647, 22));
    pnlSearchInput.setLayout(new javax.swing.BoxLayout(pnlSearchInput, javax.swing.BoxLayout.LINE_AXIS));

    lblSearch.setText(" Seach For: ");
    pnlSearchInput.add(lblSearch);
    pnlSearchInput.add(txtSearch);

    btnSeach.setText("Search");
    btnSeach.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnSeachActionPerformed(evt);
      }
    });
    pnlSearchInput.add(btnSeach);

    btnSearchTest.setText("TEST");
    btnSearchTest.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnSearchTestActionPerformed(evt);
      }
    });
    pnlSearchInput.add(btnSearchTest);

    tabSearch.add(pnlSearchInput);

    pnlSearchArray.setLayout(new java.awt.GridLayout(4, 4));
    tabSearch.add(pnlSearchArray);

    tabPane.addTab("search", tabSearch);

    tabSplit.setLayout(new javax.swing.BoxLayout(tabSplit, javax.swing.BoxLayout.PAGE_AXIS));

    pnlSplitChoose.setMaximumSize(new java.awt.Dimension(65577, 30));
    pnlSplitChoose.setLayout(new javax.swing.BoxLayout(pnlSplitChoose, javax.swing.BoxLayout.LINE_AXIS));

    cmbSplitChoose.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Preset 1", "Preset 2", "Preset 3", "Preset 4", "Preset 5", "Preset 6", "Preset 7", "Preset 8", "Preset 9", "Preset 10" }));
    cmbSplitChoose.setSelectedIndex(-1);
    cmbSplitChoose.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        cmbSplitChooseActionPerformed(evt);
      }
    });
    pnlSplitChoose.add(cmbSplitChoose);

    lblSplitLength.setText("Length: ");
    pnlSplitChoose.add(lblSplitLength);

    sprSplitLength.setModel(new javax.swing.SpinnerNumberModel(5, 1, 20, 1));
    sprSplitLength.addChangeListener(new javax.swing.event.ChangeListener() {
      public void stateChanged(javax.swing.event.ChangeEvent evt) {
        sprSplitLengthStateChanged(evt);
      }
    });
    pnlSplitChoose.add(sprSplitLength);

    btnSplitRand.setText("Random");
    btnSplitRand.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnSplitRandActionPerformed(evt);
      }
    });
    pnlSplitChoose.add(btnSplitRand);

    tabSplit.add(pnlSplitChoose);

    pnlSplitArray.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
    pnlSplitArray.setLayout(new javax.swing.BoxLayout(pnlSplitArray, javax.swing.BoxLayout.LINE_AXIS));
    tabSplit.add(pnlSplitArray);

    pnlSplitInput.setMaximumSize(new java.awt.Dimension(2147483647, 22));
    pnlSplitInput.setLayout(new javax.swing.BoxLayout(pnlSplitInput, javax.swing.BoxLayout.LINE_AXIS));

    btnSplit.setText("Can Split?");
    btnSplit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnSplitActionPerformed(evt);
      }
    });
    pnlSplitInput.add(btnSplit);

    btnSplitTest.setText("TEST");
    btnSplitTest.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnSplitTestActionPerformed(evt);
      }
    });
    pnlSplitInput.add(btnSplitTest);

    btnSplitTestPresets.setText("TEST ALL PRESETS");
    btnSplitTestPresets.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnSplitTestPresetsActionPerformed(evt);
      }
    });
    pnlSplitInput.add(btnSplitTestPresets);

    tabSplit.add(pnlSplitInput);

    tabPane.addTab("equalSplit", tabSplit);

    tabSpecial.setLayout(new javax.swing.BoxLayout(tabSpecial, javax.swing.BoxLayout.PAGE_AXIS));

    pnlSpecialChoose.setMaximumSize(new java.awt.Dimension(65577, 30));
    pnlSpecialChoose.setLayout(new javax.swing.BoxLayout(pnlSpecialChoose, javax.swing.BoxLayout.LINE_AXIS));

    lblSpecialMax.setText(" Max Number:");
    pnlSpecialChoose.add(lblSpecialMax);

    sprSpecialMax.setModel(new javax.swing.SpinnerNumberModel(100, 1, null, 10));
    pnlSpecialChoose.add(sprSpecialMax);

    btnSpecialCalc.setText("Calculate Special Array");
    btnSpecialCalc.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnSpecialCalcActionPerformed(evt);
      }
    });
    pnlSpecialChoose.add(btnSpecialCalc);

    tabSpecial.add(pnlSpecialChoose);

    lblSpecialArray.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
    lblSpecialArray.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    lblSpecialArray.setText("{ 1, 3, 7, 13, 19, 27, 39, 49, 63, 79, 91 }");
    pnlScrollSpecialArray.setViewportView(lblSpecialArray);

    tabSpecial.add(pnlScrollSpecialArray);

    pnlSpecialInput.setMaximumSize(new java.awt.Dimension(2147483647, 22));
    pnlSpecialInput.setLayout(new javax.swing.BoxLayout(pnlSpecialInput, javax.swing.BoxLayout.LINE_AXIS));

    lblSpecialCheck.setText(" Check Number:");
    pnlSpecialInput.add(lblSpecialCheck);
    pnlSpecialInput.add(txtSpecialCheck);

    btnSpecialCheck.setText("isSpecial?");
    btnSpecialCheck.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnSpecialCheckActionPerformed(evt);
      }
    });
    pnlSpecialInput.add(btnSpecialCheck);

    btnSpecialTest.setText("TEST");
    btnSpecialTest.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnSpecialTestActionPerformed(evt);
      }
    });
    pnlSpecialInput.add(btnSpecialTest);

    tabSpecial.add(pnlSpecialInput);

    tabPane.addTab("isSpecial", tabSpecial);

    getContentPane().add(tabPane, java.awt.BorderLayout.CENTER);

    pack();
  }// </editor-fold>//GEN-END:initComponents

  // ============== minDiff =================
  private void cmbMinDiffChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMinDiffChooseActionPerformed
    int preset = cmbMinDiffChoose.getSelectedIndex();
    if (preset >= 0 || preset < minDiffPresets.length) {
      fillMinDiffPreset(preset);
    }
    pnlMinDiffArray.revalidate();
  }//GEN-LAST:event_cmbMinDiffChooseActionPerformed

  private void sprMinDiffLengthStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sprMinDiffLengthStateChanged
    createMinDiffArray((int) sprMinDiffLength.getValue());
    pnlMinDiffArray.revalidate();
  }//GEN-LAST:event_sprMinDiffLengthStateChanged

  private void btnMinDiffFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinDiffFindActionPerformed
    if (txtX.getText().isEmpty() || txtY.getText().isEmpty()) {
      return;
    }

    int x = Integer.parseInt(txtX.getText());
    int y = Integer.parseInt(txtY.getText());
    int[] arr = new int[txtMinDiffArray.length];

    for (int i = 0; i < arr.length; i++) {
      if (txtMinDiffArray[i].getText().isEmpty()) {
        return;
      }
      arr[i] = Integer.parseInt(txtMinDiffArray[i].getText());
    }

    int diff;
    try {
      diff = Ex14.findMinDiff(arr, x, y);
    } catch (Exception ex) {
      displayException(ex);
      return;
    }

    JOptionPane.showMessageDialog(this, diff, "findMinDiff",
      JOptionPane.PLAIN_MESSAGE);
  }//GEN-LAST:event_btnMinDiffFindActionPerformed

  private void btnMinDiffRandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinDiffRandActionPerformed
    Random rnd = new Random();
    int len = (int) sprMinDiffLength.getValue();
    createMinDiffArray(len);
    for (JTextField txt: txtMinDiffArray) {
      txt.setText("" + (1 + rnd.nextInt(10)));
    }
  }//GEN-LAST:event_btnMinDiffRandActionPerformed

  private void btnMinDiffTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinDiffTestActionPerformed
    tstMinDiff();
  }//GEN-LAST:event_btnMinDiffTestActionPerformed

  // ============= search ================
  private void cmbSearchChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSearchChooseActionPerformed
    int preset = cmbSearchChoose.getSelectedIndex();
    if (preset >= 0 || preset < searchPresets.length) {
      fillSearchPreset(preset);
    }
    pnlSearchArray.revalidate();
  }//GEN-LAST:event_cmbSearchChooseActionPerformed

  private void sldSearchLengthStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldSearchLengthStateChanged
    int length = 1 << sldSearchLength.getValue();
    createSearchArray(length);
  }//GEN-LAST:event_sldSearchLengthStateChanged

  private void btnSearchRandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchRandActionPerformed
    Random rnd = new Random();
    int len = 1 << sldSearchLength.getValue();
    createMinDiffArray(len);
    int len2 = len * len;
    
    int[] arr = new int[len2];
    int num = 0;
    for (int i = 0; i < len2; i++) {
      num += 1 + rnd.nextInt(5);
      arr[i] = num;
    }
    
    int[][] mat = arrayToCircleMatrix(arr, len);
    for (int r = 0; r < len; r++) for (int c = 0; c < len; c++) {
      txtSearchArray[r][c].setText("" + mat[r][c]);
    }
  }//GEN-LAST:event_btnSearchRandActionPerformed

  private void btnSeachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeachActionPerformed
    if (txtSearch.getText().isEmpty()) return;
    
    int len = txtSearchArray.length;
    int num = Integer.parseInt(txtSearch.getText());
    int[][] mat = new int[len][len];
    
    for (int r = 0; r < len; r++) for (int c = 0; c < len; c++) {
      if (txtSearchArray[r][c].getText().isEmpty()) return;
      mat[r][c] = Integer.parseInt(txtSearchArray[r][c].getText());
    }
    
    boolean found;
    try {
      found = Ex14.search(mat, num);
    } catch (Exception ex) {
      displayException(ex);
      return;
    }
    
    JOptionPane.showMessageDialog(this, found, "search",
      JOptionPane.PLAIN_MESSAGE);
  }//GEN-LAST:event_btnSeachActionPerformed

  private void btnSearchTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchTestActionPerformed
    tstSearch();
  }//GEN-LAST:event_btnSearchTestActionPerformed
  
  // ============= equalSplit ==============
  private void cmbSplitChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSplitChooseActionPerformed
    int preset = cmbSplitChoose.getSelectedIndex();
    if (preset >= 0 || preset < equalSplitPresets.length) {
      fillSplitPreset(preset);
    }
    pnlSplitArray.revalidate();
  }//GEN-LAST:event_cmbSplitChooseActionPerformed

  private void sprSplitLengthStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sprSplitLengthStateChanged
    createSplitArray((int) sprSplitLength.getValue());
    pnlSplitArray.revalidate();
  }//GEN-LAST:event_sprSplitLengthStateChanged

  private void btnSplitRandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSplitRandActionPerformed
    Random rnd = new Random();
    int len = (int) sprSplitLength.getValue();
    createSplitArray(len);
    for (JTextField txt: txtSplitArray) {
      txt.setText("" + (rnd.nextInt(20) - 10));
    }
  }//GEN-LAST:event_btnSplitRandActionPerformed

  private void btnSplitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSplitActionPerformed
    int[] arr = new int[txtSplitArray.length];

    for (int i = 0; i < arr.length; i++) {
      if (txtSplitArray[i].getText().isEmpty()) {
        return;
      }
      arr[i] = Integer.parseInt(txtSplitArray[i].getText());
    }

    boolean canSplit;
    try {
      canSplit = Ex14.equalSplit(arr);
    } catch (Exception ex) {
      displayException(ex);
      return;
    }

    JOptionPane.showMessageDialog(this, canSplit, "equalSplit",
      JOptionPane.PLAIN_MESSAGE);
  }//GEN-LAST:event_btnSplitActionPerformed

  private void btnSplitTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSplitTestActionPerformed
    tstEqualSplit();
  }//GEN-LAST:event_btnSplitTestActionPerformed

  private void btnSplitTestPresetsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSplitTestPresetsActionPerformed
    tstEqualSplitPresets();
  }//GEN-LAST:event_btnSplitTestPresetsActionPerformed
  
  // ============== isSpecial =================
  private void btnSpecialCalcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSpecialCalcActionPerformed
    calculateSpecialArray((int)sprSpecialMax.getValue());
    pnlScrollSpecialArray.revalidate();
  }//GEN-LAST:event_btnSpecialCalcActionPerformed

  private void btnSpecialCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSpecialCheckActionPerformed
    if (txtSpecialCheck.getText().isEmpty()) {
      return;
    }
    
    int num = Integer.parseInt(txtSpecialCheck.getText());

    boolean special;
    try {
      special = Ex14.isSpecial(num);
    } catch (Exception ex) {
      displayException(ex);
      return;
    }

    JOptionPane.showMessageDialog(this, special, "isSpecials",
      JOptionPane.PLAIN_MESSAGE);
  }//GEN-LAST:event_btnSpecialCheckActionPerformed

  private void btnSpecialTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSpecialTestActionPerformed
    tstIsSpecial();
  }//GEN-LAST:event_btnSpecialTestActionPerformed

  public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new GUI14Tester().setVisible(true);
      }
    });
  }

  // =============== Helpers =================
  private boolean isNum(String str) {
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      if (!(Character.isDigit(c) || c == '-')) {
        return false;
      }
    }
    return true;
  }

  private void updateSldSearchLength(int length) {
    int count = 0;
    while (length > 1) {
      length /= 2;
      count++;
    }
    sldSearchLength.setValue(count);
  }
  
  private int[][] arrayToCircleMatrix(int[] arr, int size) {
    int[][] mat = new int[size][size];
    if (size == 2) {
      arrayToCircleMatrix(arr, 0, mat, 0, 0, size);
      return mat;
    }
    int size2 = size / 2;
    int len4 = size * size / 4;
    arrayToCircleMatrix(arr, 0, mat, 0, 0, size2);
    arrayToCircleMatrix(arr, len4, mat, 0, size2, size2);
    arrayToCircleMatrix(arr, 2*len4, mat, size2, size2, size2);
    arrayToCircleMatrix(arr, 3*len4, mat, size2, 0, size2);
    return mat;
  }
  
  private void arrayToCircleMatrix(int[] arr, int i, int[][] mat, int r, int c,
      int size) {
    if (size == 2) {
      mat[r][c] = arr[i];
      mat[r][c + 1] = arr[i + 1];
      mat[r + 1][c + 1] = arr[i + 2];
      mat[r + 1][c] = arr[i + 3];
      return;
    }
    int size2 = size / 2;
    int len4 = size * size / 4;
    arrayToCircleMatrix(arr, i, mat, r, c, size2);
    arrayToCircleMatrix(arr, i + len4, mat, r, c + size2, size2);
    arrayToCircleMatrix(arr, i + 2*len4, mat, r + size2, c + size2, size2);
    arrayToCircleMatrix(arr, i + 3*len4, mat, r + size2, c, size2);
  }
  
  private void displayException(Exception ex) {
    StringWriter writer = new StringWriter();
    ex.printStackTrace(new PrintWriter(writer));

    JTextArea txt = new JTextArea();
    txt.setRows(20);
    float font = Math.max(txt.getFont().getSize2D(), 14f);
    txt.setFont(txt.getFont().deriveFont(font));
    txt.setText("The tester crashed:\n" + writer.toString());
    txt.setCaretPosition(0);
    txt.setEditable(false);

    JScrollPane pane = new JScrollPane(txt);

    JOptionPane.showMessageDialog(this, pane, ex.getClass().getName(),
      JOptionPane.ERROR_MESSAGE);
  }
  
  // ============== Tests ================
  private void tstMinDiff() {
    int len = txtMinDiffArray.length;
    int[] arr = new int[len];
    for (int i = 0; i < len; i++) {
      if (txtMinDiffArray[i].getText().isEmpty()) {
        return;
      }
      arr[i] = Integer.parseInt(txtMinDiffArray[i].getText());
    }
    
    StringBuilder builder = new StringBuilder();
    boolean success = true;
    
    for (int i = 0; i < len; i++) for (int j = i + 1; j < len; j++) {
      int x = arr[i], y = arr[j];
      if (x == y) continue;
      builder.append("Testing x = ").append(x).append(" y = ").append(y)
        .append(": ");
      int expected = minDiffExpected(arr, x, y);
      int actual;
      try {
        actual = Ex14.findMinDiff(arr, x, y);
      } catch (Exception ex) {
        displayException(ex);
        return;
      }
      if (actual == expected) builder.append("OK\n");
      else {
        builder.append("ERROR - expected: ").append(expected)
						.append(", actual: ").append(actual).append('\n');
					success = false;
      }
    }

		
		JTextArea txt = new JTextArea(builder.toString());
		txt.setRows(30);
		txt.setMargin(new Insets(0, 0, 0, 30));
		txt.setEditable(false);
		txt.setOpaque(false);

		JScrollPane pane = new JScrollPane(txt);
		pane.setBorder(null);

		int type = success ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE;
		String title = "findMinDiff() Test " + (success ? "Passed!" : "Failed!");
		JOptionPane.showMessageDialog(this, pane, title, type);
  }
  
  private int minDiffExpected(int[] arr, int x, int y) {
    int len = txtMinDiffArray.length;
    int minDiff = Integer.MAX_VALUE;
    for (int i = 0; i < len; i++) for (int j = 0; j < len; j++) {
      if (arr[i] == x && arr[j] == y){
        minDiff = Math.min(Math.abs(i - j), minDiff);
      }
    }
    return minDiff;
  }
  
  private void tstSearch() {
    int len = txtSearchArray.length;
    int[][] mat = new int[len][len];
    for (int r = 0; r < len; r++) for (int c = 0; c < len; c++) {
      if (txtSearchArray[r][c].getText().isEmpty()) {
        return;
      }
      mat[r][c] = Integer.parseInt(txtSearchArray[r][c].getText());
    }
    
    StringBuilder builder = new StringBuilder();
    boolean success = true;
    
    for (int val = mat[0][0] - 10; val < mat[len-1][0] + 10; val++) {
      builder.append("Testing ").append(val).append(": ");
      boolean expected = searchExpected(mat, val);
      boolean actual;
      try {
        actual = Ex14.search(mat, val);
      } catch (Exception ex) {
        displayException(ex);
        return;
      }
      if (actual == expected) builder.append("OK\n");
      else {
        builder.append("ERROR - expected: ").append(expected)
						.append(", actual: ").append(actual).append('\n');
					success = false;
      }
    }

		
		JTextArea txt = new JTextArea(builder.toString());
		txt.setRows(30);
		txt.setMargin(new Insets(0, 0, 0, 30));
		txt.setEditable(false);
		txt.setOpaque(false);

		JScrollPane pane = new JScrollPane(txt);
		pane.setBorder(null);

		int type = success ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE;
		String title = "search() Test " + (success ? "Passed!" : "Failed!");
		JOptionPane.showMessageDialog(this, pane, title, type);
  }
  
  private boolean searchExpected(int[][] mat, int value){
    for (int[] row : mat) for (int col : row) {
      if (value == col) return true;
    }
    return false;
  }
  
  private void tstEqualSplit() {
    int len = txtSplitArray.length;
    int[] arr = new int[len];
    for (int i = 0; i < len; i++) {
      if (txtSplitArray[i].getText().isEmpty()) {
        return;
      }
      arr[i] = Integer.parseInt(txtSplitArray[i].getText());
    }
    
    StringBuilder builder = new StringBuilder();
    boolean success = true;
    
    builder.append("Testing equalSplit").append(": ");
    boolean expected = equalSplitExpected(arr);
    boolean actual;
    try {
      actual = Ex14.equalSplit(arr);
    } catch (Exception ex) {
      displayException(ex);
      return;
    }
    if (actual == expected) {
      builder.append("OK\n");
    } else {
      builder.append("ERROR - expected: ").append(expected)
        .append(", actual: ").append(actual).append('\n');
      success = false;
    }

		
		JTextArea txt = new JTextArea(builder.toString());
		txt.setRows(30);
		txt.setMargin(new Insets(0, 0, 0, 30));
		txt.setEditable(false);
		txt.setOpaque(false);

		JScrollPane pane = new JScrollPane(txt);
		pane.setBorder(null);

		int type = success ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE;
		String title = "equalSplit() Test " + (success ? "Passed!" : "Failed!");
		JOptionPane.showMessageDialog(this, pane, title, type);
  }
  
  private void tstEqualSplitPresets() {
    StringBuilder builder = new StringBuilder();
    boolean success = true;
    
    int i = 1;
    for (int[] preset : equalSplitPresets) {
      builder.append("Testing Preset ").append(i).append(": ");
      i++;
      boolean expected = equalSplitExpected(preset);
      boolean actual;
      try {
        actual = Ex14.equalSplit(preset);
      } catch (Exception ex) {
        displayException(ex);
        return;
      }
      if (actual == expected) {
        builder.append("OK\n");
      } else {
        builder.append("ERROR - expected: ").append(expected)
          .append(", actual: ").append(actual).append('\n');
        success = false;
      }
    }

		
		JTextArea txt = new JTextArea(builder.toString());
		txt.setRows(30);
		txt.setMargin(new Insets(0, 0, 0, 30));
		txt.setEditable(false);
		txt.setOpaque(false);

		JScrollPane pane = new JScrollPane(txt);
		pane.setBorder(null);

		int type = success ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE;
		String title = "equalSplit() Test " + (success ? "Passed!" : "Failed!");
		JOptionPane.showMessageDialog(this, pane, title, type);
  }
  
  private boolean equalSplitExpected(int[] arr) {
    if (arr.length % 2 != 0) return false;
    
    int r = arr.length / 2;
    ArrayList<int[]> list = equalSplitExpected(arr, 0, new int[r], r);
    
    for (int[] set : list) {
      int si = 0, ai = 0;
      int sum1 = 0, sum2 = 0;
      for (int i = 0, s = 0; i < arr.length; i++){
        if (s < set.length && set[s] == arr[i]) sum1 += set[s++];
        else sum2 += arr[i];
      }
      if (sum1 == sum2) return true;
    }
    
    return false;
  }
  
  private ArrayList<int[]> equalSplitExpected(int[] arr, int start, int[] comb, int r) {
    if (r == 0) {
      ArrayList<int[]> list = new ArrayList<>();
      list.add(comb);
      return list;
    }
    
    ArrayList<int[]> list = new ArrayList<>();
    for (int i = start; i <= arr.length - r; i++){
      comb[comb.length - r] = arr[i];
      list.addAll(equalSplitExpected(arr, i + 1, comb.clone(), r - 1));
    }
    return list;
  }
  
  private void tstIsSpecial() {
    StringBuilder builder = new StringBuilder();
    boolean success = true;

    for (int num = -10; num <= specials[specials.length - 1]; num++) {
      builder.append("Testing ").append(num).append(": ");
      boolean expected = isSpecialExpected(num);
      boolean actual;

      try {
        actual = Ex14.isSpecial(num);
      } catch (Exception ex) {
        displayException(ex);
        return;
      }

      if (actual == expected) {
        builder.append("OK\n");
      } else {
        builder.append("ERROR - expected: ").append(expected)
          .append(", actual: ").append(actual).append('\n');
        success = false;
      }
    }

    JTextArea txt = new JTextArea(builder.toString());
    txt.setRows(30);
    txt.setMargin(new Insets(0, 0, 0, 30));
    txt.setEditable(false);
    txt.setOpaque(false);

    JScrollPane pane = new JScrollPane(txt);
    pane.setBorder(null);

    int type = success ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE;
    String title = "isSpecial() Test " + (success ? "Passed!" : "Failed!");
    JOptionPane.showMessageDialog(this, pane, title, type);
  }
  
  private boolean isSpecialExpected(int num) {
    for (int special : specials) {
      if (num == special) return true;
    }
    return false;
  }
  
// ============== Listeners =================
  private final DocumentFilter intFilter = new DocumentFilter() { //#region
    @Override
    public void insertString(DocumentFilter.FilterBypass fb, int offset, String string,
      AttributeSet attr) throws BadLocationException {
      if (!isNum(string)) {
        return;
      }

      super.insertString(fb, offset, string, attr);
    }

    @Override
    public void remove(DocumentFilter.FilterBypass fb, int offset, int length)
      throws BadLocationException {
      super.remove(fb, offset, length);
    }

    @Override
    public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text,
      AttributeSet attrs) throws BadLocationException {
      if (!isNum(text)) {
        return;
      }

      super.replace(fb, offset, length, text, attrs);
    }
  }; //#endregion

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnMinDiffFind;
  private javax.swing.JButton btnMinDiffRand;
  private javax.swing.JButton btnMinDiffTest;
  private javax.swing.JButton btnSeach;
  private javax.swing.JButton btnSearchRand;
  private javax.swing.JButton btnSearchTest;
  private javax.swing.JButton btnSpecialCalc;
  private javax.swing.JButton btnSpecialCheck;
  private javax.swing.JButton btnSpecialTest;
  private javax.swing.JButton btnSplit;
  private javax.swing.JButton btnSplitRand;
  private javax.swing.JButton btnSplitTest;
  private javax.swing.JButton btnSplitTestPresets;
  private javax.swing.JComboBox<String> cmbMinDiffChoose;
  private javax.swing.JComboBox<String> cmbSearchChoose;
  private javax.swing.JComboBox<String> cmbSplitChoose;
  private javax.swing.JLabel lblMinDiffLength;
  private javax.swing.JLabel lblSearch;
  private javax.swing.JLabel lblSpecialArray;
  private javax.swing.JLabel lblSpecialCheck;
  private javax.swing.JLabel lblSpecialMax;
  private javax.swing.JLabel lblSplitLength;
  private javax.swing.JLabel lblX;
  private javax.swing.JLabel lblY;
  private javax.swing.JPanel pnlMidDiffChoose;
  private javax.swing.JPanel pnlMinDiffArray;
  private javax.swing.JPanel pnlMinDiffInput;
  private javax.swing.JScrollPane pnlScrollSpecialArray;
  private javax.swing.JPanel pnlSearchArray;
  private javax.swing.JPanel pnlSearchChoose;
  private javax.swing.JPanel pnlSearchInput;
  private javax.swing.JPanel pnlSpecialChoose;
  private javax.swing.JPanel pnlSpecialInput;
  private javax.swing.JPanel pnlSplitArray;
  private javax.swing.JPanel pnlSplitChoose;
  private javax.swing.JPanel pnlSplitInput;
  private javax.swing.JSlider sldSearchLength;
  private javax.swing.JSpinner sprMinDiffLength;
  private javax.swing.JSpinner sprSpecialMax;
  private javax.swing.JSpinner sprSplitLength;
  private javax.swing.JPanel tabMinDiff;
  private javax.swing.JTabbedPane tabPane;
  private javax.swing.JPanel tabSearch;
  private javax.swing.JPanel tabSpecial;
  private javax.swing.JPanel tabSplit;
  private javax.swing.JTextField txtSearch;
  private javax.swing.JTextField txtSpecialCheck;
  private javax.swing.JTextField txtX;
  private javax.swing.JTextField txtY;
  // End of variables declaration//GEN-END:variables
}
