package kr.co.mlec.framework;

import java.util.HashMap;
import java.util.Map;

public class ModelAndView {

	private String view;
	private Map<String, Object> model;
	
	public ModelAndView() {
		model = new HashMap<String, Object>();
	}

	public ModelAndView(String view) {
		this.view = view;
		model = new HashMap<>();
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	public Map<String, Object> getModel() {
		return model;
	}

	public void setModel(Map<String, Object> model) {
		this.model = model;
	}
	
	public void setAttribute(String key, Object value) {
		model.put(key, value);
	}
	
	
	public void addAttribute(String key, Object value) {
		model.put(key, value);
	}
	
	
}
