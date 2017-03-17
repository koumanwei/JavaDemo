package com.koumanwei.reflect;

public class NoteBook {
	public void run() {
		System.out.println("NoteBook is running");
	}

	public void useUSB(USB usb) {
		if (usb != null) {
			usb.open();
			usb.close();
		}
	}
}
