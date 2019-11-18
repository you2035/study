package util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static final DateFormat dateTimeMSFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final SimpleDateFormat timeShortFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    public static final SimpleDateFormat monthDataFormat = new SimpleDateFormat("MM-dd");
    public static final DateFormat dateTimeMSNoBlankFormatter = new SimpleDateFormat("ddHHmmssSSS");

    public static final SimpleDateFormat dateFormatLocal = new SimpleDateFormat("yyyy年MM月dd日");
    public static final SimpleDateFormat yearMonthFormatLocal = new SimpleDateFormat("yyyy年MM月");
    public static final SimpleDateFormat yearFormatLocal = new SimpleDateFormat("yyyy年");
    public static final SimpleDateFormat minutSecondFormat = new SimpleDateFormat("mm:ss");
    public static final SimpleDateFormat dateDHTMLXFormat = new SimpleDateFormat("dd-MM-yyyy");
    public static final SimpleDateFormat yearMonthFormat = new SimpleDateFormat("yyyy-MM");

    public static final long SECOND = 1000;
    public static final long MINUTE = 60 * SECOND;
    public static final long HOUR = 60 * MINUTE;
    public static final long DAY = 24 * HOUR;
    public static final long YEAR = 365 * DAY;

    public static void main(String[] args) throws ParseException {

        		Calendar calendar1= Calendar.getInstance();
		calendar1.set(2019,1,1);
		Calendar calendar2 = Calendar.getInstance();
		calendar2.set(2019,1,2);
		int day = daysBetween(calendar1.getTime(),calendar2.getTime());
        System.out.println("day1 = "+dateFormat.format(calendar1.getTime()));
        System.out.println("day2 = "+dateFormat.format(calendar2.getTime()));
		System.out.println(day);
//
//		compareDate("2019-01-01","2019-01-02");

//		String date = getMonday(new Date(System.currentTimeMillis()));
//		System.out.println(date);

//		System.out.println(dateFormat.format(getCycleEndDate(10)));

        String date = "2019-1-01";

//		System.out.println(dateFormat.format(getWeekTaskStart(dateFormat.parse(date), 5,"w1",4)));

//		String v= dateFormat.format(getNextDayWithNumber(new Timestamp((dateFormat.parse(date)).getTime()),-5));
//		String v = dateFormat.format(getCurrMonthFirstDay(dateFormat.parse(date)));
//		String v = dateFormat.format(getCycleMonthEndDate(dateFormat.parse(date),0));
//		String v = dateFormat.format(getCycleWeekEndDate(dateFormat.parse(date),1));
//		String v = dateFormat.format(getCurrQuarterFirstDay(dateFormat.parse(date)));
//		String v = dateFormat.format(getCycleQuarterEndDate(dateFormat.parse(date),4));
//		String v = dateFormat.format(getMonthTaskStart(dateFormat.parse(date),2,"m7","26",3));
//		String v = dateFormat.format(getCycleYearEndDate(dateFormat.parse(date),3));
        String v = dateFormat.format(getYearTaskStart(dateFormat.parse(date),2,"m2","w4",3,4));

//        System.out.println(v);

    }

    public static boolean compareDate(String date1, String date2) {
        boolean flag = true;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date d1 = dateFormat.parse(date1);
            Date d2 = dateFormat.parse(date2);
            if (d1.before(d2)) { //<=
                flag = true;
            } else {
                flag = false;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 日期格式的计算
     *
     * @param startDate 较小的时间
     * @param endDate   较大的时间
     * @return 相差天数
     * @throws ParseException
     */
    public static int daysBetween(Date startDate, Date endDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        startDate = sdf.parse(sdf.format(startDate));
        endDate = sdf.parse(sdf.format(endDate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(startDate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(endDate);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);

        return Integer.parseInt(String.valueOf(between_days));
    }

    //获取当前日期所在的周的周一，并以周一为一周开始
    public static String getMonday(Date date) {
        if (date == null || date.equals("")) {
            System.out.println("date is null or empty");
            return "0000-00-00 00:00:00";
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        //set the first day of the week is Monday
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return dateFormat.format(cal.getTime());
    }

    //根据参数no 获取no周后的周日
    public static Date getCycleWeekEndDate(Date cycleStart,int no){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(cycleStart);
        calendar.add(Calendar.WEEK_OF_YEAR,no);
        calendar.set(Calendar.DAY_OF_WEEK,Calendar.SUNDAY);
        return calendar.getTime();
    }

    /**
     * 根据传入的参数周期任务相关参数信息
     * <p>
     * w1,星期一;w2,星期二;w3,星期三;w4,星期四;w5,星期五;w6,星期六;w7,星期日;
     *
     * @return
     */
    public static Date getWeekTaskStart(Date cycleStart, int no, String week, int times) {

        if (times < no) {
            no = times;
        }

        Integer weekValue = 1;

        if (week.length() == 2) {
            weekValue = Integer.parseInt(week.substring(1, 2));
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(cycleStart);
        cal.add(Calendar.WEEK_OF_YEAR, no);
        cal.set(Calendar.DAY_OF_WEEK, weekValue);

        // 获得当前日期是一个星期的第几天
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }

        int day = cal.get(Calendar.DAY_OF_WEEK);

        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() + (weekValue - day));

        return cal.getTime();
    }

    /**
     * 根据指定日期获取指定天数后的日期
     *
     * @param date
     * @param day
     * @return
     */
    public static Timestamp getNextDayWithNumber(Timestamp date, int day) {
        long time = date.getTime();
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(time);
        c.add(Calendar.DATE, day);
        return new Timestamp(c.getTimeInMillis());
    }

    //根据传入的日期获取当前月份的第一天
    public static Date getCurrMonthFirstDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    //根据参数no 获取no月的最后一天
    public static Date getCycleMonthEndDate(Date date,int no){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH,no);
        int maxDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        calendar.set(Calendar.DAY_OF_MONTH,maxDays);
        return calendar.getTime();
    }

    //根据传入的日期获取当前季度的第一天
    public static Date getCurrQuarterFirstDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int month = calendar.get(Calendar.MONTH);
        Date firstDate = getQuarterFirthDayWithMonthNo(month + 1);

        return firstDate;
    }

    private static Date getQuarterFirthDayWithMonthNo(int month) {
        System.out.println("month = "+month);

        Calendar calendar = Calendar.getInstance();
        if (month >= 1 && month <= 3) {
            calendar.set(Calendar.MONTH,0);
        } else if (month >= 4 && month <= 6) {
            calendar.set(Calendar.MONTH,3);
        } else if (month >= 7 && month <= 9) {
            calendar.set(Calendar.MONTH,6);
        } else if (month >= 10 && month <= 12) {
            calendar.set(Calendar.MONTH,9);
        }

        calendar.set(Calendar.DAY_OF_MONTH,1);

        return calendar.getTime();
    }

    //根据参数no 获取no季度的最后一天
    public static Date getCycleQuarterEndDate(Date date, int no) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, (no * 3) - 1);
        int maxDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        calendar.set(Calendar.DAY_OF_MONTH, maxDays);
        return calendar.getTime();
    }

    public static Date getQuarterTaskStart(Date cycleStart, int no, String model, String value, int times,int monthNo) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(cycleStart);

        if (times < no) {
            no = times;
        }

        if(monthNo > 3){
            monthNo = 3;
        }

        calendar.add(Calendar.MONTH,((no-1)*3)+(monthNo-1));

        Date date = getDateWithModelAndValue(calendar.getTime(), model, value);

        return date;
    }

    public static Date getMonthTaskStart(Date cycleStart, int no, String model, String value, int times) {
        if (times < no) {
            no = times;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(cycleStart);
        calendar.add(Calendar.MONTH, no -1);

        Date date = getDateWithModelAndValue(calendar.getTime(), model, value);
        return date;
    }

    private static Date getDateWithModelAndValue(Date date, String model, String value) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        //按星期取日期
        if ("m1".equals(model) || "m2".equals(model) || "m3".equals(model) || "m4".equals(model) || "m5".equals(model)) {
            Integer monthWeekNo = Integer.parseInt(model.substring(1,2));
            Integer weekValue = Integer.parseInt(value.substring(1,2));

            if(weekValue == 7){
                weekValue = 1;
            } else {
                weekValue = weekValue + 1;
            }
            calendar.set(Calendar.WEEK_OF_MONTH,monthWeekNo);
            calendar.set(Calendar.DAY_OF_WEEK,weekValue);
        } else if ("m6".equals(model)) {
            Integer day = Integer.parseInt(value);

            //获取本月最大天数
            int maxDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

            if (day >= maxDays) {
                day = maxDays;
            }

            calendar.set(Calendar.DAY_OF_MONTH,day);
            //倒数第几天
        } else if ("m7".equals(model)) {
            Integer day = Integer.parseInt(value);

            //获取本月最大天数
            int maxDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

            if (day >= maxDays) {
                day = maxDays;
            }

            day = maxDays - day;

            //若刚好等于最大天数，则取该月第一天
            if(day == 0){
                day = 1;
            }

            calendar.set(Calendar.DAY_OF_MONTH,day);
        }
        return calendar.getTime();
    }

    //根据传入的日期获取当前年份的第一天
    public static Date getCurrYearFirstDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MONTH,0);
        calendar.set(Calendar.DAY_OF_MONTH,1);
        return calendar.getTime();
    }

    //根据参数no 获取no年份的最后一天
    public static Date getCycleYearEndDate(Date date, int no) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR,no - 1);
        calendar.set(Calendar.MONTH,11);
        int maxDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        calendar.set(Calendar.DAY_OF_MONTH, maxDays);
        return calendar.getTime();
    }

    public static Date getYearTaskStart(Date cycleStart, int no, String model, String value, int times, int monthNo) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(cycleStart);
        if (times < no) {
            no = times;
        }

        if (monthNo > 12) {
            monthNo = 12;
        }

        calendar.add(Calendar.MONTH,((no - 1) * 12) + (monthNo - 1));

        Date date = getDateWithModelAndValue(calendar.getTime(), model, value);

        return date;
    }
}
