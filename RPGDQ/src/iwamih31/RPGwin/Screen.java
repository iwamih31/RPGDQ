package iwamih31.RPGwin;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

public class Screen extends JFrame implements ActionListener, KeyListener {

	JLabel ansLabel;
	static JLabel display;
	protected static String value;
	String op1;
	String op2;
	String operator;
	int opMode;
	private int blank;
	private static JLabel q;
	private static Object[] ynList;
	private JTextArea inpT;
	private Story sto;
	private JComponent pict;
	private JTextArea textAreaN;
	private JTextArea textAreaW;
	private JTextArea textAreaC;
	private JTextArea textAreaE;
	private JTextArea textAreaS;
	private static Border border;
	private JTextArea textAreaB;
	private JTextArea menuAreaB;
	private JTextArea pictAreaB;
	private static String ent;
	private static Story story;
	private String buttonName;
	private String yName;
	private Ex useEx;
	private JPanel eventPanel;
	private JPanel backPanel;
	private String eventImage;
	private int imageCode;
	private String cancel;
	private static int w;
	private static int h;
	private static int fontSize;
	private static int count;
	private static String message;
	private static Object[] menu;
	private static int mode;
	private static Component panelN;
	private static Component panelW;
	private static Component panelC;
	private static Component panelE;
	private static Component panelS;
	private static JLabel labelN;
	private static JLabel labelW;
	private static JLabel labelC;
	private static JLabel labelE;
	private static JLabel labelS;
	private static String tex;
	private static JFrame frame;
	private static JPanel panelSet;
	private static JPanel changePanelSet;
	private static CardLayout cardLayout;
	private static JPanel clear;
	private static JLabel space;
	private static String entMark;

	public Screen(Object[] mList) {
		super("????????????");

		/*
		 * String exterior =
		 * "javax.swing.plaf.windows.WindowsLookAndFeel";//????????????plaf
		 * .?????????metal.MetalLookAndFeel???????????? try{
		 * UIManager.setLookAndFeel(exterior);
		 * SwingUtilities.updateComponentTreeUI(this.frame); } catch (Exception
		 * e) { e.printStackTrace(); }
		 */

		menu(mList);
	}

	public Screen(String s) {
		super(s);
		start(s);
	}

	private void start(String s) {
//		?????????????????????????????????????????????1?????????1????????????????????????????????????
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        w = screenSize.width / 100;
        h = screenSize.height / 100;
        fontSize = w;
		setMode(0);
		border = new LineBorder(Color.WHITE, 2, true);
//		yName = Main.getyName();
		ynList = new Object[]{ "??????", "?????????" };
		entMark = (" ??? ");
		ent = entMark;
		cancel = "Cancel";
		labelSet("");
		int bWE = 30;
		textAreaB = textAreaSet("",1,5);
		menuAreaB = textAreaSet("",1,1);
		textAreaN = textAreaSet("",5,5);/////////////???????????????????????????
		textAreaW = textAreaSet("",5,bWE);///////////??????
		textAreaC = textAreaSet("",5,9);////////////??????
		textAreaE = textAreaSet("",5,bWE);///////////????????????
		textAreaS = textAreaSet("",1,5);/////////////???????????????

		labelN = labelSet("???????????????????????????");
		labelW = labelSet("??????");
		labelC = labelSet("??????");
		labelE = labelSet("????????????");
		labelS = labelSet("???????????????");

		panelN = panelSetUD(textAreaN, textAreaB);
		panelW = panelSetUD(null, textAreaW);
		panelC = panelSetUD(null,labelC);
		panelE = panelSetUD(null, textAreaE);
		panelS = panelSetUD(null, textAreaS);

		space = labelSet("                                       ");

		eventImage = "?????????.png";

		outer();
	}

	private static JLabel b() {
		JLabel b = labelSet(" ");
		return b;
	}

	private static JTextArea textAreaSet(String text, int rows, int columns) {

		JTextArea textAreaSet = new JTextArea(text, rows,columns);
		format(textAreaSet);
		textAreaSet.setEditable(false);
		textAreaSet.setOpaque(false);///////////////????????????????????????
		return textAreaSet;
	}

	private static JLabel labelSet(String string) {

		JLabel labelSet = new JLabel(string, JLabel.CENTER);
		format(labelSet);
		labelSet.setOpaque(false);///////////////????????????????????????
		return labelSet;
	}

	private static JPanel panelSetLR(Object left, Object right) {
		JPanel panelSet = new JPanel();
		format(panelSet, 100, 100);
		panelSet.setLayout(new BoxLayout(panelSet, BoxLayout.X_AXIS));
		if (left != null) {
			panelSet.add((Component) left);
		}
		if (right != null) {
			panelSet.add((Component) right);
		}
		return panelSet;
	}

	private static JPanel panelSetUD(Object up, Object down) {
		JPanel panelSet = new JPanel();
		format(panelSet, 100, 100);
		panelSet.setLayout(new BoxLayout(panelSet, BoxLayout.Y_AXIS));
		if (up != null) {
			panelSet.add((Component) up);
		}
		if (down != null) {
			panelSet.add((Component) down);
		}
		return panelSet;
	}

	private static JPanel panelSetWCE(Object west, Object center, Object east) {
		JPanel panelSet = new JPanel();
		format(panelSet, 100, 100);
		panelSet.setLayout(new BorderLayout());
		if (west != null) {
			panelSet.add((Component) west, BorderLayout.WEST);
		}
		if (center != null) {
			panelSet.add((Component) center, BorderLayout.CENTER);
		}
		if (east != null) {
			panelSet.add((Component) east, BorderLayout.EAST);
		}
		return panelSet;
	}

	private static JPanel panelSetNCS(Object north, Object center, Object south) {
		JPanel panelSet = new JPanel();
		format(panelSet, 100, 100);
		panelSet.setLayout(new BorderLayout());
		if (north != null) {
			panelSet.add((Component) north, BorderLayout.NORTH);
		}
		if (center != null) {
			panelSet.add((Component) center, BorderLayout.CENTER);
		}
		if (south != null) {
			panelSet.add((Component) south, BorderLayout.SOUTH);
		}
		return panelSet;
	}

	private static JPanel panelSetTMB(Object top, Object middle, Object bottom) {
		JPanel panelSet = new JPanel();
		format(panelSet);
		panelSet.setLayout(new FlowLayout());
		if (top != null) {
			panelSet.add((Component) top);
		}
		if (middle != null) {
			panelSet.add((Component) middle);
		}
		if (bottom != null) {
			panelSet.add((Component) bottom);
		}
		return panelSet;
	}

	private static void outer() {
		if (frame != null) {
			frame.setVisible(false);
		}
		frame = new JFrame("RPG");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(w*100, h*100);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setLayout(new FlowLayout());



		changePanelSet = new JPanel();
		format(changePanelSet);
		cardLayout = new CardLayout();
		changePanelSet.setLayout(cardLayout);

		changePanelSet.add(panelSet(), "??????");

		clear = new JPanel();
		format(clear);
		changePanelSet.add(clear, "??????");

		frame.add(changePanelSet);

		change("??????");

		frame.setVisible(true);


	}

	private static void change(String mode) {

		cardLayout.removeLayoutComponent(panelSet);
		changePanelSet.add(panelSet, "??????");
		cardLayout.show(changePanelSet,mode);
	}

	private static void change() {

		panelSet();
		change("??????");
	}

	private static JPanel panelSet() {

		JPanel panelSetC = new JPanel();
		format(panelSetC);
		panelSetC.setPreferredSize(new Dimension(w*70, h*80));
		panelSetC.setLayout(new BoxLayout(panelSetC, BoxLayout.Y_AXIS));
		panelSetC.add(panelN);
		panelSetC.add(panelC);
		panelSetC.add(panelS);

		panelSet = new JPanel();
		format(panelSet);
		panelSet.setLayout(new FlowLayout());
		panelSet.add(panelW);
		panelSet.add(b());
		panelSet.add(panelSetC);
		panelSet.add(b());
		panelSet.add(panelE);

		return panelSet;

	}



	private static void centerSet(Object west, Object center, Object east) {

		JLabel space = labelSet("                                       ");
		JPanel panelQ = panelSetWCE(west, center, east);
		JPanel panelQA = panelSetWCE(space, panelQ, space);
		int rows = 7;
		int columns = 75;
		JTextArea blankAreaN = textAreaSet(" ",rows,columns);
		JTextArea blankAreaS = textAreaSet(" ",rows,columns);

		panelC = panelSetNCS(blankAreaN, panelQA,blankAreaS);

		change();
	}


	private static void format(Component component, int width, int height) {
		format(component);
		component.setSize(width, height);
//		component.setPreferredSize(new Dimension(width, height));
	}


	private static void format(Component component) {

		component.setFont(new Font("Monospaced", Font.BOLD, fontSize));
		component.setForeground(Color.WHITE);
		component.setBackground(Color.BLACK);

		if (mode > 0 && dead() > 0) {
			component.setForeground(Color.RED);
		}

	}


	private static Border border() {

		border = new LineBorder(Color.WHITE, 2, true);

		if (mode > 0 && denger() > 0) {
			border = new LineBorder(Color.YELLOW, 2, true);
		}

		return border;
	}

	private static int denger() {

		int dengerLevel = 0;
		Member[] party = Main.getParty();
		for (int i = 0; i < party.length; i++) {
			if (party[i].getHp() <= party[i].getAp()) dengerLevel++;
		}
		return dengerLevel;
	}

	private static int dead() {

		int deadNumber = 0;
		Member[] party = Main.getParty();
		for (int i = 0; i < party.length; i++) {
			if (party[i].getHp() < 1) deadNumber++;
		}
		return deadNumber;
	}

	static void que() {

		labelC = labelSet(tex);

		JPanel bPanel = new JPanel();
		format(bPanel,100,500);
		bPanel.setLayout(new GridLayout(2, 0, 0, 0));

		JButton[] button = new JButton[2];// /////////////////???????????????

		for (int i = 0; i < 2; i++) {
			String bN = (String) ynList[i];
			button[i] = new JButton(bN);
			format(button[i]);
			button[i].setFocusPainted(false);
			button[i].addActionListener(Main.getSc());
			button[i].addKeyListener(Main.getSc());
			button[i].setBorder(border());

			bPanel.add(button[i]);
		}

		centerSet(space,labelC, bPanel);

		// more();
	}

	private void inputName(String s) {

			buttonName = null;

			inpT = new JTextArea(1, 7);

			format(inpT);

			inpT.setBorder(border());

			JPanel bPanel = new JPanel();
			format(bPanel,100, 500);
			bPanel.setLayout(new GridLayout(0, 2, 0, 0));
			bPanel.setPreferredSize(new Dimension(60, 20));

			int bI = 1;// //////////////////////////////////???????????????

			JButton[] button = new JButton[bI];

			String[] bList = { "OK" };

			for (int i = 0; i < bI; i++) {
				String bN = (String) bList[i];
				button[i] = new JButton(bN);
				format(button[i],20,10);
//				button[i].setMargin(new Insets(20, 10, 20, 10));///////??????????????????
				button[i].setFocusPainted(false);
				button[i].addActionListener(this);
				button[i].addKeyListener(this);
				button[i].setBorder(border());
				bPanel.add(button[i]);
			}

			q = labelSet(tex);

			JPanel a = panelSetLR(inpT, bPanel);

			centerSet(space, q, a);

		}

	private void begin() {
		tex = "     ??????????????????????????????????????????";
		inputName("??????");
	}

	private void load() {
		Main.load();
	}

	public void menu(Object[] mList) {

		JPanel panel = new JPanel();
		format(panel);
		panel.setLayout(new GridLayout(5, 0, 0, 0));
//			panel.setBorder(border);
		panel.setPreferredSize(new Dimension(w*10, h*50));

		JButton[] button = new JButton[mList.length];// /////////////////???????????????

		for (int i = 0; i < (mList.length); i++) {
			String bN =  String.valueOf(mList[i]);
			button[i] = new JButton(bN);
			format(button[i], 50, 50);
			button[i].setMargin(new Insets(20, 10, 20, 10));///////??????????????????
			button[i].setFocusPainted(false);
			button[i].addActionListener(this);
			button[i].addKeyListener(this);
			button[i].setBorder(border());
			panel.add(button[i]);
		}

		String bN =  cancel;
		JButton jButton = new JButton(bN);
		format(jButton);
		jButton.setMargin(new Insets(20, 10, 20, 10));///////??????????????????
		jButton.setFocusPainted(false);
		jButton.addActionListener(this);
		jButton.addKeyListener(this);
		jButton.setBorder(border());
		jButton.setPreferredSize(new Dimension(w*10, h*13));
//			panel.add(jButton);

		JPanel bPanel = panelSetNCS(panel, menuAreaB,jButton);
		bPanel.setPreferredSize(new Dimension(w*10, h*80));

		panelE = panelSetWCE(null, bPanel, null);

	}

	public void actionPerformed(ActionEvent e) {

		String select = e.getActionCommand();

		if(select.equals(buttonName)){
			buttonName = ent;
		}else{
			buttonName = select;
		}


		System.out.println("");// ////////////////////////////////////////
		System.out.println("buttonName = " + buttonName);// //////////////////////////
		System.out.println("");// ////////////////////////////////////////

		switch (mode) {
			case 0 ://??????
				if (buttonName.equals(ynList[0])) {
					begin();
					opening();
				}
				if (buttonName.equals(ynList[1])) {
					load();
					toNormal();
				}else{
					opening();
				}
				break;

			case 1 ://??????

				break;

			case 2 ://??????

				count = 0;
				whichUse(buttonName);

				break;

			case 3 ://?????????

				break;

			case 4 ://??????

				break;

			case 5 ://??????

				break;

			case 9 ://??????

				break;

			default :

				break;
		}

	actionPerformedSwitch1();

	actionPerformedSwitch21();

	actionPerformedSwitch22();

	actionPerformedSwitch3();

	actionPerformedSwitch4();

	actionPerformedSwitch5();

	}


	private void opening() {

		if (buttonName.equals("OK")) {
			yName = null;
			String inputName = inpT.getText();

			int p = 0;
			char[] chars = inputName.toCharArray();
			for (int i = 0; i < chars.length; i++) {
				p += (String.valueOf(chars[i]).getBytes().length);
			}
			System.out.println("");// ////////////////////////////////////////
			System.out.println("?????????????????? = " + p);// //////////////////////////
			System.out.println("");// ////////////////////////////////////////

			while (yName == null) {
				if (p < 8) {
					if (inputName.equals("")) {
						inputName = Main.getyName();
					}
					Main.setyName(inputName);
					yName = inputName;

					System.out.println("");// ////////////////////////////////////////
					System.out.println("yName = " + yName);// //////////////////////////
					System.out.println("");// ////////////////////////////////////////
				} else {

					System.out.println("");// ////////////////////////////////////////
					System.out.println("yName = " + yName);// //////////////////////////
					System.out.println("");// ////////////////////////////////////////

					buttonName.equals(null);
					tex = "?????????????????????????????????????????????";
					change();
					inputName("??????");
				}
			}
			Main.begin();
			story = new Story();
			story.on("  ??????????????????[ " + yName + " ]??????????????????????????????????????????");
			prologue();
		}

		if (buttonName.equals(ent)) {

			System.out.println("");// ////////////////////////////////////////
			System.out.println("buttonName = " + buttonName);// //////////////////////////
			System.out.println("");// ////////////////////////////////////////

			System.out.println("");// ////////////////////////////////////////
			System.out.println("count = " + count);// //////////////////////////
			System.out.println("");// ////////////////////////////////////////

			if (count < story.getTextList().length) {

				setMessageEnt(story.getTextList()[count]);

				if (count == 4) {
					Main.setG(100);
					prologue();
				}
				if (count == 7) Main.fi.setHp(Main.getFiHP());
				if (count == 9) Main.pr.setHp(Main.getPrHP());
				if (count == 11) Main.mg.setHp(Main.getMgHP());
				Main.pGet();

				count = (count + 1);

				if (count < 5) {
					prologue();
				} else {
					castle();
				}

			} else {

				toNormal();

			}

		}
	}

	private void field() {

		System.out.println("");//////////////////////////////////////////
		System.out.println("field() ?????????");////////////////////////////
		System.out.println("");//////////////////////////////////////////

		setMode(1);/////////////////////////////////// ?

		buttonName = null;

		partySt();
		info(goldList(),itemList(),"");
		scene();
		menu(Command.menu());
		comment();

		change();
	}

	private void fieldMenu(Object[] setMenu) {
		// TODO ?????????????????????????????????????????????

		System.out.println("");//////////////////////////////////////////
		System.out.println("fieldMenu(String[] setMenu) ?????????");//////////////////////////////
		System.out.println("");//////////////////////////////////////////

		buttonName = null;

		partySt();
		info(goldList(),itemList(),"");
		scene();
		menu(setMenu);
		comment();

		change();

	}

	private void use() {
		// TODO ?????????????????????????????????????????????

		System.out.println("");//////////////////////////////////////////
		System.out.println("use() ?????????");//////////////////////////////
		System.out.println("");//////////////////////////////////////////

		buttonName = null;

		partySt();
		info(goldList(),itemList(),"");
		scene();
		menu(menu);
		comment();

		change();

	}

	private void whichUse(String selectButtonName) {

		System.out.println("");//////////////////////////////////////////
		System.out.println("fieldUse(" + selectButtonName +") ?????????");////////
		System.out.println("");//////////////////////////////////////////

		if (selectButtonName.equals(menu[0])) {

			buttonName = null;

			printMode();

			Main.use(1);

			setMessage("???????????????????????????????????????");

			item();

			setMode(21);
		}

		if (selectButtonName.equals(menu[1])) {

			buttonName = null;

			printMode();

			Main.use(2);

			setMessage("????????????????????????");

			who();

			setMode(22);
		}
	}

	public void actionPerformedSwitch1() {

		switch (mode) {

			case 1 ://??????
				count = 0;
				fieldAction(buttonName);

				break;

			case 10 ://
				if (buttonName.equals(ent)) {
					Main.event();
					String[] text = Main.getDoText();
					setMessageEnt(text[count]);
					count = (count + 1);
					adventure();
				}
				break;

			case 11 ://?????????

				eventMenu1();

				break;

			case 12 ://??????

				eventMenu0();

				break;

			case 13 ://??????

				eventMenu0();

				break;

			case 14 ://??????

				setMode(5);

				break;

			case 15 ://??????

				eventMenu0();

				break;

		}
	}

	private void adventure() {

		System.out.println("");//////////////////////////////////////////
		System.out.println("adventure() ?????????");//////////////////////////////
		System.out.println("");//////////////////////////////////////////

		buttonName = null;

		partySt();
		info(goldList(),itemList(),"");
		scene();
		menu(Command.menu());
		comment();

		change();

	}

	private void fieldAction(String selectButtonName) {

			System.out.println("");//////////////////////////////////////////
			System.out.println("fieldAction(" + selectButtonName +") ?????????");////////
			System.out.println("");//////////////////////////////////////////

			String[] menu = Command.menu();

			if (selectButtonName.equals(menu[0])) {

				buttonName = null;

				printMode();

				Main.action(1);

	//			setMessageEnt(Main.getText());

				setMessageEnt("???????????????" + Main.getName() + "????????????????????????????????????");

				setMode(10);

				adventure();
			}

			if (selectButtonName.equals(menu[1])) {

				buttonName = null;

				printMode();

				Main.action(2);

				setMessage("?????????????????????????????????");

				setMode(2);

				use();
			}

			if (selectButtonName.equals(menu[2])) {

				buttonName = null;

				printMode();

				Main.action(3);

				setMode(3);

				shop();
			}

			if (selectButtonName.equals(menu[3])) {

				buttonName = null;

				printMode();

				Main.action(4);

				setMode(4);

				inn();

			}
		}

	private void eventMenu0() {
		if (buttonName.equals(ent)) {

			System.out.println("");/////////////////////////////
			System.out.println("buttonName = " + buttonName);///
			System.out.println("");/////////////////////////////

			String[] text = Main.getDoText();

			if (count < text.length) {

				setMessageEnt(text[count]);

				if (count == 0) {

				}

				count = (count + 1);

				adventure();

			} else {

				toNormal();

			}
		}
	}

	private void eventMenu1() {
		if (buttonName.equals(ent)) {

			System.out.println("");/////////////////////////////
			System.out.println("buttonName = " + buttonName);///
			System.out.println("");/////////////////////////////

			String[] text = Main.getDoText();

			if (count < text.length) {

				setMessageEnt(text[count]);

				if (count == 2) {
					Main.healing();
				}

				count = (count + 1);

				adventure();

			} else {

				toNormal();

			}
		}
	}

	public void actionPerformedSwitch21() {

		switch (mode) {

			case 21 ://??????,??????

				if (Battle.getfMode()==0){
					fieldItem(buttonName);
				}else{
					battleItem(buttonName);
				}

				break;

			case 200 ://??????,??????,??????

				if (buttonName.equals(ent)) {
					itemLoop();
				}
				break;

			case 211 ://??????,??????,[1],?????????
				count = 0;
				menu = Main.getpNa();

				for (int i = 0; i < menu.length; i++) {

					if (buttonName.equals(menu[i])){
						setMode(200);
						Item.who1(i);
						itemLoop();
					}
				}
				break;

//			case 2110 ://??????,??????,[1],[0],??????
//			case 2111 ://??????,??????,[1],[1],??????
//			case 2112 ://??????,??????,[1],[2],??????
//			case 2113 ://??????,??????,[1],[3],??????
//
//				if (buttonName.equals(ent)) {
//					itemMenu1(mode - 2110);
//				}
//				break;

			case 212 ://????????????[2],??????
				count = 0;
				setMode(200);
				break;

			case 213 ://????????????[3],??????
				count = 0;
				setMode(200);
				break;

			case 214 ://????????????[4],?????????
				count = 0;
				menu = Main.getpNa();

				for (int i = 0; i < menu.length; i++) {

					if (buttonName.equals(menu[i])){
						setMode(200);
						Item.who4(i);
						itemLoop();
					}
				}
				break;

//			case 2140 ://??????,??????,[4],[0],??????
//			case 2141 ://??????,??????,[4],[1],??????
//			case 2142 ://??????,??????,[4],[2],??????
//			case 2143 ://??????,??????,[4],[3],??????
//
//				if (buttonName.equals(ent)) {
//					itemMenu4(mode - 2140);
//				}
//				break;

			case 2101 ://??????????????????,??????,??????,[1],?????????
				count = 0;
				menu = Main.getpNa();

				for (int i = 0; i < menu.length; i++) {

					if (buttonName.equals(menu[i])){
						setMode(555);
						Item.who1(i);
						battleLoop();
					}
				}
				break;

//			case 21010 ://??????????????????,??????,??????,[1],[0],??????
//			case 21011 ://??????????????????,??????,??????,[1],[1],??????
//			case 21012 ://??????????????????,??????,??????,[1],[2],??????
//			case 21013 ://??????????????????,??????,??????,[1],[3],??????
//
//				if (buttonName.equals(ent)) {
//					battleLoop();
//				}
//				break;

			case 2102 ://??????????????????,????????????[2],???????????????????????????
				count = 0;
				Monster[] mons = Battle.getMons();

				for (int i = 0; i < mons.length; i++) {

					if (buttonName.equals(mons[i].getName())){
						setMode(555);
						Item.who2(i);
						battleLoop();
					}
				}
				break;

			case 2103 ://??????????????????,????????????[3]

				setMode(555);

				break;

			case 2104 ://??????????????????,????????????[4],?????????
				count = 0;
				menu = Main.getpNa();

				for (int i = 0; i < menu.length; i++) {

					if (buttonName.equals(menu[i])){
						setMode(555);
						Item.who4(i);
						battleLoop();
					}
				}
				break;

//			case 21040 ://??????????????????,??????,??????,[4],[0],??????
//			case 21041 ://??????????????????,??????,??????,[4],[1],??????
//			case 21042 ://??????????????????,??????,??????,[4],[2],??????
//			case 21043 ://??????????????????,??????,??????,[4],[3],??????
//
//				if (buttonName.equals(ent)) {
//					battleLoop();
//				}
//				break;
		}
	}

	private void item() {

		System.out.println("");//////////////////////////////////////////
		System.out.println("Item() ?????????");//////////////////////////////
		System.out.println("");//////////////////////////////////////////

		buttonName = null;

		partySt();
		info(goldList(),itemList(),"");
		scene();
		menu(Item.menu());
		comment();

		change();
	}

	private void fieldItem(String setButtonName) {

		menu = Item.menu();
		Member user = Main.getHu();

		for (int i = 0; i < menu.length; i++) {

			if (setButtonName.equals(menu[i])) {
				setMode(211+i);
				Item.use(user, i);
				who();
			}
		}
		if (setButtonName.equals(cancel)) {
			setMode(200);
			Item.use(user, 10);
			itemLoop();
		}

	}

	private void battleItem(String setButtonName) {

		menu = Item.menu();
		Member user = Main.getParty()[Battle.getActor()];

		if (setButtonName.equals(menu[0])) {
			setMode(2101);
			Item.use(user, 0);
			menu = Main.getpNa();
			battle();
		}
		if (setButtonName.equals(menu[1])) {
			setMode(2102);
			Item.use(user, 1);
			menu = Battle.mNa();
			battle();
		}
		if (setButtonName.equals(menu[2])) {
			setMode(555);
			count = 0;
			Item.use(user, 2);
			battleLoop();
		}
		if (setButtonName.equals(menu[3])) {
			setMode(2104);
			Item.use(user, 3);
			menu = Main.getpNa();
			battle();
		}
		if (setButtonName.equals(cancel)) {
			setMode(555);
			count = 0;
			Item.use(user, 10);
			battleLoop();
		}

	}

	private void itemLoop() {

		System.out.println("");////////////////////////////////
		System.out.println("itemLoop() ?????????");///
		System.out.println("");////////////////////////////////

		String[] text = Item.getItemText();

		if (count < text.length) {

			setMessageEnt(text[count]);

			if (count == 0) {

			}

			count = (count + 1);

			item();

		} else {

			toNormal();
		}
	}


	private void itemMenu1(int who) {

		System.out.println("");////////////////////////////////
		System.out.println("itemMenu1(" + who + ") ?????????");///
		System.out.println("");////////////////////////////////

		String[] text = Item.getItemText();

		if (count < text.length) {

			setMessageEnt(text[count]);

			if (count == 0) {
				Item.who1(who);
			}

			count = (count + 1);

			item();

		} else {

			toNormal();

		}
	}

	private void battleItemMenu1(int who) {

		System.out.println("");////////////////////////////////
		System.out.println("itemMenu1(" + who + ") ?????????");///
		System.out.println("");////////////////////////////////

		String[] text = Item.getItemText();

		if (count < text.length) {

			setMessageEnt(text[count]);

			if (count == 0) {
				Item.who1(who);
			}

			count = (count + 1);

			battle();

		} else {

			if (Battle.getfMode() == 0) {
				toNormal();
			}else{
				count = 0;
//				setMode(50);
				Main.getBat().turn();
				menu = Battle.getMenu();
//				battle();
			}
		}
	}

	private void itemMenu4(int who) {
		// TODO ?????????????????????????????????????????????

		System.out.println("");////////////////////////////////
		System.out.println("itemMenu1(" + who + ") ?????????");///
		System.out.println("");////////////////////////////////

		String[] text = Item.getItemText();

		if (count < text.length) {

			setMessageEnt(text[count]);

			if (count == 0) {
				Item.who4(who);
			}

			count = (count + 1);

			item();

		} else {

			toNormal();

		}
	}

	public void actionPerformedSwitch22() {

		switch (mode) {

			case 22 ://??????,??????,?????????

				whoExField(buttonName);
				break;

			case 220 ://??????,??????,?????????

				count = 0;
				menu = useEx.menu();
				whatEx();
				break;

			case 2250 ://??????,??????,??????

				if (buttonName.equals(ent)&&mode<3000) {

					exLoop();
				}
				break;


			case 22501 ://??????,??????,heal(),?????????

				count = 0;

				menu = Main.getpNa();

				for (int i = 0; i < menu.length; i++) {

					if (buttonName.equals(menu[i])) {
						setMode(2250);
						useEx.heal(i);
						exLoop();
					}
				}
				break;

			case 22502 ://??????,??????,resu(),?????????

				count = 0;

				menu = Main.getpNa();

				for (int i = 0; i < menu.length; i++) {

					if (buttonName.equals(menu[i])) {
						setMode(2250);
						useEx.resu(i);
						exLoop();
					}
				}
				break;

			case 22503 ://??????,??????,death(),???????????????????????????

				count = 0;

				menu = Battle.mNa();

				for (int i = 0; i < Battle.getMons().length; i++) {

					if (buttonName.equals(Battle.getMons()[i].getName())) {
						setMode(2250);
						Magic.death(i);
						exLoop();
					}
				}
				break;
		}
	}

	private void ex() {
		// TODO ?????????????????????????????????????????????
		System.out.println("");//////////////////////////////////////////
		System.out.println("ex() ?????????");//////////////////////////////
		System.out.println("");//////////////////////////////////////////

		buttonName = null;

		menu = useEx.menu();

		partySt();
		info(goldList(),itemList(),exList());
		if(Battle.getfMode()==0){
			scene();
		}else{
			monster();
		}
		menu(menu);
		comment();

		change();
	}

	private void whoExField(String setButtonName) {

		System.out.println("");//////////////////////////////////////////
		System.out.println("whoExField(" + setButtonName + ") ?????????");//////////////////////////////
		System.out.println("");//////////////////////////////////////////

		Member[] party = Main.getParty();

		setMessage("??????????????????????????????");////////////////////????????????

		menu = Main.getpNa();



			if (setButtonName.equals(menu[0])) {
				useEx = new Power(party[0]);
				Main.ex(0);
				setMode(220);
				ex();
			}

			if (setButtonName.equals(menu[1])) {
				useEx = new Wonder(party[1]);
				Main.ex(1);
				setMode(220);
				ex();
			}

			if (setButtonName.equals(menu[2])) {
				useEx = new Bless(party[2]);
				Main.ex(2);
				setMode(220);
				ex();
			}

			if (setButtonName.equals(menu[3])) {
				useEx = new Magic(party[3]);
				Main.ex(3);
				setMode(220);
				ex();
			}

	}

	private void whoExBattle() {

		int actor = Battle.getActor();

		System.out.println("");//////////////////////////////////////////
		System.out.println("whoExBattle(" + actor + ") ?????????");//////////////////////////////
		System.out.println("");//////////////////////////////////////////

		Member[] party = Main.getParty();

		setMessage("??????????????????????????????");////////////////////????????????

		if (actor == 0) {
			useEx = new Power(party[0]);
		}
		if (actor == 1) {
			useEx = new Wonder(party[1]);
		}
		if (actor == 2) {
			useEx = new Bless(party[2]);
		}
		if (actor == 3) {
			useEx = new Magic(party[3]);
		}

		System.out.println("");//////////////////////////////////////////
		System.out.println("useEx = " + useEx.getClass() + " ??????");//////////////////////////////
		System.out.println("");//////////////////////////////////////////

		System.out.println("");//////////////////////////////////////////
		System.out.println("Ex.getName() = " + Ex.getName() + " ??????");//////////////////////////////
		System.out.println("");//////////////////////////////////////////

		party[actor].ex();
		setMode(220);
		menu = useEx.menu();
		battle();
	}

	private void whatEx() {

		menu = useEx.menu();

		for (int i = 0; i < menu.length; i++) {

			if (buttonName.equals(menu[i])) {
				setMode(2250);
				useEx.select(i);
				exLoop();
			}
		}
		if (buttonName.equals(cancel)) {
			setMode(2250);
			useEx.select(10);
			exLoop();
		}
	}

	private void exLoop() {

		System.out.println("");////////////////////////////////
		System.out.println("exLoop() ?????????");///
		System.out.println("");////////////////////////////////

		String[] text = useEx.getExText();

		System.out.println("");////////////////////////////////
		System.out.println("count =(" + count + ")");///
		System.out.println("");////////////////////////////////

		if (count < text.length) {

			if (count == 0) {

			}

			if (Battle.getfMode() == 0) {

				if (mode > 10000) {
					setMessage(text[count]);
					who();

				} else {

					setMessageEnt(text[count]);

					ex();

				}
			}else{
				if (mode > 10000) {

					setMessage(text[count]);

				} else {

					setMessageEnt(text[count]);

				}
				battleEx();
			}

			count = (count + 1);

		} else {

			if (Battle.getfMode() == 0) {
				toNormal();
			}else{
				count = 0;
//				setMode(50);
				Main.getBat().turn();
				menu = Battle.getMenu();
//				battle();
			}
		}
	}

	public void actionPerformedSwitch3() {

		Member user;
		switch (mode) {

			case 3 ://???
				count = 0;
				Main.action(3);
				setMessage("???????????????????????????????????????????????????????????????");
				menu = new Object[]{ "??????", "??????" };
				shop();
				setMode(33);

				break;

			case 33 ://???,???????????????
				count = 0;
				if(buttonName.equals(menu[0])){//??????
					setMode(30);
					Main.shop(0);
					setMessage("????????????????????????");
					menu = new Object[]{ "??????", "??????" };
					shop();
				}

				if(buttonName.equals(menu[1])){//??????
					setMode(31);
					Main.shop(1);
					setMessage("????????????????????????");
					menu = new Object[]{ "??????", "??????" };
					shop();
				}
				break;

			case 30 ://???,??????,????????????
				count = 0;
				if(buttonName.equals(menu[0])){
					setMode(300);
					Main.buy(0);
					setMessage("???????????????????????????");
					menu = Item.menu();
					shop();
				}

				if(buttonName.equals(menu[1])){
					setMode(301);
					Main.buy(1);
					setMessage("?????????????????????????????????");
					menu = Main.getpNa();
					shop();
				}
				break;

			case 31 ://???,??????,????????????
				count = 0;
				if(buttonName.equals(menu[0])){
					setMode(310);
					Main.sell(0);
					setMessage("???????????????????????????");
					menu = Item.menu();
					shop();
				}

				if(buttonName.equals(menu[1])){
					setMode(311);
					Main.sell(1);
					setMessage("?????????????????????????????????");
					menu = Main.getpNa();
					shop();
				}
				break;

			case 300 ://???,??????,??????,????????????

				count = 0;
				menu = Item.menu();
				user = Main.getHu();

				for (int i = 0; i < menu.length; i++) {
					if (buttonName.equals(menu[i])) {
						setMode(3000);
						Shop.buyItem(user, i);
						shopLoop();
					}
				}

				if (buttonName.equals(cancel)) {
					setMode(3000);
					Shop.buyWaponWhich(10);
					shopLoop();
				}
				break;

			case 3000 ://???,???????????????

				if (buttonName.equals(ent)) {
					shopLoop();
				}
				break;

			case 301 ://???,??????,??????,?????????
				count = 0;

				menu = Main.getpNa();

				for (int i = 0; i < menu.length; i++) {

					if (buttonName.equals(menu[i])) {
						setMode(3010);
						Shop.buyWapon(i);
						shopWapon(i);
					}
				}
				break;

			case 3010 ://???,??????,??????,????????????

				count = 0;

				for (int i = 0; i < menu.length; i++) {
					if (buttonName.equals(menu[i])) {
						setMode(3000);
						Shop.buyWaponWhich(i + 1);
						shopLoop();
					}
				}

				if (buttonName.equals(cancel)) {
					setMode(3000);
					Shop.buyWaponWhich(10);
					shopLoop();
				}
				break;

			case 310 ://???,??????,??????

				count = 0;
				menu = Item.menu();
				user = Main.getHu();

				for (int i = 0; i < menu.length; i++) {

					if (buttonName.equals(menu[i])) {
						setMode(3000);
						Shop.sellItem(user, i);
						shopLoop();
					}
				}
				break;
		}
	}

	private void shop() {
			// TODO ?????????????????????????????????????????????

	//		setMode(3);/////////////////////////////////// ?

			System.out.println("");//////////////////////////////////////////
			System.out.println("shop() ?????????");//////////////////////////////
			System.out.println("");//////////////////////////////////////////

			buttonName = null;

			partySt();
			info(goldList(),itemList(),shopList());
			scene();
			menu(menu);
			comment();

			change();

		}

	private void shopWapon(int i) {
		// TODO ?????????????????????????????????????????????

//		setMode(3);/////////////////////////////////// ?

		System.out.println("");//////////////////////////////////////////
		System.out.println("shop() ?????????");//////////////////////////////
		System.out.println("");//////////////////////////////////////////

		buttonName = null;

		partySt();
		info(goldList(),itemList(),shopWaponList(i));
		scene();
		menu(menu);
		comment();

		change();

	}

	private void shopLoop() {

		System.out.println("");/////////////////////////////
		System.out.println("buttonName = " + buttonName);///
		System.out.println("");/////////////////////////////

		String[] text = Shop.getShopText();

		if (count < text.length) {

			setMessageEnt(text[count]);

			if (count == 0) {

			}

			count = (count + 1);

			shop();

		} else {

			toNormal();

		}
	}

	public void actionPerformedSwitch4() {

		switch (mode) {

			case 4 ://??????
				count = 0;
				menu = new Object[]{ "??????", "?????????", "????????????", "???????????????" };

				if (buttonName.equals(menu[0])) {
					setMode(41);
					innMenu1();
				}
				if (buttonName.equals(menu[1])) {
					setMode(42);
					innMenu2();
				}
				if (buttonName.equals(menu[2])) {
					setMode(43);
					innMenu3();
				}
				if (buttonName.equals(menu[3])) {
					setMode(44);
					setMessage( "??????????????????????????????" );
					who();
				}
				break;

			case 41 ://
				if (buttonName.equals(ent)) {
					innMenu1();
				}
				break;

			case 42 ://
				if (buttonName.equals(ent)) {
					innMenu2();
				}
				break;

			case 43 ://????????????
				if (buttonName.equals(ent)) {
					innMenu3();
				}
				break;

			case 431 ://??????
				if(buttonName.equals(ent)){
					setMessageEnt(Main.getName() + "???????????????????????????");
					innMenu0();
				}
				break;

			case 44 ://???????????????,?????????
				count = 0;
				menu = Main.getpNa();

				if (buttonName.equals(menu[0])) {
					setMode(440);
					Main.revive(0);
					fieldMenu(menu);
				}

				if (buttonName.equals(menu[1])) {
					setMode(441);
					Main.revive(1);
					fieldMenu(menu);
				}

				if (buttonName.equals(menu[2])) {
					setMode(442);
					Main.revive(2);
					fieldMenu(menu);
				}

				if (buttonName.equals(menu[3])) {
					setMode(443);
					Main.revive(3);
					fieldMenu(menu);
				}
				break;

			case 440 ://???????????????,[0]???,??????
			case 441 ://???????????????,[1]???,??????
			case 442 ://???????????????,[2]???,??????
			case 443 ://???????????????,[3]???,??????
			case 445 ://???????????????,[??????],??????

				if (buttonName.equals(ent)) {
					innMenu4();
				}
				break;

			case 444 ://???????????????,?????????

				if (buttonName.equals(ent)) {
					toNormal();
				}
				break;

			case 4444 ://???????????????,???????????????
				count = 0;
				menu = new String[]{"??????","?????????"};

				if (buttonName.equals(menu[0])) {
					buttonName = null;
					Main.reviveYes(1);
					innMenu4();
				}

				if (buttonName.equals(menu[1])) {
					buttonName = null;
					innMenu4();
				}

				if (buttonName.equals(ent)) {
					buttonName = null;
					innMenu4();
				}

		}
	}

	private void inn() {

		System.out.println("");//////////////////////////////////////////
		System.out.println("inn() ?????????");//////////////////////////////
		System.out.println("");//////////////////////////////////////////

		buttonName = null;

		partySt();
		info(goldList(),itemList(),"");
		scene();
		Object[] innMenu = new Object[]{ "??????", "?????????", "????????????", "???????????????" };
		menu(innMenu);
		comment();

		change();

	}

	private void status() {
		System.out.println("");//////////////////////////////////////////
		System.out.println("status() ?????????");//////////////////////////////
		System.out.println("");//////////////////////////////////////////

		buttonName = null;

		Status.statusModel();

		partyStAll();
		info(goldList(),itemList(),"");
		sceneBlank();
		Object[] innMenu = new Object[]{ "??????", "?????????", "????????????", "???????????????" };
		menu(innMenu);

		setMessageEnt("??? ?????????");
		comment();

		change();

	}

	private void innMenu0() {

		System.out.println("");////////////////////////////////////////////////
		System.out.println("innMenu0() ?????????  buttonName = " + buttonName);///
		System.out.println("");////////////////////////////////////////////////

		if (count == 0) {
			count = (count + 1);
			inn();

		} else {

			toNormal();
		}
	}

	private void innMenu1() {

		System.out.println("");////////////////////////////////////////////////
		System.out.println("innMenu1() ?????????  buttonName = " + buttonName);///
		System.out.println("");////////////////////////////////////////////////

		String[] text = Main.innText;

		if (count < text.length) {
			setMessageEnt(text[count]);

			if (count == 1) {
				Main.innMenu(1);
			}

			count = (count + 1);

			inn();

		} else {

			toNormal();

		}
	}

	private void innMenu2() {

		System.out.println("");////////////////////////////////////////////////
		System.out.println("innMenu2() ?????????  buttonName = " + buttonName);///
		System.out.println("");////////////////////////////////////////////////

		count = 0;

		setMode(444);

		Main.innMenu(0);

		inn();
	}

	private void innMenu3() {

		System.out.println("");////////////////////////////////////////////////
		System.out.println("innMenu3() ?????????  buttonName = " + buttonName);///
		System.out.println("");////////////////////////////////////////////////

		setMode(431);
		status();
		count = 0;
	}

	private void innMenu4() {

		System.out.println("");///////////////////////////////
		System.out.println("innMenu4() ?????????");///
		System.out.println("");///////////////////////////////

		if (count == 0) {

		}

		String[] text = Main.getText();

		if (count < text.length) {

			setMessageEnt(text[count]);

			count = (count + 1);

			inn();

		} else {

			count = 0;

			setMode(444);

			Main.innMenu(0);

			inn();
		}
	}


	public void actionPerformedSwitch5() {

		switch (mode) {

			case 5 ://??????

					buttonName = null;
					menu = Battle.getMenu();
					Main.battle();
					count = 0;
				break;

			case 50 ://??????,????????????

				setMessage(Battle.getBattleText()[0]);
				menu = Battle.getMenu();
				setMode(55);
				battle();

				break;

			case 55 ://??????,????????????,???????????????

				count = 0;

				menu = Battle.getMenu();

				if (menu[0].equals(buttonName)) {//??????
					Main.getBat().pSelect(0);
					setMode(550);
					setMessage(Battle.getBattleText()[0]);
					attack();
				}
				if (menu[1].equals(buttonName)) {//??????
					Main.getBat().pSelect(1);
					setMode(551);
				}
				if (menu[2].equals(buttonName)) {//??????
					Main.getBat().pSelect(2);
					setMode(552);
					whoExBattle();
					menu = useEx.menu();
					battleEx();
				}
				if (menu[3].equals(buttonName)) {//?????????
					Main.getBat().pSelect(3);
					setMode(553);
					battleLoop();
				}
				if (cancel.equals(buttonName)) {//???????????????
					Main.getBat().pSelect(10);
					setMode(555);
					battleLoop();
				}
				break;

			case 550 ://??????,????????????,??????

				count = 0;

//				buttonName = null;

				Monster[] mons = Battle.mons;

				for (int i = 0; i < mons.length; i++) {

					if (buttonName.equals(mons[i].getName())){
						setMode(555);
						Main.getBat().attack(i);
						battleLoop();
					}
				}
				if (buttonName.equals(cancel)){
					setMode(555);
					Main.getBat().attack(10);
					battleLoop();
				}
				break;

//			case 5500 ://??????,????????????,??????,0
//			case 5501 ://??????,????????????,??????,1
//			case 5502 ://??????,????????????,??????,2
//			case 5503 ://??????,????????????,??????,3
//
////				buttonName = null;
//
//				if (buttonName.equals(ent)) {
//
//					battleLoop();
//				}
//
//				break;

			case 551 ://??????,????????????,??????

				buttonName = null;

				setMessage("???????????????????????????????????????");

				menu = Item.menu();

				battle();

				setMode(21);

				break;

			case 552 ://??????,????????????,??????

//				buttonName = null;

				if (buttonName.equals(ent)) {

					battleLoop();
				}

				break;

			case 553 ://??????,????????????,?????????

//				buttonName = null;

				if (buttonName.equals(ent)) {

					battleLoop();
				}

				break;

			case 555 ://??????,??????

				if (buttonName.equals(ent)) {

					battleLoop();
				}

				break;

			case 5555 ://?????????

				count = 0;
				setMode(55551);
				Battle.exp();
				expLoop();
				break;

			case 55551 ://?????????,EXP

				if (buttonName.equals(ent)) {

					expLoop();
				}
				break;

			case 55552 ://?????????,LEV

				if (buttonName.equals(ent)) {

					levLoop();
				}
				break;

			case 55553 ://?????????,GOLD

				if (buttonName.equals(ent)) {

					goldLoop();
				}
				break;

			case 55554 ://?????????,ITEM

				if (buttonName.equals(ent)) {

					getItemLoop();
					Battle.setItem(1);
				}
				break;

			case 55555 ://?????????,ITEM,??????

				if (buttonName.equals(ent)) {

					getItemLoop();
					Battle.setItem(2);
				}
				break;
		}
	}

	private void battle() {

		System.out.println("");//////////////////////////////////////////
		System.out.println("battle() ?????????");//////////////////////////////
		System.out.println("");//////////////////////////////////////////

		buttonName = null;

		partySt();
		info(goldList(),itemList(),"");
		monster();
		menu(menu);
		comment();

		change();
	}

	private void battleEx() {

		System.out.println("");//////////////////////////////////////////
		System.out.println("battle() ?????????");//////////////////////////////
		System.out.println("");//////////////////////////////////////////

		buttonName = null;

		partySt();
		info(goldList(),itemList(),exList());
		monster();
		menu(menu);
		comment();

		change();
	}

	private void battleLoop() {

		System.out.println("");///////////////////
		System.out.println("battleLoop() ?????????" );///
		System.out.println("");///////////////////

		System.out.println("");///////////////////
		System.out.println("count = " + count);///
		System.out.println("");///////////////////

		String[] text = Battle.getBattleText();

		if (count < text.length) {

			setMessageEnt(text[count]);

			if (count == 0) {

			}

			count = (count + 1);

			battle();

		} else {
			if(Battle.getfMode() == 0){
				toNormal();
			}else{
				count = 0;
//				setMode(50);
				Main.getBat().turn();
				menu = Battle.getMenu();
//				battle();
			}
		}
	}

	private void expLoop() {

		System.out.println("");///////////////////
		System.out.println("expLoop() ?????????");///
		System.out.println("");///////////////////

		System.out.println("");///////////////////
		System.out.println("count = " + count);///
		System.out.println("");///////////////////


		String[] text = Battle.getBattleText();

		if (count < text.length) {
			setMessageEnt(text[count]);
			count++;
			battle();

		} else {
			if (Battle.getfMode() == 0) {
				toNormal();
			} else {
				count = 0;
				setMode(55553);
				Battle.gold();
			}
		}
	}

	private void levLoop() {

		System.out.println("");///////////////////
		System.out.println("levLoop() ?????????");///
		System.out.println("");///////////////////

		System.out.println("");///////////////////
		System.out.println("count = " + count);///
		System.out.println("");///////////////////

		String[] text = Battle.getBattleText();

		if (count < 5) {

//			Battle.lev(count-1);

			setMessageEnt(text[0]);

			battle();

		} else {
			if (Battle.getfMode() == 0) {
				toNormal();
			} else {
				count = 0;
				setMode(55553);
				Battle.gold();
			}
		}
	}

	private void goldLoop() {

		System.out.println("");///////////////////
		System.out.println("goldLoop() ?????????");///
		System.out.println("");///////////////////

		System.out.println("");///////////////////
		System.out.println("count = " + count);///
		System.out.println("");///////////////////

		String[] text = Battle.getBattleText();

		if (count < text.length) {

			setMessageEnt(text[count]);

			if (count == 0) {

			}

			count = (count + 1);

			battle();

		} else {
			if (Battle.getfMode() == 0) {
				toNormal();
			} else {
				count = 0;
				setMode(55554);
				Battle.item();
			}
		}
	}

	private void getItemLoop() {

		System.out.println("");///////////////////
		System.out.println("getItemLoop() ?????????");///
		System.out.println("");///////////////////

		System.out.println("");///////////////////
		System.out.println("count = " + count);///
		System.out.println("");///////////////////

		String[] text = Battle.getBattleText();

		if (count < text.length) {

			setMessageEnt(text[count]);

			if (count == 0) {

			}

			count = (count + 1);

			battle();

		} else {
			if (Battle.getfMode() == 0) {
				toNormal();
			} else {
				toNormal();
				System.out.println("");//////////////////////////////////////////
				System.out.println("?????????????????????????????????");//////////////////////////////
				System.out.println("");//////////////////////////////////////////
			}
		}
	}


	private void who() {

		System.out.println("");//////////////////////////////////////////
		System.out.println("who() ?????????");//////////////////////////////
		System.out.println("");//////////////////////////////////////////

		buttonName = null;

		partySt();
		info(goldList(),itemList(),"");
		scene();
		menu(Main.getpNa());
		comment();

		change();
	}



	private void attack() {

		System.out.println("");//////////////////////////////////////////
		System.out.println("attack() ?????????");//////////////////////////////
		System.out.println("");//////////////////////////////////////////

		buttonName = null;

		partySt();
		info(goldList(),itemList(),"");
		monster();
		menu(Battle.mNa());
		comment();

		change();
	}

	private void toNormal() {
		setMode(1);/////////////////////////////////////??????????????????
		Main.save();
		setMessage("???????????????????");
		field();
	}

	private void printMode() {

		System.out.println("");//////////////////////////////////////////
		System.out.println("mode = " + getMode() + " ??????");//////////////////
		System.out.println("");//////////////////////////////////////////
	}

	private void partyStAll() {
		JTable pTab = new JTable();
		format(pTab);
		Status tableModel = new Status();
		pTab.setModel(tableModel);
		pTab.setAutoCreateRowSorter(true);
		pTab.setRowHeight(30);
		pTab.setShowVerticalLines(true);// ??????
		pTab.setShowHorizontalLines(false);// ??????
		pTab.setPreferredSize(new Dimension(890, 280));
		pTab.setBorder(border());

		DefaultTableCellRenderer tableCellRendererC = new DefaultTableCellRenderer();
		tableCellRendererC.setHorizontalAlignment(JLabel.CENTER);

		TableColumn[] name = new TableColumn[pTab.getColumnModel().getColumnCount()];

		for (int i = 0; i < name.length; i++) {
			name[i] = pTab.getColumnModel().getColumn(i);
			name[i].setCellRenderer(tableCellRendererC);
		}

		format(pTab.getTableHeader(), 30, 30);
		pTab.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

		JPanel panel = panelSetUD(pTab.getTableHeader(), pTab);
		format(panel);
		panel.setBorder(border());

		panelN = panelSetWCE(null, panel, null);


	}

	private void partySt() {
		JTable pTab = new JTable();
		format(pTab);
		Main tableModel1 = Main.mai;
		pTab.setModel(tableModel1);
//		pTab.setAutoCreateRowSorter(true);
		pTab.setRowHeight(fontSize * 2);
		pTab.setShowVerticalLines(true);// ??????
		pTab.setShowHorizontalLines(false);// ??????
		pTab.setPreferredSize(new Dimension(w*70, h*6));
		pTab.setBorder(border());

		DefaultTableCellRenderer tableCellRendererC = new DefaultTableCellRenderer();
		tableCellRendererC.setHorizontalAlignment(JLabel.CENTER);

		TableColumn[] name = new TableColumn[pTab.getColumnModel().getColumnCount()];

		for (int i = 0; i < name.length; i++) {
			name[i] = pTab.getColumnModel().getColumn(i);
			name[i].setCellRenderer(tableCellRendererC);
		}

		format(pTab.getTableHeader());
		pTab.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

		JPanel panel = panelSetUD(pTab.getTableHeader(), pTab);
		format(panel);
		panel.setBorder(border());

		panelN = panelSetWCE(null, panel, null);

	}

	private void partyStBlank() {

		JTextArea partyStBlank = textAreaSet(" ", 5, 10);
		panelN = panelSetNCS(null, partyStBlank, null);
	}

	private void monster() {
		JTable pTab = new JTable();
		format(pTab);
		Battle tableModel1 = Main.getBat();
		pTab.setModel(tableModel1);
//		pTab.setAutoCreateRowSorter(true);
		pTab.setRowHeight(fontSize * 2);
		pTab.setShowVerticalLines(true);// ??????
		pTab.setShowHorizontalLines(false);// ??????
		pTab.setPreferredSize(new Dimension(w*70, h*6));
		pTab.setBorder(border());

		DefaultTableCellRenderer tableCellRendererC = new DefaultTableCellRenderer();
		tableCellRendererC.setHorizontalAlignment(JLabel.CENTER);

		TableColumn[] name = new TableColumn[pTab.getColumnModel().getColumnCount()];

		for (int i = 0; i < name.length; i++) {
			name[i] = pTab.getColumnModel().getColumn(i);
			name[i].setCellRenderer(tableCellRendererC);
		}

		format(pTab.getTableHeader());
		pTab.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

		JPanel stPanel = panelSetUD(pTab.getTableHeader(), pTab);
		format(stPanel);
		stPanel.setBorder(border());

		setBackPanel("?????????.png");

		ImageIcon icon0 = new ImageIcon(drawMonster(0));
		JLabel label0 = new JLabel(icon0);

		ImageIcon icon1 = new ImageIcon(drawMonster(1));
		JLabel label1 = new JLabel(icon1);

		ImageIcon icon2 = new ImageIcon(drawMonster(2));
		JLabel label2 = new JLabel(icon2);

		ImageIcon icon3 = new ImageIcon(drawMonster(3));
		JLabel label3 = new JLabel(icon3);

		ImageIcon iconItem = new ImageIcon(drawItem());
		JLabel labelItem = new JLabel(iconItem);

		JPanel monsterPanel = new JPanel();
		format(monsterPanel);
		monsterPanel.setOpaque(false);///////////////????????????????????????
//		monsterPanel.setPreferredSize(new Dimension(900, 200));
		int m = Battle.mNumber();
		if (m < 1){/////////////////////////////////////////////////??????????????????
			monsterPanel.setLayout(new GridLayout(0, 1, 0, 0));
			monsterPanel.add(labelItem);
		} else {////////////////////////////////////////////////////??????????????????
			monsterPanel.setLayout(new GridLayout(0, m, 0, 0));
			if (Battle.mons[0].getHp() > 0) monsterPanel.add(label0);
			if (Battle.mons[1].getHp() > 0) monsterPanel.add(label1);
			if (Battle.mons[2].getHp() > 0) monsterPanel.add(label2);
			if (Battle.mons[3].getHp() > 0) monsterPanel.add(label3);
		}

		JPanel battlePanel = new JPanel();
		format(battlePanel);
		battlePanel.setPreferredSize(new Dimension(890, 200));
		SpringLayout layout = new SpringLayout();
		battlePanel.setLayout(layout);
		layout.putConstraint(SpringLayout.NORTH, backPanel, 1, SpringLayout.NORTH, battlePanel);
		layout.putConstraint(SpringLayout.NORTH, monsterPanel, 1, SpringLayout.NORTH, battlePanel);
		layout.putConstraint(SpringLayout.WEST, backPanel, 5, SpringLayout.WEST, battlePanel);
		layout.putConstraint(SpringLayout.WEST, monsterPanel, 5, SpringLayout.WEST, battlePanel);
		layout.putConstraint(SpringLayout.EAST, backPanel, 5, SpringLayout.EAST, battlePanel);
		layout.putConstraint(SpringLayout.EAST, monsterPanel, 5, SpringLayout.EAST, battlePanel);
		battlePanel.add(monsterPanel);
		battlePanel.add(backPanel);

		JTextArea monsterBlank = textAreaSet(" ", 1, 10);

		panelC = panelSetNCS(battlePanel, stPanel,monsterBlank);

	}

	private JPanel setBackPanel(String backURL) {

		ImageIcon iconBack = new ImageIcon(backURL);
		JLabel labelBack = new JLabel(iconBack);

		backPanel = new JPanel();
		format(backPanel);
		backPanel.add(labelBack);
//		backPanel.setPreferredSize(new Dimension(900, 200));

		return backPanel;
	}

	private String drawMonster(int number) {

		Monster monster = Battle.mons[number];

		String drawMonster = null;

		switch (monster.getCode()) {
			case 0 :
				if(monster.getHp() < 1){
					drawMonster = "?????????";
				}else{
					drawMonster = "?????????";
				}
				break;

			case 1 :
				drawMonster = "????????????";
				break;

			case 2 :
				drawMonster = "?????????????????????";
				break;

			case 3 :
				drawMonster = "????????????";
				break;

			case 4 :
				drawMonster = "???????????????";
				break;

			case 5 :
				drawMonster = "??????";
				break;

			default :
				break;
		}

		return drawMonster + ".png";
	}

	private String drawItem() {

		String drawItem = null;

		switch (Battle.getItem()) {
			case 0 :
				drawItem = "?????????";
				break;

			case 1 :
				drawItem = "??????";
				break;

			case 2 :
				drawItem = "??????????????????";
				break;

			case 3 :
				drawItem = (String) Item.menu()[0];
				break;

			case 4 :
				drawItem = (String) Item.menu()[1];
				break;

			case 5 :
				drawItem = (String) Item.menu()[2];
				break;

			case 6 :
				drawItem = (String) Item.menu()[3];
				break;

			case 7 :
				drawItem = "???";
				break;

			case 8 :
				drawItem = "???";
				break;

			case 9 :
				drawItem = "???";
				break;

			case 10 :
				drawItem = "???";
				break;

			default :
				drawItem = "?????????";
				break;
		}

		return drawItem + ".png";
	}

	void prologue() {

		System.out.println("");//////////////////////////////////////////
		System.out.println("prologue() ?????????");/////////////////////////
		System.out.println("");//////////////////////////////////////////

		buttonName = null;

		partyStBlank();
		info(goldList(),"","");
		scene();
		menu(Command.menu());
		comment();

		change();
	}

	private void castle() {

		System.out.println("");//////////////////////////////////////////
		System.out.println("field() ?????????");////////////////////////////
		System.out.println("");//////////////////////////////////////////

		setMode(0);/////////////////////////////////// ?

		buttonName = null;

		partySt();
		info(goldList(),itemList(),"");
		scene();
		menu(Command.menu());
		comment();

		change();
	}

	private JPanel goldList() {
		return infoTable(new Gold(),"?????????");
	}

	private JPanel itemList() {
		return infoTable(new Item(),"????????????");
	}

	private JPanel exList() {
		return infoTable(useEx,"?????? MP");
	}

	private JPanel shopList() {
		return infoTable(new Shop(),"??????");
	}

	private JPanel shopWaponList(int who) {
		return infoTable(new Wapon(who),"????????????");
	}

	private JPanel infoTable(Object setTableModel,String tableName) {

		JTable pTab = new JTable();
		format(pTab);
		pTab.setModel((TableModel) setTableModel);
		pTab.setAutoCreateRowSorter(true);
		pTab.setRowHeight(fontSize * 2);
		pTab.setShowVerticalLines(false);// ??????
		pTab.setShowHorizontalLines(false);// ??????
		pTab.setPreferredSize(new Dimension(w*25, pTab.getRowCount() * fontSize));

		DefaultTableCellRenderer tableCellRendererC = new DefaultTableCellRenderer();
		tableCellRendererC.setHorizontalAlignment(JLabel.LEFT);

		TableColumn[] name = new TableColumn[pTab.getColumnModel().getColumnCount()];

		for (int i = 0; i < name.length; i++) {
			name[i] = pTab.getColumnModel().getColumn(i);
			name[i].setCellRenderer(tableCellRendererC);
		}

		JLabel tName = labelSet(tableName);

		JPanel panelT = panelSetLR(b(), pTab);
		panelT.setBorder(border());

		JPanel panel = panelSetUD(tName, panelT);
		format(panel);
		panel.setBorder(border());
		panel.setPreferredSize(new Dimension(w*13, (pTab.getRowCount()+1) * fontSize * 2 - 4));

		return panel;

	}

	private JPanel infoTable(Object setTableModel) {
		return infoTable(setTableModel,"");
	}

	private void info(Object top, Object middle, Object bottom) {

		if (top.equals("")) top = null;
		if (middle.equals("")) middle = null;
		if (bottom.equals("")) bottom = null;

		JPanel infoPanel = panelSetTMB(top, middle, bottom);
		format(infoPanel);
		infoPanel.setPreferredSize(new Dimension(w*13, h*80));
		panelW = panelSetNCS(infoPanel, null, null);

	}


	private JPanel ent() {

		int bI = 1;// //////////////////////////////////???????????????

		JPanel panel = new JPanel();
		format(panel);
		// panel.setSize(300, 300);
		panel.setLayout(new GridLayout(bI, 0, 10, 1));
		LineBorder b = new LineBorder(getForeground(), 2, true);
		panel.setBorder(b);

		JButton[] button = new JButton[bI];

		String[] bList = { ent };

		System.out.println("");//////////////////////////////////////////
		System.out.println("bList[0] = " + bList[0]);////////////////////////////
		System.out.println("");//////////////////////////////////////////

		for (int i = 0; i < bI; i++) {
			String bN = (String) bList[i];
			button[i] = new JButton(bN);
			format(button[i]);
			// button[i].setSize(100, 50);
			button[i].setFocusPainted(false);
			button[i].addActionListener(this);
			button[i].addKeyListener(this);
			panel.add(button[i]);
		}
		return panel;
	}

	private void scene() {

		setBackPanel("???????????????.png");

		setEventPanel(eventImage());

		JPanel fieldPanel = new JPanel();
		format(fieldPanel);
		fieldPanel.setPreferredSize(new Dimension(890, 200));
		SpringLayout layout = new SpringLayout();
		fieldPanel.setLayout(layout);
		layout.putConstraint(SpringLayout.NORTH, backPanel, 1, SpringLayout.NORTH, fieldPanel);
		layout.putConstraint(SpringLayout.NORTH, eventPanel, 1, SpringLayout.NORTH, fieldPanel);
		layout.putConstraint(SpringLayout.WEST, backPanel, 0, SpringLayout.WEST, fieldPanel);
		layout.putConstraint(SpringLayout.WEST, eventPanel, 0, SpringLayout.WEST, fieldPanel);
		layout.putConstraint(SpringLayout.EAST, backPanel, 0, SpringLayout.EAST, fieldPanel);
		layout.putConstraint(SpringLayout.EAST, eventPanel, 0, SpringLayout.EAST, fieldPanel);
		fieldPanel.add(eventPanel);
		fieldPanel.add(backPanel);

		JPanel scene = panelSetNCS(null, fieldPanel,null);
		scene.setPreferredSize(new Dimension(890, 300));
		scene.setForeground(Color.BLACK);
		scene.setBackground(Color.GRAY);
		scene.setBorder(border());

		panelC = panelSetNCS(pictAreaB(), scene,pictAreaB());

	}

	private String eventImage() {
		// TODO ?????????????????????????????????????????????
		String fileName = "";

		imageCode = mode;

		imageCodeOmit(3);

		imageCodeOmit(4);

		switch (imageCode) {
			case 11 :
				fileName = "????????????";//?????????
				break;

			case 12 :
				fileName = "?????????????????????";//??????
				break;

			case 15 :
				fileName = "??????";//??????
				break;

			case 3 :
			case 33 :
			case 30 :
			case 31 :
			case 310 :
			case 3100 :
			case 3101 :
			case 3102 :
			case 3103 :
				fileName = "??????";//??????
				break;

			case 4 :
			case 41 :
			case 42 :
			case 43 :
			case 431 :
			case 44 :
			case 4444 :
				fileName = "?????????????????????";//??????
				break;

			default :
				fileName = "?????????";
				break;
		}
		return fileName + ".png";
	}

	private void imageCodeOmit(int i) {

		if (i * 10 <= mode && mode < (i + 1) * 10) imageCode = i;
		if (i * 100 <= mode && mode < (i + 1) * 100) imageCode = i;
		if (i * 1000 <= mode && mode < (i + 1) * 1000) imageCode = i;
		if (i * 10000 <= mode && mode < (i + 1) * 10000) imageCode = i;
	}

	private JPanel setEventPanel(String eventURL) {

		ImageIcon eventIcon = new ImageIcon(eventURL);
		JLabel label = new JLabel(eventIcon);

		eventPanel = new JPanel();
		format(eventPanel);
		eventPanel.setOpaque(false);///////////////????????????????????????
		eventPanel.add(label);

		return eventPanel;
	}

	private void sceneBlank() {
		pict = textAreaSet("",7,1);

		pict.setOpaque(true);

		panelC = panelSetNCS(null, pict,null);

	}

	private Object pictAreaB() {
		pictAreaB = textAreaSet("",1,4);
		pictAreaB.setFont(new Font("Monospaced", Font.BOLD, 16));
		return pictAreaB;
	}

	private void comment() {

		sto = new Story();

		JTable st = new JTable();
		Story tableModel2 = sto;
		st.setAutoCreateRowSorter(true);
		st.setModel(tableModel2);

		DefaultTableCellRenderer tableCellRendererC = new DefaultTableCellRenderer();
		tableCellRendererC.setHorizontalAlignment(JLabel.CENTER);

		TableColumn col = st.getColumnModel().getColumn(0);
		col.setCellRenderer(tableCellRendererC);
		format(st);
		st.setRowHeight(fontSize*2);
		st.setShowVerticalLines(false);// ??????
		st.setShowHorizontalLines(false);// ??????
		st.setPreferredSize(new Dimension(w*70, h*20));
		format(st.getTableHeader());
		st.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

		JPanel panel = new JPanel();
		format(panel);
		panel.setLayout(new BorderLayout());
		panel.setBorder(border());
		panel.add(st, BorderLayout.CENTER);

		panelS= panelSetWCE(null, panel, ent());

	}

	public void keyTyped(KeyEvent e) {
		// clickButton(String.valueOf(e.getKeyChar()));
	}

	public void keyPressed(KeyEvent e) {
		// if (e.getKeyCode() == KeyEvent.VK_ENTER )
		// Money.getMon().job(Money.menu[ 0 ]);
		// if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
		// Money.getMon().job(Money.menu[ 1 ]);
		// if (e.getKeyCode() == KeyEvent.VK_DELETE )
		// Money.getMon().job(Money.menu[ 2 ]);
		// if (e.getKeyCode() == KeyEvent.VK_ESCAPE )
		// Money.getMon().job(Money.menu[ 3 ]);
		// if (e.getKeyCode() == KeyEvent.VK_SPACE )
		// Money.getMon().job(Money.menu[ 4 ]);

		// blank = Money.getMon().data.length;
		// table.setRowSelectionInterval(0, blank-1);
		// table.setRowSelectionInterval(blank, blank);
	}

	public void keyReleased(KeyEvent e) {
	}

	private void clickButton(String s) {// /////////////
	// for (int i = 0; i < 5; i++) {
	// if (s.equals(Money.menu[i]))
	// button[1].doClick(100);
	// }
	}

	public static String inpDS(String s) {
		UIManager.put("OptionPane.okButtonText", "OK");
		UIManager.put("OptionPane.cancelButtonText", "Cancel");
		do {
			value = JOptionPane.showInputDialog(s);
			if (value == null) {// Cancel???????????????????????????
				display.setText("????????????????????????");
				break;
			}
		} while (value.equals(null));
		if (value.equals("")) {
		} else {
			display.setText(value + " ");
		}
		return value;
	}

	public static int inpDI(String s) {
		UIManager.put("OptionPane.okButtonText", "OK");
		UIManager.put("OptionPane.cancelButtonText", "Cancel");
		do {
			value = JOptionPane.showInputDialog(s);
			if (value == null) {// Cancel???????????????????????????
				display.setText("????????????????????????");
				break;
			}
		} while (value.equals(null));
		if (value.equals("")) {
			display.setText("????????????????????????????????????");
			inpDI(s);
		} else {
			display.setText(value + " ");
		}
		int r = Integer.parseInt(value);
		return r;
	}

	public static void setFrame(JFrame frame) {
		Screen.frame = frame;
	}

	public JFrame getFrame() {
		return frame;
	}

	public static void rem() {
		// Money tableModel = Money.getMon();
		// Table.win.table.setModel(tableModel);
		// table.setRowSelectionInterval(0, Money.data.length - 1);
		// table.revalidate();
	}

	public static void setTex(String text) {
		tex = text;
	}

	public String getTex() {
		return tex;
	}

	public static void setMessage(String text) {

		ent = " ??? ";

		story = new Story();

		story.on(text);
	}

	public static void setMessageEnt(String text) {

		ent = entMark;

		story = new Story();

		story.on(text + "     next" + ent);
	}

	public String getMessage() {
		return message;
	}

	public static void setMode(int mode) {

		System.out.println("");//////////////////////////////////////////
		System.out.println("Screen.setMode(" + mode +") ?????????");////////
		System.out.println("");//////////////////////////////////////////

		Screen.mode = mode;
	}

	public static int getMode() {
		return mode;
	}

	public static void setMenu(Object[] menu) {
		Screen.menu = menu;
	}

	public Object[] getMenu() {
		return menu;
	}

	public static void setCount(int count) {
		Screen.count = count;
	}

	public static int getCount() {
		return count;
	}

	public void setEnt(String ent) {
		Screen.ent = ent;
	}

	public static String getEnt() {
		return ent;
	}
}
