package pub.platform.advance.utils;

import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

import com.ccb.dao.SYSSCHEDULER;

public class SchedulerManager extends HttpServlet {

	static{
		System.out.println("////////////////////////////////////////");
		System.out.println("loading SchedulerManager.class");
		System.out.println("////////////////////////////////////////");
	}

    public static Scheduler scheduler;
    public static Map jobInfoMap = new HashMap();

	// 初始化
    public void init() throws ServletException {
		//System.out.println();
		printLine();
		System.out.println("正在加载调度作业任务信息......");
		try{
			// 加载作业信息			
			SchedulerManager.loadSchedulerInfo();
		}catch(Exception e){
			e.printStackTrace();
		}

		System.out.println("加载调度作业任务信息结束！");
		printLine();
	}

	// 销毁
    public void destroy() {
		System.out.println();
		printLine();
		System.out.println("正在关闭所有调度作业任务......");

		try{
			// 关闭调度作业
			SchedulerManager.shutdownScheduler();
		}catch(Exception e){
			e.printStackTrace();
		}

		System.out.println("关闭调度作业任务信息结束！");
		printLine();
	}

	// 重新加载作业信息
	public static void reload(){
		System.out.println();
		printLine();
		System.out.println("开始重新加载作业信息......");
		try {
			SchedulerManager.loadSchedulerInfo();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("重新加载作业信息结束！");
		printLine();
	}

	public static void shutdown(){
		System.out.println();
		printLine();
		System.out.println("开始停止所有作业......");
		try {
			SchedulerManager.shutdownScheduler();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("停止所有作业结束！");
		printLine();
	}

	// 加载作业信息
	private static synchronized void loadSchedulerInfo()throws Exception{

		SchedulerManager.shutdownScheduler();

		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
               // System.out.println("ddd");
		SchedulerManager.scheduler = schedulerFactory.getScheduler();

		List list = SYSSCHEDULER.find("", true);


		for(int i=0; i<list.size(); i++){
			SYSSCHEDULER scheuler = (SYSSCHEDULER)list.get(i);
			JobInfo job = new JobInfo(scheuler);
		}

		SchedulerManager.scheduler.start();
	}

	// 关闭调度作业
	private static synchronized void shutdownScheduler()throws Exception{
		if(SchedulerManager.scheduler != null){
			SchedulerManager.scheduler.shutdown(false);
			SchedulerManager.jobInfoMap.clear();
		}
	}

    public void doPost(HttpServletRequest request, HttpServletResponse response)
    	throws ServletException, IOException {
    	doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    	throws ServletException, IOException {
    	if("reload".equals(request.getParameter("action"))){
    		System.out.println("********  reload  *********");
    		SchedulerManager.reload();

    	}else if("shutdown".equals(request.getParameter("action"))){
    		System.out.println("********  shutdown  **********");
    		SchedulerManager.shutdown();
    	}

    	response.sendError(HttpServletResponse.SC_FORBIDDEN);
    }

	private static void printLine(){
		System.out.println("//////////////////////////" + new Date() + "//////////////////////////");
	}

}


