package be.umons.observer;

import java.util.Observer;

public interface IObservable {
	public void addObserver(Observer obs);
	public void updateObserver();
	public void delObserver();
}