/**
 * 
 */
package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author Lucas Batista 10 de mar. de 2024
 */
public class RedesController {

	public RedesController() {
		super();
	}

	public String os() {
		String os = System.getProperty("os.name");
		String arch = System.getProperty("os.arch");
		String version = System.getProperty("os.version");

		return os + " - v." + version + " - arch." + arch;
	}

	public void ip(String process) {
		try {
			Process p = Runtime.getRuntime().exec(process);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);

			String linha = buffer.readLine();
			while (linha != null) {
				String[] leLinha = linha.split(" ");
				for (String i : leLinha) {
					if (i.contains("Adaptador") || i.contains("IPv4")) {
						System.out.println(linha);
					}
				}
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void ping(String process) {
		try {
			Process p = Runtime.getRuntime().exec(process);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);

			String linha = buffer.readLine();
			while (linha != null) {
					System.out.println(linha);
					linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
