package md_project0_main;

import md_project0_dao.DAO_BankUserImplement;

public class main {
	  public static void main(String[] args) throws Exception {
		  DAO_BankUserImplement dbi = new DAO_BankUserImplement();
		  int id=dbi.login("USER1","PASSWORD1");
		 // System.out.println(id);
		  dbi.viewAll();
	  }

	}