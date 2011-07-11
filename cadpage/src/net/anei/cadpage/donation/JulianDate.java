package net.anei.cadpage.donation;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Internal class used for date calculation.  Represents a date
 * in terms of its year and number of days into year and can easily
 * calculate the number of days between two JulianDates
 */
public class JulianDate {
  private int year;
  private int day;
  
  public JulianDate(Date date) {
    Calendar cal = new GregorianCalendar();
    cal.setTime(date);
    year = cal.get(Calendar.YEAR);
    day = cal.get(Calendar.DAY_OF_YEAR);
  }

  /**
   * Set year
   * @param year
   */
  public void setYears(int year) {
    this.year = year;
  }
  
  public Date getDate() {
    Calendar cal = new GregorianCalendar();
    cal.set(Calendar.YEAR, year);
    cal.set(Calendar.DAY_OF_YEAR, day);
    return cal.getTime();
  }
  
  /**
   * Determine number of days to specified date
   * @param toDate date that is being compared
   * @return number of days from our date to toDate.  Result will be
   * positive if toDate is in the future and negative if toDate is in the past
   */
  public int diffDays(JulianDate toDate) {
    int diffDays = toDate.day - day;
    
    for (int tyear = year; tyear < toDate.year; tyear++) {
      diffDays += daysInYear(tyear);
    }
    
    for (int tyear = toDate.year; tyear < year; tyear++) {
      diffDays -= daysInYear(tyear);
    }
    
    return diffDays;
  }
  
  /**
   * Return number of days in specified year
   * @param year requested year
   * @return number of days in year
   */
  public static int daysInYear(int year) {
    return new GregorianCalendar(year, 11, 31).get(Calendar.DAY_OF_YEAR);
  }
  
  /**
   * If this is the current date, calculate the system time in msecs when the 
   * current date will no longer be this date.
   * @return the valid time limit when this will no longer be the current date
   */
  public long validUntilTime() {
    Calendar cal = new GregorianCalendar(0,0,0,0,0);
    cal.set(Calendar.YEAR, year);
    cal.set(Calendar.DAY_OF_YEAR, day);
    cal.add(Calendar.DAY_OF_YEAR, 1);
    return cal.getTime().getTime();
  }
  
  public String toString() {
    return year + ":" + day;
  }
}
