/**
 * 
 */
package view;

import javax.swing.JOptionPane;

import controller.RedesController;

/**
 * @author Lucas Batista
 * 10 de mar. de 2024
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RedesController procController = new RedesController();
		String os = procController.os();	
		System.out.println(os);				//Exibe sistema operacional
		
		System.out.println("");	
		
		int option;
        do {
            option = JOptionPane.showOptionDialog(null, os + "\nEscolha uma opção para executar:", "Opções",
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    new String[] { "IP", "Ping", "Encerrar" }, "ip");

            switch (option) {
                case JOptionPane.YES_OPTION:
                	if (os.contains("Windows")) {		
            			String process = "ipconfig";	//Executa ip no Windows
            			procController.ip(process);
            		} else {
            			String process = "ifconfig";	//Executa ip no Linux
            			procController.ip(process);
            		}
                    break;
                    
                case JOptionPane.NO_OPTION:
                	if (os.contains("Windows")) {		
            			String process = "ping -4 -n 10 www.google.com.br";	//Executa ping no Windows
            			procController.ping(process);
            		} else {
            			String process = "ping -4 -c 10 www.google.com.br";	//Executa ping no Linux
            			procController.ping(process);
            		}
                    break;
                case JOptionPane.CANCEL_OPTION:
                    JOptionPane.showMessageDialog(null, "Programa encerrado.");
                    break;
            }
        } while (option != JOptionPane.CANCEL_OPTION);
		
		
		
		System.out.println("");	
		
		
	}

}
