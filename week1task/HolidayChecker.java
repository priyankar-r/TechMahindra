package week1task;

public class HolidayChecker {
	    enum DaysOfWeek {
	        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
	    }

	    public static void checkHoliday(DaysOfWeek day) {
	        if (day == DaysOfWeek.SATURDAY || day == DaysOfWeek.SUNDAY) {
	            System.out.println(day + ": is a holiday");
	        } else {
	            System.out.println(day + ": not a holiday");
	        }
	    }

	    public static void main(String[] args) {
	        checkHoliday(DaysOfWeek.MONDAY);
	        checkHoliday(DaysOfWeek.SATURDAY);
	        checkHoliday(DaysOfWeek.SUNDAY);
	        checkHoliday(DaysOfWeek.FRIDAY);
	    }
}
