package edu.mum.cs525.finco.presentation;

public class Mediator {
	private FinCoMainFrame mainFrame;
	
	public Mediator(FinCoMainFrame mainFrame){
		this.mainFrame = mainFrame;
	}
	public void updateUIComponentStates(){
		if(mainFrame.getJTable1().getSelectionModel().getMinSelectionIndex() < 0){
			mainFrame.JButton_Deposit.setEnabled(false);
			mainFrame.JButton_Withdraw.setEnabled(false);
		} else{
			mainFrame.JButton_Deposit.setEnabled(true);
			mainFrame.JButton_Withdraw.setEnabled(true);
		}
	}
}
