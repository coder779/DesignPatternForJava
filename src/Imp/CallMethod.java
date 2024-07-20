package Imp;

import designImp.Adapter.AudioPlayer;
import designImp.Bridge.*;
import designImp.Observer.*;

public class CallMethod {

	public void callAdapterPattern(boolean isShow) {

		if (isShow) {
			AudioPlayer audioPlayer = new AudioPlayer();

			audioPlayer.play("mp3", "beyond the horizon.mp3");
			audioPlayer.play("mp4", "alone.mp4");
			audioPlayer.play("vlc", "far far away.vlc");
			audioPlayer.play("avi", "mind me.avi");
		}
	}

	public void callBridgePattern(boolean isShow) {
		if (isShow) {
			Shape redCircle = new Circle(100, 100, 10, new RedCircle());
			Shape greenCircle = new Circle(100, 100, 10, new GreenCircle());

			redCircle.draw();
			greenCircle.draw();
		}
	}

	public void callObserverPattern(boolean isShow) {
		if (isShow) {
			Subject subject = new Subject();

			new HexaObserver(subject);
			new OctalObserver(subject);
			new BinaryObserver(subject);

			System.out.println("First state change: 15");
			subject.setState(15);
			System.out.println("Second state change: 10");
			subject.setState(10);
		}
	}
}
