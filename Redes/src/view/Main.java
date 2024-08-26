package view;
import controller.RedesController;

public class Main 
{
 public static void main(String Args[])
 {
	RedesController rede = new RedesController();
	String pro = "IPCONFIG";
	String proL = "ifconfig";
	String ping = "ping -4 -n 10 www.google.com.br";
	
	rede.os();
//	rede.readProcess(pro);
//	rede.readProcess(proL);
    rede.readProcess(ping);
	
 }

}
