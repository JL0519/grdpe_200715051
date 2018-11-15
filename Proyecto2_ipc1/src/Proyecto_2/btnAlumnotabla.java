package Proyecto_2;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class btnAlumnotabla extends DefaultTableCellRenderer{
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus,int row, int column) {
		
		if(value instanceof JButton) {//PARA QUE SI INGRESAMOS UN BOTON LO AGREGE A LA TABLA
			//SI SE QUIERE CAMBIAR POR UN JCOMBO O UN JLABEL SOLO SE CAMBIA EN EL PARENTESIS EL JBUTTTON 
			
			JButton btn = (JButton)value;
			return btn;
		}
		
		return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	} 

}
