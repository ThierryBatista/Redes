package controller;
import java.io.*;

public class RedesController 
{

 public RedesController() 
 {
  super();
 }
  

public void os()
 {
  String os = System.getProperty("os.name");
  System.out.println(os);
 }


public void callProcess(String proc)
{
 String[]procVet = proc.split(" ");
 try
 {
  Runtime.getRuntime().exec(procVet); 
 }catch (Exception e)
  {
   String msg = e.getMessage();
   if (msg.contains("740"))
   {
	StringBuffer buffer = new StringBuffer();
	buffer.append("cmd /c");
	buffer.append(" ");
	buffer.append(proc);
	try
	{
	 String[]procvet1 = buffer.toString().split("");
	 Runtime.getRuntime().exec(procvet1);	
	}catch (Exception e1)
	 {
	  System.err.println(e1.getMessage());
	 } 
   } else
	  {
	   System.err.println(msg); 
	  }
  }
 
 }

public void readProcess(String proc)
{
 String[] procvt = proc.split(" ");
 try 
 {
  Process p = Runtime.getRuntime().exec(procvt);
  InputStream fluxo = p.getInputStream();
  InputStreamReader ler = new InputStreamReader(fluxo);
  BufferedReader buffer = new BufferedReader(ler);
  String linha = buffer.readLine();
  while (linha != null)
  {  
	  if (linha.contains("Adaptador Ethernet Ethernet ") || linha.contains("IPv4") || linha.contains("tempo="))
		{
		System.out.println(linha); 
		linha = buffer.readLine();
		} else if (linha.contains("tempo="))
		 {
			System.out.println(linha); 
			linha = buffer.readLine();
		 }
  } 
  buffer.close();
  ler.close();
  fluxo.close();
 } catch (Exception e)
   {
	System.out.println(""); 
   }
}
	
}
