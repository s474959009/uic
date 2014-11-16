package com.ulricqin.uic.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;

public class GlobalInterceptor implements Interceptor {
	
	@Override
	public void intercept(ActionInvocation ai) {
		try {
			ai.invoke();
		} catch (Exception e) {
			// TODO: send stackTrace to maintainer(email)
			System.out.println(">>> " + e.getMessage());
			ai.getController().renderJson("msg", e.getMessage());
		}
	}

}