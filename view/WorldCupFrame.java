package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Player;
import model.Striker;

public class WorldCupFrame extends JFrame 
{
	//The "scope" of this variable is the entire
	//class. So other methods and inner classes can see it.
	private JButton addButton;
	private JButton editButton;
	private JButton deleteButton;
	private JButton okButton;
	private JButton cancelButton;
	private JTable playerTable;
	
	public WorldCupFrame(String title)
	{
		super(title);
		//This is what we are going to use as the 
		//content of our JFrame
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		
		//Call to method to create side panel
		JPanel sidePanel = createSideButtonPanel();		
		mainPanel.add(sidePanel, BorderLayout.EAST);

		//Call to method to create bottom panel
		JPanel bottomPanel = createBottomButtonPanel();
		mainPanel.add(bottomPanel, BorderLayout.SOUTH);
		
		//Call to method to create table scroll pane
		JScrollPane tableScrollPane = createTableScrollPane();
		mainPanel.add(tableScrollPane, BorderLayout.CENTER);
		
		getContentPane().add(mainPanel);
	}
	
	private JScrollPane createTableScrollPane()
	{
		playerTable = new JTable();
		
		/////////////////TEMPORARY CODE////////////////
		//Artifically create an ArrayList of Players for the moment
		ArrayList<Player> tempPlayers = new ArrayList<Player>();
				
		Striker striker1 = new Striker("john", 25, 33, 6.2, 0);
		Striker striker2 = new Striker("patrick", 35, 100, 6.5, 0);
		
		tempPlayers.add(striker1);
		tempPlayers.add(striker2);
		
		///////////////////////////////////////////////
		
		//In future weeks we'll have a call to the 
		//controller here to get us the list of players which
		//it manages as data model objects
		WorldCupTableModel tableModel = new WorldCupTableModel(tempPlayers);
		playerTable.setModel(tableModel);
		
		JScrollPane tableScrollPane = new JScrollPane(playerTable);
		//Can also be done this way
		//JScrollPane tableScrollPane = new JScrollPane();
		//tableScrollPane.add(playerTable)
		return tableScrollPane;
	}
	
	private JPanel createBottomButtonPanel()
	{
		okButton = new JButton("OK");
		cancelButton = new JButton("Cancel");
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(okButton);
		buttonPanel.add(cancelButton);
		
		return buttonPanel;
	}
	
	private JPanel createSideButtonPanel()
	{
		addButton = new JButton("Add");
		editButton = new JButton("Edit");
		deleteButton = new JButton("Delete");
		
		//Create an instance of inner class
		//SideButtonsActionListener
		//When we create an instance of the inner class we pass
		//it a reference to its containing class.
		ButtonsActionListener buttonListener = 
				new ButtonsActionListener(this);
		
		addButton.addActionListener(buttonListener);
		editButton.addActionListener(buttonListener);
		deleteButton.addActionListener(buttonListener);
		
		JPanel sideButtonPanel = new JPanel();
		
		BoxLayout boxL = new BoxLayout(sideButtonPanel, BoxLayout.Y_AXIS);
		sideButtonPanel.setLayout(boxL);

// Can also be written like this in one line.
//		sideButtonPanel.setLayout(
//		new BoxLayout(sideButtonPanel, BoxLayout.X_AXIS));
		sideButtonPanel.add(addButton);
		sideButtonPanel.add(Box.createVerticalStrut(5));
		sideButtonPanel.add(editButton);
		sideButtonPanel.add(Box.createVerticalStrut(5));
		sideButtonPanel.add(deleteButton);
		
		return sideButtonPanel;
	}
	
	//Inner class implementation of ActionListener
	private class ButtonsActionListener implements ActionListener
	{
		//This is to allow this inner class to refer to its 
		//containing class (i.e. WorldCupFrame)
		private WorldCupFrame outerClass;
		
		public ButtonsActionListener(WorldCupFrame outerClass)
		{
			this.outerClass = outerClass;
		}
		
		public void actionPerformed(ActionEvent e)
		{
			//We know that the source of any ActionEvent
			//in this program MUST be a JButton seeing as
			//we only added an instance of this listener to 
			//JButtons
			JButton sourceButton = (JButton)e.getSource();
			if(sourceButton.equals(addButton))
			{
				AddPlayerDialog addPlyrDlg = 
							new AddPlayerDialog(this.outerClass, "Add Player");
				addPlyrDlg.setSize(200, 300);
				addPlyrDlg.setVisible(true);
			}
			else if(sourceButton.equals(editButton))
			{
				System.out.println("Edit button clicked");
			}
			//This is the code which responds to the delete button
			else 
			{
				//Check if row is selected
				if(playerTable.getSelectedRow() == -1)
				{
					JOptionPane.showMessageDialog
							(outerClass, 
							 "You need to select a row in the table", 
							 "Error", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					String message = "Are you sure you want to delete this player ?";
					int answer = 
							JOptionPane.showConfirmDialog(outerClass, message);
					if(answer == JOptionPane.YES_OPTION)
					{
						
					}
					else if (answer == JOptionPane.NO_OPTION)
					{
						
					}
					else
					{
						
					}
				}
			}
				
		}
	}
	
}
