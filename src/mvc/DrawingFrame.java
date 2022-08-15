package mvc;

import geometry.Point;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class DrawingFrame extends JFrame implements ActionListener {

	
	private static final long serialVersionUID = 1L;
	private DrawingController controller;
	private DrawingView view;

	private final ButtonGroup tools = new ButtonGroup();
	private final ButtonGroup colors = new ButtonGroup();

	public Color innerColor = Color.RED;
	public Color outerColor = Color.BLACK;
	public Point startPoint = null;

	ImageIcon iconUndo = new ImageIcon("C:\\Users\\ACER\\git\\do-marija555\\DizajnerskiObrasci\\src\\resources\\iconUndo.png");
	ImageIcon iconRedo = new ImageIcon("C:\\Users\\ACER\\git\\do-marija555\\DizajnerskiObrasci\\src\\resources\\iconRedo.png");
	ImageIcon iconSelect = new ImageIcon("C:\\Users\\ACER\\git\\do-marija555\\DizajnerskiObrasci\\src\\resources\\iconSelect.png");
	ImageIcon iconModify = new ImageIcon("C:\\Users\\ACER\\git\\do-marija555\\DizajnerskiObrasci\\src\\resources\\iconModify.png");
	ImageIcon iconDelete = new ImageIcon("C:\\Users\\ACER\\git\\do-marija555\\DizajnerskiObrasci\\src\\resources\\iconDelete.png");
	ImageIcon iconNext = new ImageIcon("C:\\Users\\ACER\\git\\do-marija555\\DizajnerskiObrasci\\src\\resources\\iconNext.png");
	
	private final JPanel leftPanel = new JPanel();
	private final JPanel topPanel = new JPanel();
	private final JPanel rightPanel = new JPanel();

	private final JToggleButton btnSelect = new JToggleButton();
	private final JButton btnModify = new JButton();
	private final JButton btnDelete = new JButton();
	private final JToggleButton btnPoint = new JToggleButton("Point");
	private final JToggleButton btnLine = new JToggleButton("Line");
	private final JToggleButton btnRectangle = new JToggleButton("Rectangle");
	private final JToggleButton btnCircle = new JToggleButton("Circle");
	private final JToggleButton btnDonut = new JToggleButton("Donut");
	private final JToggleButton btnHex = new JToggleButton("Hexagon");
	private  JButton btnUndo = new JButton();
	private  JButton btnRedo = new JButton();
	private final JButton btnInnerColor = new JButton("InnerColor");
	private final JButton btnOuterColor = new JButton("OuterColor");
	private final JTextArea logArea = new JTextArea();
	private final JScrollPane scrollPane = new JScrollPane(logArea);
	private final JButton btnToBack = new JButton("To back");
	private final JButton btnToFront = new JButton("To front");
	private final JButton btnBringToBack = new JButton("Bring to back");
	private final JButton btnBringToFront = new JButton("Bring to front");
	private final JButton btnNext = new JButton();
	private final JMenuBar menuBar = new JMenuBar();
	private final JMenu menuFile = new JMenu("File");
	private final JMenuItem openItem = new JMenuItem("Open");
	private final JMenuItem saveItem = new JMenuItem("Save");
	
	public DrawingFrame() {

		menuFile.add(openItem);
		menuFile.add(saveItem);
		menuBar.add(menuFile);
		setJMenuBar(menuBar);
		
		setupIconBtn(btnUndo, iconUndo, 50, 50);
		setupIconBtn(btnRedo, iconRedo, 50, 50);
		setupIconTgl(btnSelect, iconSelect, 50, 50);
		setupIconBtn(btnModify, iconModify, 50, 50);
		setupIconBtn(btnDelete, iconDelete, 50, 50);
		setupIconBtn(btnNext, iconNext, 50, 50);

	
		leftPanel.setLayout(new GridLayout(0, 1, 10, 10));
		topPanel.setLayout(new FlowLayout()); 
		rightPanel.setLayout(new GridLayout(0, 1, 3, 3));
		view = new DrawingView();

		view.setPreferredSize(new Dimension(800, 600));
		leftPanel.setPreferredSize(new Dimension(110, 200));
		rightPanel.setPreferredSize(new Dimension(120, 200));

		
		btnNext.setEnabled(false);
		tools.add(btnNext);
		topPanel.add(btnNext);
		
		tools.add(btnSelect);
		topPanel.add(btnSelect);

		tools.add(btnModify);
		topPanel.add(btnModify);

		tools.add(btnDelete);
		topPanel.add(btnDelete);

		tools.add(btnPoint);
		leftPanel.add(btnPoint);

		tools.add(btnLine);
		leftPanel.add(btnLine);

		tools.add(btnRectangle);
		leftPanel.add(btnRectangle);

		tools.add(btnCircle);
		leftPanel.add(btnCircle);

		tools.add(btnDonut);
		leftPanel.add(btnDonut);

		tools.add(btnHex);
		leftPanel.add(btnHex);

		topPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		topPanel.add(btnUndo);
		topPanel.add(btnRedo);
		
		tools.add(btnToBack);
		rightPanel.add(btnToBack);

		tools.add(btnToFront);
		rightPanel.add(btnToFront);

		tools.add(btnBringToBack);
		rightPanel.add(btnBringToBack);

		tools.add(btnBringToFront);
		rightPanel.add(btnBringToFront);


		btnInnerColor.setBackground(innerColor);
		btnOuterColor.setBackground(outerColor);
		colors.add(btnInnerColor);
		colors.add(btnOuterColor);
		rightPanel.add(btnInnerColor);
		rightPanel.add(btnOuterColor);

		btnModify.setEnabled(false);
		btnDelete.setEnabled(false);
		
		btnBringToBack.setEnabled(false);
		btnBringToFront.setEnabled(false);
		btnToBack.setEnabled(false);
		btnToFront.setEnabled(false);
		
		btnUndo.setEnabled(false);
		btnRedo.setEnabled(false);
		
		scrollPane.setPreferredSize(new Dimension(0, 150));
		logArea.setEnabled(false);
		
		setupListeners();

		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(scrollPane, BorderLayout.PAGE_END);
		getContentPane().add(view, BorderLayout.CENTER);
		getContentPane().add(leftPanel, BorderLayout.WEST);
		getContentPane().add(topPanel, BorderLayout.NORTH);
		getContentPane().add(rightPanel, BorderLayout.EAST);
	}

	public DrawingView getView() {
		return view;
	}

	public void setController(DrawingController controller) {
		this.controller = controller;
	}

	public JToggleButton getBtnSelect() {
		return btnSelect;
	}

	public JButton getBtnModify() {
		return btnModify;
	}

	public JToggleButton getBtnPoint() {
		return btnPoint;
	}

	public JToggleButton getBtnLine() {
		return btnLine;
	}

	public JToggleButton getBtnRectangle() {
		return btnRectangle;
	}

	public JToggleButton getBtnCircle() {
		return btnCircle;
	}

	public JToggleButton getBtnDonut() {
		return btnDonut;
	}

	public JToggleButton getBtnHex() {
		return btnHex;
	}

	private void setupIconBtn(JButton btn, ImageIcon icon, int width, int height) {
		Image img = icon.getImage();
		Image newImg = img.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(newImg);
		btn.setIcon(icon);
	}

	private void setupIconTgl(JToggleButton btn, ImageIcon icon, int width, int height) {
		Image img = icon.getImage();
		Image newImg = img.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(newImg);
		btn.setIcon(icon);
	}

	private void setupListeners() {
		
		view.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.mouseClicked(e);
			}
		});

		
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.actionPerformed(e);
			}
		});

		
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.actionPerformed(e);
			}
		});

		btnUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.actionPerformed(e);
			}
		});
		
		btnRedo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.actionPerformed(e);
			}
		});
		
		
		btnToBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.actionPerformed(e);
					}
				});

		btnToFront.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				controller.actionPerformed(e);
					}
				});

		btnBringToBack.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						controller.actionPerformed(e);
					}
				});
		
		btnBringToFront.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						controller.actionPerformed(e);
					}
				});

		
		btnOuterColor.addActionListener(this);
		btnInnerColor.addActionListener(this);

		saveItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				JFileChooser c = new JFileChooser();
				FileNameExtensionFilter f = new FileNameExtensionFilter("Bin", "bin");
				c.setFileFilter(f);

				int userSelection = c.showSaveDialog(null);

				if (userSelection == JFileChooser.APPROVE_OPTION) {
					File fileToSave = c.getSelectedFile();
					File fileToSaveLog;
					String filePath = fileToSave.getAbsolutePath();
					
					if (!filePath.endsWith(".bin") && !filePath.contains(".")) {
						fileToSave = new File(filePath + ".bin");
						fileToSaveLog = new File(filePath + ".txt");
					}

					String filename = fileToSave.getPath();

					if (filename.substring(filename.lastIndexOf("."), filename.length()).contentEquals(".bin")) {
						try {
							filename = fileToSave.getAbsolutePath().substring(0, filename.lastIndexOf(".")) + ".txt";
							System.out.println(filename);
							fileToSaveLog = new File(filename);
							controller.save(fileToSave, fileToSaveLog);
						} catch (IOException e) {
							e.printStackTrace();
						}

					} else {
						JOptionPane.showMessageDialog(null, "File is not valid");
					}
				}

			}
		});
		
		openItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser c = new JFileChooser();
				FileNameExtensionFilter f = new FileNameExtensionFilter("bin", "bin", "txt");

				c.setFileFilter(f);

				c.setDialogTitle("Open");
				int userSelection = c.showOpenDialog(null);

				if (userSelection == JFileChooser.APPROVE_OPTION) {
					File fileToLoad = c.getSelectedFile();
					String filename = fileToLoad.getPath();
					if (filename.substring(filename.lastIndexOf("."), filename.length()).contentEquals(".bin")) {
						try {
							controller.load(fileToLoad);
						} catch (IOException m) {
							m.printStackTrace();
						} catch (ClassNotFoundException e1) {
							e1.printStackTrace();
						}

					} else if (filename.substring(filename.lastIndexOf("."), filename.length()).contentEquals(".txt")) {

						try {
							controller.loadOneByOne(fileToLoad);

						} catch (IOException m) { 
							m.printStackTrace();
						}

					} else {
						JOptionPane.showMessageDialog(null, "The file is not valid");
					}
				}

			}
		});
		
	

		btnNext.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					try {
						controller.loadNext();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});

		}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "InnerColor") {
			innerColor = JColorChooser.showDialog(this, "Choose your inner color", Color.RED);
			btnInnerColor.setBackground(innerColor);
		} else if (e.getActionCommand() == "OuterColor") {
			outerColor = JColorChooser.showDialog(this, "Choose your outer color", Color.RED);
			btnOuterColor.setBackground(outerColor);
		}

	}

	public JButton getBtnDelete() {
		return btnDelete;
	}
 
	public JButton getBtnUndo() {
		return btnUndo;
	}

	public void setBtnUndo(JButton btnUndo) {
		this.btnUndo = btnUndo;
	}

	public JButton getBtnRedo() {
		return btnRedo;
	}

	public void setBtnRedo(JButton btnRedo) {
		this.btnRedo = btnRedo;
	}

	public JTextArea getLogArea() {
		return logArea;
	}

	public JButton getBtnToBack() {
		return btnToBack;
	}

	public JButton getBtnToFront() {
		return btnToFront;
	}

	public JButton getBtnBringToBack() {
		return btnBringToBack;
	}

	public JButton getBtnBringToFront() {
		return btnBringToFront;
	}

	public JButton getBtnNext() {
		return btnNext;
	}
}