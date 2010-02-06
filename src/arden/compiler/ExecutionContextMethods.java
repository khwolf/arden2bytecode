package arden.compiler;

import java.lang.reflect.Method;

import arden.runtime.ArdenRunnable;
import arden.runtime.ArdenValue;
import arden.runtime.ExecutionContext;

/** Contains references to the methods from the ExecutionContext class */
final class ExecutionContextMethods {
	public static final Method createQuery;
	public static final Method write, getMessage;
	public static final Method findModule, findInterface;
	public static final Method callWithDelay;
	public static final Method getEventTime, getTriggerTime, getCurrentTime;

	static {
		try {
			createQuery = ExecutionContext.class.getMethod("createQuery", String.class);
			write = ExecutionContext.class.getMethod("write", ArdenValue.class, String.class);
			getMessage = ExecutionContext.class.getMethod("getMessage", String.class);
			findModule = ExecutionContext.class.getMethod("findModule", String.class, String.class);
			findInterface = ExecutionContext.class.getMethod("findInterface", String.class);
			callWithDelay = ExecutionContext.class.getMethod("callWithDelay", ArdenRunnable.class, ArdenValue[].class,
					ArdenValue.class);
			getEventTime = ExecutionContext.class.getMethod("getEventTime");
			getTriggerTime = ExecutionContext.class.getMethod("getTriggerTime");
			getCurrentTime = ExecutionContext.class.getMethod("getCurrentTime");
		} catch (SecurityException e) {
			throw new RuntimeException(e);
		} catch (NoSuchMethodException e) {
			throw new RuntimeException(e);
		}
	}
}
