package com.zy.ywyd.gameoperators.until;

import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log {  
     //Logger实例  
     public Logger loger;  
     public Logger errrorloger;
     public Logger paylogger;
     //将Log类封装成单实例的模式，独立于其他类。以后要用到日志的地方只要获得Log的实例就可以方便使用  
     private static Log log;  
     private static String str;
     //构造函数，用于初始化Logger配置需要的属性  
     private Log()  
     {  
         //获得当前目录路径  
         String filePath=this.getClass().getResource("/").getPath();  
         //找到log4j.properties配置文件所在的目录(已经创建好)  
         filePath=filePath.substring(1).replace("bin", "src");  
         //获得日志类loger的实例  
         loger=Logger.getLogger(this.getClass());
         errrorloger = Logger.getLogger("errorlog");
         paylogger = Logger.getLogger("paylog");
         //loger所需的配置文件路径  
         PropertyConfigurator.configure("/"+filePath+"log4j.properties");  
         
         str = filePath;
     }  
       
     public static Log getLoger()  
     {  
         if(log!=null)  
             return log;  
         else 
             return new Log();  
     }  
   //测试函数  
     public static void main(String args[])  
     {      	
    	 Log logc = Log.getLoger();
    	 logc.errrorloger.error("error,error,errorqqq");
    	 logc.paylogger.info("info info info wwww");
     }
     //记录错误日志
     public static void errorLog(Exception e){
    	 Log log=Log.getLoger();  
    	 System.out.println(str);
    	 log.errrorloger.error(e.getMessage(), e);
     }
     //记录回复日志
     public static void payLog(String msg){
    	 Log log=Log.getLoger();  
    	 System.out.println(str);
    	 log.paylogger.error(msg);
     }
  
 } 