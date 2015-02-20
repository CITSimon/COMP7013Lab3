package view;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

import model.Player;

public class WorldCupTableModel extends DefaultTableModel 
{
	private static final int NO_OF_COLS = 4;
	//Constants for column indices
	private static final int NAME_COL = 0;
	private static final int AGE_COL = 1;
	private static final int INTERNATIONAL_CAPS_COL = 2;
	private static final int GOALS_SCORED = 3;
	
	private ArrayList<Player> thePlayers;
	
	public WorldCupTableModel(ArrayList<Player> thePlayers)
	{
		super();
		this.thePlayers = thePlayers;
	}
	
	//This method is overridden from superclass DefaultTableModel
	public int getColumnCount()
	{
		return NO_OF_COLS;
	}
	//This method is overridden from superclass DefaultTableModel
	public String getColumnName(int columnIndex)
	{
		if(columnIndex == NAME_COL)
		{
			return "Name";
		}
		else if(columnIndex == AGE_COL)
		{
			return "Age";
		}
		else if(columnIndex == INTERNATIONAL_CAPS_COL)
		{
			return "International Caps";
		}
		else 
		{
			return "Goals Scored";
		}
	}
	
	//This method is overridden from superclass DefaultTableModel
	public int getRowCount()
	{
		if(this.thePlayers != null)
		{
			return this.thePlayers.size();
		}
		else
		{
			return 0;
		}
	}
	
	//This method is overridden from superclass DefaultTableModel
	//The row "points at" the Player and the col "points at" the
	//relevant piece of information from that Player.
	public Object getValueAt(int row, int col)
	{
		//Get the Player from the "raw data" ArrayList at 
		//index row
		Player currentPlayer = this.thePlayers.get(row);
		if(col == NAME_COL)
		{
			return currentPlayer.getName();
		}
		else if(col == AGE_COL)
		{
			return currentPlayer.getAge();
		}
		else if(col == INTERNATIONAL_CAPS_COL)
		{
			return currentPlayer.getInternationalCaps();
		}
		else 
		{
			return currentPlayer.getNoOfGoals();
		}
	}

	@Override
	public boolean isCellEditable(int row, int col) 
	{
		return false;
	}
	
}
