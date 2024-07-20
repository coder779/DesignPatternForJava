package designImp.Adapter;

public class AudioPlayer implements MediaPlayer {
	MediaAdapter mediaAdapter;

	@Override
	public void play(String audioType, String fileName) {

		audioType = audioType.toLowerCase();
		
		switch (audioType) {
		case "mp3":
			System.out.println("Playing mp3 file. Name: " + fileName);
			break;
		case "vlc":
		case "mp4":
			mediaAdapter = new MediaAdapter(audioType);
			mediaAdapter.play(audioType, fileName);
			break;
		default:
			System.out.println("Invalid media. " + audioType + " format not supported");
			break;
		}

	}
}