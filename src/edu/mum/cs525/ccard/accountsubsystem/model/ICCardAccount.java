package edu.mum.cs525.ccard.accountsubsystem.model;

import java.util.Date;

public interface ICCardAccount {
	public Date getExpireDate();
	public void setExpireDate(Date expireDate);
}
