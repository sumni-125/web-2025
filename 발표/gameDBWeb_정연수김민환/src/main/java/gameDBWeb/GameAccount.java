package gameDBWeb;

public class GameAccount {

	String account_id;
	String account_pw;
	String account_name;
	
	public GameAccount(String account_id, String account_pw, String account_name) {
		super();
		this.account_id = account_id;
		this.account_pw = account_pw;
		this.account_name = account_name;
	}
	
	public GameAccount() {

	}
	
	

	@Override
	public String toString() {
		return "GameAccount [account_id=" + account_id + ", account_pw=" + account_pw + ", account_name=" + account_name
				+ "]";
	}

	public String getAccount_id() {
		return account_id;
	}

	public String getAccount_pw() {
		return account_pw;
	}

	public String getAccount_name() {
		return account_name;
	}
	
	
}
