package org.ufla.maratonadeprogramacao.generictest;
import static org.junit.Assert.assertFalse;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.junit.Test;

public class GenericTest {
	
	Configuration configuration;
	
	public GenericTest(Configuration configuration) {
		this.configuration = configuration;
	}
	
	
	@Test
	public void test() throws IOException, InterruptedException {
		Process p;
		String line, actLine;
		boolean error = false;
		StringBuffer sbSol, sbActSol;
		String[] testFiles = (new File(configuration.testsAdress)).list();
		for (String testFile : testFiles) {
			if (testFile.contains(".sol")) {
				continue;
			}
			testFile = configuration.testsAdress+testFile;
			p = Runtime.getRuntime().exec(configuration.command, null, 
					configuration.binDirectory);

			//Setando a entrada
			BufferedReader brIn = new BufferedReader(new FileReader(testFile)); 
			BufferedWriter bwIn = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
			while ((line = brIn.readLine()) != null) {
				bwIn.write(line);
				bwIn.newLine();
			}
			brIn.close();
			bwIn.close();
			
			//Esperando a execução
			p.waitFor();

			//Conferindo a saída
			sbSol = new StringBuffer();
			sbActSol = new StringBuffer();
			BufferedReader brSol = new BufferedReader(new FileReader(testFile.replace(".in", ".sol"))); 
			BufferedReader brActSol = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while ((line = brSol.readLine()) != null) {
				actLine = brActSol.readLine();
				if (!line.equals(actLine)) {
					error = true;
				}
				sbSol.append(line).append('\n');
				sbActSol.append(actLine).append('\n');
			}
			actLine = brActSol.readLine();
			if (actLine != null) {
				sbActSol.append(actLine).append('\n');
				while ((actLine = brActSol.readLine()) != null) {
					sbActSol.append(actLine).append('\n');
				}
				error = true;
			}
			
			if (error) {
				System.out.println("ERRO! Teste: "+testFile);
//				System.out.println("\nENTRADA:");
//				brIn = new BufferedReader(new FileReader(testFile));
//				while ((line = brIn.readLine()) != null) {
//					System.out.println(line);
//				}
//				brIn.close();
				
				System.out.println("\nSOLUÇÃO ATUAL:");
				System.out.println(sbActSol);
				System.out.println("\nSOLUÇÃO CORRETA:");
				System.out.println(sbSol);
			}
			brSol.close();
			brActSol.close();
			p.destroy();
			assertFalse(error);
			System.out.println("SUCCESS: "+testFile);
		}
		System.out.println("TODAS SOLUÇÕES ESTÃO CORRETAS!");
	}

}
