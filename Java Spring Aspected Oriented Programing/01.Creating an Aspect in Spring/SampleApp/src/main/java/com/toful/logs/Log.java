package com.toful.logs;

public class Log {
	
	public void vehicleAboutToMove()
	{
		System.out.println("Saving to log (from aspect): Vehicle action: About to move");
	}
	
	public void vehicleAboutToStop()
	{
		System.out.println("Saving to log (from aspect): Vehicle action: Stopping");
	}
}
