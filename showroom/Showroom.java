package showroom;

import java.util.*;

public class Showroom {
	
	
	public static void main(String args[]) {
		ArrayList<Mobile> mobiles = new ArrayList<Mobile>();
		ArrayList<Customer> customers = new ArrayList<Customer>();
		
		mobiles.add(new Mobile(1,"realme",250000,11.1,2));
		mobiles.add(new Mobile(2,"redmi",10000,10.2,22));
		mobiles.add(new Mobile(3,"vivo",15000,9.3,12));
		mobiles.add(new Iphone(4,"13pro",134500,12.23,1,50));
		Iphone phone = new Iphone(5,"13pro",134500,12.23,1,50);
		Scanner scan =  new Scanner(System.in);
		
		
		
		int input = 1;
		while(input == 1) {
			System.out.println("do want attend next customer press ( 1 ) or ( 0 )");
			input = scan.nextInt();
			if(input == 1 ) {
				
				System.out.println("welcom sir:)");
				System.out.println("if want to buy a mobile press( 1 ) or see mobile ( 2 )" );
				int loopcase = 1;
				while(loopcase == 1) {
					
					System.out.println("----------------------------------------------------");
					int opt = scan.nextInt();
//case 1 -----------------------------------------------------------------------
					switch(opt) {
					case 1:
						
						System.out.println("these our mobile collection");
						System.out.println("*****************************************************");
						for(Mobile m : mobiles) {
							m.displaydetail();
							}
						
						System.out.println("*****************************************************");
						//ArrayList<Mobile> mobile = mobiles;
						System.out.println("which mobile sir :-");
										
						Customer customer = new Customer();
						
						if(customer.isavailable(mobiles,customers)) {
							customers.add(customer);
							
							System.out.println("yes sir we have this mobile");
							System.out.println("-------------------------------------");
							System.out.println("we have to bill the mobile press ( 1 )");
							
							System.out.println("fill the customer detail");
							customer.customerdetail();
							System.out.println("--------------------------------------");
							System.out.println("u r details");
								
							customer.customername();
							System.out.println("----------------------------------------");
													
							System.out.println("EMI ( 1 ) or CASH ( 2 )");
							int ec = scan.nextInt();
							switch(ec) {
							
								
							case 1:
								
								customer.emidetail(customers);
								customer.emicalculation(mobiles,customers);
									
								if(customer.ispaidemi(customers)) {
									
									System.out.println("customer EMI paid :- " + customer.getemipaid());
									System.out.println("u r emi amount is :- " + customer.getemi());
									}
									customer.emibill();
									break;
														
								case 2:
									
									if(customer.ispaid(customers)) {
										
										//customer.customername();
										System.out.println("paid " + customer.getpaid());
										System.out.println("-----------------------------");
										customer.bill();
										}
										break;
										
								default :
									System.out.println("u r enter the wrong option ");
									
								}
												
								 }
								else {
									System.out.println("sorry dont't have this mobile");
									}
									break;
//-------------------------------------------------------------------------------------					
								case 2:
									System.out.println("these our mobile collection");
									System.out.println("*****************************************************");
									for(Mobile m : mobiles) {
										m.displaydetail();
										}
									
									System.out.println("if u want to buy press ( 1 ) exit press ( 0 )");
									loopcase = scan.nextInt();
									if(loopcase == 1)
										System.out.println("conform press ( 1 ) exit press ( 0 ) ");
										
									else {
											System.out.println("thanks vistin again");
											loopcase = 0;
										}
										break;
										
									default :
										System.out.println("wrong option THANKS VISITING AGAIN");
										loopcase = 0;
										break;
									}
				}

				
			}
			else {
				System.out.println("wrong option pls exit");
			}
		}
		
		
		
		
	}
}
