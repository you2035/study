package designPattern.Adapter;

/**
 * @Auther: liuxin
 * @Date: 2020/1/3 17:19
 * @Description:
 */
public class VlcPlayer implements AdvancedMediaPlayer {
	@Override
	public void playVlc(String fileName) {
		System.out.println("Playing vlc file. Name: "+ fileName);
	}

	@Override
	public void playMp4(String fileName) {
		//什么也不做
	}
}
