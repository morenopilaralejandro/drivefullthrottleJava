package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import classes.CategoryFactory;
import classes.CategoryInterface;
import classes.QuestionFactory;
import classes.QuestionInterface;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import java.awt.Insets;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import java.awt.Dimension;

public class ViewFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	//text strings
	private String str1="DriveFullThrottle";
	private String str2="Manage Questions";
	private String str3="ID";
	private String str4="Image file";
	private String str5="Question";
	private String str6="Correct";
	private String str7="Answer";
	private String str8="A";
	private String str9="B";
	private String str10="C";
	private String str11="Difficulty";
	private String str12="Category";
	private String str13="Save";
	private String str14="Clear";
	private String str15="Delete";
	private String str16="Exit";
	
	private String str17="Record inserted.";
	private String str18="Update record with ID ";
	private String str19="Record updated.";
	private String str20="Delete record with ID ";
	private String str21="Record deleted.";
	
	private String strTbl0="Id";
	private String strTbl1="Question";
	private String strTbl2="Diff";
	private String strTbl3="Cat";
	
	//class
	private QuestionInterface qObj = QuestionFactory.getQuestionObject();	
	private ArrayList<QuestionInterface> qArr;
	private String[] diffArr;
	private CategoryInterface catObj = CategoryFactory.getCategoryObject();
	private ArrayList<CategoryInterface> catArr;

	//gui
	private boolean editEnabled;
	private JPanel contentPane;
	private JTable tblQ;
	private JTextField tfId;
	private JTextField tfImg;
	private JTextArea taQuestion;
	ButtonGroup rdOption;
	private JTextArea taOption0;
	private JTextArea taOption1;
	private JTextArea taOption2;
	JComboBox<String> cbDiff;
	JComboBox<String> cbCat;
	private JLabel lblImgQ;

	
	/**
	 * Launch the application.
	 */
	public static void viewPanel(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewFrame frame = new ViewFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewFrame() {
		setResizable(false);
		setTitle(str1);
		ImageIcon favIcon = new ImageIcon(this.getClass().getResource("/link_img/favicon-32x32.png"));
		setIconImage(favIcon.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 529, 599);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		editEnabled=true;
		
		JPanel homePanel = new JPanel();
		contentPane.add(homePanel, "name_2396510668496");
		homePanel.setLayout(null);
		
		JLabel lblTitle = new JLabel(str1);
		lblTitle.setBounds(12, 30, 485, 95);
		homePanel.add(lblTitle);
		lblTitle.setFont(new Font("Dialog", Font.BOLD, 28));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel auxPanel1 = new JPanel();
		auxPanel1.setBounds(12, 152, 485, 35);
		homePanel.add(auxPanel1);
		
		JPanel qPanel = new JPanel();
		contentPane.add(qPanel, "name_2396524908465");
		
		//btn manage question Home -> Question
		JButton btnManQuestion = new JButton(str2);
		auxPanel1.add(btnManQuestion);
		btnManQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				homePanel.setVisible(false);
				qPanel.setVisible(true);
				setTitle(str1+" - "+str2);
				clearManageQuestion();
				refreshQ();
			}
		});
		qPanel.setLayout(null);
		
		tblQ = new JTable();
		
		JScrollPane scTblPane = new JScrollPane(tblQ);
		scTblPane.setBounds(12, 5, 485, 87);
	
		qPanel.add(scTblPane);
		
		JLabel lblId = new JLabel(str3);
		lblId.setBounds(12, 104, 36, 15);
		qPanel.add(lblId);
		
		tfId = new JTextField();
		lblId.setLabelFor(tfId);
		tfId.setBounds(30, 102, 36, 19);
		qPanel.add(tfId);
		tfId.setColumns(10);
		
		JLabel lblImg = new JLabel(str4);
		lblImg.setBounds(84, 104, 70, 15);
		qPanel.add(lblImg);
		
		tfImg = new JTextField();
		lblImg.setLabelFor(tfImg);
		tfImg.setBounds(161, 102, 140, 19);
		qPanel.add(tfImg);
		tfImg.setColumns(10);
		
		JLabel lblQuestion = new JLabel(str5);
		lblQuestion.setBounds(12, 131, 70, 15);
		qPanel.add(lblQuestion);
		
		JScrollPane scTaQuestionPane = new JScrollPane();
		scTaQuestionPane.setBounds(12, 148, 485, 56);
		qPanel.add(scTaQuestionPane);
		
		taQuestion = new JTextArea();
		scTaQuestionPane.setViewportView(taQuestion);
		taQuestion.setWrapStyleWord(true);
		taQuestion.setMargin(new Insets(2, 2, 2, 2));
		taQuestion.setLineWrap(true);
		lblQuestion.setLabelFor(taQuestion);
		taQuestion.setColumns(10);
		
		JLabel lblCorrect = new JLabel(str6);
		lblCorrect.setBounds(12, 216, 54, 15);
		qPanel.add(lblCorrect);
		
		JLabel lblAnswers = new JLabel(str7);
		lblAnswers.setBounds(84, 216, 59, 15);
		qPanel.add(lblAnswers);
		
		JRadioButton rdOption0 = new JRadioButton(str8);
		rdOption0.setBounds(12, 238, 36, 23);
		qPanel.add(rdOption0);
		
		JRadioButton rdOption1 = new JRadioButton(str9);
		rdOption1.setBounds(12, 293, 36, 23);
		qPanel.add(rdOption1);
		
		JRadioButton rdOption2 = new JRadioButton(str10);
		rdOption2.setBounds(12, 348, 36, 23);
		qPanel.add(rdOption2);
		
		rdOption= new ButtonGroup();
		rdOption.add(rdOption0);
		rdOption.add(rdOption1);
		rdOption.add(rdOption2);
		
		JScrollPane scTaOption0Pane = new JScrollPane();
		scTaOption0Pane.setBounds(84, 238, 413, 43);
		qPanel.add(scTaOption0Pane);
		
		taOption0 = new JTextArea();
		taOption0.setLineWrap(true);
		taOption0.setWrapStyleWord(true);
		scTaOption0Pane.setViewportView(taOption0);
		taOption0.setMargin(new Insets(2, 2, 2, 2));
		taOption0.setColumns(10);
		
		JScrollPane scTaOption1Pane = new JScrollPane();
		scTaOption1Pane.setBounds(84, 293, 413, 43);
		qPanel.add(scTaOption1Pane);
		
		taOption1 = new JTextArea();
		taOption1.setWrapStyleWord(true);
		taOption1.setLineWrap(true);
		scTaOption1Pane.setViewportView(taOption1);
		taOption1.setMargin(new Insets(2, 2, 2, 2));
		taOption1.setColumns(10);
		
		JScrollPane scTaOption2Pane = new JScrollPane();
		scTaOption2Pane.setBounds(84, 348, 413, 43);
		qPanel.add(scTaOption2Pane);
		
		taOption2 = new JTextArea();
		taOption2.setWrapStyleWord(true);
		taOption2.setLineWrap(true);
		scTaOption2Pane.setViewportView(taOption2);
		taOption2.setMargin(new Insets(2, 2, 2, 2));
		taOption2.setColumns(10);
		
		JLabel lblDiff = new JLabel(str11);
		lblDiff.setBounds(12, 408, 70, 15);
		qPanel.add(lblDiff);
		
		diffArr= new String[3];
		diffArr[0]="1";
		diffArr[1]="2";
		diffArr[2]="3";
		cbDiff = new JComboBox<String>(diffArr);
		cbDiff.setBounds(84, 403, 59, 24);
		qPanel.add(cbDiff);
		
		JLabel lblCat = new JLabel(str12);
		lblCat.setBounds(161, 408, 70, 15);
		qPanel.add(lblCat);
		
		catArr = (ArrayList<CategoryInterface>) catObj.getAllCategories();
		String[] catArrAux = new String[catArr.size()];
		for (int i=0; i<catArr.size(); i++) {
			catArrAux[i]=catArr.get(i).getIdCat()+
					" - "+catArr.get(i).getName();
		}
		cbCat = new JComboBox<String>(catArrAux);
		cbCat.setBounds(243, 403, 254, 24);
		qPanel.add(cbCat);
		
		JPanel auxPanel2 = new JPanel();
		auxPanel2.setBounds(285, 486, 212, 64);
		qPanel.add(auxPanel2);
		auxPanel2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnSaveQ = new JButton(str13);
		btnSaveQ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idAux=0;
				if(!tfId.getText().isEmpty()) {
					idAux=Integer.parseInt(tfId.getText());
				}
				if(editEnabled) {
					qObj.insert(idAux, tfImg.getText(), taQuestion.getText(), 
							taOption0.getText(), taOption1.getText(), taOption2.getText(), 
							getSelectedRadio(), cbDiff.getSelectedIndex()+1, cbCat.getSelectedIndex()+1);
					JOptionPane.showMessageDialog(null, str17, str1, JOptionPane.INFORMATION_MESSAGE);
					clearManageQuestion();
					refreshQ();
				}else {
					 int conf = JOptionPane.showConfirmDialog(null, str18+idAux+"?", str1, 
							 JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
					 if(conf==0) {
						 int selectedRow = tblQ.getSelectedRow();
						 if (selectedRow>=0) {
							 int clickedId = (int) tblQ.getValueAt(selectedRow, 0);
							 qObj = findElementById(clickedId);
							 qObj.setImg(tfImg.getText());
							 qObj.setStmnt(taQuestion.getText());
							 String[] auxArr = new String[3];
							 auxArr[0]=taOption0.getText();
							 auxArr[1]=taOption1.getText();
							 auxArr[2]=taOption2.getText();
							 qObj.setoArr(auxArr);
							 qObj.setCorrectAnswer(getSelectedRadio());
							 qObj.setDifficulty(cbDiff.getSelectedIndex()+1);
							 qObj.setCategory(cbCat.getSelectedIndex()+1);
							 JOptionPane.showMessageDialog(null, str19, str1, JOptionPane.INFORMATION_MESSAGE);
						 }
						 refreshQ();
					 }
				}
			}
		});
		btnSaveQ.setPreferredSize(new Dimension(90, 25));
		auxPanel2.add(btnSaveQ);
		
		JButton btnClearQ = new JButton(str14);
		btnClearQ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearManageQuestion();
			}
		});
		btnClearQ.setPreferredSize(new Dimension(90, 25));
		auxPanel2.add(btnClearQ);
		
		JButton btnDeleteQ = new JButton(str15);
		btnDeleteQ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int selectedRow = tblQ.getSelectedRow();
				 if (selectedRow>=0) {
					 int clickedId = (int) tblQ.getValueAt(selectedRow, 0);
					 qObj = findElementById(clickedId);
					 int conf = JOptionPane.showConfirmDialog(null, str20+qObj.getIdQ()+"?", str1, 
							 JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE); 
					 if(conf==0) {
						 qObj.delete();
						 JOptionPane.showMessageDialog(null, str21, str1, JOptionPane.INFORMATION_MESSAGE);
					 }
				 }
				 clearManageQuestion();
				 refreshQ();
			}
		});
		btnDeleteQ.setPreferredSize(new Dimension(90, 25));
		auxPanel2.add(btnDeleteQ);
		
		JButton btnExitQ = new JButton(str16);
		//btn manage question Question -> Home
		btnExitQ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				qPanel.setVisible(false);
				homePanel.setVisible(true);
				setTitle(str1);
			}
		});
		btnExitQ.setPreferredSize(new Dimension(90, 25));
		auxPanel2.add(btnExitQ);
		
		lblImgQ = new JLabel("");
		lblImgQ.setBounds(12, 435, 160, 115);
		lblImgQ.setVisible(false);
		qPanel.add(lblImgQ);
		
		//table on click
		tblQ.getSelectionModel().addListSelectionListener((ListSelectionListener) new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	        	int selectedRow = tblQ.getSelectedRow();
	        	if (selectedRow>=0) {
					int clickedId = (int) tblQ.getValueAt(selectedRow, 0);
					qObj = findElementById(clickedId);
					//fields
		        	editEnabled=false;
					tfId.setText("" + qObj.getIdQ());
					tfId.setEditable(false);
					tfImg.setText(qObj.getImg());
					taQuestion.setText(qObj.getStmnt());
					taOption0.setText(qObj.getoArr()[0]);
					taOption1.setText(qObj.getoArr()[1]);
					taOption2.setText(qObj.getoArr()[2]);
					//img
					try {
						lblImgQ.setVisible(false);
						String imgRoute = qObj.getImg();
						if (imgRoute != null) {
							ImageIcon imagIcon = new ImageIcon(ViewFrame.class.getResource("/link_img/" + imgRoute));
							Image img = imagIcon.getImage().getScaledInstance(160, 115, java.awt.Image.SCALE_SMOOTH);
							;
							imagIcon = new ImageIcon(img);

							lblImgQ.setIcon(imagIcon);
							lblImgQ.setVisible(true);
						}
					} catch (Exception e) {
						lblImgQ.setVisible(false);
					}
					//check radio
					rdOption.clearSelection();
					switch (qObj.getCorrectAnswer()) {
					case 0:
						rdOption0.setSelected(true);
						break;
					case 1:
						rdOption1.setSelected(true);
						break;
					case 2:
						rdOption2.setSelected(true);
						break;
					default:
						rdOption0.setSelected(true);
					}
					cbDiff.setSelectedIndex(qObj.getDifficulty() - 1);
					cbCat.setSelectedIndex(qObj.getCategory() - 1);
				}
	        }
	    });
	}
	
	//find the object in the arraylist
	private QuestionInterface findElementById(int id) {
		QuestionInterface res=null;
		for(QuestionInterface i:qArr) {
			if(i.getIdQ()==id) {
				res=i;
			}
		}
		return res;
	}
	
	//refresh question arraylist and jtable
	public void refreshQ() {
		int colNum=4;
	    qArr = (ArrayList<QuestionInterface>) qObj.getAllQuestion();
	    
	    //column names
	    Object[] colNames = new Object[colNum];
	    colNames[0]=strTbl0;
	    colNames[1]=strTbl1;
	    colNames[2]=strTbl2;
	    colNames[3]=strTbl3;
	    DefaultTableModel model = new DefaultTableModel(colNames, 0);
	    
	    //get data from the arraylist
	    for (int i = 0; i < qArr.size(); i++) {
	        Object[] rowData = new Object[colNum];
	        rowData[0] = qArr.get(i).getIdQ();
	        rowData[1] = qArr.get(i).getStmnt();
	        rowData[2] = qArr.get(i).getDifficulty();
	        rowData[3] = qArr.get(i).getCategory();
	        model.addRow(rowData);
	    }
	    tblQ.setModel(model);
	    
	    //change column width
	    TableColumn col = null;
	    for (int i = 0; i < colNum; i++) {
	    	col = tblQ.getColumnModel().getColumn(i);
	        if (i == 1) {
	        	col.setPreferredWidth(360);
	        } else {
	        	col.setPreferredWidth(20);
	        }
	    }   
	}
	
	public void clearManageQuestion() {
		tblQ.clearSelection();
		editEnabled=true;
		tfId.setEditable(true);
		tfId.setText("");
		tfImg.setText("");
		taQuestion.setText("");
		rdOption.clearSelection();
		taOption0.setText("");
		taOption1.setText("");
		taOption2.setText("");
		cbDiff.setSelectedIndex(0);
		cbCat.setSelectedIndex(0);
		lblImgQ.setVisible(false);
	}
	
	public int getSelectedRadio() {
		int res = 0;
		int counter=0;
		Enumeration<AbstractButton> auxEnum = rdOption.getElements();
        while(auxEnum.hasMoreElements()) {
            AbstractButton i = auxEnum.nextElement();
            if (i.isSelected()) {
                res=counter;
            }
            counter++;
        }
		return res;
	}
}
