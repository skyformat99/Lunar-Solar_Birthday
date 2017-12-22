package info.bytegosky.lunarsolarbirthday;

import com.nlf.calendar.*;
import java.util.Scanner;

/**
 * Created by BYTEGOING on 2017/12/23.
 */
public class main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("公农历生日重叠计算器");
        System.out.println("BY BYTEGOING, 2017.");
        System.out.println("采用了@6tail的Java农历程序，在此感谢原作者.");
        int solar_year, solar_month, solar_day, lunar_year, lunar_month, lunar_day, times;
        do
        {
            System.out.print("请输入公历出生年份(例:公历1999年1月2日出生输入:1999): ");
            solar_year = scanner.nextInt();
        }
        while(solar_year > 2099 || solar_year < 1900);
        do
        {
            System.out.print("请输入公历出生月份(例:公历1999年1月2日出生输入:01): ");
            solar_month = scanner.nextInt();
        }
        while(solar_month > 12 || solar_month <= 0);
        do
        {
            System.out.print("请输入公历出生日(例:公历1999年1月2日出生输入:02): ");
            solar_day = scanner.nextInt();
        }
        while(solar_day <= 0 || solar_day > 31);
        do
        {
            System.out.print("请输入阴历出生年份(例:阴历丙寅年肆月廿一出生输入:1986): ");
            lunar_year = scanner.nextInt();
        }
        while(lunar_year > 2099 || lunar_year < 1900);
        do
        {
            System.out.print("请输入阴历出生月份(例:阴历丙寅年肆月廿一出生输入:04): ");
            lunar_month = scanner.nextInt();
        }
        while(lunar_month > 12 || lunar_month <= 0);
        do
        {
            System.out.print("请输入阴历出生日(例:阴历丙寅年肆月廿一出生输入:21): ");
            lunar_day = scanner.nextInt();
        }
        while(lunar_day <= 0 || lunar_day > 31);
        do
        {
            System.out.print("请输入从公历出生年起查询年数(上限直到2099年): ");
            times = scanner.nextInt();
        }
        while (solar_year + times > 2099 || times == 0);
        System.out.println("正在计算...(仅输出重叠日期)");
        System.out.printf("|%-15s|%-15s|%-3s|\n", "公历生日的公历日期", "农历生日的公历日期", "结果");
        for(int i = 0; i <= times; i++)
        {
            Solar solar_date = new Solar(solar_year, solar_month, solar_day); //创建一个公历对象
            Lunar lunar_date = new Lunar(lunar_year, lunar_month, lunar_day); //创建一个农历对象
            if(solar_date.getLunar().toString().equals(lunar_date.toString())) //比较公历->农历与农历日期是否相符
            {
                //相符
                System.out.printf("|%-15s|%-15s|%-3s|\n", solar_date.toString(), lunar_date.getSolar().toString(), "重叠");
                solar_year++;
                lunar_year++;
                //清除对象
                solar_date = null;
                lunar_date = null;
                System.gc();
            }
            else
            {
                //不相符
                //System.out.printf("|%-15s|%-15s|%-3s|\n", solar_date.toString(), lunar_date.getSolar().toString(), "不重叠");
                solar_year++;
                lunar_year++;
                //清除对象
                solar_date = null;
                lunar_date = null;
                System.gc();
            }
        }
    }
}
