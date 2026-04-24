package lab6;


public class Lab6 {

	private class FullDate {
		String date;
		String month;
		String year;
		String[] months = {
			    "January",
			    "February",
			    "March",
			    "April",
			    "May",
			    "June",
			    "July",
			    "August",
			    "September",
			    "October",
			    "November",
			    "December"
			};
		private String findMonthByNumber(String month) {
			int numberMonth = Integer.parseInt(month);
			return months[numberMonth-1];
			

		}
		public FullDate(String date, String month, String year) {
			super();
			this.date = date;
			this.month = findMonthByNumber(month);
			this.year = year;
		}

		@Override
		public String toString() {
			return date +" "+month +" "+ year;
		}

	}

	private void formatDate(String date) {
		String[] split = date.split("/");
		FullDate fullDate = new FullDate(split[0], split[1], split[2]);
		System.out.println(fullDate.toString());
	}

	public static void main(String[] args) {
		Lab6 lab6 = new Lab6();
		lab6.formatDate("21/12/2000");
	}

}
