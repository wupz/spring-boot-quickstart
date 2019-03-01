package cn.dfun.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class FirstListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("进入FirstListener...");
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}
}
