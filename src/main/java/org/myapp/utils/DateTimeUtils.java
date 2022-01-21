package org.myapp.utils;

import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;
import org.myapp.ApplicationException;

public class DateTimeUtils {

  /**
  Converts number of millisecons since 1st of January 1970 to Date-object
  https://docs.oracle.com/javase/8/docs/api/java/util/Date.html#getTime--
  **/
  public Date formatLongToDate(Long msSinceUnixEpoch) throws ApplicationException {
    try {
      Date date = new Date(msSinceUnixEpoch);
      return date;
    } catch (Exception e) {
      throw (new ApplicationException("Could not create date from timestamp"));
    }
  }

  public String formatDateToString(Date date) throws ApplicationException {
     try {
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
      return simpleDateFormat.format(date);
    } catch (Exception e) {
      throw (new ApplicationException("Date in wrong format. expecting YYYY-MM-dd"));
    }
  }

  public Long convertYYYYMMDDtoLong(String dateString) throws ApplicationException {
    try {
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
      return simpleDateFormat.parse(dateString).getTime();
    } catch (Exception e) {
      throw (new ApplicationException("Date in wrong format. expecting YYYY-MM-dd"));
    }
  }

}
