package edu.mum.cs525.finco;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import edu.mum.cs525.finco.accountsubsystem.controller.AccountController;
import edu.mum.cs525.finco.accountsubsystem.controller.AccountVisitor;
import edu.mum.cs525.finco.accountsubsystem.controller.EvaluateFunctor;
import edu.mum.cs525.finco.accountsubsystem.controller.IAccountController;
import edu.mum.cs525.finco.accountsubsystem.controller.IAccountVisitor;
import edu.mum.cs525.finco.accountsubsystem.model.IAccount;
import edu.mum.cs525.finco.accountsubsystem.model.ITransaction;
import edu.mum.cs525.finco.customersubsystem.controller.CustomerController;
import edu.mum.cs525.finco.customersubsystem.controller.ICustomerController;
import edu.mum.cs525.finco.customersubsystem.model.IAddress;
import edu.mum.cs525.finco.customersubsystem.model.ICompany;
import edu.mum.cs525.finco.customersubsystem.model.ICustomer;
import edu.mum.cs525.finco.customersubsystem.model.IPerson;
import edu.mum.cs525.finco.dataaccesssubsystem.DataAccessSubSystem;
import edu.mum.cs525.finco.presentation.FinCoMainFrame;
import edu.mum.cs525.finco.presentation.Mediator;

public class FinCo implements IFinCo {

    protected IAccountController accountController;
    protected ICustomerController customerController;
    protected DefaultTableModel defaultTableModel;
    protected IAccountVisitor accountVisitor;
    EvaluateFunctor evaluateFuctor;
    String amountColumnLabel = "Amount";
    Mediator mediator;

    
    public FinCo(IAccountController accountController,ICustomerController customerController) {
		this.accountController = accountController;
		this.customerController = customerController;
	}

    public FinCo() {
		this.accountController = new AccountController();
		this.customerController= new CustomerController();
	}
    


    @Override
    public void withdrawMoney(IAccount account, ITransaction transaction) {
    	accountController.withdrawMoney(transaction, account);
    	refreshDataTableRows();
    	mediator.updateUIComponentStates();
    }

    @Override
    public void addInterest() {
        accountController.addInterest();
        refreshDataTableRows();
    }

    @Override
    public String generateReport(IAccount account) {
    	return account.generateReport();
    }


    public static void main(String[] args) {
    	IAccountController acctController = new AccountController();
    	acctController.setDbStore(new DataAccessSubSystem()); //set the database system
        FinCo finco = new FinCo();
        finco.setAccountVisitor(new AccountVisitor()); //set default account visitor
        
        String[] dataTableCols = {"AccountNo", "Name", "P/C", "Account type", "Balance"};
        finco.initializeFincoApp(dataTableCols, new FinCoMainFrame(finco), "FinCo application");

    }

    protected void initializeFincoApp(String[] dataTableCols, FinCoMainFrame frame, String applicationTitle) {
        //initialize defaultdatatablecolumn
        defaultTableModel = new DefaultTableModel();
        for (String colName : dataTableCols) {
            defaultTableModel.addColumn(colName);
        }

        this.setDefaultTableModel(defaultTableModel);
        frame.setTitle(applicationTitle);
        frame.getJTable1().setModel(defaultTableModel);
        mediator = new Mediator(frame);
        mediator.updateUIComponentStates();
        frame.setVisible(true);
        

    }

    public DefaultTableModel getDefaultTableModel() {
        return defaultTableModel;
    }

    public void setDefaultTableModel(DefaultTableModel defaultTableModel) {
        this.defaultTableModel = defaultTableModel;
    }

    public void addRow(IAccount account) {
		ICustomer customer = account.getAccountOwner();
		IAddress address = customer.getAddress();
		Object rowdata[] = new Object[defaultTableModel.getColumnCount()];
		rowdata[0] = account;
		rowdata[1] = customer.getName();
		rowdata[2] = customer.getType();
		rowdata[3] = "Account";
		rowdata[4] = account.getAccountBalance();
		defaultTableModel.addRow(rowdata);
    }

    @Override
    public void depositeMoney(IAccount account, ITransaction transaction) {
    	accountController.depositeMoney(transaction, account);
    	refreshDataTableRows();
    	mediator.updateUIComponentStates();
    }

    public String getAmountColumnLabel() {
        return amountColumnLabel;
    }

    public void setAmountColumnLabel(String amountColumnLabel) {
        this.amountColumnLabel = amountColumnLabel;
    }

    
    public void refreshDataTableRows(){
    	if (defaultTableModel.getRowCount() > 0) {
			for (int i = defaultTableModel.getRowCount() - 1; i > -1; i--) {
				defaultTableModel.removeRow(i);
			}
		}
		List<IAccount> accounts = accountController.getAccounts();

		for (IAccount account : accounts)
			addRow(account);
    }

	public EvaluateFunctor getEvaluateFuctor() {
		return evaluateFuctor;
	}

	public void setEvaluateFuctor(EvaluateFunctor evaluateFuctor) {
		this.evaluateFuctor = evaluateFuctor;
	}

	@Override
	public void addCompanyAccount(IAccountVisitor accountVisitor,ICompany company, String accountNumber) {
        this.accountVisitor=accountVisitor;
        accountController.createCompanyAccount(accountVisitor, company, accountNumber);
        addRow(accountController.getAccount(accountNumber));
	
	}

	@Override
	public void addPersonAccount(IAccountVisitor accountVisitor,IPerson person, String accountNumber) {
		accountController.createPersonAccount(accountVisitor, person, accountNumber);
		this.accountVisitor = accountVisitor;
		addRow(accountController.getAccount(accountNumber));
	}
	@Override
	public IAccount getAccountFromAccountNumber(String accountNumber) {
		IAccount account=accountController.getAccount(accountNumber);
		return account;	
	}

	@Override
	public void updateUICommands() {
		mediator.updateUIComponentStates();
	}

	public IAccountVisitor getAccountVisitor() {
		return accountVisitor;
	}

	public void setAccountVisitor(IAccountVisitor accountVisitor) {
		this.accountVisitor = accountVisitor;
	}

}