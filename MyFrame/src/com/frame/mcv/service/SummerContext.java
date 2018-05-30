package com.frame.mcv.service;

import com.frame.mcv.controller.Dispatcher;


public class SummerContext {
	private Dispatcher dispatcher;
	private HandlerMap  handlerMapping;
	private HandlerAdapter  handlerAdapterImpl;
	private HandlerAdapter  handler;
	private HandlerAdapter  viewResolver;
	private HandlerAdapter  view;
	public SummerContext() {
		super();
		this.handlerMapping = new HandlerMapImpl(); 
	}
	
	
	
	
	public Dispatcher getDispatcher() {
		return dispatcher;
	}
	public void setDispatcher(Dispatcher dispatcher) {
		this.dispatcher = dispatcher;
	}
	public HandlerMap getHandlerMapping() {
		return handlerMapping;
	}
	public void setHandlerMapping(HandlerMap handlerMapping) {
		this.handlerMapping = handlerMapping;
	}
	public HandlerAdapter getHandlerAdapterImpl() {
		return handlerAdapterImpl;
	}
	public void setHandlerAdapterImpl(HandlerAdapter handlerAdapterImpl) {
		this.handlerAdapterImpl = handlerAdapterImpl;
	}
	public HandlerAdapter getHandler() {
		return handler;
	}
	public void setHandler(HandlerAdapter handler) {
		this.handler = handler;
	}
	public HandlerAdapter getViewResolver() {
		return viewResolver;
	}
	public void setViewResolver(HandlerAdapter viewResolver) {
		this.viewResolver = viewResolver;
	}
	public HandlerAdapter getView() {
		return view;
	}
	public void setView(HandlerAdapter view) {
		this.view = view;
	}
	
	
}
