package genericLibraries;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

public class JavaUtils {
	/**
	 * this method is used to get random Number
	 * @return random
	 */
	public int getrandomNo(){
		Random ran = new Random();
		int random = ran.nextInt(1000);
		return random;
	}
	/**
	 * this method is used for system Date
	 * @return String
	 */
	public String systemDateMonthYear() {
		 LocalDate date = LocalDate.now();
		 DateTimeFormatter d = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		 String updated = d.format(date);
		 return updated;
	}
	/**
	 * this method is used for system Year Month Date
	 * @return
	 */
	//live date and month
		public String systemYearMontDate()
		
		{
			LocalDate date = LocalDate.now();
			DateTimeFormatter d = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String systemDate = d.format(date);
			return systemDate;
		}
		/**
		 * this method is used for future Date In Terms Of Months
		 * @param futureMon
		 * @return
		 */
		//future date and month
		public String futureDateInTermsOfMonths(long futureMon) {
			LocalDate date = LocalDate.now();
			LocalDate future = date.plusMonths(futureMon);

			DateTimeFormatter d = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String futureMonth = d.format(future);
			return futureMonth;
		}
		/**
		 * this method is used for system Date And Time
		 * @return
		 */
		//date format with year month, date,time
		public String sysDateAndTime() {
		    Date date = new Date();
		    SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		    String format = sim.format(date);
		    return format;
		}


}
