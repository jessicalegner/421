package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.border.TitledBorder;
import javax.swing.JTextPane;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.ScrollPaneConstants;

import utils.ReadObjects;
import utils.WriteObjects;

import domain.FacultyList;
import domain.FacultyMember;

import FIMS.AddRecordHandler;
import FIMS.DeleteRecordHandler;
import FIMS.EditRecordHandler;
import FIMS.SearchRecordHandler;
import FIMS.ViewAllRecordsHandler;
import FIMS.ViewOneRecordHandler;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Class to handle all gui realted items
 * 
 */
public class GUI extends JFrame
{
	static AddRecordHandler arh = new AddRecordHandler();
	static EditRecordHandler erh = new EditRecordHandler();
	static DeleteRecordHandler drh = new DeleteRecordHandler();
	static SearchRecordHandler srh = new SearchRecordHandler();
	static ViewAllRecordsHandler varh = new ViewAllRecordsHandler();
	static ViewOneRecordHandler vorh = new ViewOneRecordHandler();

	static FacultyList fl = new FacultyList();
	// static ReadObjects ro = new ReadObjects();

	private JPanel contentPane;

	private static CardLayout cl;
	static int selectedPerson = 0;

	JPanel panel_menu;
	public final JPanel panel_content;

	JButton button;
	JButton btnMenuSearch;
	JButton btnGenerateReport;
	JButton btnAddRecord;
	static JButton btnViewAll;
	static JButton btnBackToList;
	JButton btnEditRecord;
	static JButton btnView;
	JButton btnEdit;
	static JButton btnDelete;
	static JButton btnSearch;
	JButton btnGenerate;
	static JButton btnAdd;
	JButton btnSubmit_edit;

	public JRadioButton rdbtnMale;
	public JRadioButton rdbtnFemale;
	public JRadioButton rdbtnMale_edit;
	public JRadioButton rdbtnFemale_edit;

	public final JComboBox<String> comboBox_dept;
	public final JComboBox<String> comboBox_college;
	public final JComboBox<String> comboBox_dept_edit;
	public final JComboBox<String> comboBox_college_edit;
	public JComboBox<String> comboBox_rank;
	public JComboBox<String> comboBox_currentRank;
	public JComboBox<String> comboBox_degree;
	public JComboBox<String> comboBox_month;
	public JComboBox<String> comboBox_rank_edit;
	public JComboBox<String> comboBox_degree_edit;
	public JComboBox<String> comboBox_month_edit;
	public final JComboBox<String> comboBox_search_college;
	public final JComboBox<String> comboBox_search_dept;
	public JComboBox<String> comboBox_search_rank;
	public JComboBox<String> comboBox_search_eval;
	public JComboBox<String> comboBox_search_promo;
	public JComboBox<String> comboBox_search_sab;

	public JTextField textField_name;
	public JTextField textField_year;
	public JTextField textField_search_name;
	public JTextField txtInstitution;
	public JTextField textField;
	public JTextField textField_name_edit;
	public JTextField textField_year_edit;
	public JTextField txtInstitution_edit;
	public JTextField textField_expCred_edit;

	public JTextArea textArea_comments;
	public JTextArea textArea_comments_edit;

	public final JList list;

	public JTextField textField_tenureGranted;

	/*
	 * These are the view one tab items that need to be public for the handlers
	 */
	public JLabel tab_gen_name;
	public JLabel tab_gen_college = new JLabel();
	public JLabel tab_gen_department = new JLabel();
	public JLabel tab_gen_RAH = new JLabel();
	public JLabel tab_gen_degree = new JLabel();
	public JLabel tab_gen_comments = new JLabel();
	public JLabel tab_gen_gender = new JLabel();
	public JLabel tab_gen_institution = new JLabel();
	public JLabel tab_eval_name = new JLabel();
	public JLabel tab_eval_1yr = new JLabel();
	public JLabel tab_eval_2yr = new JLabel();
	public JLabel tab_eval_4yr = new JLabel();
	public JLabel tab_eval_5yr = new JLabel();
	public JLabel tab_eval_tenure_granted = new JLabel();
	public JLabel tab_eval_doh = new JLabel();
	public JLabel tab_promo_doh = new JLabel();
	public JLabel tab_promo_name = new JLabel();
	public JLabel tab_promo_rank = new JLabel();
	public JLabel tab_promo_toasst = new JLabel();
	public JLabel tab_promo_toassoc = new JLabel();
	public JLabel tab_promo_toprof = new JLabel();
	public JLabel label_2 = new JLabel();
	public JLabel tab_sab_eligible;
	public JLabel tab_sab_name = new JLabel();
	public JLabel tab_sab_doh = new JLabel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					final GUI frame = new GUI();
					frame.setVisible(true);

					addRecord_Listener(frame);
					deleteRecord_Listener(frame);
					searchForRecord_Listener(frame);
					viewAllRecords_Listener(frame);
					viewOneRecord_Listener(frame);
					back_Listener(frame);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI()
	{
		addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent arg0)
			{
				WriteObjects.writeDataToExcelFile(fl);
			}
		});

		try
		{
			fl = ReadObjects.readObjects();
		}
		catch (Exception e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		setTitle("Faculty Information Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1053, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel_menu = new JPanel();
		panel_menu.setBounds(10, 11, 138, 409);
		contentPane.add(panel_menu);
		panel_menu.setLayout(null);

		button = new JButton("Home");
		button.setFont(new Font("Arial", Font.PLAIN, 11));
		button.setIcon(new ImageIcon(
				"C:\\Users\\Owner\\Desktop\\mimiGlyphs\\mimiGlyphs\\png\\6.png"));
		button.setBounds(10, 5, 120, 25);
		panel_menu.add(button);

		btnMenuSearch = new JButton("Search");
		btnMenuSearch.setBounds(10, 123, 120, 25);
		btnMenuSearch.setIcon(new ImageIcon(
				"C:\\Users\\Owner\\Desktop\\mimiGlyphs\\mimiGlyphs\\png\\7.png"));
		panel_menu.add(btnMenuSearch);

		btnGenerateReport = new JButton("Generate Report");
		btnGenerateReport.setFont(new Font("Arial", Font.PLAIN, 11));
		btnGenerateReport.setBounds(10, 65, 120, 25);
		panel_menu.add(btnGenerateReport);

		JLabel label = new JLabel("");
		label.setBounds(128, 99, 0, 0);
		panel_menu.add(label);

		btnAddRecord = new JButton("Add Record");
		btnAddRecord.setBounds(10, 35, 120, 25);
		btnAddRecord.setFont(new Font("Arial", Font.PLAIN, 11));
		panel_menu.add(btnAddRecord);
		btnAddRecord.setFont(new Font("Arial", Font.PLAIN, 11));

		btnViewAll = new JButton("View All Records");
		btnViewAll.setFont(new Font("Arial", Font.PLAIN, 11));
		btnViewAll.setBounds(10, 95, 120, 25);
		panel_menu.add(btnViewAll);

		// CREATE "CARDS"
		// -- HOME
		final JPanel content_home = new JPanel();
		JLabel lblWelcomToThe = new JLabel(
				"Welcom to the SVSU Faculty Information Management System");
		lblWelcomToThe.setBounds(239, 11, 620, 29);
		content_home.add(lblWelcomToThe);

		JLabel lblUseTheNavigation = new JLabel(
				"Use the navigation to the left to add new records, " +
				"generate reports, view records and search for a record.");
		lblUseTheNavigation.setVerticalAlignment(SwingConstants.TOP);
		lblUseTheNavigation.setBounds(239, 60, 620, 46);
		content_home.add(lblUseTheNavigation);

		// -- ADD
		final JPanel content_add = new JPanel();
		btnAdd = new JButton("Add");
		btnAdd.setBounds(770, 375, 89, 23);
		content_add.add(btnAdd);
		content_add.setLayout(null);
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(10, 15, 73, 14);
		content_add.add(lblName);

		JLabel lblCollege = new JLabel("College");
		lblCollege.setBounds(10, 65, 73, 14);
		content_add.add(lblCollege);

		textField_name = new JTextField();
		textField_name.setBounds(100, 12, 170, 20);
		content_add.add(textField_name);
		textField_name.setColumns(10);

		comboBox_college = new JComboBox<String>();
		comboBox_college.setBounds(100, 63, 208, 20);
		content_add.add(comboBox_college);
		comboBox_college.setModel(new DefaultComboBoxModel<String>(new String[] {
				"Select College", "ABS", "BUS", "EDUC", "HHS", "SET" }));

		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setBounds(359, 68, 73, 14);
		content_add.add(lblDepartment);

		comboBox_dept = new JComboBox<String>();
		comboBox_dept.setBounds(449, 65, 208, 20);
		content_add.add(comboBox_dept);
		comboBox_dept.setEnabled(false);

		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(359, 15, 46, 14);
		content_add.add(lblGender);

		rdbtnMale = new JRadioButton("M");
		rdbtnMale.setBounds(411, 11, 38, 23);
		content_add.add(rdbtnMale);

		rdbtnFemale = new JRadioButton("F");
		rdbtnFemale.setBounds(451, 11, 33, 23);
		content_add.add(rdbtnFemale);

		JLabel lblRankAtHire = new JLabel("Rank at Hire");
		lblRankAtHire.setBounds(10, 118, 73, 14);
		content_add.add(lblRankAtHire);

		comboBox_rank = new JComboBox<String>();
		comboBox_rank.setBounds(100, 115, 208, 20);
		content_add.add(comboBox_rank);
		comboBox_rank.setModel(new DefaultComboBoxModel<String>(new String[] {
				"Select", "Lecturer", "Instructor", "Assistant Professor",
				"Associate Professor", "Professor" }));

		JLabel lblAppointment = new JLabel("Appointment");
		lblAppointment.setBounds(11, 168, 73, 14);
		content_add.add(lblAppointment);

		comboBox_month = new JComboBox<String>();
		comboBox_month.setBounds(101, 165, 73, 20);
		content_add.add(comboBox_month);
		comboBox_month.setModel(new DefaultComboBoxModel<String>(new String[] {
				"January", "February", "March", "April", "May", "June", "July",
				"August", "September", "October", "November", "December" }));

		textField_year = new JTextField();
		textField_year.setText("2013");
		textField_year.setBounds(184, 166, 86, 20);
		content_add.add(textField_year);
		textField_year.setColumns(10);

		JLabel lblDegree = new JLabel("Degree");
		lblDegree.setBounds(10, 218, 73, 14);
		content_add.add(lblDegree);

		comboBox_degree = new JComboBox<String>();
		comboBox_degree.setBounds(100, 215, 79, 20);
		content_add.add(comboBox_degree);
		comboBox_degree.setModel(new DefaultComboBoxModel<String>(new String[] {
				"Select", "MA", "MFA", "MS", "MSW", "ABD", "EdD", "PhD" }));

		txtInstitution = new JTextField();
		txtInstitution.setText("Institution");
		txtInstitution.setBounds(189, 215, 155, 20);
		content_add.add(txtInstitution);
		txtInstitution.setColumns(10);

		JLabel lblComments = new JLabel("Comments");
		lblComments.setBounds(10, 320, 73, 14);
		content_add.add(lblComments);

		textArea_comments = new JTextArea();
		textArea_comments.setBounds(100, 315, 244, 55);
		textArea_comments.setAlignmentX(TOP_ALIGNMENT);
		textArea_comments.setAlignmentY(TOP_ALIGNMENT);
		content_add.add(textArea_comments);

		JLabel lblExperienceCredits = new JLabel("Experience");
		lblExperienceCredits.setBounds(10, 267, 73, 14);
		content_add.add(lblExperienceCredits);

		textField = new JTextField();
		textField.setBounds(100, 265, 86, 20);
		content_add.add(textField);
		textField.setToolTipText("Enter number of years experience");
		textField.setColumns(10);

		// -- VIEW ONE
		final JPanel content_view_one = new JPanel();
		content_view_one.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 869, 409);
		content_view_one.add(tabbedPane);

		// -- -- GENERAL TAB
		final JPanel tab_general = new JPanel();
		tabbedPane.addTab("General", null, tab_general, null);
		tab_general.setLayout(null);

		JLabel lblName_1 = new JLabel("Name");
		lblName_1.setBounds(10, 15, 78, 14);
		tab_general.add(lblName_1);

		JLabel lblCollege_1 = new JLabel("College");
		lblCollege_1.setBounds(10, 75, 78, 14);
		tab_general.add(lblCollege_1);

		JLabel lblNewLabel = new JLabel("Department");
		lblNewLabel.setBounds(10, 105, 78, 14);
		tab_general.add(lblNewLabel);

		JLabel lblRAH = new JLabel("Rank at Hire");
		lblRAH.setBounds(10, 135, 78, 14);
		tab_general.add(lblRAH);

		JLabel lblEducation_1 = new JLabel("Education");
		lblEducation_1.setBounds(10, 165, 78, 14);
		tab_general.add(lblEducation_1);

		JLabel lblComments_1 = new JLabel("Comments");
		lblComments_1.setBounds(10, 195, 78, 14);
		tab_general.add(lblComments_1);

		JLabel lblGender_1 = new JLabel("Gender:");
		lblGender_1.setBounds(10, 45, 46, 14);
		tab_general.add(lblGender_1);

		btnBackToList = new JButton("Back to list");
		btnBackToList.setBounds(10, 347, 111, 23);
		tab_general.add(btnBackToList);

		btnEditRecord = new JButton("Edit");
		btnEditRecord.setBounds(765, 347, 89, 23);
		tab_general.add(btnEditRecord);

		// populate general tab
		tab_gen_name = new JLabel();
		tab_gen_name.setBounds(103, 15, 143, 14);
		tab_general.add(tab_gen_name);

		tab_gen_college = new JLabel();
		tab_gen_college.setBounds(103, 75, 143, 14);
		tab_general.add(tab_gen_college);

		tab_gen_department = new JLabel();
		tab_gen_department.setBounds(103, 105, 143, 14);
		tab_general.add(tab_gen_department);

		tab_gen_RAH = new JLabel();
		tab_gen_RAH.setBounds(103, 135, 143, 14);
		tab_general.add(tab_gen_RAH);

		tab_gen_degree = new JLabel();
		tab_gen_degree.setBounds(103, 165, 71, 14);
		tab_general.add(tab_gen_degree);

		tab_gen_comments = new JLabel();
		tab_gen_comments.setVerticalAlignment(SwingConstants.TOP);
		tab_gen_comments.setBounds(103, 195, 290, 67);
		tab_general.add(tab_gen_comments);

		tab_gen_gender = new JLabel();
		tab_gen_gender.setBounds(103, 45, 80, 14);
		tab_general.add(tab_gen_gender);

		tab_gen_institution = new JLabel();
		tab_gen_institution.setBounds(211, 165, 290, 14);
		tab_general.add(tab_gen_institution);

		// -- -- EVALUATION TAB
		final JPanel tab_eval = new JPanel();
		tabbedPane.addTab("Evaluation", null, tab_eval, null);
		tab_eval.setLayout(null);

		JLabel lblName_2 = new JLabel("Name");
		lblName_2.setSize(46, 14);
		lblName_2.setLocation(10, 11);
		tab_eval.add(lblName_2);

		JLabel lblDateOfHire3 = new JLabel("Date of hire");
		lblDateOfHire3.setSize(73, 14);
		lblDateOfHire3.setLocation(10, 35);
		tab_eval.add(lblDateOfHire3);

		JLabel lblstYearEvaluation = new JLabel("1st Year Evaluation");
		lblstYearEvaluation.setBounds(86, 60, 113, 14);
		tab_eval.add(lblstYearEvaluation);

		JLabel lblndYearEvaluation = new JLabel("2nd Year Evaluation");
		lblndYearEvaluation.setBounds(86, 90, 113, 14);
		tab_eval.add(lblndYearEvaluation);

		JLabel lblPretenureReview = new JLabel("Pre-Tenure Review");
		lblPretenureReview.setBounds(86, 120, 113, 14);
		tab_eval.add(lblPretenureReview);

		JLabel lblTenureReview = new JLabel("Tenure Review");
		lblTenureReview.setBounds(86, 150, 113, 14);
		tab_eval.add(lblTenureReview);

		JLabel lblTenureGranted = new JLabel("Tenure Granted");
		lblTenureGranted.setBounds(86, 180, 113, 14);
		tab_eval.add(lblTenureGranted);

		// populate eval tab
		tab_eval_name = new JLabel();
		tab_eval_name.setBounds(300, 11, 123, 14);
		tab_eval.add(tab_eval_name);

		tab_eval_1yr = new JLabel();
		tab_eval_1yr.setBounds(300, 60, 132, 14);
		tab_eval.add(tab_eval_1yr);

		tab_eval_2yr = new JLabel();
		tab_eval_2yr.setBounds(300, 90, 132, 14);
		tab_eval.add(tab_eval_2yr);

		tab_eval_4yr = new JLabel();
		tab_eval_4yr.setBounds(300, 120, 132, 14);
		tab_eval.add(tab_eval_4yr);

		tab_eval_5yr = new JLabel();
		tab_eval_5yr.setBounds(300, 150, 132, 14);
		tab_eval.add(tab_eval_5yr);

		tab_eval_tenure_granted = new JLabel();
		tab_eval_tenure_granted.setBounds(300, 180, 132, 14);
		tab_eval.add(tab_eval_tenure_granted);

		tab_eval_doh = new JLabel();
		tab_eval_doh.setBounds(300, 35, 123, 14);
		tab_eval.add(tab_eval_doh);

		// -- -- PROMOTION TAB
		final JPanel tab_promo = new JPanel();
		tabbedPane.addTab("Promotion", null, tab_promo, null);
		tab_promo.setLayout(null);

		JLabel lblName_3 = new JLabel("Name");
		lblName_3.setSize(46, 14);
		lblName_3.setLocation(10, 11);
		tab_promo.add(lblName_3);

		JLabel lblDateOfHire2 = new JLabel("Date of hire");
		lblDateOfHire2.setSize(73, 14);
		lblDateOfHire2.setLocation(10, 35);
		tab_promo.add(lblDateOfHire2);

		JLabel lblNewLabel_1 = new JLabel("Current Rank");
		lblNewLabel_1.setBounds(10, 59, 98, 14);
		tab_promo.add(lblNewLabel_1);

		JLabel lblToAsst = new JLabel("To Asst");
		lblToAsst.setBounds(86, 100, 63, 14);
		tab_promo.add(lblToAsst);

		JLabel lblToAssoc = new JLabel("To Assoc");
		lblToAssoc.setBounds(86, 136, 63, 14);
		tab_promo.add(lblToAssoc);

		JLabel lblToProf = new JLabel("To Prof");
		lblToProf.setBounds(86, 171, 63, 14);
		tab_promo.add(lblToProf);

		JCheckBox chckbxNoFurtherReview = new JCheckBox("No Further Review");
		chckbxNoFurtherReview.setBounds(86, 196, 209, 23);
		tab_promo.add(chckbxNoFurtherReview);

		// population of promo tab
		tab_promo_doh = new JLabel();
		tab_promo_doh.setBounds(300, 34, 100, 14);
		tab_promo.add(tab_promo_doh);

		tab_promo_name = new JLabel();
		tab_promo_name.setBounds(300, 11, 100, 14);
		tab_promo.add(tab_promo_name);

		tab_promo_rank = new JLabel();
		tab_promo_rank.setBounds(300, 59, 100, 14);
		tab_promo.add(tab_promo_rank);

		tab_promo_toasst = new JLabel();
		tab_promo_toasst.setBounds(300, 100, 143, 14);
		tab_promo.add(tab_promo_toasst);

		tab_promo_toassoc = new JLabel();
		tab_promo_toassoc.setBounds(300, 136, 143, 14);
		tab_promo.add(tab_promo_toassoc);

		tab_promo_toprof = new JLabel();
		tab_promo_toprof.setBounds(300, 171, 143, 14);
		tab_promo.add(tab_promo_toprof);

		JButton btnRecordPromotion = new JButton("Record Promotion");
		btnRecordPromotion.setBounds(10, 243, 198, 23);
		tab_promo.add(btnRecordPromotion);

		// -- -- SABBATICAL TAB
		final JPanel tab_sab = new JPanel();
		tabbedPane.addTab("Sabbatical", null, tab_sab, null);
		tab_sab.setLayout(null);

		JLabel lblName_4 = new JLabel("Name");
		lblName_4.setBounds(10, 10, 61, 14);
		tab_sab.add(lblName_4);

		JLabel lblDateOfHire_1 = new JLabel("Date of hire");
		lblDateOfHire_1.setBounds(10, 40, 79, 14);
		tab_sab.add(lblDateOfHire_1);

		JLabel lblNotEligibleFor = new JLabel(
				"Not eligible for sabbatical at this time.");
		lblNotEligibleFor.setBounds(86, 65, 261, 14);
		tab_sab.add(lblNotEligibleFor);

		JLabel lblEligible = new JLabel("Eligible");
		lblEligible.setBounds(86, 93, 68, 14);
		tab_sab.add(lblEligible);

		// populate sab tab
		tab_sab_eligible = new JLabel();
		tab_sab_eligible.setBounds(300, 93, 79, 14);
		tab_sab.add(tab_sab_eligible);

		tab_sab_name = new JLabel();
		tab_sab_name.setBounds(300, 11, 111, 14);
		tab_sab.add(tab_sab_name);

		tab_sab_doh = new JLabel();
		tab_sab_doh.setBounds(300, 40, 111, 14);
		tab_sab.add(tab_sab_doh);

		// -- VIEW ALL
		final JPanel content_view_all = new JPanel();
		content_view_all.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.
						HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 0, 869, 364);
		JLabel label1 = new JLabel(String.format("%-30s %-32s %-32s %-15s", "Name",
				"Dept.", "College", "Rank"));
		label1.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		scrollPane.setColumnHeaderView(label1);
		content_view_all.add(scrollPane);

		list = new JList();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setCellRenderer(new MyCellRenderer());
		scrollPane.setViewportView(list);

		btnView = new JButton("View");
		btnView.setIcon(new ImageIcon(
				"C:\\Users\\Owner\\Desktop\\mimiGlyphs\\mimiGlyphs\\png\\12.png"));
		btnView.setBounds(236, 375, 89, 23);
		content_view_all.add(btnView);

		btnEdit = new JButton("Edit");
		btnEdit.setIcon(new ImageIcon(
				"C:\\Users\\Owner\\Desktop\\mimiGlyphs\\mimiGlyphs\\png\\39.png"));
		btnEdit.setBounds(369, 375, 89, 23);
		content_view_all.add(btnEdit);

		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
			}
		});
		btnDelete.setIcon(new ImageIcon(
				"C:\\Users\\Owner\\Desktop\\mimiGlyphs\\mimiGlyphs\\png\\51.png"));
		btnDelete.setBounds(509, 375, 107, 23);
		content_view_all.add(btnDelete);

		// -- SEARCH
		final JPanel content_search = new JPanel();
		content_search.setLayout(null);
		JPanel searchpanel = new JPanel();
		searchpanel.setBorder(new TitledBorder(null, "Search By:",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		searchpanel.setBounds(20, 10, 430, 325);
		content_search.add(searchpanel);
		searchpanel.setLayout(null);

		comboBox_search_college = new JComboBox();
		comboBox_search_college.setModel(new DefaultComboBoxModel(new String[] {
				"Select College", "ABS", "BUS", "EDUC", "HHS", "SET",
				"Pre-Professional Programs" }));
		comboBox_search_college.setBounds(120, 60, 203, 20);
		searchpanel.add(comboBox_search_college);

		JCheckBox rdbtnCollegeSearch = new JCheckBox("College");
		rdbtnCollegeSearch.setBounds(19, 59, 95, 23);
		searchpanel.add(rdbtnCollegeSearch);

		JCheckBox rdbtnRankSearch = new JCheckBox("Rank");
		rdbtnRankSearch.setBounds(21, 119, 93, 23);
		searchpanel.add(rdbtnRankSearch);

		JCheckBox rdbtnEvalsSearch = new JCheckBox("Evaluations");
		rdbtnEvalsSearch.setBounds(19, 149, 95, 23);
		searchpanel.add(rdbtnEvalsSearch);

		comboBox_search_rank = new JComboBox();
		comboBox_search_rank.setModel(new DefaultComboBoxModel(new String[] {
				"Select Rank", "Lecturer", "Instructor", "Assistant Professor",
				"Associate Professor", "Full Professor" }));
		comboBox_search_rank.setBounds(120, 120, 203, 20);
		searchpanel.add(comboBox_search_rank);

		comboBox_search_eval = new JComboBox();
		comboBox_search_eval.setModel(new DefaultComboBoxModel(new String[] {
				"All", "Fall", "Winter" }));
		comboBox_search_eval.setBounds(120, 150, 71, 20);
		searchpanel.add(comboBox_search_eval);

		JCheckBox rdbtnPromoSearch = new JCheckBox("Promotions");
		rdbtnPromoSearch.setBounds(19, 179, 95, 23);
		searchpanel.add(rdbtnPromoSearch);

		comboBox_search_promo = new JComboBox();
		comboBox_search_promo.setModel(new DefaultComboBoxModel(new String[] {
				"All", "Fall", "Winter" }));
		comboBox_search_promo.setBounds(120, 180, 71, 20);
		searchpanel.add(comboBox_search_promo);

		JCheckBox rdbtnSabbaticalSearch = new JCheckBox("Sabbatical");
		rdbtnSabbaticalSearch.setBounds(19, 209, 95, 23);
		searchpanel.add(rdbtnSabbaticalSearch);

		comboBox_search_sab = new JComboBox();
		comboBox_search_sab.setModel(new DefaultComboBoxModel(new String[] { "All",
				"Fall", "Winter" }));
		comboBox_search_sab.setBounds(120, 210, 71, 20);
		searchpanel.add(comboBox_search_sab);

		btnSearch = new JButton("Search");
		btnSearch.setBounds(332, 289, 89, 23);
		searchpanel.add(btnSearch);

		comboBox_search_dept = new JComboBox();
		comboBox_search_dept.setEnabled(false);
		comboBox_search_dept.setBounds(120, 90, 203, 20);
		searchpanel.add(comboBox_search_dept);

		JLabel lblDepartmentSearch = new JLabel("Department");
		lblDepartmentSearch.setBounds(40, 93, 74, 14);
		searchpanel.add(lblDepartmentSearch);

		textField_search_name = new JTextField();
		textField_search_name.setBounds(120, 29, 203, 20);
		searchpanel.add(textField_search_name);
		textField_search_name.setColumns(10);

		JCheckBox chckbxName = new JCheckBox("Name");
		chckbxName.setBounds(19, 28, 97, 23);
		searchpanel.add(chckbxName);

		// -- GENERATE
		final JPanel content_generate = new JPanel();
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Generate Report By:",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(20, 10, 430, 325);
		content_generate.add(panel);
		panel.setLayout(null);

		final JComboBox comboBox_generate_college = new JComboBox();
		comboBox_generate_college.setModel(new DefaultComboBoxModel(new String[] {
				"Select College", "ABS", "BUS", "EDUC", "HHS", "SET",
				"Pre-Professional Programs" }));
		comboBox_generate_college.setBounds(120, 26, 203, 20);
		panel.add(comboBox_generate_college);

		JCheckBox rdbtnCollege = new JCheckBox("College");
		rdbtnCollege.setBounds(19, 25, 95, 23);
		panel.add(rdbtnCollege);

		JCheckBox rdbtnRank = new JCheckBox("Rank");
		rdbtnRank.setBounds(21, 85, 93, 23);
		panel.add(rdbtnRank);

		JCheckBox rdbtnEvals = new JCheckBox("Evaluations");
		rdbtnEvals.setBounds(19, 115, 95, 23);
		panel.add(rdbtnEvals);

		JComboBox comboBox_generate_rank = new JComboBox();
		comboBox_generate_rank.setModel(new DefaultComboBoxModel(new String[] {
				"Select Rank", "Lecturer", "Instructor", "Assistant Professor",
				"Associate Professor", "Full Professor" }));
		comboBox_generate_rank.setBounds(120, 86, 203, 20);
		panel.add(comboBox_generate_rank);

		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] { "All", "Fall",
				"Winter" }));
		comboBox_5.setBounds(120, 116, 71, 20);
		panel.add(comboBox_5);

		JCheckBox rdbtnPromo = new JCheckBox("Promotions");
		rdbtnPromo.setBounds(19, 145, 95, 23);
		panel.add(rdbtnPromo);

		JComboBox comboBox_generate_promo = new JComboBox();
		comboBox_generate_promo.setModel(new DefaultComboBoxModel(new String[] {
				"All", "Fall", "Winter" }));
		comboBox_generate_promo.setBounds(120, 146, 71, 20);
		panel.add(comboBox_generate_promo);

		JCheckBox rdbtnSabbatical = new JCheckBox("Sabbatical");
		rdbtnSabbatical.setBounds(19, 175, 95, 23);
		panel.add(rdbtnSabbatical);

		JComboBox comboBox_generate_sab = new JComboBox();
		comboBox_generate_sab.setModel(new DefaultComboBoxModel(new String[] {
				"All", "Fall", "Winter" }));
		comboBox_generate_sab.setBounds(120, 176, 71, 20);
		panel.add(comboBox_generate_sab);

		btnGenerate = new JButton("Generate");
		btnGenerate.setBounds(331, 291, 89, 23);
		panel.add(btnGenerate);

		final JComboBox comboBox_generate_dept = new JComboBox();
		comboBox_generate_dept.setEnabled(false);
		comboBox_generate_dept.setBounds(120, 56, 203, 20);
		panel.add(comboBox_generate_dept);

		JLabel lblDepartment_1 = new JLabel("Department");
		lblDepartment_1.setBounds(40, 59, 74, 14);
		panel.add(lblDepartment_1);

		// -- EDIT
		JPanel content_edit = new JPanel();
		btnSubmit_edit = new JButton("Submit");
		btnSubmit_edit.setBounds(770, 375, 89, 23);
		content_edit.add(btnSubmit_edit);
		content_edit.setLayout(null);

		JLabel lblName_edit = new JLabel("Name");
		lblName_edit.setBounds(10, 15, 73, 14);
		content_edit.add(lblName_edit);

		JLabel lblCollege_edit = new JLabel("College");
		lblCollege_edit.setBounds(10, 67, 73, 14);
		content_edit.add(lblCollege_edit);

		textField_name_edit = new JTextField();
		textField_name_edit.setBounds(100, 12, 170, 20);
		content_edit.add(textField_name_edit);
		textField_name_edit.setColumns(10);

		comboBox_college_edit = new JComboBox<String>();
		comboBox_college_edit.setBounds(100, 65, 208, 20);
		content_edit.add(comboBox_college_edit);
		comboBox_college_edit.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Select College", "ABS", "BUS", "EDUC", "HHS", "SET" }));

		JLabel lblDepartment_edit = new JLabel("Department");
		lblDepartment_edit.setBounds(359, 68, 101, 14);
		content_edit.add(lblDepartment_edit);

		comboBox_dept_edit = new JComboBox<String>();
		comboBox_dept_edit.setBounds(470, 64, 208, 20);
		content_edit.add(comboBox_dept_edit);
		comboBox_dept_edit.setEnabled(false);

		JLabel lblGender_edit = new JLabel("Gender");
		lblGender_edit.setBounds(359, 13, 46, 14);
		content_edit.add(lblGender_edit);

		rdbtnMale_edit = new JRadioButton("M");
		rdbtnMale_edit.setBounds(470, 11, 38, 23);
		content_edit.add(rdbtnMale_edit);

		rdbtnFemale_edit = new JRadioButton("F");
		rdbtnFemale_edit.setBounds(510, 11, 33, 23);
		content_edit.add(rdbtnFemale_edit);

		JLabel lblRankAtHire_edit = new JLabel("Rank at Hire");
		lblRankAtHire_edit.setBounds(10, 118, 73, 14);
		content_edit.add(lblRankAtHire_edit);

		comboBox_rank_edit = new JComboBox();
		comboBox_rank_edit.setBounds(100, 115, 208, 20);
		content_edit.add(comboBox_rank_edit);
		comboBox_rank_edit.setModel(new DefaultComboBoxModel(new String[] {
				"Select", "Lecturer", "Instructor", "Assistant Professor",
				"Associate Professor", "Professor" }));

		JLabel lblAppointment_edit = new JLabel("Appointment");
		lblAppointment_edit.setBounds(10, 168, 73, 14);
		content_edit.add(lblAppointment_edit);

		comboBox_month_edit = new JComboBox();
		comboBox_month_edit.setBounds(100, 165, 73, 20);
		content_edit.add(comboBox_month_edit);
		comboBox_month_edit.setModel(new DefaultComboBoxModel(new String[] {
				"January", "February", "March", "April", "May", "June", "July",
				"August", "September", "October", "November", "December" }));

		textField_year_edit = new JTextField();
		textField_year_edit.setText("2013");
		textField_year_edit.setBounds(183, 166, 86, 20);
		content_edit.add(textField_year_edit);
		textField_year_edit.setColumns(10);

		JLabel lblDegree_edit = new JLabel("Degree");
		lblDegree_edit.setBounds(10, 218, 73, 14);
		content_edit.add(lblDegree_edit);

		comboBox_degree_edit = new JComboBox();
		comboBox_degree_edit.setBounds(100, 215, 79, 20);
		content_edit.add(comboBox_degree_edit);
		comboBox_degree_edit.setModel(new DefaultComboBoxModel(new String[] {
				"Select", "MA", "MFA", "MS", "MSW", "ABD", "EdD", "PhD" }));

		txtInstitution_edit = new JTextField();
		txtInstitution_edit.setText("Institution");
		txtInstitution_edit.setBounds(189, 215, 155, 20);
		content_edit.add(txtInstitution_edit);
		txtInstitution_edit.setColumns(10);

		JLabel lblComments_edit = new JLabel("Comments");
		lblComments_edit.setBounds(10, 320, 73, 14);
		content_edit.add(lblComments_edit);

		textArea_comments_edit = new JTextArea();
		textArea_comments_edit.setBounds(100, 315, 244, 55);
		textArea_comments_edit.setAlignmentX(TOP_ALIGNMENT);
		textArea_comments_edit.setAlignmentY(TOP_ALIGNMENT);
		content_edit.add(textArea_comments_edit);

		JLabel lblExperienceCredits_edit = new JLabel("Experience");
		lblExperienceCredits_edit.setBounds(10, 268, 73, 14);
		content_edit.add(lblExperienceCredits_edit);

		textField_expCred_edit = new JTextField();
		textField_expCred_edit.setBounds(100, 265, 86, 20);
		content_edit.add(textField_expCred_edit);
		textField_expCred_edit.setToolTipText("Enter number of years experience");
		textField_expCred_edit.setColumns(10);

		JLabel lblCurrentRank = new JLabel("Current Rank");
		lblCurrentRank.setBounds(359, 118, 101, 14);
		content_edit.add(lblCurrentRank);

		comboBox_currentRank = new JComboBox();
		comboBox_currentRank.setModel(new DefaultComboBoxModel(new String[] {
				"Select", "Lecturer", "Instructor", "Assistant Professor",
				"Associate Professor", "Professor" }));

		comboBox_currentRank.setBounds(470, 115, 208, 20);
		content_edit.add(comboBox_currentRank);

		content_home.setLayout(null);
		content_generate.setLayout(null);

		// create panel to contain the cards
		panel_content = new JPanel();
		panel_content.setBounds(158, 11, 869, 409);
		cl = new CardLayout();
		panel_content.setLayout(cl);

		// add the cards
		panel_content.add(content_home, "Home");
		panel_content.add(content_add, "Add New Record");
		panel_content.add(content_view_one, "View Record");
		panel_content.add(content_view_all, "View All Records");
		panel_content.add(content_search, "Search");
		panel_content.add(content_generate, "Generate Reports");
		panel_content.add(content_edit, "Edit Record");

		JLabel lblTenureGranted_1 = new JLabel("Tenure Granted");
		lblTenureGranted_1.setBounds(359, 168, 101, 14);
		content_edit.add(lblTenureGranted_1);

		textField_tenureGranted = new JTextField();
		textField_tenureGranted.setBounds(470, 165, 86, 20);
		content_edit.add(textField_tenureGranted);
		textField_tenureGranted.setColumns(10);

		contentPane.add(panel_content);

		// Dynamic select box. Whatever is chosen for college determines
		// what options are available in the department combo box
		comboBox_college.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e)
			{
				String ABS[] = { "CJ", "ART", "ENGL", "PHIL", "HIST", "SOC", "GEOG" };
				String BUS[] = { "Marketing", "Managment", "ACCT" };
				String EDU[] = { "choice" };
				String HHS[] = { "KINE", "SW" };
				String SET[] = { "MATH", "CHEM" };

				if (e.getSource() == comboBox_college)
				{
					if (comboBox_college.getSelectedItem().equals("Select College"))
					{
						comboBox_dept.removeAllItems();
						comboBox_dept.setEnabled(false);
					}
					else if (comboBox_college.getSelectedItem().equals("ABS"))
					{
						comboBox_dept.setEnabled(true);
						comboBox_dept.removeAllItems();
						for (int i = 0; i < ABS.length; i++)
						{
							comboBox_dept.addItem(ABS[i]);
						}
					}
					else if (comboBox_college.getSelectedItem().equals("BUS"))
					{
						comboBox_dept.setEnabled(true);
						comboBox_dept.removeAllItems();
						for (int i = 0; i < BUS.length; i++)
						{
							comboBox_dept.addItem(BUS[i]);
						}
					}
					else if (comboBox_college.getSelectedItem().equals("EDUC"))
					{
						comboBox_dept.setEnabled(true);
						comboBox_dept.removeAllItems();
						for (int i = 0; i < EDU.length; i++)
						{
							comboBox_dept.addItem(EDU[i]);
						}
					}
					else if (comboBox_college.getSelectedItem().equals("HHS"))
					{
						comboBox_dept.setEnabled(true);
						comboBox_dept.removeAllItems();
						for (int i = 0; i < HHS.length; i++)
						{
							comboBox_dept.addItem(HHS[i]);
						}
					}
					else if (comboBox_college.getSelectedItem().equals("SET"))
					{
						comboBox_dept.setEnabled(true);
						comboBox_dept.removeAllItems();
						for (int i = 0; i < SET.length; i++)
						{
							comboBox_dept.addItem(SET[i]);
						}
					}
				}
			}
		});

		// Dynamic select box. Whatever is chosen for college determines
		// what options are available in the department combo box
		comboBox_generate_college.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e)
			{
				String ABS[] = { "CJ", "ART", "ENGL", "PHIL", "HIST", "SOC", "GEOG" };
				String BUS[] = { "Marketing", "Managment", "ACCT" };
				String EDU[] = { "choice" };
				String HHS[] = { "KINE", "SW" };
				String SET[] = { "MATH", "CHEM" };

				if (e.getSource() == comboBox_generate_college)
				{
					if (comboBox_generate_college.getSelectedItem().equals(
							"Select College"))
					{
						comboBox_generate_dept.removeAllItems();
						comboBox_generate_dept.setEnabled(false);
					}
					else if (comboBox_generate_college.getSelectedItem().equals("ABS"))
					{
						comboBox_generate_dept.setEnabled(true);
						comboBox_generate_dept.removeAllItems();
						for (int i = 0; i < ABS.length; i++)
						{
							comboBox_generate_dept.addItem(ABS[i]);
						}
					}
					else if (comboBox_generate_college.getSelectedItem().equals("BUS"))
					{
						comboBox_generate_dept.setEnabled(true);
						comboBox_generate_dept.removeAllItems();
						for (int i = 0; i < BUS.length; i++)
						{
							comboBox_generate_dept.addItem(BUS[i]);
						}
					}
					else if (comboBox_generate_college.getSelectedItem().equals("EDUC"))
					{
						comboBox_generate_dept.setEnabled(true);
						comboBox_generate_dept.removeAllItems();
						for (int i = 0; i < EDU.length; i++)
						{
							comboBox_generate_dept.addItem(EDU[i]);
						}
					}
					else if (comboBox_generate_college.getSelectedItem().equals("HHS"))
					{
						comboBox_generate_dept.setEnabled(true);
						comboBox_generate_dept.removeAllItems();
						for (int i = 0; i < HHS.length; i++)
						{
							comboBox_generate_dept.addItem(HHS[i]);
						}
					}
					else if (comboBox_generate_college.getSelectedItem().equals("SET"))
					{
						comboBox_generate_dept.setEnabled(true);
						comboBox_generate_dept.removeAllItems();
						for (int i = 0; i < SET.length; i++)
						{
							comboBox_generate_dept.addItem(SET[i]);
						}
					}
				}
			}
		});

		// Dynamic select box. Whatever is chosen for college determines
		// what options are available in the department combo box
		comboBox_college_edit.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e)
			{
				String ABS[] = { "CJ", "ART", "ENGL", "PHIL", "HIST", "SOC", "GEOG" };
				String BUS[] = { "Marketing", "Managment", "ACCT" };
				String EDU[] = { "choice" };
				String HHS[] = { "KINE", "SW" };
				String SET[] = { "MATH", "CHEM" };

				if (e.getSource() == comboBox_college_edit)
				{
					if (comboBox_college_edit.getSelectedItem().equals("Select College"))
					{
						comboBox_dept_edit.removeAllItems();
						comboBox_dept_edit.setEnabled(false);
					}
					else if (comboBox_college_edit.getSelectedItem().equals("ABS"))
					{
						comboBox_dept_edit.setEnabled(true);
						comboBox_dept_edit.removeAllItems();
						for (int i = 0; i < ABS.length; i++)
						{
							comboBox_dept_edit.addItem(ABS[i]);
						}
					}
					else if (comboBox_college_edit.getSelectedItem().equals("BUS"))
					{
						comboBox_dept_edit.setEnabled(true);
						comboBox_dept_edit.removeAllItems();
						for (int i = 0; i < BUS.length; i++)
						{
							comboBox_dept_edit.addItem(BUS[i]);
						}
					}
					else if (comboBox_college_edit.getSelectedItem().equals("EDUC"))
					{
						comboBox_dept_edit.setEnabled(true);
						comboBox_dept_edit.removeAllItems();
						for (int i = 0; i < EDU.length; i++)
						{
							comboBox_dept_edit.addItem(EDU[i]);
						}
					}
					else if (comboBox_college_edit.getSelectedItem().equals("HHS"))
					{
						comboBox_dept_edit.setEnabled(true);
						comboBox_dept_edit.removeAllItems();
						for (int i = 0; i < HHS.length; i++)
						{
							comboBox_dept_edit.addItem(HHS[i]);
						}
					}
					else if (comboBox_college_edit.getSelectedItem().equals("SET"))
					{
						comboBox_dept_edit.setEnabled(true);
						comboBox_dept_edit.removeAllItems();
						for (int i = 0; i < SET.length; i++)
						{
							comboBox_dept_edit.addItem(SET[i]);
						}
					}
				}
			}
		});

		button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				cl.show(panel_content, "Home");
			}
		});

		btnAddRecord.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				cl.show(panel_content, "Add New Record");
			}
		});

		btnGenerateReport.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				cl.show(panel_content, "Generate Reports");
			}
		});

		btnEdit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				selectedPerson = list.getSelectedIndex();
				cl.show(panel_content, "Edit Record");

				textField_name_edit.setText(fl.getRecord(selectedPerson).getName());
				comboBox_college_edit.setSelectedItem(fl.getRecord(selectedPerson)
						.getCollege());
				comboBox_dept_edit.setSelectedItem(fl.getRecord(selectedPerson)
						.getDepartment());

				if (String.valueOf(fl.getRecord(selectedPerson).getGender())
						.equals("F"))
					rdbtnFemale_edit.setSelected(true);
				else
					rdbtnMale_edit.setSelected(true);
				// comboBox_rank_edit.setSelectedItem(rank[selectedPerson]);

				// comboBox_month_edit
				// textField_year_edit
				// comboBox_degree_edit
				// txtInstitution_edit
				// textArea_comments_edit
				// textField_expCred_edit
				// comboBox_currentRank
			}
		});

		btnMenuSearch.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				selectedPerson = list.getSelectedIndex();
				cl.show(panel_content, "Search");
			}
		});

		btnRecordPromotion.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JComponent prompt = null;

				final JComponent[] inputs = new JComponent[] {
						new JLabel("Please enter year of promotion"), prompt };
				String yearOfPromo = JOptionPane.showInputDialog(null, inputs,
						"Record Promotion", JOptionPane.PLAIN_MESSAGE);
			}
		});
	}

	public static void addElements(final GUI frame, FacultyList fl)
	{
		// first number is number of rows, second is number of columns
		String[][] columnData = new String[fl.getSize()][4];
		fl.sortName();
		// dynamic setting of String[][]
		for (int i = 0; i < fl.getSize(); i++)
		{
			columnData[i][0] = fl.getRecord(i).getName();
			columnData[i][1] = fl.getRecord(i).getDepartment();
			columnData[i][2] = fl.getRecord(i).getCollege();
			columnData[i][3] = fl.getRecord(i).getRank().getCurrentRank();
		}
		frame.list.setListData(columnData);
	}

	static class MyCellRenderer extends JPanel implements ListCellRenderer
	{
		JLabel left, middle, right, rightright;

		MyCellRenderer()
		{
			setLayout(new GridLayout(1, 4));
			left = new JLabel();
			middle = new JLabel();
			right = new JLabel();
			rightright = new JLabel();
			left.setOpaque(true);
			middle.setOpaque(true);
			right.setOpaque(true);
			rightright.setOpaque(true);
			add(left);
			add(middle);
			add(right);
			add(rightright);
		}

		public Component getListCellRendererComponent(JList list, Object value,
				int index, boolean isSelected, boolean cellHasFocus)
		{
			String leftData = ((String[]) value)[0];
			String middleData = ((String[]) value)[1];
			String rightData = ((String[]) value)[2];
			String rightrightData = ((String[]) value)[3];
			left.setText(leftData);
			middle.setText(middleData);
			right.setText(rightData);
			rightright.setText(rightrightData);
			if (isSelected)
			{
				left.setBackground(list.getSelectionBackground());
				left.setForeground(list.getSelectionForeground());
				middle.setBackground(list.getSelectionBackground());
				middle.setForeground(list.getSelectionForeground());
				right.setBackground(list.getSelectionBackground());
				right.setForeground(list.getSelectionForeground());
				rightright.setBackground(list.getSelectionBackground());
				rightright.setForeground(list.getSelectionForeground());
			}
			else
			{
				left.setBackground(list.getBackground());
				left.setForeground(list.getForeground());
				middle.setBackground(list.getBackground());
				middle.setForeground(list.getForeground());
				right.setBackground(list.getBackground());
				right.setForeground(list.getForeground());
				rightright.setBackground(list.getBackground());
				rightright.setForeground(list.getForeground());
			}
			setEnabled(list.isEnabled());
			setFont(list.getFont());
			return this;
		}
	}

	/**
	 * Create listener to detect when the search for record button is pressed
	 * @param frame
	 */
	public static void searchForRecord_Listener(final GUI frame)
	{
		btnSearch.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				srh.search(frame, fl);
			}
		});
	}

	/**
	 * Create listener to detect when the delete record button is pressed 
	 * Show the delete dialogue
	 * 
	 * @param frame
	 */
	public static void deleteRecord_Listener(final GUI frame)
	{
		btnDelete.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// confirmation?
				drh.delete(frame, fl);
			}
		});
	}

	/**
	 * Create listener to detect when the add record button is pressed Checks to
	 * make sure the basic information is entered, adds the record, switches back
	 * to the view all records screen
	 * 
	 * @param frame
	 */
	public static void addRecord_Listener(final GUI frame)
	{
		btnAdd.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// error checking??
				if (frame.textField_name.getText().isEmpty())
				{
					JComponent prompt = null;

					final JComponent[] inputs = new JComponent[] {
							new JLabel(
									"ERROR: Please enter the NAME of the new faculty member."),
							prompt };
					frame.textField_name.setText(JOptionPane.showInputDialog(null,
							inputs, "ENTER NAME", JOptionPane.PLAIN_MESSAGE));
				}
				arh.add(frame, fl);
				addElements(frame, fl);
				cl.show(frame.panel_content, "View All Records");
			}
		});
	}

	/**
	 * Create listener to detect when the view all records button is pressed
	 * Shows all of the records
	 * 
	 * @param frame
	 */
	public static void viewAllRecords_Listener(final GUI frame)
	{
		btnViewAll.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				addElements(frame, fl);
				cl.show(frame.panel_content, "View All Records");
			}
		});
	}

	/**
	 * Creates the listener to detect if the view one record button was pressed
	 * Displays the information for ONE faculty memeber
	 * @param frame
	 */
	public static void viewOneRecord_Listener(final GUI frame)
	{
		btnView.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				selectedPerson = frame.list.getSelectedIndex();
				System.out.println("Index of selected person : " + selectedPerson);
				vorh.viewOne(frame, selectedPerson, fl);
				cl.show(frame.panel_content, "View Record");
			}
		});
	}

	/**
	 * Creates the listener to detect if the back button was pressed
	 * Takes back to the view all records screen
	 * @param frame
	 */
	public static void back_Listener(final GUI frame)
	{
		btnBackToList.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				addElements(frame, fl);
				cl.show(frame.panel_content, "View All Records");
			}
		});
	}
}
