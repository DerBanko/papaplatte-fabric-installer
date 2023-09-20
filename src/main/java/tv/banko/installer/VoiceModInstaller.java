package tv.banko.installer;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

import net.fabricmc.installer.Main;
import net.fabricmc.installer.util.Utils;

public class VoiceModInstaller {

	public static void install() throws IOException {
		String modsFolder = System.getProperty("user.home") + "/AppData/Roaming/.minecraft/mods";
		File modsFolderFile = new File(modsFolder);
		Path modsFolderPath = modsFolderFile.toPath();

		if (modsFolderFile.exists()) {
			Files.move(modsFolderPath, new File(modsFolder + "-" + System.currentTimeMillis()).toPath());
		}

		try {
			Utils.downloadFile(new URL(Main.VOICE_MOD_DOWNLOAD_URL), new File(modsFolder + "/voicechat.jar").toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
