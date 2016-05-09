package kr.co.mlec.framework;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class HandlerMapping {

	private Map<String, CtrlAndMethod> mappings;

	public HandlerMapping(String uriCtrlNames) throws Exception {
		
		mappings = new HashMap<>();
		
		String[] ctrls = uriCtrlNames.split("\\|");
		for(String ctrl : ctrls) {
			System.out.println(ctrl);
			
			Class<?> clz = Class.forName(ctrl.trim());
			Object target = clz.newInstance();
			
			Method[] mArr = clz.getMethods();
			for(Method method : mArr) {
				RequestMapping reqAnno = (RequestMapping)method.getAnnotation(RequestMapping.class);
				if(reqAnno == null) continue;
				
				String uri = reqAnno.value();
				
				CtrlAndMethod cam = new CtrlAndMethod(target, method);
				
				mappings.put(uri, cam);
			}
		}
		
	}
	
	public CtrlAndMethod getCtrlAndMethod(String uri) {
		System.out.println("uri : " + uri);
		return mappings.get(uri);
	}
		
}
