package md_project0_dao;

import java.sql.SQLException;

public interface DAO_BankUserInterface {
	
        public boolean isRegistered(String userName) throws Exception;
		public int login(String userName, String password) throws Exception; // DONE
		public boolean createAccount()throws Exception;//done
		public void viewAll() throws Exception;//done
		public boolean update(int userId)throws Exception;//done
		public boolean delete(int userId)throws Exception;//done

}
