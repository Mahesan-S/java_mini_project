package showroom;

import java.util.*;

public class Customer extends Thread{
	String customername,bankname;
	String Mobilename;
	boolean paid,emipaid;
	int ph,emi;
	int addaharno,account_no,serial_no;

//	------------------------------------------------------------------------------------------
	public Customer() {
		
		Scanner s = new Scanner(System.in);
		System.out.println("enter u mobile name and 2nd enter ( serial_no )");
		
		Mobilename = s.nextLine();
		serial_no = s.nextInt();
		
		System.out.println(serial_no + " " + Mobilename);
		
		
	}
	
//	------------------------------------------------------------------------------------------	
	public void customerdetail(){
		Scanner scan = new Scanner(System.in);
		
		System.out.println("enter u name");
		customername = scan.next();
		
//		System.out.println("paid or not");
//		paid = scan.nextBoolean();
		
		System.out.println("mobile number");
		ph = scan.nextInt();
		
	}

//	------------------------------------------------------------------------------------------
	public boolean getpaid() {
		return paid;
	}
	
	public void setpaid(boolean val) {
		this.paid = val;
	}
//	------------------------------------------------------------------------------------------
	
	public void setemipaid(boolean val) {
		emipaid = val;
	}
	
	public boolean getemipaid() {
		return emipaid;
	}
//	------------------------------------------------------------------------------------------
	
	public String getname() {
		return customername;
	}

//	------------------------------------------------------------------------------------------
	
	public int getemi() {
		return emi;
	}
	
	public void setemi(int val) {
		emi = val;
	}
	
//------------------------------------------------------------------------------------------
	public boolean isavailable(ArrayList<Mobile> mobiles,ArrayList<Customer> customer) {
		int stock = 0;
		for(Mobile m : mobiles ) {
			if(Mobilename.equals(m.mobilename)  && serial_no == m.serial_no) {
				stock = m.getstocks();
				m.setstocks(stock--);
			}		
		}
		
		int buy = 0;
		for(Customer c: customer ) {
			if(c.Mobilename == Mobilename && c.serial_no == serial_no) {
				buy++;
			}
		} 
			return buy<stock?true:false; 
  }
//	------------------------------------------------------------------------------------------------
	public void customername() {
		System.out.println(customername + " " + ph + " " + paid + " " + Mobilename);
	}
//	------------------------------------------------------------------------------------------
	public void bill() {
		String nl = System.lineSeparator();
		System.out.println("Loding...........");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("-------------------------------------------------------");
		System.out.println("customer name :- " + customername + nl + 
						   "mobile name :- " + Mobilename + '\n' +
						   
						   "paid :- "  + paid + nl + 
						   "contact number :- " + ph + '\n');
		System.out.println("-------------------------------------------------------");
	}
	

//	------------------------------------------------------------------------------------------	
	public boolean ispaid(ArrayList<Customer> customers) {
		for(Customer c: customers) {
			if(c.getpaid() == false) {
				setpaid(true);
			}
		}
		return true;
	}
	
//	------------------------------------------------------------------------------------------
	void emidetail(ArrayList<Customer> customers) {
		Scanner scan = new Scanner(System.in);
		String nl = System.lineSeparator();
		
		 
		System.out.println("customer name :- " + customername + nl + 
					   "mobile name :- " + Mobilename + '\n' + 
					   "paid :- "  + paid + nl + 
					   "contact number :- " + ph + '\n');
		
		
		System.out.println("enter u addahar no");
		addaharno = scan.nextInt();
		System.out.println("enter bank name");
		bankname = scan.next();
		System.out.println("enter account number");
		account_no = scan.nextInt();
		
	}

//	------------------------------------------------------------------------------------------
	public void emicalculation(ArrayList<Mobile> mobiles,ArrayList<Customer> customers) {
		int val = 0; 
		int result = 0;
		int p = 0;
		int n = 10;
		int r = 0006;
		for(Mobile m: mobiles )
			if(m.getname() == Mobilename) {
				p = m.getprice();
				val =p*r*(1+r)*n % (1+r)*n-1;
				result =val;
			}
		for(Customer c : customers)
			if(c.Mobilename == Mobilename) {
				c.setemi(result);
			}
//			P * r * (1 + r)n/((1 + r)n - 1);
		
		
	}
	
	
//	------------------------------------------------------------------------------------------	

	public boolean ispaidemi(ArrayList<Customer> customers) {
		for(Customer c : customers)
			if(c.getemipaid() == false) {
				setemipaid(true);
			}
		return true;
	}

//	------------------------------------------------------------------------------------------
	public void emibill() {
		String nl = System.lineSeparator();
		System.out.println("-------------------------------------------------------");
		System.out.println("customer name :- " + customername + nl + 
				   "mobile name :- " + Mobilename + '\n' +
				   "EMI :- " + emi + nl +
				   "ADDAHER no :- " + addaharno + '\n' +
				   "bank name & account no :- " + bankname + "  "+ account_no + nl +
				   "paid :- "  + emipaid + nl + 
				   "contact number :- " + ph + '\n');
		System.out.println("--------------------------------------------------------");
	}
}
