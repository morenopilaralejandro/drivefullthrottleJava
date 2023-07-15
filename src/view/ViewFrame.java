package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import classes.QuestionFactory;
import classes.QuestionInterface;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.ButtonGroup;
import java.awt.Insets;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class ViewFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	//text strings
	private String str0="DriveFullThrottle";
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
	
	private String strTbl0="Id";
	private String strTbl1="Question";
	private String strTbl2="Diff";
	private String strTbl3="Cat";
	
	//class
	private QuestionInterface qObj = QuestionFactory.getQuestionObject();	
	private ArrayList<QuestionInterface> qArr;
	
	//gui
	private JPanel contentPane;
	private JTable tblQ;
	private JTextField tfId;
	private JTextField tfImg;
	private JTextArea taQuestion;
	private JTextArea taOption0;
	private JTextArea tfOption1;
	private JTextArea taOption2;

	
	
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
		setTitle(str0);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 529, 599);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
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
		tfId.setBounds(30, 104, 36, 19);
		qPanel.add(tfId);
		tfId.setColumns(10);
		
		JLabel lblImg = new JLabel(str4);
		lblImg.setBounds(84, 104, 70, 15);
		qPanel.add(lblImg);
		
		tfImg = new JTextField();
		lblImg.setLabelFor(tfImg);
		tfImg.setBounds(158, 104, 140, 19);
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
		
		ButtonGroup rdOption= new ButtonGroup();
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
		
		tfOption1 = new JTextArea();
		tfOption1.setWrapStyleWord(true);
		tfOption1.setLineWrap(true);
		scTaOption1Pane.setViewportView(tfOption1);
		tfOption1.setMargin(new Insets(2, 2, 2, 2));
		tfOption1.setColumns(10);
		
		JScrollPane scTaOption2Pane = new JScrollPane();
		scTaOption2Pane.setBounds(84, 348, 413, 43);
		qPanel.add(scTaOption2Pane);
		
		taOption2 = new JTextArea();
		taOption2.setWrapStyleWord(true);
		taOption2.setLineWrap(true);
		scTaOption2Pane.setViewportView(taOption2);
		taOption2.setMargin(new Insets(2, 2, 2, 2));
		taOption2.setColumns(10);
		
		//table on click
		tblQ.getSelectionModel().addListSelectionListener((ListSelectionListener) new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	        	int clickedId = (int) tblQ.getValueAt(tblQ.getSelectedRow(), 0);
	        	qObj = findElementById(clickedId);
	            
	        	tfId.setText(""+qObj.getIdQ());
	        	tfId.setEditable(false);
	        	tfImg.setText(qObj.getImg());
	        	taQuestion.setText(qObj.getStmnt());
	        	taOption0.setText(qObj.getoArr()[0]);
	        	tfOption1.setText(qObj.getoArr()[1]);
	        	taOption2.setText(qObj.getoArr()[2]);
	        	
	        	rdOption.clearSelection();
	        	switch(qObj.getCorrectAnswer()) {
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
}
