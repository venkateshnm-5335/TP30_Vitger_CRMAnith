package genericLibraries;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtils {
	/**
	 * to read data from property file
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public String readDataFromProprtyFile(String key) throws Exception
	{
		FileInputStream fis = new FileInputStream(IpathConstants.filePath);
		Properties pObj = new Properties();
		pObj.load(fis);
		String value = pObj.getProperty(key);
		return value;
	}
	
}
