package controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class IntroController implements Initializable {
	@FXML
	private MediaView mediaView;
	private Main main;
	
	private File file;
	private Media media;
	private MediaPlayer mediaPlayer;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		file = new File("intro.mp4");
		media = new Media(file.toURI().toString());
		mediaPlayer =new MediaPlayer(media);
		mediaView.setMediaPlayer(mediaPlayer);
	}
	public void skipIntro() {	
		main.showMain();
	}
	public void play() {
		mediaPlayer.play();
	}

	public void setMain(Main main) {
		this.main=main;
	}
	
}
