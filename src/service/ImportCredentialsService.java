package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;
import br.com.caelum.vraptor.ioc.Component;

@Component
public class ImportCredentialsService {

	public void importCredentialsFile(UploadedFile inputFile) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputFile.getFile()));
		try {
			System.out.println(reader.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
