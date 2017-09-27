package edu.mum.cs525.ccard.presentation;

import java.awt.event.ActionEvent;

import edu.mum.cs525.finco.IFinCo;
import edu.mum.cs525.finco.presentation.FinCoAddPersonAccountDialog;
import edu.mum.cs525.finco.presentation.FinCoMainFrame;

import javax.swing.*;

/**
 * A basic JFC based application.
 */
public class CCardMainFrame extends FinCoMainFrame
{
	private static final long serialVersionUID = -7628963601322300516L;
	
    CCardMainFrame thisframe;
    IFinCo finco;

	public CCardMainFrame(IFinCo finco)
	{
		super(finco);
		thisframe=this;
		this.finco = finco;
		
		setTitle("Credit-card processing Application.");
	
//		JButton_NewCCAccount.setText("Add Credit-card accountsubsystem");
		JButton_Withdraw.setBounds(468, 150, 96, 33);
		JButton_Withdraw.setText("Charge");
		JButton_CompAC.setText("Generate Monthly bills"); //use this button for generating reports
		SymAction lSymAction = new SymAction();
		JButton_CompAC.addActionListener(lSymAction);
		
	}

	JButton JButton_GenBill = new JButton();
	


	class SymAction implements java.awt.event.ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			Object object = event.getSource();
			
			if (object == JButton_GenBill)
				JButtonGenerateBill_actionPerformed(event);
			
		}	
		
	}

	void JButtonNewCCAC_actionPerformed(ActionEvent event)
	{
		CCardAddPersonAccountDialog pac = new CCardAddPersonAccountDialog(myframe, finco);
		pac.setBounds(450, 20, 300, 330);
		pac.show();

       
        
    }

	void JButtonGenerateBill_actionPerformed(ActionEvent event)
	{
		//get the selected account
		//generate the bill
		CCardReportDialog billFrm = new CCardReportDialog();
		billFrm.setBounds(450, 20, 400, 350);
		billFrm.show();
	    
	}

	@Override
	protected void JButtonPerAC_actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		FinCoAddPersonAccountDialog pac = new CCardAddPersonAccountDialog(myframe, finco); //person
		pac.setBounds(450, 20, 300, 330);
		pac.show();
	}

	@Override
	protected void JButtonCompAC_actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		CCardReportDialog billFrm = new CCardReportDialog();
		billFrm.setBounds(450, 20, 400, 350);
		billFrm.show();
	}

	@Override
	protected void JButtonDeposit_actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		super.JButtonDeposit_actionPerformed(event);
	}

	@Override
	protected void JButtonWithdraw_actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		super.JButtonWithdraw_actionPerformed(event);
	}

	}


